package com.baidu.tbadk.core.util;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class l {
    private int[] afm;
    private SoftReference<ImageView> afo;
    private int afp;
    private a afq;
    private int afr;
    private BitmapFactory.Options aft;
    private Bitmap mBitmap;
    private int afs = 1;
    private Handler mHandler = new Handler();
    private int mIndex = -1;
    private boolean afn = false;
    private boolean wy = false;

    /* loaded from: classes.dex */
    public interface a {
        void uK();
    }

    public static l a(ImageView imageView, int i, int i2, int i3) {
        return new l(imageView, i, i2, i3);
    }

    public l(ImageView imageView, int i, int i2, int i3) {
        this.mBitmap = null;
        this.afm = cG(i);
        this.afo = new SoftReference<>(imageView);
        this.afp = 1000 / i2;
        this.afr = i3;
        imageView.setImageResource(this.afm[0]);
        if (Build.VERSION.SDK_INT >= 11) {
            Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
            this.mBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            this.aft = new BitmapFactory.Options();
            this.aft.inBitmap = this.mBitmap;
            this.aft.inMutable = true;
            this.aft.inSampleSize = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int uJ() {
        this.mIndex++;
        if (this.mIndex + 1 >= this.afm.length) {
            this.afs++;
        }
        if (this.mIndex >= this.afm.length) {
            this.mIndex = 0;
        }
        return this.afm[this.mIndex];
    }

    public synchronized void b(ImageView imageView) {
        this.afn = true;
        if (!this.wy) {
            if (this.afo.get() == null) {
                this.afo = new SoftReference<>(imageView);
            }
            this.mHandler.post(new Runnable() { // from class: com.baidu.tbadk.core.util.l.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap;
                    ImageView imageView2 = (ImageView) l.this.afo.get();
                    if (!l.this.afn || imageView2 == null || l.this.afs > l.this.afr) {
                        l.this.wy = false;
                        if (l.this.afq != null) {
                            l.this.afq.uK();
                        }
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        return;
                    }
                    l.this.wy = true;
                    l.this.mHandler.postDelayed(this, l.this.afp);
                    if (imageView2.isShown()) {
                        int uJ = l.this.uJ();
                        if (l.this.mBitmap != null && !l.this.mBitmap.isRecycled()) {
                            try {
                                bitmap = BitmapFactory.decodeResource(imageView2.getResources(), uJ, l.this.aft);
                            } catch (Exception e) {
                                e.printStackTrace();
                                bitmap = null;
                            }
                            if (bitmap != null) {
                                imageView2.setImageBitmap(bitmap);
                                return;
                            }
                            imageView2.setImageResource(uJ);
                            l.this.mBitmap.recycle();
                            l.this.mBitmap = null;
                            return;
                        }
                        imageView2.setImageResource(uJ);
                    }
                }
            });
        }
    }

    public synchronized void stop() {
        this.afn = false;
        this.afo.clear();
        this.wy = false;
        this.mIndex = -1;
        this.afs = 1;
    }

    public void a(a aVar) {
        this.afq = aVar;
    }

    private int[] cG(int i) {
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
