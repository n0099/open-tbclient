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
    private int[] aeI;
    private SoftReference<ImageView> aeK;
    private int aeL;
    private a aeM;
    private int aeN;
    private BitmapFactory.Options aeP;
    private Bitmap mBitmap;
    private int aeO = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean aeJ = false;
    private boolean wA = false;

    /* loaded from: classes.dex */
    public interface a {
        void un();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.aeI = cE(i);
        this.aeK = new SoftReference<>(imageView);
        this.aeL = 1000 / i2;
        this.aeN = i3;
        imageView.setImageResource(this.aeI[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.aeP = new BitmapFactory.Options();
                this.aeP.inBitmap = this.mBitmap;
                this.aeP.inMutable = true;
                this.aeP.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int um() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.aeI.length) {
            this.aeO++;
        }
        if (this.mIndex >= this.aeI.length) {
            this.mIndex = 0;
        }
        return this.aeI[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.aeJ = true;
        if (!this.wA) {
            if (this.aeK.get() == null) {
                this.aeK = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.aeK.get();
                    if (!l.this.aeJ || imageView2 == null || l.this.aeO > l.this.aeN) {
                        l.this.wA = false;
                        if (l.this.aeM != null) {
                            l.this.aeM.un();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wA = true;
                    l.this.mHandler.postDelayed(this, l.this.aeL);
                    if (imageView2.isShown()) {
                        int um = l.this.um();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), um, l.this.aeP);
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
        this.aeJ = false;
        this.aeK.clear();
        this.wA = false;
        this.mIndex = -1;
        this.aeO = 1;
    }

    public void a(a aVar) {
        this.aeM = aVar;
    }

    private int[] cE(int i) {
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
