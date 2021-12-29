package c.a.x.b.e;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.refresh.ContinuousAnimationView;
import com.baidu.live.business.refresh.SmartBubbleAnimatedView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d extends c.a.x.b.e.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f27440h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f27441i;

    /* renamed from: j  reason: collision with root package name */
    public f f27442j;

    /* renamed from: k  reason: collision with root package name */
    public e f27443k;
    public g l;
    public InterfaceC1577d m;
    public ContinuousAnimationView n;
    public boolean o;
    public SmartBubbleAnimatedView p;
    public i q;
    public h r;
    public boolean s;
    public boolean t;
    public boolean u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public final Animator.AnimatorListener x;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27444e;

        public a(d dVar) {
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
            this.f27444e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f27444e.v == null) {
                return;
            }
            this.f27444e.v.onClick(view);
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f27445e;

        public b(d dVar) {
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
            this.f27445e = dVar;
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
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f27445e.u) {
                return;
            }
            this.f27445e.u = true;
            this.f27445e.n.setSpeed(1.0f);
            this.f27445e.n.setMinAndMaxFrame(d.z, d.A);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements SmartBubbleAnimatedView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
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
            this.a = dVar;
        }

        @Override // com.baidu.live.business.refresh.SmartBubbleAnimatedView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.q == null) {
                return;
            }
            this.a.q.onAnimationEnd();
        }
    }

    /* renamed from: c.a.x.b.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1577d {
        void a();
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(View view, boolean z);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes9.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a();

        public abstract String b();
    }

    /* loaded from: classes9.dex */
    public interface i {
        void a(int i2);

        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-120865109, "Lc/a/x/b/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-120865109, "Lc/a/x/b/e/d;");
                return;
            }
        }
        y = c.a.x.b.e.b.a().f27436i;
        z = c.a.x.b.e.b.a().f27437j;
        A = c.a.x.b.e.b.a().f27438k;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f27440h = null;
        this.f27441i = null;
        this.f27442j = null;
        this.f27443k = null;
        this.l = null;
        this.m = null;
        this.o = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = null;
        this.w = new a(this);
        this.x = new b(this);
    }

    @Override // c.a.x.b.e.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = c.a.x.c.a.d.live_feed_page_pull_down_bd;
            if ("baidu".equals(LiveFeedPageSdk.f().e())) {
                i2 = c.a.x.c.a.d.live_feed_page_pull_down_bd;
            } else if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                i2 = c.a.x.c.a.d.live_feed_page_pull_down_hk;
            } else if ("quanmin".equals(LiveFeedPageSdk.f().e())) {
                i2 = c.a.x.c.a.d.live_feed_page_pull_down_qm;
            } else if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                i2 = c.a.x.c.a.d.live_feed_page_pull_down_tb;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null);
            this.f27440h = inflate;
            this.f27441i = (LinearLayout) inflate.findViewById(c.a.x.c.a.c.pull_root);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f27440h.findViewById(c.a.x.c.a.c.continuous_loading_view);
            this.n = continuousAnimationView;
            continuousAnimationView.setOnClickListener(this.w);
            q();
            return this.f27440h;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.x.b.e.a
    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.t = true;
            if (r() && this.n.isAnimating()) {
                this.n.cancelAnimation();
            }
            e eVar = this.f27443k;
            if (eVar != null) {
                eVar.a(this.f27440h, z2);
            }
        }
    }

    @Override // c.a.x.b.e.a
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || c()) {
            return;
        }
        InterfaceC1577d interfaceC1577d = this.m;
        if (interfaceC1577d != null) {
            interfaceC1577d.a();
        }
        if (!u()) {
            v();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.n;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.n.cancelAnimation();
    }

    @Override // c.a.x.b.e.a
    public void f(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || c()) {
            return;
        }
        f fVar = this.f27442j;
        if (fVar != null && this.t) {
            fVar.onListPullRefresh(z2);
        }
        this.t = true;
    }

    @Override // c.a.x.b.e.a
    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            g gVar = this.l;
            if (gVar != null) {
                gVar.a(z2);
            }
            q();
        }
    }

    @Override // c.a.x.b.e.a, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.x.b.e.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            q();
            if (!r() || c()) {
                return;
            }
            w();
        }
    }

    @Override // c.a.x.b.e.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.x.b.e.a, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.onPullPercentChange(f2, f3);
            if (r()) {
                this.n.setAlpha(f2);
                this.n.setFrame((int) (f2 * y));
            }
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public final void q() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.p;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.f27441i.removeView(this.p);
            }
            if (!r() || (continuousAnimationView = this.n) == null) {
                return;
            }
            if (continuousAnimationView.getVisibility() != 0) {
                this.n.setVisibility(0);
            }
            if (this.n.isAnimating()) {
                this.n.cancelAnimation();
            }
            this.n.setMinAndMaxProgress(0.0f, 1.0f);
            this.n.setFrame(0);
            this.n.setSpeed(1.3f);
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.x.b.e.c.a().b() : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void t(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            String k2 = c.a.x.k.f.e().k(z2);
            if (TextUtils.isEmpty(k2)) {
                int l = c.a.x.k.f.e().l(z2);
                if (l != 0) {
                    this.n.setAnimation(l);
                    return;
                }
                return;
            }
            this.n.setAnimation(k2);
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (s() && this.s && this.r != null && this.f27441i != null) {
                this.n.setVisibility(8);
                if (this.p == null) {
                    SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(getContext());
                    this.p = smartBubbleAnimatedView;
                    smartBubbleAnimatedView.setExtrusionRemind(true);
                }
                this.p.tipText = this.r.b();
                this.p.delayDuring = this.r.a();
                if (this.p.getParent() != null) {
                    this.f27441i.removeView(this.p);
                }
                this.f27441i.addView(this.p);
                this.p.setOnBubbleAnimateListener(new c(this));
                i iVar = this.q;
                if (iVar != null) {
                    iVar.a(this.p.getTipViewHeight());
                }
                this.p.playExpansionAnimation();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && r() && (continuousAnimationView = this.n) != null) {
            continuousAnimationView.loop(false);
        }
    }

    public final void w() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (continuousAnimationView = this.n) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.n.cancelAnimation();
        }
        this.u = false;
        this.n.loop(true);
        this.n.setMinFrame(y);
        this.n.setRepeatMode(1);
        this.n.removeAllAnimatorListeners();
        this.n.addAnimatorListener(this.x);
        this.n.playAnimation();
    }
}
