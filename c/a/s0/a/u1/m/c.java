package c.a.s0.a.u1.m;

import android.os.Bundle;
import c.a.s0.a.y0.k.f.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements c.a.s0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.s0.a.z2.g1.c<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || c.a(hybridUbcFlow)) {
                return;
            }
            long f2 = hybridUbcFlow.f("na_first_meaningful_paint", "naStart");
            if (f2 <= 0) {
                f2 = hybridUbcFlow.f("na_first_paint", "naStart");
            }
            if (f2 <= 0) {
                f2 = hybridUbcFlow.f("slave_first_rendered", "naStart");
            }
            if (f2 <= 0) {
                f2 = hybridUbcFlow.f("fe_page_show", "naStart");
            }
            if (f2 <= 0) {
                f2 = hybridUbcFlow.f("na_page_show", "naStart");
            }
            if (f2 <= 0) {
                f2 = hybridUbcFlow.f("na_receive_intent", "naStart");
            }
            if (f2 <= 0) {
                f2 = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("property_launch_cost", f2);
            c.a.s0.a.y1.c.a e2 = c.a.s0.a.y1.c.a.e();
            c.a.s0.a.y1.c.c cVar = new c.a.s0.a.y1.c.c(20, bundle);
            cVar.f(true);
            e2.h(cVar);
            c.a.s0.a.u1.k.f.j().c(f2);
            c.a.s0.a.u1.l.g.a.e().f();
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(HybridUbcFlow hybridUbcFlow) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridUbcFlow)) == null) ? hybridUbcFlow.p("performanceEnd") && !hybridUbcFlow.p("na_first_meaningful_paint") : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.a.z2.g1.c
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            hybridUbcFlow.J("670");
            hybridUbcFlow.D("preload_scene", "1");
            hybridUbcFlow.E("from", "swan");
            hybridUbcFlow.H("component_reporter", new c.a.s0.a.u1.d());
            hybridUbcFlow.H("component_reporter", new c.a.s0.a.p1.r.d.c());
            hybridUbcFlow.H("component_reporter", new c.a.s0.a.u1.a());
            hybridUbcFlow.H("component_reporter", new c.a.s0.a.u1.f());
            hybridUbcFlow.H("callback_on_submit", new b.a());
            hybridUbcFlow.H("fmp_callback", new f("fmp_callback"));
            hybridUbcFlow.H("fmp_callback", new c.a.s0.a.u1.r.d.a());
            hybridUbcFlow.H("callback_on_submit", new f("callback_on_submit"));
            hybridUbcFlow.H("callback_on_submit", new c.a.s0.a.v2.a());
            hybridUbcFlow.H("callback_on_submit", new a(this));
        }
    }
}
