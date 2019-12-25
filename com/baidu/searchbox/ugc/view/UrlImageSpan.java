package com.baidu.searchbox.ugc.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import android.view.View;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.tbadk.TbConfig;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class UrlImageSpan extends ImageSpan {
    public static final int CENTER_CROP = 1;
    public static final int FIT_WIDTH = 4;
    public static final int TOP_CROP = 2;
    private OnClickListener mClickListener;
    private String mDetailType;
    private WeakReference<Drawable> mDrawableRef;
    private Matrix mMatrix;
    private int mPicMargin;
    private int mPicMarginBottom;
    private int mPicMarginTop;
    private boolean mResult;
    private int mScaleType;
    private int mType;
    private String mUrl;
    private boolean mUseMarginBottom;
    private boolean mUseMarginTop;
    private int vHeight;
    private int vWidth;

    /* loaded from: classes11.dex */
    public interface OnClickListener {
        void onClick(UrlImageSpan urlImageSpan, String str);
    }

    public UrlImageSpan(Context context, Bitmap bitmap) {
        super(context, bitmap);
        this.vWidth = TbConfig.HEAD_IMG_SIZE;
        this.vHeight = 370;
        this.mMatrix = new Matrix();
        this.mPicMargin = 20;
        this.mPicMarginTop = this.mPicMargin;
        this.mPicMarginBottom = this.mPicMargin;
        this.mScaleType = 4;
    }

    public UrlImageSpan(Context context, Bitmap bitmap, int i, String str, int i2, int i3, int i4, String str2) {
        super(context, bitmap, i);
        this.vWidth = TbConfig.HEAD_IMG_SIZE;
        this.vHeight = 370;
        this.mMatrix = new Matrix();
        this.mPicMargin = 20;
        this.mPicMarginTop = this.mPicMargin;
        this.mPicMarginBottom = this.mPicMargin;
        this.mScaleType = 4;
        this.mUrl = str;
        this.mType = i2;
        this.vWidth = i3;
        this.vHeight = i4;
        this.mPicMargin = DeviceUtil.ScreenInfo.dp2px(context, 20.0f);
        this.mDetailType = str2;
    }

    public UrlImageSpan(Context context, Bitmap bitmap, int i, String str, int i2, int i3, int i4, boolean z, boolean z2, String str2) {
        this(context, bitmap, i, str, i2, i3, i4, str2);
        this.mPicMarginTop = z ? this.mPicMargin : 0;
        this.mUseMarginTop = z;
        this.mPicMarginBottom = z2 ? this.mPicMargin : 0;
        this.mUseMarginBottom = z2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = 0.0f;
        Drawable cachedDrawable = getCachedDrawable();
        int intrinsicWidth = cachedDrawable.getIntrinsicWidth();
        int intrinsicHeight = cachedDrawable.getIntrinsicHeight();
        this.mMatrix.reset();
        if (this.mScaleType == 1) {
            if (this.vHeight * intrinsicWidth > this.vWidth * intrinsicHeight) {
                f3 = this.vHeight / intrinsicHeight;
                f4 = (this.vWidth - (intrinsicWidth * f3)) * 0.5f;
            } else {
                f3 = this.vWidth / intrinsicWidth;
                f4 = 0.0f;
                f5 = (this.vHeight - (intrinsicHeight * f3)) * 0.5f;
            }
            this.mMatrix.setScale(f3, f3);
            this.mMatrix.postTranslate(Math.round(f4), f5);
        } else if (this.mScaleType == 2) {
            if (this.vHeight * intrinsicWidth > this.vWidth * intrinsicHeight) {
                f = this.vHeight / intrinsicHeight;
                f2 = (this.vWidth - (intrinsicWidth * f)) * 0.5f;
            } else {
                float f6 = this.vWidth / intrinsicWidth;
                float f7 = (this.vHeight - (intrinsicHeight * f6)) * 0.5f;
                f = f6;
                f2 = 0.0f;
            }
            this.mMatrix.setScale(f, f);
            this.mMatrix.postTranslate(Math.round(f2), 0.0f);
        } else if (this.mScaleType == 4) {
            float f8 = this.vWidth / intrinsicWidth;
            this.vHeight = (int) (intrinsicHeight * f8);
            this.mMatrix.setScale(f8, f8);
        }
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = (-this.vHeight) - this.mPicMarginTop;
            fontMetricsInt.descent = this.mPicMarginBottom;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = fontMetricsInt.descent;
        }
        return this.vWidth;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable cachedDrawable = getCachedDrawable();
        canvas.save();
        canvas.translate(f, (i5 - this.vHeight) - this.mPicMarginBottom);
        canvas.clipRect(0, 0, this.vWidth, this.vHeight);
        canvas.concat(this.mMatrix);
        try {
            cachedDrawable.draw(canvas);
            canvas.restore();
        } catch (Exception e) {
        }
    }

    public String getUrl() {
        return this.mUrl;
    }

    public int getType() {
        return this.mType;
    }

    public String getdetailType() {
        return this.mDetailType;
    }

    public boolean useMarginTop() {
        return this.mUseMarginTop;
    }

    public boolean userMarginBottom() {
        return this.mUseMarginBottom;
    }

    public void loadImage(int i, int i2) {
        this.vWidth = i;
        this.vHeight = i2;
    }

    public void setLoadImageResult(boolean z) {
        this.mResult = z;
    }

    public boolean isLoadImageFailed() {
        return !this.mResult;
    }

    private Drawable getCachedDrawable() {
        WeakReference<Drawable> weakReference = this.mDrawableRef;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = weakReference.get();
        }
        if (drawable == null) {
            Drawable drawable2 = getDrawable();
            this.mDrawableRef = new WeakReference<>(drawable2);
            return drawable2;
        }
        return drawable;
    }

    public int getvWidth() {
        return this.vWidth;
    }

    public int getvHeight() {
        return this.vHeight;
    }

    public void setClickListener(OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
    }

    public void onClick(View view) {
        if (this.mClickListener != null) {
            this.mClickListener.onClick(this, this.mUrl);
        }
    }
}
