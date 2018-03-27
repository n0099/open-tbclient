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
    private int[] aUT;
    private SoftReference<ImageView> aUV;
    private int aUW;
    private a aUX;
    private int aUY;
    private BitmapFactory.Options aVa;
    private Bitmap mBitmap;
    private int aUZ = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aUU = false;
    private boolean sw = false;

    /* loaded from: classes.dex */
    public interface a {
        void BZ();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aUT = fB(i);
        this.aUV = new SoftReference<>(imageView);
        this.aUW = 1000 / i2;
        this.aUY = i3;
        imageView.setImageResource(this.aUT[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aVa = new BitmapFactory.Options();
                this.aVa.inBitmap = this.mBitmap;
                this.aVa.inMutable = true;
                this.aVa.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BY() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aUT.length) {
            this.aUZ++;
        }
        if (this.mIndex >= this.aUT.length) {
            this.mIndex = 0;
        }
        return this.aUT[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aUU = true;
        if (!this.sw) {
            if (this.aUV.get() == null) {
                this.aUV = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aUV.get();
                    if (!l.this.aUU || imageView2 == null || l.this.aUZ > l.this.aUY) {
                        l.this.sw = false;
                        if (l.this.aUX != null) {
                            l.this.aUX.BZ();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sw = true;
                    l.this.mHandler.postDelayed(this, l.this.aUW);
                    if (imageView2.isShown()) {
                        int BY = l.this.BY();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BY, l.this.aVa);
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
        this.aUU = false;
        this.aUV.clear();
        this.sw = false;
        this.mIndex = -1;
        this.aUZ = 1;
    }

    public void a(a aVar) {
        this.aUX = aVar;
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
