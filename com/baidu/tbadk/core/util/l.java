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
    private SoftReference<ImageView> aTA;
    private int aTB;
    private a aTC;
    private int aTD;
    private BitmapFactory.Options aTF;
    private int[] aTy;
    private Bitmap mBitmap;
    private int aTE = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aTz = false;
    private boolean sx = false;

    /* loaded from: classes.dex */
    public interface a {
        void BG();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aTy = fB(i);
        this.aTA = new SoftReference<>(imageView);
        this.aTB = 1000 / i2;
        this.aTD = i3;
        imageView.setImageResource(this.aTy[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aTF = new BitmapFactory.Options();
                this.aTF.inBitmap = this.mBitmap;
                this.aTF.inMutable = true;
                this.aTF.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int BF() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aTy.length) {
            this.aTE++;
        }
        if (this.mIndex >= this.aTy.length) {
            this.mIndex = 0;
        }
        return this.aTy[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aTz = true;
        if (!this.sx) {
            if (this.aTA.get() == null) {
                this.aTA = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aTA.get();
                    if (!l.this.aTz || imageView2 == null || l.this.aTE > l.this.aTD) {
                        l.this.sx = false;
                        if (l.this.aTC != null) {
                            l.this.aTC.BG();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.sx = true;
                    l.this.mHandler.postDelayed(this, l.this.aTB);
                    if (imageView2.isShown()) {
                        int BF = l.this.BF();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), BF, l.this.aTF);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(BF);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(BF);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.aTz = false;
        this.aTA.clear();
        this.sx = false;
        this.mIndex = -1;
        this.aTE = 1;
    }

    public void a(a aVar) {
        this.aTC = aVar;
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
