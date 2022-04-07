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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ShadowDrawable extends Drawable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL = 4369;
    public static final int BOTTOM = 4096;
    public static final int LEFT = 1;
    public static final int NO_BOTTOM = 273;
    public static final int NO_TOP = 4353;
    public static final int RIGHT = 256;
    public static final int SHAPE_CIRCLE = 2;
    public static final int SHAPE_ROUND = 1;
    public static final int TOP = 16;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] mBgColor;
    public Paint mBgPaint;
    public LinearGradient mLinearGradient;
    public int mOffsetX;
    public int mOffsetY;
    public RectF mRect;
    public int mShadowColor;
    public Paint mShadowPaint;
    public int mShadowRadius;
    public int mShadowSide;
    public int mShape;
    public int mShapeRadius;

    /* loaded from: classes3.dex */
    public @interface ShadowSide {
    }

    /* loaded from: classes3.dex */
    public @interface Shape {
    }

    public ShadowDrawable() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mShadowSide = ALL;
        this.mShape = 1;
        this.mShapeRadius = 0;
        this.mShadowColor = SelectorHelper.parseColor("#4d000000");
        this.mShadowRadius = SelectorHelper.dip2px(12.0f);
        this.mOffsetX = 0;
        this.mOffsetY = 0;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new ShadowDrawable() : (ShadowDrawable) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        LinearGradient linearGradient;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
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
                int i = this.mShapeRadius;
                canvas.drawRoundRect(rectF, i, i, this.mShadowPaint);
                RectF rectF2 = this.mRect;
                int i2 = this.mShapeRadius;
                canvas.drawRoundRect(rectF2, i2, i2, this.mBgPaint);
                return;
            }
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
            canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mBgPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public void into(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || view2 == null) {
            return;
        }
        view2.setLayerType(1, null);
        ViewCompat.setBackground(view2, this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rect) == null) {
            super.onBoundsChange(rect);
            if (this.mShape == 1) {
                this.mRect = new RectF(rect.left + ((this.mShadowSide & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.mShapeRadius), rect.top + ((this.mShadowSide & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.mShapeRadius), rect.right - ((this.mShadowSide & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.mShapeRadius), rect.bottom - ((this.mShadowSide & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.mShapeRadius));
            } else {
                int i = this.mShadowRadius;
                this.mRect = new RectF(rect.left + i, rect.top + i, rect.right - i, rect.bottom - i);
            }
            int[] iArr = this.mBgColor;
            if (iArr == null || iArr.length <= 1) {
                return;
            }
            RectF rectF = this.mRect;
            float f = rectF.left;
            float height = rectF.height() / 2.0f;
            RectF rectF2 = this.mRect;
            this.mLinearGradient = new LinearGradient(f, height, rectF2.right, rectF2.height() / 2.0f, this.mBgColor, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mShadowPaint.setAlpha(i);
        }
    }

    public ShadowDrawable setBgColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.mBgColor[0] = SelectorHelper.getColor(i);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, colorFilter) == null) {
            this.mShadowPaint.setColorFilter(colorFilter);
        }
    }

    public ShadowDrawable setOffsetX(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
            this.mOffsetX = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, i, this.mOffsetY, this.mShadowColor);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setOffsetY(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.mOffsetY = i;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, i, this.mShadowColor);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShadowAlpha(@IntRange(from = 0, to = 255) int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            setAlpha(i);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShadowColor(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            int color = SelectorHelper.getColor(i);
            this.mShadowColor = color;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, color);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShadowLayer(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048592, this, i, i2, i3, i4)) == null) {
            int color = SelectorHelper.getColor(i);
            this.mShadowColor = color;
            this.mShadowRadius = i4;
            this.mOffsetX = i2;
            this.mOffsetY = i3;
            this.mShadowPaint.setShadowLayer(i4, i2, i3, color);
            return this;
        }
        return (ShadowDrawable) invokeIIII.objValue;
    }

    public ShadowDrawable setShadowOpacity(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            int color = SelectorHelper.getColor(i, f);
            this.mShadowColor = color;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, color);
            return this;
        }
        return (ShadowDrawable) invokeCommon.objValue;
    }

    public ShadowDrawable setShadowRadius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
            this.mShadowRadius = i;
            this.mShadowPaint.setShadowLayer(i, this.mOffsetX, this.mOffsetY, this.mShadowColor);
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShadowSide(@ShadowSide int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            this.mShadowSide = i;
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShape(@Shape int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
            this.mShape = i;
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setShapeRadius(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
            this.mShapeRadius = i;
            return this;
        }
        return (ShadowDrawable) invokeI.objValue;
    }

    public ShadowDrawable setBgColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.mBgColor[0] = SelectorHelper.parseColor(str);
            return this;
        }
        return (ShadowDrawable) invokeL.objValue;
    }

    public ShadowDrawable setBgColor(@ColorRes int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, iArr)) == null) {
            int length = iArr.length;
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                iArr2[i] = SelectorHelper.getColor(iArr[i]);
            }
            this.mBgColor = iArr2;
            return this;
        }
        return (ShadowDrawable) invokeL.objValue;
    }

    public ShadowDrawable setShadowColor(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            int parseColor = SelectorHelper.parseColor(str);
            this.mShadowColor = parseColor;
            this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, parseColor);
            return this;
        }
        return (ShadowDrawable) invokeL.objValue;
    }

    public ShadowDrawable setShadowLayer(int i, float f, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            this.mShadowRadius = i4;
            this.mOffsetX = i2;
            this.mOffsetY = i3;
            setShadowOpacity(i, f);
            return this;
        }
        return (ShadowDrawable) invokeCommon.objValue;
    }

    public ShadowDrawable setBgColor(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = SelectorHelper.parseColor(strArr[i]);
            }
            this.mBgColor = iArr;
            return this;
        }
        return (ShadowDrawable) invokeL.objValue;
    }
}
