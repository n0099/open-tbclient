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
/* loaded from: classes10.dex */
public class b extends ImageSpan {
    public static Map<String, b> bPf = new HashMap();
    private static final int bPh = Color.parseColor("#FF454545");
    private int bPg;
    protected WeakReference<Context> bPi;
    private String bPj;
    private a bPk;
    private Bitmap bPl;
    private AlaLiveMarkData bPm;
    protected boolean bPn;
    private WeakReference<Drawable> mDrawableRef;
    private int mRetryCount;
    private int mUsedHeight;
    private int mUsedWidth;
    private boolean needCache;

    /* loaded from: classes10.dex */
    public interface a {
        void a(b bVar, Bitmap bitmap);

        void e(Bitmap bitmap);
    }

    public b(Context context, Bitmap bitmap) {
        super(context, bitmap);
        this.bPg = 3;
    }

    public b(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, a aVar) {
        this(context, alaLiveMarkData, z, 1.0f, aVar);
    }

    public b(Context context, int i) {
        super(context, i);
        this.bPg = 3;
    }

    public b(Context context, AlaLiveMarkData alaLiveMarkData, boolean z, float f, a aVar) {
        super(context, 1);
        int dimensionPixelSize;
        float f2;
        this.bPg = 3;
        this.bPi = new WeakReference<>(context);
        this.bPm = alaLiveMarkData;
        this.bPj = this.bPm.mark_pic;
        this.bPk = aVar;
        if (this.bPm.limitedHeight > 0) {
            dimensionPixelSize = this.bPm.limitedHeight;
        } else {
            dimensionPixelSize = context.getResources().getDimensionPixelSize(a.d.sdk_ds32);
        }
        this.mUsedHeight = this.bPm.height;
        if (this.mUsedHeight <= 0) {
            this.mUsedHeight = dimensionPixelSize;
            f2 = 0.0f;
        } else {
            f2 = this.mUsedHeight != dimensionPixelSize ? dimensionPixelSize / this.mUsedHeight : 0.0f;
        }
        this.mUsedWidth = this.bPm.width;
        if (this.mUsedWidth <= 0) {
            this.mUsedWidth = dimensionPixelSize;
        } else if (f2 > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f2);
        }
        if (f > 0.0f) {
            this.mUsedWidth = (int) (this.mUsedWidth * f);
            this.mUsedHeight = (int) (this.mUsedHeight * f);
        }
        VH();
    }

    private void VH() {
        if (!TextUtils.isEmpty(this.bPj)) {
            VJ();
        }
    }

    private void VI() {
        try {
            this.bPl = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.ARGB_8888);
            this.bPl.eraseColor(bPh);
        } catch (OutOfMemoryError e) {
            try {
                this.bPl = Bitmap.createBitmap(this.mUsedWidth, this.mUsedHeight, Bitmap.Config.RGB_565);
                this.bPl.eraseColor(bPh);
            } catch (OutOfMemoryError e2) {
            }
        }
    }

    private void VJ() {
        VI();
        if (this.bPk != null && this.bPl != null) {
            this.bPk.a(this, this.bPl);
        }
        VK();
    }

    private void VK() {
        BdResourceLoader.getInstance().loadResource(this.bPj, 10, new BdResourceCallback<BdImage>() { // from class: com.baidu.live.view.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.live.adp.lib.resourceloader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                super.onLoaded((AnonymousClass1) bdImage, str, i);
                if (bdImage != null && bdImage.getRawBitmap() != null) {
                    b.this.needCache = true;
                    b.this.g(bdImage.getRawBitmap());
                    if (b.this.bPk != null && b.this.bPl != null) {
                        b.this.bPk.e(b.this.bPl);
                    }
                }
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Bitmap bitmap) {
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
                    if (this.bPm.isWidthAutoFit && copy.getWidth() > 0 && copy.getHeight() > 0) {
                        this.mUsedWidth = (int) (((copy.getWidth() * 1.0f) * this.mUsedHeight) / copy.getHeight());
                    }
                    if (this.mUsedWidth <= 0) {
                        this.mUsedWidth = 1;
                    }
                    if (this.mUsedHeight <= 0) {
                        this.mUsedHeight = 1;
                    }
                    if (copy.getWidth() < this.mUsedWidth || copy.getHeight() < this.mUsedHeight) {
                        this.bPl = BdBitmapHelper.getInstance().enlargeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    } else {
                        this.bPl = BdBitmapHelper.getInstance().resizeBitmap(copy, this.mUsedWidth, this.mUsedHeight);
                    }
                    if (this.bPk != null && this.bPl != null) {
                        this.bPk.a(this, this.bPl);
                    }
                    this.bPn = true;
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
        if (this.bPl != null && this.bPi.get() != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.bPi.get().getResources(), this.bPl);
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

    protected Drawable getCachedDrawable() {
        if (this.bPl == null && !TextUtils.isEmpty(this.bPj) && this.mRetryCount < this.bPg) {
            VK();
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
