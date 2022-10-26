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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
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

    public ColorStateList getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBackground;
        }
        return (ColorStateList) invokeV.objValue;
    }

    public float getCornerRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCornerRadius;
        }
        return invokeV.floatValue;
    }

    public float getMaxShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRawMaxShadowSize;
        }
        return invokeV.floatValue;
    }

    public float getMinWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.mRawMaxShadowSize;
            return (Math.max(f, this.mCornerRadius + this.mInsetShadow + (f / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + this.mInsetShadow) * 2.0f);
        }
        return invokeV.floatValue;
    }

    public float getShadowSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mRawShadowSize;
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ColorStateList colorStateList = this.mBackground;
            if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {resources, colorStateList, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDirty = true;
        this.mAddPaddingForCorners = true;
        this.mPrintedShadowClipWarning = false;
        this.mShadowStartColor = resources.getColor(R.color.obfuscated_res_0x7f06044f);
        this.mShadowEndColor = resources.getColor(R.color.obfuscated_res_0x7f06044e);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701b3);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (int) (f + 0.5f);
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f2, f3);
    }

    private void buildComponents(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, rect) == null) {
            float f = this.mRawMaxShadowSize;
            float f2 = 1.5f * f;
            this.mCardBounds.set(rect.left + f, rect.top + f2, rect.right - f, rect.bottom - f2);
            buildShadowCorners();
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

    private int toEven(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, this, f)) == null) {
            int i = (int) (f + 0.5f);
            if (i % 2 == 1) {
                return i - 1;
            }
            return i;
        }
        return invokeF.intValue;
    }

    public void getMaxShadowAndCornerPadding(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            getPadding(rect);
        }
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
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mPaint.setAlpha(i);
            this.mCornerShadowPaint.setAlpha(i);
            this.mEdgeShadowPaint.setAlpha(i);
        }
    }

    public void setColor(ColorStateList colorStateList) {
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

    public void setMaxShadowSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            setShadowSize(this.mRawShadowSize, f);
        }
    }

    public void setShadowSize(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f) == null) {
            setShadowSize(f, this.mRawMaxShadowSize);
        }
    }

    private void buildShadowCorners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            float f = this.mCornerRadius;
            RectF rectF = new RectF(-f, -f, f, f);
            RectF rectF2 = new RectF(rectF);
            float f2 = this.mShadowSize;
            rectF2.inset(-f2, -f2);
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
            float f3 = this.mCornerRadius;
            float f4 = f3 / (this.mShadowSize + f3);
            Paint paint = this.mCornerShadowPaint;
            float f5 = this.mCornerRadius + this.mShadowSize;
            int i = this.mShadowStartColor;
            paint.setShader(new RadialGradient(0.0f, 0.0f, f5, new int[]{i, i, this.mShadowEndColor}, new float[]{0.0f, f4, 1.0f}, Shader.TileMode.CLAMP));
            Paint paint2 = this.mEdgeShadowPaint;
            float f6 = this.mCornerRadius;
            float f7 = this.mShadowSize;
            int i2 = this.mShadowStartColor;
            paint2.setShader(new LinearGradient(0.0f, (-f6) + f7, 0.0f, (-f6) - f7, new int[]{i2, i2, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            this.mEdgeShadowPaint.setAntiAlias(false);
        }
    }

    public static float calculateHorizontalPadding(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return (float) (f + ((1.0d - COS_45) * f2));
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    public static float calculateVerticalPadding(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            if (z) {
                return (float) ((f * 1.5f) + ((1.0d - COS_45) * f2));
            }
            return f * 1.5f;
        }
        return invokeCommon.floatValue;
    }

    private void drawShadow(Canvas canvas) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, canvas) == null) {
            float f = this.mCornerRadius;
            float f2 = (-f) - this.mShadowSize;
            float f3 = f + this.mInsetShadow + (this.mRawShadowSize / 2.0f);
            float f4 = f3 * 2.0f;
            if (this.mCardBounds.width() - f4 > 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (this.mCardBounds.height() - f4 > 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            int save = canvas.save();
            RectF rectF = this.mCardBounds;
            canvas.translate(rectF.left + f3, rectF.top + f3);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z) {
                canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save);
            int save2 = canvas.save();
            RectF rectF2 = this.mCardBounds;
            canvas.translate(rectF2.right - f3, rectF2.bottom - f3);
            canvas.rotate(180.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z) {
                canvas.drawRect(0.0f, f2, this.mCardBounds.width() - f4, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save2);
            int save3 = canvas.save();
            RectF rectF3 = this.mCardBounds;
            canvas.translate(rectF3.left + f3, rectF3.bottom - f3);
            canvas.rotate(270.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z2) {
                canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save3);
            int save4 = canvas.save();
            RectF rectF4 = this.mCardBounds;
            canvas.translate(rectF4.right - f3, rectF4.top + f3);
            canvas.rotate(90.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z2) {
                canvas.drawRect(0.0f, f2, this.mCardBounds.height() - f4, -this.mCornerRadius, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save4);
        }
    }

    private void setShadowSize(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (f >= 0.0f) {
                if (f2 >= 0.0f) {
                    float even = toEven(f);
                    float even2 = toEven(f2);
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
                    return;
                }
                throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
            }
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
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

    public void setCornerRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            if (f >= 0.0f) {
                float f2 = (int) (f + 0.5f);
                if (this.mCornerRadius == f2) {
                    return;
                }
                this.mCornerRadius = f2;
                this.mDirty = true;
                invalidateSelf();
                return;
            }
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
    }

    public float getMinHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float f = this.mRawMaxShadowSize;
            return (Math.max(f, this.mCornerRadius + this.mInsetShadow + ((f * 1.5f) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * 1.5f) + this.mInsetShadow) * 2.0f);
        }
        return invokeV.floatValue;
    }
}
