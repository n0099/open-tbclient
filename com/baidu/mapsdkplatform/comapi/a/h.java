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
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes10.dex */
public class h extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animator a;

    /* renamed from: b  reason: collision with root package name */
    public long f35787b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f35788c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f35789d;

    /* renamed from: e  reason: collision with root package name */
    public int f35790e;

    /* renamed from: f  reason: collision with root package name */
    public int f35791f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f35792g;

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
        this.a = null;
        this.f35787b = 0L;
        this.f35788c = null;
        this.f35789d = null;
        this.f35790e = 1;
        this.f35791f = 0;
        this.f35792g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, marker)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, AnimationProperty.SCALE, this.f35792g);
            if (ofFloat != null) {
                ofFloat.setRepeatCount(this.f35791f);
                ofFloat.setRepeatMode(c());
                ofFloat.setDuration(this.f35787b);
                Interpolator interpolator = this.f35788c;
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animator = this.a) == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f35790e = i2;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.f35787b = j2;
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
            this.f35788c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, animationListener) == null) {
            this.f35789d = animationListener;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            ObjectAnimator a = a(marker);
            this.a = a;
            a(a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (animator = this.a) == null) {
            return;
        }
        animator.cancel();
        this.a = null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (i2 > 0 || i2 == -1) {
                this.f35791f = i2;
            }
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f35790e : invokeV.intValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }
}
