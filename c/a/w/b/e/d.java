package c.a.w.b.e;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.PathUtils;
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
/* loaded from: classes4.dex */
public class d extends c.a.w.b.e.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int A;
    public static final int y;
    public static final int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public View f30519h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f30520i;

    /* renamed from: j  reason: collision with root package name */
    public f f30521j;
    public e k;
    public g l;
    public InterfaceC1410d m;
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f30522e;

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
            this.f30522e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f30522e.v == null) {
                return;
            }
            this.f30522e.v.onClick(view);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f30523e;

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
            this.f30523e = dVar;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.f30523e.u) {
                return;
            }
            this.f30523e.u = true;
            this.f30523e.n.setSpeed(1.0f);
            this.f30523e.n.setMinAndMaxFrame(d.z, d.A);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements SmartBubbleAnimatedView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30524a;

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
            this.f30524a = dVar;
        }

        @Override // com.baidu.live.business.refresh.SmartBubbleAnimatedView.e
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f30524a.q == null) {
                return;
            }
            this.f30524a.q.onAnimationEnd();
        }
    }

    /* renamed from: c.a.w.b.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1410d {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(View view, boolean z);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a();

        public abstract String b();
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(int i2);

        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1863675444, "Lc/a/w/b/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1863675444, "Lc/a/w/b/e/d;");
                return;
            }
        }
        y = c.a.w.b.e.b.a().f30514i;
        z = c.a.w.b.e.b.a().f30515j;
        A = c.a.w.b.e.b.a().k;
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
        this.f30519h = null;
        this.f30520i = null;
        this.f30521j = null;
        this.k = null;
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

    @Override // c.a.w.b.e.a
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = c.a.w.c.a.d.live_feed_page_pull_down_bd;
            if (PathUtils.DIRCTORY_BAIDU.equals(LiveFeedPageSdk.e().d())) {
                i2 = c.a.w.c.a.d.live_feed_page_pull_down_bd;
            } else if ("haokan".equals(LiveFeedPageSdk.e().d())) {
                i2 = c.a.w.c.a.d.live_feed_page_pull_down_hk;
            } else if ("quanmin".equals(LiveFeedPageSdk.e().d())) {
                i2 = c.a.w.c.a.d.live_feed_page_pull_down_qm;
            } else if ("tieba".equals(LiveFeedPageSdk.e().d())) {
                i2 = c.a.w.c.a.d.live_feed_page_pull_down_tb;
            }
            View inflate = LayoutInflater.from(c()).inflate(i2, (ViewGroup) null);
            this.f30519h = inflate;
            this.f30520i = (LinearLayout) inflate.findViewById(c.a.w.c.a.c.pull_root);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f30519h.findViewById(c.a.w.c.a.c.continuous_loading_view);
            this.n = continuousAnimationView;
            continuousAnimationView.setOnClickListener(this.w);
            r();
            return this.f30519h;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.w.b.e.a
    public void b(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.t = true;
            if (s() && this.n.isAnimating()) {
                this.n.cancelAnimation();
            }
            e eVar = this.k;
            if (eVar != null) {
                eVar.a(this.f30519h, z2);
            }
        }
    }

    @Override // c.a.w.b.e.a
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || d()) {
            return;
        }
        InterfaceC1410d interfaceC1410d = this.m;
        if (interfaceC1410d != null) {
            interfaceC1410d.a();
        }
        if (!v()) {
            w();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.n;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.n.cancelAnimation();
    }

    @Override // c.a.w.b.e.a
    public void g(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z2) == null) || d()) {
            return;
        }
        f fVar = this.f30521j;
        if (fVar != null && this.t) {
            fVar.onListPullRefresh(z2);
        }
        this.t = true;
    }

    @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.w.b.e.a
    public void h(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            g gVar = this.l;
            if (gVar != null) {
                gVar.a(z2);
            }
            r();
        }
    }

    @Override // c.a.w.b.e.a
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r();
            if (!s() || d()) {
                return;
            }
            x();
        }
    }

    @Override // c.a.w.b.e.a
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // c.a.w.b.e.a, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void onPullPercentChange(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.onPullPercentChange(f2, f3);
            if (s()) {
                this.n.setAlpha(f2);
                this.n.setFrame((int) (f2 * y));
            }
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
        }
    }

    public final void r() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.p;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.f30520i.removeView(this.p);
            }
            if (!s() || (continuousAnimationView = this.n) == null) {
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

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? c.a.w.b.e.c.a().b() : invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void u(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            String k = c.a.w.i.f.e().k(z2);
            if (TextUtils.isEmpty(k)) {
                int l = c.a.w.i.f.e().l(z2);
                if (l != 0) {
                    this.n.setAnimation(l);
                    return;
                }
                return;
            }
            this.n.setAnimation(k);
        }
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (t() && this.s && this.r != null && this.f30520i != null) {
                this.n.setVisibility(8);
                if (this.p == null) {
                    SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(c());
                    this.p = smartBubbleAnimatedView;
                    smartBubbleAnimatedView.setExtrusionRemind(true);
                }
                this.p.tipText = this.r.b();
                this.p.delayDuring = this.r.a();
                if (this.p.getParent() != null) {
                    this.f30520i.removeView(this.p);
                }
                this.f30520i.addView(this.p);
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

    public final void w() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && s() && (continuousAnimationView = this.n) != null) {
            continuousAnimationView.loop(false);
        }
    }

    public final void x() {
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
