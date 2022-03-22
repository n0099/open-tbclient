package c.a.v.b.e;

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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d extends c.a.v.b.e.a {
    public static /* synthetic */ Interceptable $ic;
    public static final int u;
    public static final int v;
    public static final int w;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public View f21458d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f21459e;

    /* renamed from: f  reason: collision with root package name */
    public f f21460f;

    /* renamed from: g  reason: collision with root package name */
    public e f21461g;

    /* renamed from: h  reason: collision with root package name */
    public g f21462h;
    public InterfaceC1590d i;
    public ContinuousAnimationView j;
    public boolean k;
    public SmartBubbleAnimatedView l;
    public i m;
    public h n;
    public boolean o;
    public boolean p;
    public boolean q;
    public View.OnClickListener r;
    public View.OnClickListener s;
    public final Animator.AnimatorListener t;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onClick(view);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
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
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) || this.a.q) {
                return;
            }
            this.a.q = true;
            this.a.j.setSpeed(1.0f);
            this.a.j.setMinAndMaxFrame(d.v, d.w);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.m == null) {
                return;
            }
            this.a.m.onAnimationEnd();
        }
    }

    /* renamed from: c.a.v.b.e.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1590d {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(View view, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void onListPullRefresh(boolean z);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public abstract int a();

        public abstract String b();
    }

    /* loaded from: classes3.dex */
    public interface i {
        void a(int i);

        void onAnimationEnd();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(688481517, "Lc/a/v/b/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(688481517, "Lc/a/v/b/e/d;");
                return;
            }
        }
        u = c.a.v.b.e.b.a().i;
        v = c.a.v.b.e.b.a().j;
        w = c.a.v.b.e.b.a().k;
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
        this.f21458d = null;
        this.f21459e = null;
        this.f21460f = null;
        this.f21461g = null;
        this.f21462h = null;
        this.i = null;
        this.k = false;
        this.o = true;
        this.p = true;
        this.q = false;
        this.r = null;
        this.s = new a(this);
        this.t = new b(this);
    }

    public final void A() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && w() && (continuousAnimationView = this.j) != null) {
            continuousAnimationView.loop(false);
        }
    }

    public final void B() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (continuousAnimationView = this.j) == null) {
            return;
        }
        if (continuousAnimationView.isAnimating()) {
            this.j.cancelAnimation();
        }
        this.q = false;
        this.j.loop(true);
        this.j.setMinFrame(u);
        this.j.setRepeatMode(1);
        this.j.removeAllAnimatorListeners();
        this.j.addAnimatorListener(this.t);
        this.j.playAnimation();
    }

    @Override // c.a.v.b.e.a, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            super.c(f2, f3);
            if (w()) {
                this.j.setAlpha(f2);
                this.j.setFrame((int) (f2 * u));
            }
        }
    }

    @Override // c.a.v.b.e.a
    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean equals = "baidu".equals(LiveFeedPageSdk.f().e());
            int i2 = R.layout.obfuscated_res_0x7f0d051a;
            if (!equals) {
                if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                    i2 = R.layout.obfuscated_res_0x7f0d051b;
                } else if ("quanmin".equals(LiveFeedPageSdk.f().e())) {
                    i2 = R.layout.obfuscated_res_0x7f0d051c;
                } else if ("tieba".equals(LiveFeedPageSdk.f().e())) {
                    i2 = R.layout.obfuscated_res_0x7f0d051d;
                }
            }
            View inflate = LayoutInflater.from(getContext()).inflate(i2, (ViewGroup) null);
            this.f21458d = inflate;
            this.f21459e = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091968);
            ContinuousAnimationView continuousAnimationView = (ContinuousAnimationView) this.f21458d.findViewById(R.id.obfuscated_res_0x7f0906ee);
            this.j = continuousAnimationView;
            continuousAnimationView.setOnClickListener(this.s);
            v();
            return this.f21458d;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.v.b.e.a
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.p = true;
            if (w() && this.j.isAnimating()) {
                this.j.cancelAnimation();
            }
            e eVar = this.f21461g;
            if (eVar != null) {
                eVar.a(this.f21458d, z);
            }
        }
    }

    @Override // c.a.v.b.e.a, com.baidu.live.business.refresh.BdSwipeRefreshLayout.h
    public long getCompleteAnimTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 600L;
        }
        return invokeV.longValue;
    }

    @Override // c.a.v.b.e.a
    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || h()) {
            return;
        }
        InterfaceC1590d interfaceC1590d = this.i;
        if (interfaceC1590d != null) {
            interfaceC1590d.a();
        }
        if (!z()) {
            A();
            return;
        }
        ContinuousAnimationView continuousAnimationView = this.j;
        if (continuousAnimationView == null || !continuousAnimationView.isAnimating()) {
            return;
        }
        this.j.cancelAnimation();
    }

    @Override // c.a.v.b.e.a
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || h()) {
            return;
        }
        f fVar = this.f21460f;
        if (fVar != null && this.p) {
            fVar.onListPullRefresh(z);
        }
        this.p = true;
    }

    @Override // c.a.v.b.e.a
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            g gVar = this.f21462h;
            if (gVar != null) {
                gVar.a(z);
            }
            v();
        }
    }

    @Override // c.a.v.b.e.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            v();
            if (!w() || h()) {
                return;
            }
            B();
        }
    }

    @Override // c.a.v.b.e.a
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    public final void v() {
        ContinuousAnimationView continuousAnimationView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.l;
            if (smartBubbleAnimatedView != null && smartBubbleAnimatedView.getParent() != null) {
                this.f21459e.removeView(this.l);
            }
            if (!w() || (continuousAnimationView = this.j) == null) {
                return;
            }
            if (continuousAnimationView.getVisibility() != 0) {
                this.j.setVisibility(0);
            }
            if (this.j.isAnimating()) {
                this.j.cancelAnimation();
            }
            this.j.setMinAndMaxProgress(0.0f, 1.0f);
            this.j.setFrame(0);
            this.j.setSpeed(1.3f);
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? c.a.v.b.e.c.a().b() : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            String k = c.a.v.i.f.e().k(z);
            if (TextUtils.isEmpty(k)) {
                int l = c.a.v.i.f.e().l(z);
                if (l != 0) {
                    this.j.setAnimation(l);
                    return;
                }
                return;
            }
            this.j.setAnimation(k);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (x() && this.o && this.n != null && this.f21459e != null) {
                this.j.setVisibility(8);
                if (this.l == null) {
                    SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(getContext());
                    this.l = smartBubbleAnimatedView;
                    smartBubbleAnimatedView.setExtrusionRemind(true);
                }
                this.l.a = this.n.b();
                this.l.f25745b = this.n.a();
                if (this.l.getParent() != null) {
                    this.f21459e.removeView(this.l);
                }
                this.f21459e.addView(this.l);
                this.l.setOnBubbleAnimateListener(new c(this));
                i iVar = this.m;
                if (iVar != null) {
                    iVar.a(this.l.getTipViewHeight());
                }
                this.l.f();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
