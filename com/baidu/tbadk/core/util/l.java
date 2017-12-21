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
    private int[] afl;
    private SoftReference<ImageView> afn;
    private int afo;
    private a afp;
    private int afq;
    private BitmapFactory.Options afs;
    private Bitmap mBitmap;
    private int afr = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean afm = false;
    private boolean wz = false;

    /* loaded from: classes.dex */
    public interface a {
        void un();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.afl = cE(i);
        this.afn = new SoftReference<>(imageView);
        this.afo = 1000 / i2;
        this.afq = i3;
        imageView.setImageResource(this.afl[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.afs = new BitmapFactory.Options();
                this.afs.inBitmap = this.mBitmap;
                this.afs.inMutable = true;
                this.afs.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int um() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.afl.length) {
            this.afr++;
        }
        if (this.mIndex >= this.afl.length) {
            this.mIndex = 0;
        }
        return this.afl[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.afm = true;
        if (!this.wz) {
            if (this.afn.get() == null) {
                this.afn = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.afn.get();
                    if (!l.this.afm || imageView2 == null || l.this.afr > l.this.afq) {
                        l.this.wz = false;
                        if (l.this.afp != null) {
                            l.this.afp.un();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wz = true;
                    l.this.mHandler.postDelayed(this, l.this.afo);
                    if (imageView2.isShown()) {
                        int um = l.this.um();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), um, l.this.afs);
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
        this.afm = false;
        this.afn.clear();
        this.wz = false;
        this.mIndex = -1;
        this.afr = 1;
    }

    public void a(a aVar) {
        this.afp = aVar;
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
