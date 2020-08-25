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
import com.baidu.live.sdk.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class c extends ImageSpan {
    public static Map<String, c> bsS = new HashMap();
    private static final int bsU = Color.parseColor("#FF454545");
    private int bsT;
    protected WeakReference<Context> bsV;
    private String bsW;
    private a bsX;
    private Bitmap bsY;
    private AlaLiveMarkData bsZ;
    protected boolean bta;
    private WeakReference<Drawable> mDrawableRef;
    private int mRetryCount;
    private int mUsedHeight;
    private int mUsedWidth;
    private boolean needCache;

    /* loaded from: classes7.dex */
    public interface a {
        void a(c cVar, Bitmap bitmap);

        void d(Bitmap bitmap);
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, a aVar) {
        this(context, alaLiveMarkData, z, 1.0f, aVar);
    }

    public c(Context context, int i) {
        super(context, i);
        this.bsT = 3;
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, float f, a aVar) {
        super(context, 1);
        int dimensionPixelSize;
        float f2;
        this.bsT = 3;
        this.bsV = new WeakReference<>(context);
        this.bsZ = alaLiveMarkData;
        this.bsW = this.bsZ.mark_pic;
        this.bsX = aVar;
        if (this.bsZ.limitedHeight > 0) {
            dimensionPixelSize = this.bsZ.limitedHeight;
        } else {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(a.e.sdk_ds32);
        }
        this.mUsedHeight = this.bsZ.height;
        if (this.mUsedHeight <= 0) {
            this.mUsedHeight = dimensionPixelSize;
            f2 = 0.0f;
        } else if (this.mUsedHeight != dimensionPixelSize) {
            f2 = dimensionPixelSize / this.mUsedHeight;
            this.mUsedHeight = dimensionPixelSize;
        } else {
            f2 = 0.0f;
        }
        this.mUsedWidth = this.bsZ.width;
        if (this.mUsedWidth <= 0) {
            this.mUsedWidth = dimensionPixelSize;
        } else if (f2 > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f2);
        }
        if (f > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f);
            this.mUsedHeight = (int) (this.mUsedHeight * f);
        }
        Qy();
    }

    private void Qy() {
        if (!TextUtils.isEmpty(this.bsW)) {
            QA();
        }
    }

    private void Qz() {
        try {
            this.bsY = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.ARGB_8888);
            this.bsY.eraseColor(bsU);
        } catch (OutOfMemoryError e) {
            try {
                this.bsY = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.RGB_565);
                this.bsY.eraseColor(bsU);
            } catch (OutOfMemoryError e2) {
            }
        }
    }

    private void QA() {
        Qz();
        if (this.bsX != null && this.bsY != null) {
            this.bsX.a(this, this.bsY);
        }
        QB();
    }

    private void QB() {
        BdResourceLoader.getInstance().loadResource(this.bsW, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                super.onLoaded((AnonymousClass1) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null) {
                    c.this.needCache = true;
                    c.this.e(bdImage.getRawBitmap());
                    if (c.this.bsX != null && c.this.bsY != null) {
                        c.this.bsX.d(c.this.bsY);
                    }
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Bitmap bitmap) {
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
                    if (this.bsZ.isWidthAutoFit && copy.getWidth() > 0 && copy.getHeight() > 0) {
                        this.mUsedWidth = (int) (((copy.getWidth() * 1.0f) * this.mUsedHeight) / copy.getHeight());
                    }
                    if (this.mUsedWidth <= 0) {
                        this.mUsedWidth = 1;
                    }
                    if (this.mUsedHeight <= 0) {
                        this.mUsedHeight = 1;
                    }
                    if (copy.getWidth() < this.mUsedWidth || copy.getHeight() < this.mUsedHeight) {
                        this.bsY = BdBitmapHelper.getInstance().enlargeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    } else {
                        this.bsY = BdBitmapHelper.getInstance().resizeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    }
                    if (this.bsX != null && this.bsY != null) {
                        this.bsX.a(this, this.bsY);
                    }
                    this.bta = true;
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
        if (this.bsY != null && this.bsV.get() != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.bsV.get().getResources(), this.bsY);
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
        if (this.bsY == null && !TextUtils.isEmpty(this.bsW) && this.mRetryCount < this.bsT) {
            QB();
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
