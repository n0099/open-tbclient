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
    private int[] aou;
    private SoftReference<ImageView> aow;
    private int aox;
    private a aoy;
    private int aoz;
    private Bitmap mBitmap;
    private int times = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aov = false;
    private boolean Bl = false;

    /* loaded from: classes.dex */
    public interface a {
        void yo();
    }

    public static m a(ImageView imageView, int i, int i2, int i3) {
        return new m(imageView, i, i2, i3);
    }

    public m(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aou = cF(i);
        this.aow = new SoftReference<>(imageView);
        this.aox = 1000 / i2;
        this.aoz = i3;
        imageView.setImageResource(this.aou[0]);
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
    public int yn() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aou.length) {
            this.times++;
        }
        if (this.mIndex >= this.aou.length) {
            this.mIndex = 0;
        }
        return this.aou[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aov = true;
        if (!this.Bl) {
            if (this.aow.get() == null) {
                this.aow = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.m.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) m.this.aow.get();
                    if (!m.this.aov || imageView2 == null || m.this.times > m.this.aoz) {
                        m.this.Bl = false;
                        if (m.this.aoy != null) {
                            m.this.aoy.yo();
                        }
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    m.this.Bl = true;
                    m.this.mHandler.postDelayed(this, m.this.aox);
                    if (imageView2.isShown()) {
                        int yn = m.this.yn();
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), yn, m.this.aoA);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(yn);
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(yn);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aov = false;
        this.aow.clear();
        this.Bl = false;
        this.mIndex = -1;
        this.times = 1;
    }

    public void a(a aVar) {
        this.aoy = aVar;
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
