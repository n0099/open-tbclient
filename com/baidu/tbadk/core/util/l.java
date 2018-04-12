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
    private int[] agn;
    private SoftReference<ImageView> agp;
    private int agq;
    private a agr;
    private int ags;
    private BitmapFactory.Options agu;
    private Bitmap mBitmap;
    private int agt = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean ago = false;
    private boolean mIsRunning = false;

    /* loaded from: classes.dex */
    public interface a {
        void uJ();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.agn = cA(i);
        this.agp = new SoftReference<>(imageView);
        this.agq = 1000 / i2;
        this.ags = i3;
        imageView.setImageResource(this.agn[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
                this.agu = new BitmapFactory.Options();
                this.agu.inBitmap = this.mBitmap;
                this.agu.inMutable = true;
                this.agu.inSampleSize = 1;
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uI() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.agn.length) {
            this.agt++;
        }
        if (this.mIndex >= this.agn.length) {
            this.mIndex = 0;
        }
        return this.agn[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.ago = true;
        if (!this.mIsRunning) {
            if (this.agp.get() == null) {
                this.agp = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.agp.get();
                    if (!l.this.ago || imageView2 == null || l.this.agt > l.this.ags) {
                        l.this.mIsRunning = false;
                        if (l.this.agr != null) {
                            l.this.agr.uJ();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.mIsRunning = true;
                    l.this.mHandler.postDelayed(this, l.this.agq);
                    if (imageView2.isShown()) {
                        int uI = l.this.uI();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), uI, l.this.agu);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(uI);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(uI);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.ago = false;
        this.agp.clear();
        this.mIsRunning = false;
        this.mIndex = -1;
        this.agt = 1;
    }

    public void a(a aVar) {
        this.agr = aVar;
    }

    private int[] cA(int i) {
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
