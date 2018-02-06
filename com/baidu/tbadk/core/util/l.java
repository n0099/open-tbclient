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
    private int[] aVd;
    private SoftReference<ImageView> aVf;
    private int aVg;
    private a aVh;
    private int aVi;
    private BitmapFactory.Options aVk;
    private Bitmap mBitmap;
    private int aVj = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aVe = false;
    private boolean sx = false;

    /* loaded from: classes.dex */
    public interface a {
        void BZ();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aVd = fB(i);
        this.aVf = new SoftReference<>(imageView);
        this.aVg = 1000 / i2;
        this.aVi = i3;
        imageView.setImageResource(this.aVd[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aVk = new BitmapFactory.Options();
                this.aVk.inBitmap = this.mBitmap;
                this.aVk.inMutable = true;
                this.aVk.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BY() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aVd.length) {
            this.aVj++;
        }
        if (this.mIndex >= this.aVd.length) {
            this.mIndex = 0;
        }
        return this.aVd[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aVe = true;
        if (!this.sx) {
            if (this.aVf.get() == null) {
                this.aVf = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aVf.get();
                    if (!l.this.aVe || imageView2 == null || l.this.aVj > l.this.aVi) {
                        l.this.sx = false;
                        if (l.this.aVh != null) {
                            l.this.aVh.BZ();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sx = true;
                    l.this.mHandler.postDelayed(this, l.this.aVg);
                    if (imageView2.isShown()) {
                        int BY = l.this.BY();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BY, l.this.aVk);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(BY);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(BY);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aVe = false;
        this.aVf.clear();
        this.sx = false;
        this.mIndex = -1;
        this.aVj = 1;
    }

    public void a(a aVar) {
        this.aVh = aVar;
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
