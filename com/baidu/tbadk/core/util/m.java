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
    private int[] aoS;
    private SoftReference<ImageView> aoU;
    private int aoV;
    private a aoW;
    private int aoX;
    private BitmapFactory.Options aoZ;
    private Bitmap mBitmap;
    private int aoY = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aoT = false;
    private boolean Bq = false;

    /* loaded from: classes.dex */
    public interface a {
        void yx();
    }

    public static m a(ImageView imageView, int i, int i2, int i3) {
        return new m(imageView, i, i2, i3);
    }

    public m(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aoS = cD(i);
        this.aoU = new SoftReference<>(imageView);
        this.aoV = 1000 / i2;
        this.aoX = i3;
        imageView.setImageResource(this.aoS[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aoZ = new BitmapFactory.Options();
                this.aoZ.inBitmap = this.mBitmap;
                this.aoZ.inMutable = true;
                this.aoZ.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yw() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aoS.length) {
            this.aoY++;
        }
        if (this.mIndex >= this.aoS.length) {
            this.mIndex = 0;
        }
        return this.aoS[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aoT = true;
        if (!this.Bq) {
            if (this.aoU.get() == null) {
                this.aoU = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.m.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) m.this.aoU.get();
                    if (!m.this.aoT || imageView2 == null || m.this.aoY > m.this.aoX) {
                        m.this.Bq = false;
                        if (m.this.aoW != null) {
                            m.this.aoW.yx();
                        }
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    m.this.Bq = true;
                    m.this.mHandler.postDelayed(this, m.this.aoV);
                    if (imageView2.isShown()) {
                        int yw = m.this.yw();
                        if (m.this.mBitmap != null && !m.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), yw, m.this.aoZ);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(yw);
                            m.this.mBitmap.recycle();
                            m.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(yw);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aoT = false;
        this.aoU.clear();
        this.Bq = false;
        this.mIndex = -1;
        this.aoY = 1;
    }

    public void a(a aVar) {
        this.aoW = aVar;
    }

    private int[] cD(int i) {
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
