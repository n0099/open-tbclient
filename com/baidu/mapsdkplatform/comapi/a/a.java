package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animator f7538a;

    /* renamed from: b  reason: collision with root package name */
    public long f7539b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7540c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7541d;

    /* renamed from: e  reason: collision with root package name */
    public int f7542e;

    /* renamed from: f  reason: collision with root package name */
    public int f7543f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7544g;

    public a(float... fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7538a = null;
        this.f7539b = 0L;
        this.f7540c = null;
        this.f7541d = null;
        this.f7542e = 1;
        this.f7543f = 0;
        this.f7544g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, marker)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f7544g);
            if (ofFloat != null) {
                ofFloat.setRepeatCount(this.f7543f);
                ofFloat.setRepeatMode(c());
                ofFloat.setDuration(this.f7539b);
                Interpolator interpolator = this.f7540c;
                if (interpolator != null) {
                    ofFloat.setInterpolator(interpolator);
                }
            }
            return ofFloat;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animator = this.f7538a) == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f7542e = i2;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f7539b = j;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, animator) == null) || animator == null) {
            return;
        }
        animator.addListener(new b(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interpolator) == null) {
            this.f7540c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, animationListener) == null) {
            this.f7541d = animationListener;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            ObjectAnimator a2 = a(marker);
            this.f7538a = a2;
            a(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (animator = this.f7538a) == null) {
            return;
        }
        animator.cancel();
        this.f7538a = null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 > 0 || i2 == -1) {
                this.f7543f = i2;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f7542e : invokeV.intValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }
}
