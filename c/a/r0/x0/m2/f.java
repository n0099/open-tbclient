package c.a.r0.x0.m2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import c.a.r0.x0.m2.b;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f27287a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f27288b;

    /* renamed from: c  reason: collision with root package name */
    public g f27289c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.r0.x0.m2.b f27290d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.q0.q0.o.a f27291e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f27292f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f27293g;

    /* loaded from: classes4.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f27294a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27294a = fVar;
        }

        @Override // c.a.r0.x0.m2.b.a
        public void onStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    if (this.f27294a.f27291e == null) {
                        this.f27294a.f27291e = new c.a.q0.q0.o.a("anim_switch_trans_frs");
                    }
                    this.f27294a.f27291e.b();
                } else if (i2 != 2) {
                    if (i2 == 0) {
                        this.f27294a.j();
                    }
                } else {
                    this.f27294a.k();
                    if (this.f27294a.f27291e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    this.f27294a.f27291e.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f27295e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27295e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27295e.f();
            }
        }
    }

    public f(Context context, ViewGroup viewGroup, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, intent};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27292f = new a(this);
        this.f27293g = new b(this);
        this.f27287a = context;
        this.f27288b = viewGroup;
        g gVar = new g(context);
        this.f27289c = gVar;
        c.a.r0.x0.m2.b a2 = c.a(gVar, intent);
        this.f27290d = a2;
        a2.b(this.f27292f);
    }

    public static boolean i(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, intent)) == null) ? (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.f27293g);
            if (this.f27290d.a() == 1) {
                c.a.e.e.m.e.a().postDelayed(this.f27293g, 10L);
                return;
            }
            k();
            this.f27290d.c();
        }
    }

    public final void g() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup viewGroup = this.f27288b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f27288b.getChildAt(0).setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f27288b;
            if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f27288b == null) {
            return;
        }
        f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewParent parent = this.f27289c.f27296a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f27289c.f27296a);
            }
            c.a.e.e.m.e.a().removeCallbacks(this.f27293g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = this.f27288b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f27288b.getChildAt(0).setVisibility(0);
            }
            ViewGroup viewGroup2 = this.f27288b;
            if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
                return;
            }
            this.f27288b.findViewById(16908290).setVisibility(0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f27288b == null) {
            return;
        }
        j();
        this.f27288b.addView(this.f27289c.f27296a);
        g();
        this.f27290d.d();
    }
}
