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
    private a aeA;
    private int aeB;
    private BitmapFactory.Options aeD;
    private int[] aew;
    private SoftReference<ImageView> aey;
    private int aez;
    private Bitmap mBitmap;
    private int aeC = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aex = false;
    private boolean wB = false;

    /* loaded from: classes.dex */
    public interface a {
        void ug();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aew = cD(i);
        this.aey = new SoftReference<>(imageView);
        this.aez = 1000 / i2;
        this.aeB = i3;
        imageView.setImageResource(this.aew[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aeD = new BitmapFactory.Options();
                this.aeD.inBitmap = this.mBitmap;
                this.aeD.inMutable = true;
                this.aeD.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uf() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aew.length) {
            this.aeC++;
        }
        if (this.mIndex >= this.aew.length) {
            this.mIndex = 0;
        }
        return this.aew[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aex = true;
        if (!this.wB) {
            if (this.aey.get() == null) {
                this.aey = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aey.get();
                    if (!l.this.aex || imageView2 == null || l.this.aeC > l.this.aeB) {
                        l.this.wB = false;
                        if (l.this.aeA != null) {
                            l.this.aeA.ug();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wB = true;
                    l.this.mHandler.postDelayed(this, l.this.aez);
                    if (imageView2.isShown()) {
                        int uf = l.this.uf();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), uf, l.this.aeD);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(uf);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(uf);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aex = false;
        this.aey.clear();
        this.wB = false;
        this.mIndex = -1;
        this.aeC = 1;
    }

    public void a(a aVar) {
        this.aeA = aVar;
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
