package c.a.t0.e1.y2;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import c.a.t0.e1.y2.b;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f17171b;

    /* renamed from: c  reason: collision with root package name */
    public g f17172c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.t0.e1.y2.b f17173d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.s0.o.a f17174e;

    /* renamed from: f  reason: collision with root package name */
    public b.a f17175f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f17176g;

    /* loaded from: classes7.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

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
            this.a = fVar;
        }

        @Override // c.a.t0.e1.y2.b.a
        public void onStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    if (!TbSingleton.getInstance().isEnableBenchmark() || TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        return;
                    }
                    if (this.a.f17174e == null) {
                        this.a.f17174e = new c.a.s0.s0.o.a("anim_switch_trans_frs");
                    }
                    this.a.f17174e.b();
                    BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(FrsActivityConfig.KEY_FPS_FRS_FROM, "frs", "tran");
                } else if (i2 != 2) {
                    if (i2 == 0) {
                        this.a.j();
                    }
                } else {
                    this.a.k();
                    if (this.a.f17174e != null && TbSingleton.getInstance().isEnableBenchmark() && !TbSingleton.getInstance().isAnimFpsComputed("anim_switch_trans_frs")) {
                        this.a.f17174e.c();
                    }
                    BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(FrsActivityConfig.KEY_FPS_FRS);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f17177e;

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
            this.f17177e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f17177e.f();
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
        this.f17175f = new a(this);
        this.f17176g = new b(this);
        this.a = context;
        this.f17171b = viewGroup;
        g gVar = new g(context);
        this.f17172c = gVar;
        c.a.t0.e1.y2.b a2 = c.a(gVar, intent);
        this.f17173d = a2;
        a2.b(this.f17175f);
    }

    public static boolean i(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, intent)) == null) ? (intent == null || intent.getIntExtra("transition_type", 0) == 0) ? false : true : invokeL.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.f17176g);
            if (this.f17173d.a() == 1) {
                c.a.d.f.m.e.a().postDelayed(this.f17176g, 10L);
                return;
            }
            k();
            this.f17173d.c();
        }
    }

    public final void g() {
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ViewGroup viewGroup = this.f17171b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f17171b.getChildAt(0).setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f17171b;
            if (viewGroup2 == null || (findViewById = viewGroup2.findViewById(16908290)) == null) {
                return;
            }
            findViewById.setVisibility(8);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f17171b == null) {
            return;
        }
        f();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ViewParent parent = this.f17172c.a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f17172c.a);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.f17176g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ViewGroup viewGroup = this.f17171b;
            if (viewGroup != null && (viewGroup.getChildAt(0) instanceof SwipeBackLayout)) {
                this.f17171b.getChildAt(0).setVisibility(0);
            }
            ViewGroup viewGroup2 = this.f17171b;
            if (viewGroup2 == null || viewGroup2.findViewById(16908290) == null) {
                return;
            }
            this.f17171b.findViewById(16908290).setVisibility(0);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f17171b == null) {
            return;
        }
        j();
        this.f17171b.addView(this.f17172c.a);
        g();
        this.f17173d.d();
    }
}
