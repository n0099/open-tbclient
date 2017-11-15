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
    private int[] aeR;
    private SoftReference<ImageView> aeT;
    private int aeU;
    private a aeV;
    private int aeW;
    private BitmapFactory.Options aeY;
    private Bitmap mBitmap;
    private int aeX = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aeS = false;
    private boolean wB = false;

    /* loaded from: classes.dex */
    public interface a {
        void un();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aeR = cD(i);
        this.aeT = new SoftReference<>(imageView);
        this.aeU = 1000 / i2;
        this.aeW = i3;
        imageView.setImageResource(this.aeR[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aeY = new BitmapFactory.Options();
                this.aeY.inBitmap = this.mBitmap;
                this.aeY.inMutable = true;
                this.aeY.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int um() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aeR.length) {
            this.aeX++;
        }
        if (this.mIndex >= this.aeR.length) {
            this.mIndex = 0;
        }
        return this.aeR[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aeS = true;
        if (!this.wB) {
            if (this.aeT.get() == null) {
                this.aeT = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aeT.get();
                    if (!l.this.aeS || imageView2 == null || l.this.aeX > l.this.aeW) {
                        l.this.wB = false;
                        if (l.this.aeV != null) {
                            l.this.aeV.un();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wB = true;
                    l.this.mHandler.postDelayed(this, l.this.aeU);
                    if (imageView2.isShown()) {
                        int um = l.this.um();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), um, l.this.aeY);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(um);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(um);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aeS = false;
        this.aeT.clear();
        this.wB = false;
        this.mIndex = -1;
        this.aeX = 1;
    }

    public void a(a aVar) {
        this.aeV = aVar;
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
