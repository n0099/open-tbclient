package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animator a;

    /* renamed from: b  reason: collision with root package name */
    public long f36809b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f36810c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f36811d;

    /* renamed from: e  reason: collision with root package name */
    public int f36812e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Animation> f36813f;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.f36809b = 0L;
        this.f36810c = null;
        this.f36811d = null;
        this.f36812e = 0;
        this.f36813f = new ArrayList<>();
    }

    @TargetApi(11)
    private ObjectAnimator b(Marker marker, Animation animation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, marker, animation)) == null) {
            if (animation instanceof AlphaAnimation) {
                return ((a) animation.bdAnimation).a(marker);
            }
            if (animation instanceof RotateAnimation) {
                return ((f) animation.bdAnimation).a(marker);
            }
            if (animation instanceof Transformation) {
                return ((l) animation.bdAnimation).a(marker);
            }
            if (animation instanceof ScaleAnimation) {
                return ((h) animation.bdAnimation).a(marker);
            }
            if (animation instanceof SingleScaleAnimation) {
                return ((j) animation.bdAnimation).a(marker);
            }
            return null;
        }
        return (ObjectAnimator) invokeLL.objValue;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (animator = this.a) == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            if (j2 < 0) {
                j2 = 0;
            }
            this.f36809b = j2;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || animator == null) {
            return;
        }
        animator.addListener(new e(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, interpolator) == null) {
            this.f36810c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animationListener) == null) {
            this.f36811d = animationListener;
        }
    }

    public void a(Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, animation) == null) || this.f36813f.contains(animation)) {
            return;
        }
        this.f36813f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            this.a = new AnimatorSet();
            ArrayList<Animation> arrayList = this.f36813f;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.clear();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Animation animation2 = arrayList.get(i2);
                if (animation2 != null && (b2 = b(marker, animation2)) != null) {
                    arrayList2.add(b2);
                }
            }
            long j2 = this.f36809b;
            if (j2 != 0) {
                this.a.setDuration(j2);
            }
            Interpolator interpolator = this.f36810c;
            if (interpolator != null) {
                this.a.setInterpolator(interpolator);
            }
            if (arrayList2.size() != 0) {
                int i3 = this.f36812e;
                if (i3 == 0) {
                    ((AnimatorSet) this.a).playTogether(arrayList2);
                } else if (i3 == 1) {
                    ((AnimatorSet) this.a).playSequentially(arrayList2);
                }
            }
            a(this.a);
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
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f36812e = i2;
        }
    }
}
