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
/* loaded from: classes3.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animator f7546a;

    /* renamed from: b  reason: collision with root package name */
    public long f7547b;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7548c;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7549d;

    /* renamed from: e  reason: collision with root package name */
    public int f7550e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Animation> f7551f;

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
        this.f7546a = null;
        this.f7547b = 0L;
        this.f7548c = null;
        this.f7549d = null;
        this.f7550e = 0;
        this.f7551f = new ArrayList<>();
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (animator = this.f7546a) == null) {
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
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.f7547b = j;
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
            this.f7548c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animationListener) == null) {
            this.f7549d = animationListener;
        }
    }

    public void a(Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, animation) == null) || this.f7551f.contains(animation)) {
            return;
        }
        this.f7551f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            this.f7546a = new AnimatorSet();
            ArrayList<Animation> arrayList = this.f7551f;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.clear();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Animation animation2 = arrayList.get(i2);
                if (animation2 != null && (b2 = b(marker, animation2)) != null) {
                    arrayList2.add(b2);
                }
            }
            long j = this.f7547b;
            if (j != 0) {
                this.f7546a.setDuration(j);
            }
            Interpolator interpolator = this.f7548c;
            if (interpolator != null) {
                this.f7546a.setInterpolator(interpolator);
            }
            if (arrayList2.size() != 0) {
                int i3 = this.f7550e;
                if (i3 == 0) {
                    ((AnimatorSet) this.f7546a).playTogether(arrayList2);
                } else if (i3 == 1) {
                    ((AnimatorSet) this.f7546a).playSequentially(arrayList2);
                }
            }
            a(this.f7546a);
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (animator = this.f7546a) == null) {
            return;
        }
        animator.cancel();
        this.f7546a = null;
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
            this.f7550e = i2;
        }
    }
}
