package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes.dex */
public class RoundRectDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ColorStateList mBackground;
    public final RectF mBoundsF;
    public final Rect mBoundsI;
    public boolean mInsetForPadding;
    public boolean mInsetForRadius;
    public float mPadding;
    public final Paint mPaint;
    public float mRadius;
    public ColorStateList mTint;
    public PorterDuffColorFilter mTintFilter;
    public PorterDuff.Mode mTintMode;

    public RoundRectDrawable(ColorStateList colorStateList, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {colorStateList, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInsetForPadding = false;
        this.mInsetForRadius = true;
        this.mTintMode = PorterDuff.Mode.SRC_IN;
        this.mRadius = f;
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, colorStateList, mode)) == null) {
            if (colorStateList == null || mode == null) {
                return null;
            }
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return (PorterDuffColorFilter) invokeLL.objValue;
    }

    private void setBackground(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, colorStateList) == null) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.mBackground = colorStateList;
            this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
        }
    }

    private void updateBounds(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, rect) == null) {
            if (rect == null) {
                rect = getBounds();
            }
            this.mBoundsF.set(rect.left, rect.top, rect.right, rect.bottom);
            this.mBoundsI.set(rect);
            if (this.mInsetForPadding) {
                float calculateVerticalPadding = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
                this.mBoundsI.inset((int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mPadding, this.mRadius, this.mInsetForRadius)), (int) Math.ceil(calculateVerticalPadding));
                this.mBoundsF.set(this.mBoundsI);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Paint paint = this.mPaint;
            if (this.mTintFilter == null || paint.getColorFilter() != null) {
                z = false;
            } else {
                paint.setColorFilter(this.mTintFilter);
                z = true;
            }
            RectF rectF = this.mBoundsF;
            float f = this.mRadius;
            canvas.drawRoundRect(rectF, f, f, paint);
            if (z) {
                paint.setColorFilter(null);
            }
        }
    }

    public ColorStateList getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBackground : (ColorStateList) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, outline) == null) {
            outline.setRoundRect(this.mBoundsI, this.mRadius);
        }
    }

    public float getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPadding : invokeV.floatValue;
    }

    public float getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRadius : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        ColorStateList colorStateList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ColorStateList colorStateList2 = this.mTint;
            return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.mBackground) != null && colorStateList.isStateful()) || super.isStateful();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, rect) == null) {
            super.onBoundsChange(rect);
            updateBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        PorterDuff.Mode mode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            ColorStateList colorStateList = this.mBackground;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            boolean z = colorForState != this.mPaint.getColor();
            if (z) {
                this.mPaint.setColor(colorForState);
            }
            ColorStateList colorStateList2 = this.mTint;
            if (colorStateList2 == null || (mode = this.mTintMode) == null) {
                return z;
            }
            this.mTintFilter = createTintFilter(colorStateList2, mode);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mPaint.setAlpha(i);
        }
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, colorStateList) == null) {
            setBackground(colorStateList);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
        }
    }

    public void setPadding(float f, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (f == this.mPadding && this.mInsetForPadding == z && this.mInsetForRadius == z2) {
                return;
            }
            this.mPadding = f;
            this.mInsetForPadding = z;
            this.mInsetForRadius = z2;
            updateBounds(null);
            invalidateSelf();
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048589, this, f) == null) || f == this.mRadius) {
            return;
        }
        this.mRadius = f;
        updateBounds(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorStateList) == null) {
            this.mTint = colorStateList;
            this.mTintFilter = createTintFilter(colorStateList, this.mTintMode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, mode) == null) {
            this.mTintMode = mode;
            this.mTintFilter = createTintFilter(this.mTint, mode);
            invalidateSelf();
        }
    }
}
