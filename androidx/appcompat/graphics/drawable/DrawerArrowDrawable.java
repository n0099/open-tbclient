package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    public static final float ARROW_HEAD_ANGLE;
    public transient /* synthetic */ FieldHolder $fh;
    public float mArrowHeadLength;
    public float mArrowShaftLength;
    public float mBarGap;
    public float mBarLength;
    public int mDirection;
    public float mMaxCutForBarSize;
    public final Paint mPaint;
    public final Path mPath;
    public float mProgress;
    public final int mSize;
    public boolean mSpin;
    public boolean mVerticalMirror;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ArrowDirection {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1163285928, "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1163285928, "Landroidx/appcompat/graphics/drawable/DrawerArrowDrawable;");
                return;
            }
        }
        ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    }

    public DrawerArrowDrawable(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R$styleable.DrawerArrowToggle, R$attr.drawerArrowStyle, R$style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R$styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R$styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(R$styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static float lerp(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? f2 + ((f3 - f2) * f4) : invokeCommon.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            Rect bounds = getBounds();
            int i2 = this.mDirection;
            boolean z = false;
            if (i2 != 0 && (i2 == 1 || (i2 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
                z = true;
            }
            float f3 = this.mArrowHeadLength;
            float lerp = lerp(this.mBarLength, (float) Math.sqrt(f3 * f3 * 2.0f), this.mProgress);
            float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
            float round = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
            float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
            float lerp4 = lerp(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.mProgress);
            double d2 = lerp;
            double d3 = lerp3;
            boolean z2 = z;
            float round2 = (float) Math.round(Math.cos(d3) * d2);
            float round3 = (float) Math.round(d2 * Math.sin(d3));
            this.mPath.rewind();
            float lerp5 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
            float f4 = (-lerp2) / 2.0f;
            this.mPath.moveTo(f4 + round, 0.0f);
            this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
            this.mPath.moveTo(f4, lerp5);
            this.mPath.rLineTo(round2, round3);
            this.mPath.moveTo(f4, -lerp5);
            this.mPath.rLineTo(round2, -round3);
            this.mPath.close();
            canvas.save();
            float strokeWidth = this.mPaint.getStrokeWidth();
            float height = bounds.height() - (3.0f * strokeWidth);
            canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * f2))) / 4) * 2) + (strokeWidth * 1.5f) + this.mBarGap);
            if (this.mSpin) {
                canvas.rotate(lerp4 * (this.mVerticalMirror ^ z2 ? -1 : 1));
            } else if (z2) {
                canvas.rotate(180.0f);
            }
            canvas.drawPath(this.mPath, this.mPaint);
            canvas.restore();
        }
    }

    public float getArrowHeadLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mArrowHeadLength : invokeV.floatValue;
    }

    public float getArrowShaftLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mArrowShaftLength : invokeV.floatValue;
    }

    public float getBarLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mBarLength : invokeV.floatValue;
    }

    public float getBarThickness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPaint.getStrokeWidth() : invokeV.floatValue;
    }

    @ColorInt
    public int getColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPaint.getColor() : invokeV.intValue;
    }

    public int getDirection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mDirection : invokeV.intValue;
    }

    public float getGapSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mBarGap : invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSize : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mSize : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public final Paint getPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mPaint : (Paint) invokeV.objValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mProgress : invokeV.floatValue;
    }

    public boolean isSpinEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSpin : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || i2 == this.mPaint.getAlpha()) {
            return;
        }
        this.mPaint.setAlpha(i2);
        invalidateSelf();
    }

    public void setArrowHeadLength(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || this.mArrowHeadLength == f2) {
            return;
        }
        this.mArrowHeadLength = f2;
        invalidateSelf();
    }

    public void setArrowShaftLength(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048592, this, f2) == null) || this.mArrowShaftLength == f2) {
            return;
        }
        this.mArrowShaftLength = f2;
        invalidateSelf();
    }

    public void setBarLength(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048593, this, f2) == null) || this.mBarLength == f2) {
            return;
        }
        this.mBarLength = f2;
        invalidateSelf();
    }

    public void setBarThickness(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f2) == null) || this.mPaint.getStrokeWidth() == f2) {
            return;
        }
        this.mPaint.setStrokeWidth(f2);
        this.mMaxCutForBarSize = (float) ((f2 / 2.0f) * Math.cos(ARROW_HEAD_ANGLE));
        invalidateSelf();
    }

    public void setColor(@ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 == this.mPaint.getColor()) {
            return;
        }
        this.mPaint.setColor(i2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, colorFilter) == null) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void setDirection(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || i2 == this.mDirection) {
            return;
        }
        this.mDirection = i2;
        invalidateSelf();
    }

    public void setGapSize(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048598, this, f2) == null) || f2 == this.mBarGap) {
            return;
        }
        this.mBarGap = f2;
        invalidateSelf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048599, this, f2) == null) || this.mProgress == f2) {
            return;
        }
        this.mProgress = f2;
        invalidateSelf();
    }

    public void setSpinEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || this.mSpin == z) {
            return;
        }
        this.mSpin = z;
        invalidateSelf();
    }

    public void setVerticalMirror(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || this.mVerticalMirror == z) {
            return;
        }
        this.mVerticalMirror = z;
        invalidateSelf();
    }
}
