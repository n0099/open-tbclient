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
    private int aoA;
    private BitmapFactory.Options aoB;
    private int[] aov;
    private SoftReference<ImageView> aox;
    private int aoy;
    private a aoz;
    private Bitmap mBitmap;
    private int times = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aow = false;
    private boolean Bm = false;

    /* loaded from: classes.dex */
    public interface a {
        void ym();
    }

    public static m a(ImageView imageView, int i, int i2, int i3) {
        return new m(imageView, i, i2, i3);
    }

    public m(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aov = cF(i);
        this.aox = new SoftReference<>(imageView);
        this.aoy = 1000 / i2;
        this.aoA = i3;
        imageView.setImageResource(this.aov[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aoB = new BitmapFactory.Options();
                this.aoB.inBitmap = this.mBitmap;
                this.aoB.inMutable = true;
                this.aoB.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yl() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aov.length) {
            this.times++;
        }
        if (this.mIndex >= this.aov.length) {
            this.mIndex = 0;
        }
        return this.aov[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aow = true;
        if (!this.Bm) {
            if (this.aox.get() == null) {
                this.aox = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.m.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) m.this.aox.get();
                    if (!m.this.aow || imageView2 == null || m.this.times > m.this.aoA) {
                        m.this.Bm = false;
                        if (m.this.aoz != null) {
                            m.this.aoz.ym();
                        }
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    m.this.Bm = true;
                    m.this.mHandler.postDelayed(this, m.this.aoy);
                    if (imageView2.isShown()) {
                        int yl = m.this.yl();
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), yl, m.this.aoB);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(yl);
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(yl);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aow = false;
        this.aox.clear();
        this.Bm = false;
        this.mIndex = -1;
        this.times = 1;
    }

    public void a(a aVar) {
        this.aoz = aVar;
    }

    private int[] cF(int i) {
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
