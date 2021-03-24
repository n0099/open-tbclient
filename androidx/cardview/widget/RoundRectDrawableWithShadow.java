package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;
/* loaded from: classes.dex */
public class RoundRectDrawableWithShadow extends Drawable {
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static RoundRectHelper sRoundRectHelper;
    public ColorStateList mBackground;
    public final RectF mCardBounds;
    public float mCornerRadius;
    public Paint mCornerShadowPaint;
    public Path mCornerShadowPath;
    public Paint mEdgeShadowPaint;
    public final int mInsetShadow;
    public float mRawMaxShadowSize;
    public float mRawShadowSize;
    public final int mShadowEndColor;
    public float mShadowSize;
    public final int mShadowStartColor;
    public boolean mDirty = true;
    public boolean mAddPaddingForCorners = true;
    public boolean mPrintedShadowClipWarning = false;
    public Paint mPaint = new Paint(5);

    /* loaded from: classes.dex */
    public interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (f2 + 0.5f);
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f3, f4);
    }

    private void buildComponents(Rect rect) {
        float f2 = this.mRawMaxShadowSize;
        float f3 = 1.5f * f2;
        this.mCardBounds.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f2 = this.mCornerRadius;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.mShadowSize;
        rectF2.inset(-f3, -f3);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f4 = this.mCornerRadius;
        float f5 = f4 / (this.mShadowSize + f4);
        Paint paint = this.mCornerShadowPaint;
        float f6 = this.mCornerRadius + this.mShadowSize;
        int i = this.mShadowStartColor;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i, i, this.mShadowEndColor}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.mEdgeShadowPaint;
        float f7 = this.mCornerRadius;
        float f8 = this.mShadowSize;
        int i2 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i2, i2, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f2, float f3, boolean z) {
        if (z) {
            double d2 = f2;
            double d3 = f3;
            Double.isNaN(d3);
            Double.isNaN(d2);
            return (float) (d2 + ((1.0d - COS_45) * d3));
        }
        return f2;
    }

    public static float calculateVerticalPadding(float f2, float f3, boolean z) {
        if (z) {
            double d2 = f2 * 1.5f;
            double d3 = f3;
            Double.isNaN(d3);
            Double.isNaN(d2);
            return (float) (d2 + ((1.0d - COS_45) * d3));
        }
        return f2 * 1.5f;
    }

    private void drawShadow(Canvas canvas) {
        float f2 = this.mCornerRadius;
        float f3 = (-f2) - this.mShadowSize;
        float f4 = f2 + this.mInsetShadow + (this.mRawShadowSize / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.mCardBounds.width() - f5 > 0.0f;
        boolean z2 = this.mCardBounds.height() - f5 > 0.0f;
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.drawRect(0.0f, f3, this.mCardBounds.width() - f5, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.mCardBounds;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z) {
            canvas.drawRect(0.0f, f3, this.mCardBounds.width() - f5, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.mCardBounds;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.mCardBounds.height() - f5, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.mCardBounds;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z2) {
            canvas.drawRect(0.0f, f3, this.mCardBounds.height() - f5, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f2, float f3) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 >= 0.0f) {
            float even = toEven(f2);
            float even2 = toEven(f3);
            if (even > even2) {
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
                even = even2;
            }
            if (this.mRawShadowSize == even && this.mRawMaxShadowSize == even2) {
                return;
            }
            this.mRawShadowSize = even;
            this.mRawMaxShadowSize = even2;
            this.mShadowSize = (int) ((even * 1.5f) + this.mInsetShadow + 0.5f);
            this.mDirty = true;
            invalidateSelf();
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        }
    }

    private int toEven(float f2) {
        int i = (int) (f2 + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void getMaxShadowAndCornerPadding(Rect rect) {
        getPadding(rect);
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getMinHeight() {
        float f2 = this.mRawMaxShadowSize;
        return (Math.max(f2, this.mCornerRadius + this.mInsetShadow + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
    }

    public float getMinWidth() {
        float f2 = this.mRawMaxShadowSize;
        return (Math.max(f2, this.mCornerRadius + this.mInsetShadow + (f2 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAddPaddingForCorners(boolean z) {
        this.mAddPaddingForCorners = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        this.mCornerShadowPaint.setAlpha(i);
        this.mEdgeShadowPaint.setAlpha(i);
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setCornerRadius(float f2) {
        if (f2 >= 0.0f) {
            float f3 = (int) (f2 + 0.5f);
            if (this.mCornerRadius == f3) {
                return;
            }
            this.mCornerRadius = f3;
            this.mDirty = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
    }

    public void setMaxShadowSize(float f2) {
        setShadowSize(this.mRawShadowSize, f2);
    }

    public void setShadowSize(float f2) {
        setShadowSize(f2, this.mRawMaxShadowSize);
    }
}
