package b.a.r0.x0.w2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import b.a.r0.x0.w2.b;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26541a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f26542b;

    /* renamed from: c  reason: collision with root package name */
    public g f26543c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.r0.x0.w2.b f26544d;

    /* renamed from: e  reason: collision with root package name */
    public b.a.q0.q0.o.a f26545e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f26546f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f26547g;

    /* loaded from: classes5.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f26548a;

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
            this.f26548a = fVar;
        }

        @Override // b.a.r0.x0.w2.b.a
        public void onStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    if (this.f26548a.f26545e == null) {
                        this.f26548a.f26545e = new b.a.q0.q0.o.a("anim_switch_trans_frs");
                    }
                    this.f26548a.f26545e.b();
                } else if (i2 != 2) {
                    if (i2 == 0) {
                        this.f26548a.j();
                    }
                } else {
                    this.f26548a.k();
                    if (this.f26548a.f26545e == null || !TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    this.f26548a.f26545e.c();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f26549e;

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
            this.f26549e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26549e.f();
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
        this.f26546f = new a(this);
        this.f26547g = new b(this);
        this.f26541a = context;
        this.f26542b = viewGroup;
        g gVar = new g(context);
        this.f26543c = gVar;
        b.a.r0.x0.w2.b a2 = c.a(gVar, intent);
        this.f26544d = a2;
        a2.b(this.f26546f);
    }

    public static boolean i(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, intent)) == null) ? (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            b.a.e.e.m.e.a().removeCallbacks(this.f26547g);
            if (this.f26544d.a() == 1) {
                b.a.e.e.m.e.a().postDelayed(this.f26547g, 10L);
                return;
            }
            k();
            this.f26544d.c();
        }
    }

    public final void g() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup viewGroup = this.f26542b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f26542b.getChildAt(0).setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f26542b;
            if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f26542b == null) {
            return;
        }
        f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewParent parent = this.f26543c.f26550a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f26543c.f26550a);
            }
            b.a.e.e.m.e.a().removeCallbacks(this.f26547g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = this.f26542b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f26542b.getChildAt(0).setVisibility(0);
            }
            ViewGroup viewGroup2 = this.f26542b;
            if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
                return;
            }
            this.f26542b.findViewById(16908290).setVisibility(0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f26542b == null) {
            return;
        }
        j();
        this.f26542b.addView(this.f26543c.f26550a);
        g();
        this.f26544d.d();
    }
}
