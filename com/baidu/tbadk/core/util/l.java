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
    private int aTA;
    private BitmapFactory.Options aTC;
    private int[] aTv;
    private SoftReference<ImageView> aTx;
    private int aTy;
    private a aTz;
    private Bitmap mBitmap;
    private int aTB = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aTw = false;
    private boolean sx = false;

    /* loaded from: classes.dex */
    public interface a {
        void BF();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aTv = fB(i);
        this.aTx = new SoftReference<>(imageView);
        this.aTy = 1000 / i2;
        this.aTA = i3;
        imageView.setImageResource(this.aTv[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aTC = new BitmapFactory.Options();
                this.aTC.inBitmap = this.mBitmap;
                this.aTC.inMutable = true;
                this.aTC.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BE() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aTv.length) {
            this.aTB++;
        }
        if (this.mIndex >= this.aTv.length) {
            this.mIndex = 0;
        }
        return this.aTv[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aTw = true;
        if (!this.sx) {
            if (this.aTx.get() == null) {
                this.aTx = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aTx.get();
                    if (!l.this.aTw || imageView2 == null || l.this.aTB > l.this.aTA) {
                        l.this.sx = false;
                        if (l.this.aTz != null) {
                            l.this.aTz.BF();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sx = true;
                    l.this.mHandler.postDelayed(this, l.this.aTy);
                    if (imageView2.isShown()) {
                        int BE = l.this.BE();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BE, l.this.aTC);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(BE);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(BE);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aTw = false;
        this.aTx.clear();
        this.sx = false;
        this.mIndex = -1;
        this.aTB = 1;
    }

    public void a(a aVar) {
        this.aTz = aVar;
    }

    private int[] fB(int i) {
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
