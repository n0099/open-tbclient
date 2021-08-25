package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.animation.Animation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b implements Animator.AnimatorListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f41963a;

    public b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41963a = aVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            animationListener = this.f41963a.f41959d;
            if (animationListener != null) {
                animationListener2 = this.f41963a.f41959d;
                animationListener2.onAnimationCancel();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            animationListener = this.f41963a.f41959d;
            if (animationListener != null) {
                animationListener2 = this.f41963a.f41959d;
                animationListener2.onAnimationEnd();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            animationListener = this.f41963a.f41959d;
            if (animationListener != null) {
                animationListener2 = this.f41963a.f41959d;
                animationListener2.onAnimationRepeat();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Animation.AnimationListener animationListener;
        Animation.AnimationListener animationListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            animationListener = this.f41963a.f41959d;
            if (animationListener != null) {
                animationListener2 = this.f41963a.f41959d;
                animationListener2.onAnimationStart();
            }
        }
    }
}
