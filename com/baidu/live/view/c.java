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
/* loaded from: classes4.dex */
public class c extends ImageSpan {
    public static Map<String, c> bnn = new HashMap();
    private static final int bnp = Color.parseColor("#FF454545");
    private int bno;
    protected WeakReference<Context> bnq;
    private String bnr;
    private a bns;
    private Bitmap bnt;
    private AlaLiveMarkData bnu;
    protected boolean bnv;
    private WeakReference<Drawable> mDrawableRef;
    private int mRetryCount;
    private int mUsedHeight;
    private int mUsedWidth;
    private boolean needCache;

    /* loaded from: classes4.dex */
    public interface a {
        void a(c cVar, Bitmap bitmap);

        void d(Bitmap bitmap);
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, a aVar) {
        this(context, alaLiveMarkData, z, 1.0f, aVar);
    }

    public c(Context context, int i) {
        super(context, i);
        this.bno = 3;
    }

    public c(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, float f, a aVar) {
        super(context, 1);
        int dimensionPixelSize;
        float f2;
        this.bno = 3;
        this.bnq = new WeakReference<>(context);
        this.bnu = alaLiveMarkData;
        this.bnr = this.bnu.mark_pic;
        this.bns = aVar;
        if (this.bnu.limitedHeight > 0) {
            dimensionPixelSize = this.bnu.limitedHeight;
        } else {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(a.e.sdk_ds32);
        }
        this.mUsedHeight = this.bnu.height;
        if (this.mUsedHeight <= 0) {
            this.mUsedHeight = dimensionPixelSize;
            f2 = 0.0f;
        } else if (this.mUsedHeight != dimensionPixelSize) {
            f2 = dimensionPixelSize / this.mUsedHeight;
            this.mUsedHeight = dimensionPixelSize;
        } else {
            f2 = 0.0f;
        }
        this.mUsedWidth = this.bnu.width;
        if (this.mUsedWidth <= 0) {
            this.mUsedWidth = dimensionPixelSize;
        } else if (f2 > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f2);
        }
        if (f > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f);
            this.mUsedHeight = (int) (this.mUsedHeight * f);
        }
        KG();
    }

    private void KG() {
        if (!TextUtils.isEmpty(this.bnr)) {
            KI();
        }
    }

    private void KH() {
        try {
            this.bnt = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.ARGB_8888);
            this.bnt.eraseColor(bnp);
        } catch (OutOfMemoryError e) {
            try {
                this.bnt = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.RGB_565);
                this.bnt.eraseColor(bnp);
            } catch (OutOfMemoryError e2) {
            }
        }
    }

    private void KI() {
        KH();
        if (this.bns != null && this.bnt != null) {
            this.bns.a(this, this.bnt);
        }
        KJ();
    }

    private void KJ() {
        BdResourceLoader.getInstance().loadResource(this.bnr, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.view.c.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                super.onLoaded((AnonymousClass1) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null) {
                    c.this.needCache = true;
                    c.this.e(bdImage.getRawBitmap());
                    if (c.this.bns != null && c.this.bnt != null) {
                        c.this.bns.d(c.this.bnt);
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
                    if (this.bnu.isWidthAutoFit && copy.getWidth() > 0 && copy.getHeight() > 0) {
                        this.mUsedWidth = (int) (((copy.getWidth() * 1.0f) * this.mUsedHeight) / copy.getHeight());
                    }
                    if (this.mUsedWidth <= 0) {
                        this.mUsedWidth = 1;
                    }
                    if (this.mUsedHeight <= 0) {
                        this.mUsedHeight = 1;
                    }
                    if (copy.getWidth() < this.mUsedWidth || copy.getHeight() < this.mUsedHeight) {
                        this.bnt = BdBitmapHelper.getInstance().enlargeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    } else {
                        this.bnt = BdBitmapHelper.getInstance().resizeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    }
                    if (this.bns != null && this.bnt != null) {
                        this.bns.a(this, this.bnt);
                    }
                    this.bnv = true;
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
        if (this.bnt != null && this.bnq.get() != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.bnq.get().getResources(), this.bnt);
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
        if (this.bnt == null && !TextUtils.isEmpty(this.bnr) && this.mRetryCount < this.bno) {
            KJ();
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
