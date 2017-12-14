package com.baidu.tbadk.core.util;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class l {
    private int[] afi;
    private SoftReference<ImageView> afk;
    private int afl;
    private a afm;
    private int afn;
    private BitmapFactory.Options afp;
    private Bitmap mBitmap;
    private int afo = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean afj = false;
    private boolean wy = false;

    /* loaded from: classes.dex */
    public interface a {
        void un();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.afi = cE(i);
        this.afk = new SoftReference<>(imageView);
        this.afl = 1000 / i2;
        this.afn = i3;
        imageView.setImageResource(this.afi[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.afp = new BitmapFactory.Options();
                this.afp.inBitmap = this.mBitmap;
                this.afp.inMutable = true;
                this.afp.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int um() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.afi.length) {
            this.afo++;
        }
        if (this.mIndex >= this.afi.length) {
            this.mIndex = 0;
        }
        return this.afi[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.afj = true;
        if (!this.wy) {
            if (this.afk.get() == null) {
                this.afk = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.afk.get();
                    if (!l.this.afj || imageView2 == null || l.this.afo > l.this.afn) {
                        l.this.wy = false;
                        if (l.this.afm != null) {
                            l.this.afm.un();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wy = true;
                    l.this.mHandler.postDelayed(this, l.this.afl);
                    if (imageView2.isShown()) {
                        int um = l.this.um();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), um, l.this.afp);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(um);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(um);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.afj = false;
        this.afk.clear();
        this.wy = false;
        this.mIndex = -1;
        this.afo = 1;
    }

    public void a(a aVar) {
        this.afm = aVar;
    }

    private int[] cE(int i) {
        TypedArray obtainTypedArray = TbadkCoreApplication.getInst().getResources().obtainTypedArray(i);
        int length = obtainTypedArray.length();
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = obtainTypedArray.getResourceId(i2, 0);
        }
        obtainTypedArray.recycle();
        return iArr;
    }
}
