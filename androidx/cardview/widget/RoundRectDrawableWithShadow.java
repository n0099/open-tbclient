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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RoundRectDrawableWithShadow extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final double COS_45;
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static RoundRectHelper sRoundRectHelper;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAddPaddingForCorners;
    public ColorStateList mBackground;
    public final RectF mCardBounds;
    public float mCornerRadius;
    public Paint mCornerShadowPaint;
    public Path mCornerShadowPath;
    public boolean mDirty;
    public Paint mEdgeShadowPaint;
    public final int mInsetShadow;
    public Paint mPaint;
    public boolean mPrintedShadowClipWarning;
    public float mRawMaxShadowSize;
    public float mRawShadowSize;
    public final int mShadowEndColor;
    public float mShadowSize;
    public final int mShadowStartColor;

    /* loaded from: classes.dex */
    public interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(596775504, "Landroidx/cardview/widget/RoundRectDrawableWithShadow;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(596775504, "Landroidx/cardview/widget/RoundRectDrawableWithShadow;");
                return;
            }
        }
        COS_45 = Math.cos(Math.toRadians(45.0d));
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, colorStateList, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, rect) == null) {
            float f2 = this.mRawMaxShadowSize;
            float f3 = 1.5f * f2;
            this.mCardBounds.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
            buildShadowCorners();
        }
    }

    private void buildShadowCorners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
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
            int i2 = this.mShadowStartColor;
            paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{i2, i2, this.mShadowEndColor}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
            Paint paint2 = this.mEdgeShadowPaint;
            float f7 = this.mCornerRadius;
            float f8 = this.mShadowSize;
            int i3 = this.mShadowStartColor;
            paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i3, i3, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.mEdgeShadowPaint.setAntiAlias(false);
        }
    }

    public static float calculateHorizontalPadding(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? z ? (float) (f2 + ((1.0d - COS_45) * f3)) : f2 : invokeCommon.floatValue;
    }

    public static float calculateVerticalPadding(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? z ? (float) ((f2 * 1.5f) + ((1.0d - COS_45) * f3)) : f2 * 1.5f : invokeCommon.floatValue;
    }

    private void drawShadow(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, canvas) == null) {
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
    }

    private void setBackground(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, colorStateList) == null) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.mBackground = colorStateList;
            this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
        }
    }

    private void setShadowSize(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
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
    }

    private int toEven(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, this, f2)) == null) {
            int i2 = (int) (f2 + 0.5f);
            return i2 % 2 == 1 ? i2 - 1 : i2;
        }
        return invokeF.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            if (this.mDirty) {
                buildComponents(getBounds());
                this.mDirty = false;
            }
            canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
            drawShadow(canvas);
            canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
            sRoundRectHelper.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
        }
    }

    public ColorStateList getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBackground : (ColorStateList) invokeV.objValue;
    }

    public float getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCornerRadius : invokeV.floatValue;
    }

    public void getMaxShadowAndCornerPadding(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            getPadding(rect);
        }
    }

    public float getMaxShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRawMaxShadowSize : invokeV.floatValue;
    }

    public float getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f2 = this.mRawMaxShadowSize;
            return (Math.max(f2, this.mCornerRadius + this.mInsetShadow + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
        }
        return invokeV.floatValue;
    }

    public float getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f2 = this.mRawMaxShadowSize;
            return (Math.max(f2, this.mCornerRadius + this.mInsetShadow + (f2 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rect)) == null) {
            int ceil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            rect.set(ceil2, ceil, ceil2, ceil);
            return true;
        }
        return invokeL.booleanValue;
    }

    public float getShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRawShadowSize : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ColorStateList colorStateList = this.mBackground;
            return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            super.onBoundsChange(rect);
            this.mDirty = true;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
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
        return invokeL.booleanValue;
    }

    public void setAddPaddingForCorners(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mAddPaddingForCorners = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mPaint.setAlpha(i2);
            this.mCornerShadowPaint.setAlpha(i2);
            this.mEdgeShadowPaint.setAlpha(i2);
        }
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorStateList) == null) {
            setBackground(colorStateList);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    public void setCornerRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
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
    }

    public void setMaxShadowSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f2) == null) {
            setShadowSize(this.mRawShadowSize, f2);
        }
    }

    public void setShadowSize(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            setShadowSize(f2, this.mRawMaxShadowSize);
        }
    }
}
