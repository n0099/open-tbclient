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
    private int[] aUR;
    private SoftReference<ImageView> aUT;
    private int aUU;
    private a aUV;
    private int aUW;
    private BitmapFactory.Options aUY;
    private Bitmap mBitmap;
    private int aUX = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aUS = false;
    private boolean sw = false;

    /* loaded from: classes.dex */
    public interface a {
        void BY();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aUR = fB(i);
        this.aUT = new SoftReference<>(imageView);
        this.aUU = 1000 / i2;
        this.aUW = i3;
        imageView.setImageResource(this.aUR[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aUY = new BitmapFactory.Options();
                this.aUY.inBitmap = this.mBitmap;
                this.aUY.inMutable = true;
                this.aUY.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BX() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aUR.length) {
            this.aUX++;
        }
        if (this.mIndex >= this.aUR.length) {
            this.mIndex = 0;
        }
        return this.aUR[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aUS = true;
        if (!this.sw) {
            if (this.aUT.get() == null) {
                this.aUT = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aUT.get();
                    if (!l.this.aUS || imageView2 == null || l.this.aUX > l.this.aUW) {
                        l.this.sw = false;
                        if (l.this.aUV != null) {
                            l.this.aUV.BY();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sw = true;
                    l.this.mHandler.postDelayed(this, l.this.aUU);
                    if (imageView2.isShown()) {
                        int BX = l.this.BX();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BX, l.this.aUY);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(BX);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(BX);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aUS = false;
        this.aUT.clear();
        this.sw = false;
        this.mIndex = -1;
        this.aUX = 1;
    }

    public void a(a aVar) {
        this.aUV = aVar;
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
