package com.baidu.tbadk.core.util.tbselector.shadow;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
/* loaded from: classes3.dex */
public class ShadowDrawable extends Drawable {
    public static final int ALL = 4369;
    public static final int BOTTOM = 4096;
    public static final int LEFT = 1;
    public static final int NO_BOTTOM = 273;
    public static final int NO_TOP = 4353;
    public static final int RIGHT = 256;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_ROUND = 1;
    public static final int TOP = 16;
    public int[] mBgColor;
    public Paint mBgPaint;
    public LinearGradient mLinearGradient;
    public RectF mRect;
    public Paint mShadowPaint;
    public int mShadowSide = ALL;
    public int mShape = 1;
    public int mShapeRadius = 0;
    public int mShadowColor = SelectorHelper.parseColor("#4d000000");
    public int mShadowRadius = SelectorHelper.dip2px(12.0f);
    public int mOffsetX = 0;
    public int mOffsetY = 0;

    /* loaded from: classes3.dex */
    public @interface ShadowSide {
    }

    /* loaded from: classes3.dex */
    public @interface Shape {
    }

    public ShadowDrawable() {
        this.mBgColor = r2;
        int[] iArr = {0};
        Paint paint = new Paint();
        this.mShadowPaint = paint;
        paint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.mShadowColor);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.mBgPaint = paint2;
        paint2.setAntiAlias(true);
    }

    public static ShadowDrawable make() {
        return new ShadowDrawable();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        LinearGradient linearGradient;
        int[] iArr = this.mBgColor;
        if (iArr != null) {
            if (iArr.length == 1 || (linearGradient = this.mLinearGradient) == null) {
                this.mBgPaint.setColor(this.mBgColor[0]);
            } else if (linearGradient != null) {
                this.mBgPaint.setShader(linearGradient);
            }
        }
        if (this.mShape == 1) {
            RectF rectF = this.mRect;
            int i2 = this.mShapeRadius;
            canvas.drawRoundRect(rectF, i2, i2, this.mShadowPaint);
            RectF rectF2 = this.mRect;
            int i3 = this.mShapeRadius;
            canvas.drawRoundRect(rectF2, i3, i3, this.mBgPaint);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mBgPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void into(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(1, null);
        ViewCompat.setBackground(view, this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.mShape == 1) {
            this.mRect = new RectF(rect.left + ((this.mShadowSide & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.mShapeRadius), rect.top + ((this.mShadowSide & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.mShapeRadius), rect.right - ((this.mShadowSide & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.mShapeRadius), rect.bottom - ((this.mShadowSide & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.mShapeRadius));
        } else {
            int i2 = this.mShadowRadius;
            this.mRect = new RectF(rect.left + i2, rect.top + i2, rect.right - i2, rect.bottom - i2);
        }
        int[] iArr = this.mBgColor;
        if (iArr == null || iArr.length <= 1) {
            return;
        }
        RectF rectF = this.mRect;
        float f2 = rectF.left;
        float height = rectF.height() / 2.0f;
        RectF rectF2 = this.mRect;
        this.mLinearGradient = new LinearGradient(f2, height, rectF2.right, rectF2.height() / 2.0f, this.mBgColor, (float[]) null, Shader.TileMode.CLAMP);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.mShadowPaint.setAlpha(i2);
    }

    public ShadowDrawable setBgColor(@ColorRes int i2) {
        this.mBgColor[0] = SelectorHelper.getColor(i2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mShadowPaint.setColorFilter(colorFilter);
    }

    public ShadowDrawable setOffsetX(int i2) {
        this.mOffsetX = i2;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, i2, this.mOffsetY, this.mShadowColor);
        return this;
    }

    public ShadowDrawable setOffsetY(int i2) {
        this.mOffsetY = i2;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, i2, this.mShadowColor);
        return this;
    }

    public ShadowDrawable setShadowAlpha(@IntRange(from = 0, to = 255) int i2) {
        setAlpha(i2);
        return this;
    }

    public ShadowDrawable setShadowColor(@ColorRes int i2) {
        int color = SelectorHelper.getColor(i2);
        this.mShadowColor = color;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, color);
        return this;
    }

    public ShadowDrawable setShadowLayer(int i2, int i3, int i4, int i5) {
        int color = SelectorHelper.getColor(i2);
        this.mShadowColor = color;
        this.mShadowRadius = i5;
        this.mOffsetX = i3;
        this.mOffsetY = i4;
        this.mShadowPaint.setShadowLayer(i5, i3, i4, color);
        return this;
    }

    public ShadowDrawable setShadowOpacity(int i2, float f2) {
        int color = SelectorHelper.getColor(i2, f2);
        this.mShadowColor = color;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, color);
        return this;
    }

    public ShadowDrawable setShadowRadius(int i2) {
        this.mShadowRadius = i2;
        this.mShadowPaint.setShadowLayer(i2, this.mOffsetX, this.mOffsetY, this.mShadowColor);
        return this;
    }

    public ShadowDrawable setShadowSide(@ShadowSide int i2) {
        this.mShadowSide = i2;
        return this;
    }

    public ShadowDrawable setShape(@Shape int i2) {
        this.mShape = i2;
        return this;
    }

    public ShadowDrawable setShapeRadius(int i2) {
        this.mShapeRadius = i2;
        return this;
    }

    public ShadowDrawable setBgColor(String str) {
        this.mBgColor[0] = SelectorHelper.parseColor(str);
        return this;
    }

    public ShadowDrawable setBgColor(@ColorRes int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = SelectorHelper.getColor(iArr[i2]);
        }
        this.mBgColor = iArr2;
        return this;
    }

    public ShadowDrawable setShadowColor(String str) {
        int parseColor = SelectorHelper.parseColor(str);
        this.mShadowColor = parseColor;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, parseColor);
        return this;
    }

    public ShadowDrawable setShadowLayer(int i2, float f2, int i3, int i4, int i5) {
        this.mShadowRadius = i5;
        this.mOffsetX = i3;
        this.mOffsetY = i4;
        setShadowOpacity(i2, f2);
        return this;
    }

    public ShadowDrawable setBgColor(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = SelectorHelper.parseColor(strArr[i2]);
        }
        this.mBgColor = iArr;
        return this;
    }
}
