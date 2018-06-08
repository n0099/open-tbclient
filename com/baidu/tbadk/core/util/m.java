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
public class m {
    private BitmapFactory.Options aoA;
    private int[] aot;
    private SoftReference<ImageView> aov;
    private int aow;
    private a aox;
    private int aoy;
    private Bitmap mBitmap;
    private int aoz = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aou = false;
    private boolean Bo = false;

    /* loaded from: classes.dex */
    public interface a {
        void yj();
    }

    public static m a(ImageView imageView, int i, int i2, int i3) {
        return new m(imageView, i, i2, i3);
    }

    public m(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aot = cC(i);
        this.aov = new SoftReference<>(imageView);
        this.aow = 1000 / i2;
        this.aoy = i3;
        imageView.setImageResource(this.aot[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aoA = new BitmapFactory.Options();
                this.aoA.inBitmap = this.mBitmap;
                this.aoA.inMutable = true;
                this.aoA.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yi() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aot.length) {
            this.aoz++;
        }
        if (this.mIndex >= this.aot.length) {
            this.mIndex = 0;
        }
        return this.aot[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aou = true;
        if (!this.Bo) {
            if (this.aov.get() == null) {
                this.aov = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.m.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) m.this.aov.get();
                    if (!m.this.aou || imageView2 == null || m.this.aoz > m.this.aoy) {
                        m.this.Bo = false;
                        if (m.this.aox != null) {
                            m.this.aox.yj();
                        }
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    m.this.Bo = true;
                    m.this.mHandler.postDelayed(this, m.this.aow);
                    if (imageView2.isShown()) {
                        int yi = m.this.yi();
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), yi, m.this.aoA);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(yi);
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(yi);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aou = false;
        this.aov.clear();
        this.Bo = false;
        this.mIndex = -1;
        this.aoz = 1;
    }

    public void a(a aVar) {
        this.aox = aVar;
    }

    private int[] cC(int i) {
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
