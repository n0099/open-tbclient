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
    private a aTA;
    private int aTB;
    private BitmapFactory.Options aTD;
    private int[] aTw;
    private SoftReference<ImageView> aTy;
    private int aTz;
    private Bitmap mBitmap;
    private int aTC = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aTx = false;
    private boolean sx = false;

    /* loaded from: classes.dex */
    public interface a {
        void BN();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aTw = fD(i);
        this.aTy = new SoftReference<>(imageView);
        this.aTz = 1000 / i2;
        this.aTB = i3;
        imageView.setImageResource(this.aTw[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aTD = new BitmapFactory.Options();
                this.aTD.inBitmap = this.mBitmap;
                this.aTD.inMutable = true;
                this.aTD.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BM() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aTw.length) {
            this.aTC++;
        }
        if (this.mIndex >= this.aTw.length) {
            this.mIndex = 0;
        }
        return this.aTw[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aTx = true;
        if (!this.sx) {
            if (this.aTy.get() == null) {
                this.aTy = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aTy.get();
                    if (!l.this.aTx || imageView2 == null || l.this.aTC > l.this.aTB) {
                        l.this.sx = false;
                        if (l.this.aTA != null) {
                            l.this.aTA.BN();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sx = true;
                    l.this.mHandler.postDelayed(this, l.this.aTz);
                    if (imageView2.isShown()) {
                        int BM = l.this.BM();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BM, l.this.aTD);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(BM);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(BM);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aTx = false;
        this.aTy.clear();
        this.sx = false;
        this.mIndex = -1;
        this.aTC = 1;
    }

    public void a(a aVar) {
        this.aTA = aVar;
    }

    private int[] fD(int i) {
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
