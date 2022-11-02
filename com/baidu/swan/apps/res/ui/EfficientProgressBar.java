package com.baidu.swan.apps.res.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EfficientProgressBar extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public long d;
    public Transformation e;
    public Interpolator f;
    public AnimationSet g;
    public Drawable h;
    public float i;

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final int g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i * 100 : invokeI.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EfficientProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && getVisibility() == 0) {
            if (z) {
                this.g = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.b / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.f);
                this.g.addAnimation(alphaAnimation);
                this.e.clear();
                this.g.start();
                invalidate();
                return;
            }
            f();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EfficientProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public void setProgress(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 100 && b(this.a) == 100) {
                return;
            }
            this.a = g(i);
            if (i == 100) {
                if (this.g == null) {
                    c(z);
                }
            } else if (this.d == -1) {
                i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = g(66);
        this.d = -1L;
        this.e = new Transformation();
        this.f = new DecelerateInterpolator(2.0f);
        this.i = -1.0f;
        d();
    }

    public final int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return (int) ((g(66) / 1500.0f) * ((float) j));
        }
        return invokeJ.intValue;
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            return i / 100;
        }
        return invokeI.intValue;
    }

    public void setProgressDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.h = drawable;
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public final void e() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            if (width > 0) {
                f = ((10000 - this.b) / 10000.0f) * width;
            } else {
                f = -1.0f;
            }
            if (f > 0.0f) {
                if (Build.VERSION.SDK_INT >= 11) {
                    setTranslationX(-f);
                }
                this.i = f;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b = 0;
            this.a = 0;
            this.d = -1L;
            this.g = null;
            h(0, false);
            setVisibility(4);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = 0;
            this.a = 0;
            this.g = null;
            this.d = System.currentTimeMillis();
            h(this.b, false);
            setVisibility(0);
        }
    }

    public final void h(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i > 10000) {
                i = 10000;
            }
            this.b = i;
            e();
            if (z) {
                postInvalidateDelayed(50L);
            } else {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) && this.h != null) {
            AnimationSet animationSet = this.g;
            if (animationSet != null) {
                if (animationSet.getTransformation(getDrawingTime(), this.e)) {
                    h((int) (this.e.getAlpha() * 10000.0f), false);
                } else {
                    this.g = null;
                    f();
                }
            } else if (this.d != -1 && this.b < this.c) {
                long currentTimeMillis = System.currentTimeMillis();
                int a = a(currentTimeMillis - this.d);
                int i = this.b + a;
                this.b = i;
                if (a != 0) {
                    this.d = currentTimeMillis;
                    h(i, true);
                }
            }
            int i2 = -1;
            if (getPaddingLeft() > 0) {
                i2 = canvas.save();
                canvas.clipRect(this.i + getPaddingLeft(), 0.0f, getWidth(), getHeight());
            }
            this.h.draw(canvas);
            if (i2 >= 0) {
                canvas.restoreToCount(i2);
            }
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && z && (drawable = this.h) != null) {
            drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i3 - i) - getPaddingRight(), (i4 - i2) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i);
            Drawable drawable = this.h;
            if (drawable == null) {
                intrinsicHeight = 0;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
            }
            setMeasuredDimension(size, intrinsicHeight + getPaddingBottom() + getPaddingTop());
        }
    }
}
