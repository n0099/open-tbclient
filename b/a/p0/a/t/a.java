package b.a.p0.a.t;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.r1.h;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
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
    public List<AnimatorSet> f7890a;

    /* renamed from: b  reason: collision with root package name */
    public BdShimmerView f7891b;

    /* renamed from: c  reason: collision with root package name */
    public SwanAppLaunchCircleAnimationView f7892c;

    /* renamed from: b.a.p0.a.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0367a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7894f;

        public RunnableC0367a(a aVar, SwanAppActivity swanAppActivity) {
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
            this.f7894f = aVar;
            this.f7893e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f7893e.isFinishing()) {
                return;
            }
            if (this.f7894f.f7890a != null) {
                for (AnimatorSet animatorSet : this.f7894f.f7890a) {
                    animatorSet.cancel();
                }
            }
            this.f7893e.getFloatLayer().f();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7895e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7896f;

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
            this.f7896f = aVar;
            this.f7895e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7896f.f7892c != null) {
                    this.f7896f.f7892c.setVisibility(4);
                    this.f7896f.f7892c.stopAllCircleAnimation();
                }
                if (this.f7896f.f7891b != null) {
                    this.f7896f.f7891b.dismiss();
                }
                this.f7896f.k(this.f7895e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7897a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Handler f7898b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Runnable f7899c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f7900d;

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
            this.f7900d = aVar;
            this.f7897a = swanAppActivity;
            this.f7898b = handler;
            this.f7899c = runnable;
        }

        @Override // b.a.p0.a.t.a.f
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7900d.f7892c != null) {
                    this.f7900d.f7892c.setVisibility(4);
                    this.f7900d.f7892c.stopAllCircleAnimation();
                }
                if (this.f7900d.f7891b != null) {
                    this.f7900d.f7891b.dismiss();
                }
                this.f7900d.k(this.f7897a);
                this.f7898b.removeCallbacks(this.f7899c);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7901e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7902f;

        /* renamed from: b.a.p0.a.t.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0368a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f7903e;

            public C0368a(d dVar) {
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
                this.f7903e = dVar;
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
                if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f7903e.f7901e.isFinishing()) {
                    return;
                }
                this.f7903e.f7901e.getLoadingView().f8854a.setVisibility(8);
                this.f7903e.f7901e.getLoadingView().J();
                this.f7903e.f7901e.getFloatLayer().f();
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
                if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f7903e.f7901e.isFinishing()) {
                    return;
                }
                this.f7903e.f7901e.getLoadingView().w();
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
            this.f7902f = aVar;
            this.f7901e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(this.f7902f.f(this.f7901e, 150L));
                animatorSet.addListener(new C0368a(this));
                animatorSet.start();
                this.f7902f.f7890a.add(animatorSet);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f7904e;

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
            this.f7904e = swanAppActivity;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f7904e.isFinishing()) {
                return;
            }
            this.f7904e.getLoadingView().f8854a.setVisibility(8);
            this.f7904e.getLoadingView().J();
            this.f7904e.getFloatLayer().f();
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
            if (!(interceptable == null || interceptable.invokeL(1048579, this, animator) == null) || this.f7904e.isFinishing()) {
                return;
            }
            this.f7904e.getLoadingView().w();
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
        this.f7890a = new CopyOnWriteArrayList();
    }

    public final ObjectAnimator f(SwanAppActivity swanAppActivity, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048576, this, swanAppActivity, j)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f8854a, Key.ALPHA, 1.0f, 0.0f);
            ofFloat.setDuration(j);
            return ofFloat;
        }
        return (ObjectAnimator) invokeLJ.objValue;
    }

    public final AnimatorSet g(SwanAppActivity swanAppActivity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanAppActivity)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f8857d, Key.TRANSLATION_X, -n0.f(AppRuntime.getAppContext(), 9.5f), n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(380L);
            ofFloat.setRepeatMode(2);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f8858e, Key.TRANSLATION_X, 0.0f, -n0.f(AppRuntime.getAppContext(), 19.0f));
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
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f8857d, Key.TRANSLATION_X, 0.0f, -n0.f(AppRuntime.getAppContext(), 9.5f));
            ofFloat.setDuration(240L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.getLoadingView().f8858e, Key.ALPHA, 0.0f, 1.0f);
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
            Handler i2 = b.a.p0.a.a2.d.i();
            b bVar = new b(this, swanAppActivity);
            i2.postDelayed(bVar, b.a.p0.a.r1.l.b.c());
            SwanAppSlaveManager.k1(new c(this, swanAppActivity, i2, bVar));
        }
    }

    public final void j(SwanAppActivity swanAppActivity) {
        b.a.p0.a.w2.e loadingView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, swanAppActivity) == null) || swanAppActivity.isFinishing() || (loadingView = swanAppActivity.getLoadingView()) == null) {
            return;
        }
        if (b.a.p0.a.r1.l.b.d() != 1 && b.a.p0.a.r1.l.b.d() != 3) {
            loadingView.f8854a.setVisibility(8);
            if (!b.a.p0.a.c1.a.Z().G()) {
                List<AnimatorSet> list = this.f7890a;
                if (list != null) {
                    for (AnimatorSet animatorSet : list) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.getFloatLayer().f();
                return;
            }
            q0.X(new RunnableC0367a(this, swanAppActivity));
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
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = (SwanAppLaunchCircleAnimationView) swanAppActivity.findViewById(b.a.p0.a.f.App_Launch_Circle_Animation_View);
            this.f7892c = swanAppLaunchCircleAnimationView;
            swanAppLaunchCircleAnimationView.startLoadingAnimation();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            b.a.p0.a.i2.a.d().i("first_anim_start");
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
            this.f7890a.add(animatorSet);
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
            b.a.p0.a.i2.a.d().i("first_anim_start");
            this.f7890a.add(animatorSet);
        }
    }

    public void p(SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppActivity) == null) {
            BdShimmerView bdShimmerView = (BdShimmerView) swanAppActivity.findViewById(b.a.p0.a.f.App_Launch_Shimmer_Animation_View);
            this.f7891b = bdShimmerView;
            if (bdShimmerView == null) {
                return;
            }
            bdShimmerView.setType(1);
            this.f7891b.startShimmerAnimation();
            h.o().C(new UbcFlowEvent("first_anim_start"));
            b.a.p0.a.i2.a.d().i("first_anim_start");
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            for (AnimatorSet animatorSet : this.f7890a) {
                animatorSet.removeAllListeners();
                animatorSet.cancel();
            }
            SwanAppLaunchCircleAnimationView swanAppLaunchCircleAnimationView = this.f7892c;
            if (swanAppLaunchCircleAnimationView != null) {
                swanAppLaunchCircleAnimationView.stopAllCircleAnimation();
            }
            BdShimmerView bdShimmerView = this.f7891b;
            if (bdShimmerView != null) {
                bdShimmerView.dismiss();
            }
            this.f7890a.clear();
        }
    }
}
