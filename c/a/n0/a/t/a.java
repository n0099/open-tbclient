package c.a.n0.a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.r1.h;
import c.a.n0.a.v2.n0;
import c.a.n0.a.v2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.view.SwanAppLaunchCircleAnimationView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AnimatorSet> f8340a;

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f8341b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f8342c;

    /* renamed from: c.a.n0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0362a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8344f;

        public RunnableC0362a(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8344f = aVar;
            this.f8343e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f8343e.isFinishing()) {
                return;
            }
            if (this.f8344f.f8340a != null) {
                for (AnimatorSet animatorSet : this.f8344f.f8340a) {
                    animatorSet.cancel();
                }
            }
            this.f8343e.getFloatLayer().g();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8345e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8346f;

        public b(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8346f = aVar;
            this.f8345e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8346f.f8342c != null) {
                    this.f8346f.f8342c.setVisibility(4);
                    this.f8346f.f8342c.stopAllCircleAnimation();
                }
                if (this.f8346f.f8341b != null) {
                    this.f8346f.f8341b.dismiss();
                }
                this.f8346f.k(this.f8345e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f8348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f8349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f8350d;

        public c(a aVar, SwanAppActivity swanAppActivity, Handler handler, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, handler, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8350d = aVar;
            this.f8347a = swanAppActivity;
            this.f8348b = handler;
            this.f8349c = runnable;
        }

        @Override // c.a.n0.a.t.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f8350d.f8342c != null) {
                    this.f8350d.f8342c.setVisibility(4);
                    this.f8350d.f8342c.stopAllCircleAnimation();
                }
                if (this.f8350d.f8341b != null) {
                    this.f8350d.f8341b.dismiss();
                }
                this.f8350d.k(this.f8347a);
                this.f8348b.removeCallbacks(this.f8349c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8351e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8352f;

        /* renamed from: c.a.n0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0363a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f8353e;

            public C0363a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f8353e = dVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f8353e.f8351e.isFinishing()) {
                    return;
                }
                this.f8353e.f8351e.getLoadingView().f9332a.setVisibility(8);
                this.f8353e.f8351e.getLoadingView().J();
                this.f8353e.f8351e.getFloatLayer().g();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f8353e.f8351e.isFinishing()) {
                    return;
                }
                this.f8353e.f8351e.getLoadingView().w();
            }
        }

        public d(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8352f = aVar;
            this.f8351e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.f8352f.f(this.f8351e, 150L));
                animatorSet.addListener(new C0363a(this));
                animatorSet.start();
                this.f8352f.f8340a.add(animatorSet);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f8354e;

        public e(a aVar, SwanAppActivity swanAppActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8354e = swanAppActivity;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f8354e.isFinishing()) {
                return;
            }
            this.f8354e.getLoadingView().f9332a.setVisibility(8);
            this.f8354e.getLoadingView().J();
            this.f8354e.getFloatLayer().g();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f8354e.isFinishing()) {
                return;
            }
            this.f8354e.getLoadingView().w();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    public a() {
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
        this.f8340a = new CopyOnWriteArrayList();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, swanAppActivity, j2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f9332a, "alpha", 1.0f, 0.0f);
            ofFloat.setDuration(j2);
            return ofFloat;
        }
        return (ObjectAnimator) invokeLJ.objValue;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f9335d, "translationX", -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(380L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f9336e, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
            ofFloat2.setDuration(380L);
            ofFloat2.setRepeatMode(2);
            ofFloat2.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final AnimatorSet h(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f9335d, "translationX", 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(240L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f9336e, "alpha", 0.0f, 1.0f);
            ofFloat2.setDuration(240L);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            return animatorSet;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public final void i(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, swanAppActivity) == null) {
            Handler i2 = c.a.n0.a.a2.d.i();
            b bVar = new b(this, swanAppActivity);
            i2.postDelayed(bVar, c.a.n0.a.r1.l.b.c());
            SwanAppSlaveManager.l1(new c(this, swanAppActivity, i2, bVar));
        }
    }

    public final void j(SwanAppActivity swanAppActivity) {
        c.a.n0.a.w2.e loadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (c.a.n0.a.r1.l.b.d() != 1 && c.a.n0.a.r1.l.b.d() != 3) {
            loadingView.f9332a.setVisibility(8);
            if (!c.a.n0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f8340a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().g();
                return;
            }
            q0.X(new RunnableC0362a(this, swanAppActivity));
            return;
        }
        i(swanAppActivity);
    }

    public final void k(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, swanAppActivity) == null) {
            q0.X(new d(this, swanAppActivity));
        }
    }

    public void l(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppActivity) == null) {
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(c.a.n0.a.f.App_Launch_Circle_Animation_View);
            this.f8342c = swanAppLaunchCircleAnimationView;
            swanAppLaunchCircleAnimationView.startLoadingAnimation();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            c.a.n0.a.i2.a.d().i("first_anim_start");
        }
    }

    public final void m(SwanAppActivity swanAppActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, swanAppActivity, z) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            int i2 = z ? 100 : 0;
            animatorSet.play(f(swanAppActivity, 150L));
            animatorSet.addListener(new e(this, swanAppActivity));
            animatorSet.setStartDelay(i2);
            animatorSet.start();
            this.f8340a.add(animatorSet);
        }
    }

    public void n(SwanAppActivity swanAppActivity, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppActivity, i2) == null) {
            if (i2 == 1) {
                j(swanAppActivity);
            } else if (i2 == 2) {
                m(swanAppActivity, false);
            } else if (i2 != 3) {
                j(swanAppActivity);
            } else {
                m(swanAppActivity, true);
            }
        }
    }

    public void o(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanAppActivity) == null) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(h(swanAppActivity)).before(g(swanAppActivity));
            animatorSet.start();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            c.a.n0.a.i2.a.d().i("first_anim_start");
            this.f8340a.add(animatorSet);
        }
    }

    public void p(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppActivity) == null) {
            BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(c.a.n0.a.f.App_Launch_Shimmer_Animation_View);
            this.f8341b = bdShimmerView;
            if (bdShimmerView == null) {
                return;
            }
            bdShimmerView.setType(1);
            this.f8341b.startShimmerAnimation();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            c.a.n0.a.i2.a.d().i("first_anim_start");
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (AnimatorSet animatorSet : this.f8340a) {
                animatorSet.removeAllListeners();
                animatorSet.cancel();
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f8342c;
            if (swanAppLaunchCircleAnimationView != null) {
                swanAppLaunchCircleAnimationView.stopAllCircleAnimation();
            }
            BdShimmerView bdShimmerView = this.f8341b;
            if (bdShimmerView != null) {
                bdShimmerView.dismiss();
            }
            this.f8340a.clear();
        }
    }
}
