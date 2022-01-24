package com.baidu.apollon.utils.support;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
/* loaded from: classes10.dex */
public final class AnimatorProxy extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean NEEDS_PROXY;
    public static final WeakHashMap<View, AnimatorProxy> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<View> f32769b;

    /* renamed from: c  reason: collision with root package name */
    public final Camera f32770c;

    /* renamed from: d  reason: collision with root package name */
    public final RectF f32771d;

    /* renamed from: e  reason: collision with root package name */
    public final RectF f32772e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f32773f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f32774g;

    /* renamed from: h  reason: collision with root package name */
    public float f32775h;

    /* renamed from: i  reason: collision with root package name */
    public float f32776i;

    /* renamed from: j  reason: collision with root package name */
    public float f32777j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1078454640, "Lcom/baidu/apollon/utils/support/AnimatorProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1078454640, "Lcom/baidu/apollon/utils/support/AnimatorProxy;");
                return;
            }
        }
        NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        a = new WeakHashMap<>();
    }

    public AnimatorProxy(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32770c = new Camera();
        this.f32771d = new RectF();
        this.f32772e = new RectF();
        this.f32773f = new Matrix();
        this.f32775h = 1.0f;
        this.n = 1.0f;
        this.o = 1.0f;
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f32769b = new WeakReference<>(view);
    }

    private void a() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        a(this.f32771d, view);
    }

    private void b() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, this) == null) || (view = this.f32769b.get()) == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f32772e;
        a(rectF, view);
        rectF.union(this.f32771d);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public static AnimatorProxy wrap(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, view)) == null) {
            AnimatorProxy animatorProxy = a.get(view);
            if (animatorProxy == null || animatorProxy != view.getAnimation()) {
                AnimatorProxy animatorProxy2 = new AnimatorProxy(view);
                a.put(view, animatorProxy2);
                return animatorProxy2;
            }
            return animatorProxy;
        }
        return (AnimatorProxy) invokeL.objValue;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        transformation.setAlpha(this.f32775h);
        a(transformation.getMatrix(), view);
    }

    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f32775h : invokeV.floatValue;
    }

    public float getPivotX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f32776i : invokeV.floatValue;
    }

    public float getPivotY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f32777j : invokeV.floatValue;
    }

    public float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : invokeV.floatValue;
    }

    public float getRotationX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : invokeV.floatValue;
    }

    public float getRotationY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.floatValue;
    }

    public float getScaleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.n : invokeV.floatValue;
    }

    public float getScaleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.o : invokeV.floatValue;
    }

    public int getScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            View view = this.f32769b.get();
            if (view == null) {
                return 0;
            }
            return view.getScrollX();
        }
        return invokeV.intValue;
    }

    public int getScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View view = this.f32769b.get();
            if (view == null) {
                return 0;
            }
            return view.getScrollY();
        }
        return invokeV.intValue;
    }

    public float getTranslationX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.p : invokeV.floatValue;
    }

    public float getTranslationY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.q : invokeV.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View view = this.f32769b.get();
            if (view == null) {
                return 0.0f;
            }
            return view.getLeft() + this.p;
        }
        return invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            View view = this.f32769b.get();
            if (view == null) {
                return 0.0f;
            }
            return view.getTop() + this.q;
        }
        return invokeV.floatValue;
    }

    public void setAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048591, this, f2) == null) || this.f32775h == f2) {
            return;
        }
        this.f32775h = f2;
        View view = this.f32769b.get();
        if (view != null) {
            view.invalidate();
        }
    }

    public void setPivotX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            if (this.f32774g && this.f32776i == f2) {
                return;
            }
            a();
            this.f32774g = true;
            this.f32776i = f2;
            b();
        }
    }

    public void setPivotY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            if (this.f32774g && this.f32777j == f2) {
                return;
            }
            a();
            this.f32774g = true;
            this.f32777j = f2;
            b();
        }
    }

    public void setRotation(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048594, this, f2) == null) || this.m == f2) {
            return;
        }
        a();
        this.m = f2;
        b();
    }

    public void setRotationX(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048595, this, f2) == null) || this.k == f2) {
            return;
        }
        a();
        this.k = f2;
        b();
    }

    public void setRotationY(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048596, this, f2) == null) || this.l == f2) {
            return;
        }
        a();
        this.l = f2;
        b();
    }

    public void setScaleX(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048597, this, f2) == null) || this.n == f2) {
            return;
        }
        a();
        this.n = f2;
        b();
    }

    public void setScaleY(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048598, this, f2) == null) || this.o == f2) {
            return;
        }
        a();
        this.o = f2;
        b();
    }

    public void setScrollX(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i2) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        view.scrollTo(i2, view.getScrollY());
    }

    public void setScrollY(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        view.scrollTo(view.getScrollX(), i2);
    }

    public void setTranslationX(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048601, this, f2) == null) || this.p == f2) {
            return;
        }
        a();
        this.p = f2;
        b();
    }

    public void setTranslationY(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048602, this, f2) == null) || this.q == f2) {
            return;
        }
        a();
        this.q = f2;
        b();
    }

    public void setX(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048603, this, f2) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        setTranslationX(f2 - view.getLeft());
    }

    public void setY(float f2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048604, this, f2) == null) || (view = this.f32769b.get()) == null) {
            return;
        }
        setTranslationY(f2 - view.getTop());
    }

    private void a(RectF rectF, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, rectF, view) == null) {
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            Matrix matrix = this.f32773f;
            matrix.reset();
            a(matrix, view);
            this.f32773f.mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            float f2 = rectF.right;
            float f3 = rectF.left;
            if (f2 < f3) {
                rectF.right = f3;
                rectF.left = f2;
            }
            float f4 = rectF.bottom;
            float f5 = rectF.top;
            if (f4 < f5) {
                rectF.top = f4;
                rectF.bottom = f5;
            }
        }
    }

    private void a(Matrix matrix, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, matrix, view) == null) {
            float width = view.getWidth();
            float height = view.getHeight();
            boolean z = this.f32774g;
            float f2 = z ? this.f32776i : width / 2.0f;
            float f3 = z ? this.f32777j : height / 2.0f;
            float f4 = this.k;
            float f5 = this.l;
            float f6 = this.m;
            if (f4 != 0.0f || f5 != 0.0f || f6 != 0.0f) {
                Camera camera = this.f32770c;
                camera.save();
                camera.rotateX(f4);
                camera.rotateY(f5);
                camera.rotateZ(-f6);
                camera.getMatrix(matrix);
                camera.restore();
                matrix.preTranslate(-f2, -f3);
                matrix.postTranslate(f2, f3);
            }
            float f7 = this.n;
            float f8 = this.o;
            if (f7 != 1.0f || f8 != 1.0f) {
                matrix.postScale(f7, f8);
                matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
            }
            matrix.postTranslate(this.p, this.q);
        }
    }
}
