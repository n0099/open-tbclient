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

    /* renamed from: e  reason: collision with root package name */
    public int f11349e;

    /* renamed from: f  reason: collision with root package name */
    public int f11350f;

    /* renamed from: g  reason: collision with root package name */
    public int f11351g;

    /* renamed from: h  reason: collision with root package name */
    public long f11352h;

    /* renamed from: i  reason: collision with root package name */
    public Transformation f11353i;
    public Interpolator j;
    public AnimationSet k;
    public Drawable l;
    public float m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EfficientProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11351g = g(66);
        this.f11352h = -1L;
        this.f11353i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    public final int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? (int) ((g(66) / 1500.0f) * ((float) j)) : invokeJ.intValue;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? i2 / 100 : invokeI.intValue;
    }

    public final void c(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && getVisibility() == 0) {
            if (z) {
                this.k = new AnimationSet(false);
                AlphaAnimation alphaAnimation = new AlphaAnimation(this.f11350f / 10000.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setInterpolator(this.j);
                this.k.addAnimation(alphaAnimation);
                this.f11353i.clear();
                this.k.start();
                invalidate();
                return;
            }
            f();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(11)
    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            float f2 = width > 0 ? ((10000 - this.f11350f) / 10000.0f) * width : -1.0f;
            if (f2 > 0.0f) {
                if (Build.VERSION.SDK_INT >= 11) {
                    setTranslationX(-f2);
                }
                this.m = f2;
            }
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f11350f = 0;
            this.f11349e = 0;
            this.f11352h = -1L;
            this.k = null;
            h(0, false);
            setVisibility(4);
        }
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 * 100 : invokeI.intValue;
    }

    public final void h(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 > 10000) {
                i2 = 10000;
            }
            this.f11350f = i2;
            e();
            if (z) {
                postInvalidateDelayed(50L);
            } else {
                invalidate();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f11350f = 0;
            this.f11349e = 0;
            this.k = null;
            this.f11352h = System.currentTimeMillis();
            h(this.f11350f, false);
            setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) || this.l == null) {
            return;
        }
        AnimationSet animationSet = this.k;
        if (animationSet != null) {
            if (animationSet.getTransformation(getDrawingTime(), this.f11353i)) {
                h((int) (this.f11353i.getAlpha() * 10000.0f), false);
            } else {
                this.k = null;
                f();
            }
        } else if (this.f11352h != -1 && this.f11350f < this.f11351g) {
            long currentTimeMillis = System.currentTimeMillis();
            int a2 = a(currentTimeMillis - this.f11352h);
            int i2 = this.f11350f + a2;
            this.f11350f = i2;
            if (a2 != 0) {
                this.f11352h = currentTimeMillis;
                h(i2, true);
            }
        }
        int i3 = -1;
        if (getPaddingLeft() > 0) {
            i3 = canvas.save();
            canvas.clipRect(this.m + getPaddingLeft(), 0.0f, getWidth(), getHeight());
        }
        this.l.draw(canvas);
        if (i3 >= 0) {
            canvas.restoreToCount(i3);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) && z && (drawable = this.l) != null) {
            drawable.setBounds(getPaddingLeft(), getPaddingTop(), (i4 - i2) - getPaddingRight(), (i5 - i3) - getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i2);
            Drawable drawable = this.l;
            setMeasuredDimension(size, (drawable == null ? 0 : drawable.getIntrinsicHeight()) + getPaddingBottom() + getPaddingTop());
        }
    }

    public void setProgress(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 == 100 && b(this.f11349e) == 100) {
                return;
            }
            this.f11349e = g(i2);
            if (i2 == 100) {
                if (this.k == null) {
                    c(z);
                }
            } else if (this.f11352h == -1) {
                i();
            }
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, drawable) == null) {
            this.l = drawable;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f11351g = g(66);
        this.f11352h = -1L;
        this.f11353i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EfficientProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f11351g = g(66);
        this.f11352h = -1L;
        this.f11353i = new Transformation();
        this.j = new DecelerateInterpolator(2.0f);
        this.m = -1.0f;
        d();
    }
}
