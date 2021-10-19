package c.a.r0.w3;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.w3.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class animation.Animation$AnimationListenerC1244a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f26561a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26562b;

        public animation.Animation$AnimationListenerC1244a(Animation.AnimationListener animationListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26561a = animationListener;
            this.f26562b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.f26561a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view = this.f26562b;
                if (view != null) {
                    view.clearAnimation();
                    this.f26562b.setVisibility(0);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) || (animationListener = this.f26561a) == null) {
                return;
            }
            animationListener.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (animationListener = this.f26561a) == null) {
                return;
            }
            animationListener.onAnimationStart(animation);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Animation.AnimationListener f26563a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f26564b;

        public b(Animation.AnimationListener animationListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26563a = animationListener;
            this.f26564b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.f26563a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view = this.f26564b;
                if (view != null) {
                    view.clearAnimation();
                    this.f26564b.setVisibility(8);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) || (animationListener = this.f26563a) == null) {
                return;
            }
            animationListener.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (animationListener = this.f26563a) == null) {
                return;
            }
            animationListener.onAnimationStart(animation);
        }
    }

    public static void a(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, view, i2) == null) {
            b(view, i2, null);
        }
    }

    public static void b(View view, int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65537, null, view, i2, animationListener) == null) || view == null || i2 < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new b(animationListener, view));
        view.setVisibility(8);
        view.startAnimation(alphaAnimation);
    }

    public static void c(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view, i2) == null) {
            d(view, i2, null);
        }
    }

    public static void d(View view, int i2, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, null, view, i2, animationListener) == null) || view == null || i2 < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1244a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
