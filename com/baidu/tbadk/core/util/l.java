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
    private int[] afo;
    private SoftReference<ImageView> afq;
    private int afr;
    private a afs;
    private int aft;
    private BitmapFactory.Options afv;
    private Bitmap mBitmap;
    private int afu = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean afp = false;
    private boolean wB = false;

    /* loaded from: classes.dex */
    public interface a {
        void uq();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.afo = cE(i);
        this.afq = new SoftReference<>(imageView);
        this.afr = 1000 / i2;
        this.aft = i3;
        imageView.setImageResource(this.afo[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.afv = new BitmapFactory.Options();
                this.afv.inBitmap = this.mBitmap;
                this.afv.inMutable = true;
                this.afv.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int up() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.afo.length) {
            this.afu++;
        }
        if (this.mIndex >= this.afo.length) {
            this.mIndex = 0;
        }
        return this.afo[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.afp = true;
        if (!this.wB) {
            if (this.afq.get() == null) {
                this.afq = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.afq.get();
                    if (!l.this.afp || imageView2 == null || l.this.afu > l.this.aft) {
                        l.this.wB = false;
                        if (l.this.afs != null) {
                            l.this.afs.uq();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wB = true;
                    l.this.mHandler.postDelayed(this, l.this.afr);
                    if (imageView2.isShown()) {
                        int up = l.this.up();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), up, l.this.afv);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(up);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(up);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.afp = false;
        this.afq.clear();
        this.wB = false;
        this.mIndex = -1;
        this.afu = 1;
    }

    public void a(a aVar) {
        this.afs = aVar;
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
