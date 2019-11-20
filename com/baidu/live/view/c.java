package com.baidu.live.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.baidu.live.adp.lib.resourceloader.BdResourceCallback;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.util.BdBitmapHelper;
import com.baidu.live.adp.widget.imageview.BdImage;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.k.a;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class c extends ImageSpan {
    private static final int arE = Color.parseColor("#00E6E6E6");
    private int arD;
    protected WeakReference<Context> arF;
    private String arG;
    private a arH;
    private Bitmap arI;
    private AlaLiveMarkData arJ;
    protected boolean arK;
    private WeakReference<Drawable> mDrawableRef;
    private int mRetryCount;
    private int mUsedHeight;
    private int mUsedWidth;
    private boolean needCache;

    /* loaded from: classes6.dex */
    public interface a {
        void a(c cVar, Bitmap bitmap);

        void e(Bitmap bitmap);
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, a aVar) {
        this(context, alaLiveMarkData, z, 1.0f, aVar);
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, float f, a aVar) {
        super(context, 1);
        float f2;
        this.arD = 3;
        this.arF = new WeakReference<>(context);
        this.arJ = alaLiveMarkData;
        this.arG = this.arJ.mark_pic;
        this.arH = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(a.e.sdk_ds32);
        this.mUsedHeight = this.arJ.height;
        if (this.mUsedHeight <= 0) {
            this.mUsedHeight = dimensionPixelSize;
            f2 = 0.0f;
        } else if (this.mUsedHeight != dimensionPixelSize) {
            f2 = dimensionPixelSize / this.mUsedHeight;
            this.mUsedHeight = dimensionPixelSize;
        } else {
            f2 = 0.0f;
        }
        this.mUsedWidth = this.arJ.width;
        if (this.mUsedWidth <= 0) {
            this.mUsedWidth = dimensionPixelSize;
        } else if (f2 > 0.0f) {
            this.mUsedWidth = (int) (f2 * this.mUsedWidth);
        }
        if (f > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f);
            this.mUsedHeight = (int) (this.mUsedHeight * f);
        }
        wz();
    }

    private void wz() {
        if (!TextUtils.isEmpty(this.arG)) {
            wB();
        }
    }

    private void wA() {
        try {
            this.arI = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.ARGB_8888);
            this.arI.eraseColor(arE);
        } catch (OutOfMemoryError e) {
            try {
                this.arI = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.RGB_565);
                this.arI.eraseColor(arE);
            } catch (OutOfMemoryError e2) {
            }
        }
    }

    private void wB() {
        wA();
        if (this.arH != null && this.arI != null) {
            this.arH.a(this, this.arI);
        }
        wC();
    }

    private void wC() {
        BdResourceLoader.getInstance().loadResource(this.arG, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                super.onLoaded((AnonymousClass1) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null) {
                    c.this.needCache = true;
                    c.this.f(bdImage.getRawBitmap());
                    if (c.this.arH != null && c.this.arI != null) {
                        c.this.arH.e(c.this.arI);
                    }
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Bitmap bitmap) {
        Bitmap copy;
        if (bitmap != null) {
            try {
                if (bitmap.getConfig() == null) {
                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, false);
                } else {
                    copy = bitmap.copy(bitmap.getConfig(), false);
                }
            } catch (OutOfMemoryError e) {
                if (bitmap.getConfig() == null) {
                    try {
                        copy = bitmap.copy(Bitmap.Config.RGB_565, false);
                    } catch (OutOfMemoryError e2) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (copy != null) {
                try {
                    if (copy.getWidth() < this.mUsedWidth || copy.getHeight() < this.mUsedHeight) {
                        this.arI = BdBitmapHelper.getInstance().enlargeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    } else {
                        this.arI = BdBitmapHelper.getInstance().resizeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    }
                    if (this.arH != null && this.arI != null) {
                        this.arH.a(this, this.arI);
                    }
                    this.arK = true;
                } catch (OutOfMemoryError e3) {
                    if (copy != null) {
                        copy.recycle();
                    }
                }
            }
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable == null) {
            return 0;
        }
        Rect bounds = cachedDrawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i3 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i4 = bounds.bottom - bounds.top;
            int i5 = (i4 / 2) - (i3 / 4);
            int i6 = (i3 / 4) + (i4 / 2);
            fontMetricsInt.ascent = -i6;
            fontMetricsInt.top = -i6;
            fontMetricsInt.bottom = i5;
            fontMetricsInt.descent = i5;
        }
        return bounds.right;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.arI != null && this.arF.get() != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.arF.get().getResources(), this.arI);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            return bitmapDrawable;
        }
        return super.getDrawable();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        if (cachedDrawable != null) {
            canvas.save();
            canvas.translate(f, (((i5 - i3) - cachedDrawable.getBounds().bottom) / 2) + i3);
            cachedDrawable.draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Drawable getCachedDrawable() {
        if (this.arI == null && !TextUtils.isEmpty(this.arG) && this.mRetryCount < this.arD) {
            wC();
            this.mRetryCount++;
        }
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = null;
        if (weakReference != null && this.needCache) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            drawable = getDrawable();
            if (this.needCache) {
                this.mDrawableRef = new WeakReference<>(drawable);
            }
        }
        return drawable;
    }
}
