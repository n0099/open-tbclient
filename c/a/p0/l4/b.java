package c.a.p0.l4;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16333b;

        public a(Animation.AnimationListener animationListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = animationListener;
            this.f16333b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view = this.f16333b;
                if (view != null) {
                    view.clearAnimation();
                    this.f16333b.setVisibility(0);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationStart(animation);
        }
    }

    /* renamed from: c.a.p0.l4.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class animation.Animation$AnimationListenerC1217b implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Animation.AnimationListener a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f16334b;

        public animation.Animation$AnimationListenerC1217b(Animation.AnimationListener animationListener, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animationListener, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = animationListener;
            this.f16334b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Animation.AnimationListener animationListener = this.a;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(animation);
                }
                View view = this.f16334b;
                if (view != null) {
                    view.clearAnimation();
                    this.f16334b.setVisibility(8);
                }
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationRepeat(animation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) || (animationListener = this.a) == null) {
                return;
            }
            animationListener.onAnimationStart(animation);
        }
    }

    public static void a(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, view, i) == null) {
            b(view, i, null);
        }
    }

    public static void b(View view, int i, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65537, null, view, i, animationListener) == null) || view == null || i < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new animation.Animation$AnimationListenerC1217b(animationListener, view));
        view.setVisibility(8);
        view.startAnimation(alphaAnimation);
    }

    public static void c(View view, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, view, i) == null) {
            d(view, i, null);
        }
    }

    public static void d(View view, int i, Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65539, null, view, i, animationListener) == null) || view == null || i < 0) {
            return;
        }
        view.clearAnimation();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new a(animationListener, view));
        view.setVisibility(0);
        view.startAnimation(alphaAnimation);
    }
}
