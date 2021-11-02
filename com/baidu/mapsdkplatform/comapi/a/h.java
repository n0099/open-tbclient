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
/* loaded from: classes7.dex */
public class h extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animator f39984a;

    /* renamed from: b  reason: collision with root package name */
    public long f39985b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f39986c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f39987d;

    /* renamed from: e  reason: collision with root package name */
    public int f39988e;

    /* renamed from: f  reason: collision with root package name */
    public int f39989f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f39990g;

    public h(float... fArr) {
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
        this.f39984a = null;
        this.f39985b = 0L;
        this.f39986c = null;
        this.f39987d = null;
        this.f39988e = 1;
        this.f39989f = 0;
        this.f39990g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, marker)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "scale", this.f39990g);
            if (ofFloat != null) {
                ofFloat.setRepeatCount(this.f39989f);
                ofFloat.setRepeatMode(c());
                ofFloat.setDuration(this.f39985b);
                Interpolator interpolator = this.f39986c;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animator = this.f39984a) == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f39988e = i2;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f39985b = j;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, animator) == null) || animator == null) {
            return;
        }
        animator.addListener(new i(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interpolator) == null) {
            this.f39986c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, animationListener) == null) {
            this.f39987d = animationListener;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            ObjectAnimator a2 = a(marker);
            this.f39984a = a2;
            a(a2);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (animator = this.f39984a) == null) {
            return;
        }
        animator.cancel();
        this.f39984a = null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 > 0 || i2 == -1) {
                this.f39989f = i2;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f39988e : invokeV.intValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }
}
