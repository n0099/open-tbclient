package c.a.p0.y3.d;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.viewpager.VerticalViewPager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f28831h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f28832i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TBLottieAnimationView f28833e;

    /* renamed from: f  reason: collision with root package name */
    public final VerticalViewPager f28834f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28835g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(707683889, "Lc/a/p0/y3/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(707683889, "Lc/a/p0/y3/d/a;");
                return;
            }
        }
        f28831h = c.a.o0.s.d0.b.j().g("key_video_guide_up_slide_animated", false);
        f28832i = c.a.o0.s.d0.b.j().g("key_video_guide_left_slide_animated", false);
    }

    public a(TBLottieAnimationView tBLottieAnimationView, VerticalViewPager verticalViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tBLottieAnimationView, verticalViewPager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f28835g = false;
        this.f28833e = tBLottieAnimationView;
        this.f28834f = verticalViewPager;
        f();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f28832i = true;
        }
    }

    public final void b(VerticalViewPager verticalViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, verticalViewPager) == null) {
            verticalViewPager.setCurrentItem(verticalViewPager.getCurrentItem() + 1, true);
        }
    }

    public void c() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tBLottieAnimationView = this.f28833e) == null || this.f28834f == null || this.f28835g || !f28831h || f28832i || tBLottieAnimationView.isAnimating()) {
            return;
        }
        this.f28833e.setImageAssetsFolder("lottie_video_guide_left");
        k(R.raw.lottie_video_guide_left);
        f28832i = true;
        this.f28835g = true;
        c.a.o0.s.d0.b.j().t("key_video_guide_left_slide_animated", true);
    }

    public void d() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tBLottieAnimationView = this.f28833e) == null || this.f28834f == null || this.f28835g || f28831h || tBLottieAnimationView.isAnimating()) {
            return;
        }
        this.f28833e.setImageAssetsFolder("lottie_video_guide_up");
        k(R.raw.lottie_video_guide_up);
        f28831h = true;
        this.f28835g = true;
        c.a.o0.s.d0.b.j().t("key_video_guide_up_slide_animated", true);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f28833e.isAnimating()) {
                this.f28833e.pauseAnimation();
            }
            this.f28833e.setVisibility(8);
        }
    }

    public final void f() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tBLottieAnimationView = this.f28833e) == null || this.f28834f == null) {
            return;
        }
        tBLottieAnimationView.setOnClickListener(this);
        this.f28833e.addAnimatorUpdateListener(this);
        this.f28833e.addAnimatorListener(this);
        this.f28833e.setRepeatCount(2);
        this.f28833e.setRepeatMode(1);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f28835g = false;
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f28833e == null || this.f28834f == null) {
            return;
        }
        e();
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28833e.setVisibility(0);
            this.f28833e.playAnimation();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            b(this.f28834f);
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f28833e.setAnimation(i2);
            i();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, animator) == null) || this.f28833e == null || this.f28834f == null) {
            return;
        }
        e();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, animator) == null) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, animator) == null) {
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, valueAnimator) == null) || (tBLottieAnimationView = this.f28833e) == null || this.f28834f == null || !tBLottieAnimationView.isAnimating() || f28832i || !f28831h) {
            return;
        }
        valueAnimator.getAnimatedFraction();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            e();
        }
    }
}
