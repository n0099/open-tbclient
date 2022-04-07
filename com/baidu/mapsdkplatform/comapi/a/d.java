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
/* loaded from: classes2.dex */
public class d extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animator a;
    public long b;
    public Interpolator c;
    public Animation.AnimationListener d;
    public int e;
    public ArrayList<Animation> f;

    public d() {
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
        this.a = null;
        this.b = 0L;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = new ArrayList<>();
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
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            if (j < 0) {
                j = 0;
            }
            this.b = j;
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
            this.c = interpolator;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, animationListener) == null) {
            this.d = animationListener;
        }
    }

    public void a(Animation animation) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, animation) == null) || this.f.contains(animation)) {
            return;
        }
        this.f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, marker, animation) == null) {
            this.a = new AnimatorSet();
            ArrayList<Animation> arrayList = this.f;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.clear();
            for (int i = 0; i < arrayList.size(); i++) {
                Animation animation2 = arrayList.get(i);
                if (animation2 != null && (b = b(marker, animation2)) != null) {
                    arrayList2.add(b);
                }
            }
            long j = this.b;
            if (j != 0) {
                this.a.setDuration(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null) {
                this.a.setInterpolator(interpolator);
            }
            if (arrayList2.size() != 0) {
                int i2 = this.e;
                if (i2 == 0) {
                    ((AnimatorSet) this.a).playTogether(arrayList2);
                } else if (i2 == 1) {
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
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.e = i;
        }
    }
}
