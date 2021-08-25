package c.a.o0.a.r1.m;

import android.os.Bundle;
import c.a.o0.a.l0.o.a;
import c.a.o0.a.n2.h.b;
import c.a.o0.a.r1.k.f;
import c.a.o0.a.y0.k.f.b;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements c.a.o0.a.v2.e1.b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<HybridUbcFlow> {
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
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || c.a(hybridUbcFlow)) {
                return;
            }
            long e2 = hybridUbcFlow.e("na_first_meaningful_paint", "naStart");
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_first_paint", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("slave_first_rendered", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("fe_page_show", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_page_show", "naStart");
            }
            if (e2 <= 0) {
                e2 = hybridUbcFlow.e("na_receive_intent", "naStart");
            }
            if (e2 <= 0) {
                e2 = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putLong("property_launch_cost", e2);
            c.a.o0.a.v1.c.a e3 = c.a.o0.a.v1.c.a.e();
            c.a.o0.a.v1.c.c cVar = new c.a.o0.a.v1.c.c(20, bundle);
            cVar.f(true);
            e3.h(cVar);
            f.j().c(e2);
            c.a.o0.a.r1.l.f.a.e().f();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hybridUbcFlow)) == null) ? hybridUbcFlow.n("performanceEnd") && !hybridUbcFlow.n("na_first_meaningful_paint") : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.a.v2.e1.b
    /* renamed from: b */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            hybridUbcFlow.G("670");
            hybridUbcFlow.A("preload_scene", "1");
            hybridUbcFlow.B("from", "swan");
            hybridUbcFlow.E("component_reporter", new c.a.o0.a.r1.d());
            hybridUbcFlow.E("component_reporter", new c.a.o0.a.n1.q.d.c());
            hybridUbcFlow.E("component_reporter", new c.a.o0.a.r1.a());
            hybridUbcFlow.E("component_reporter", new c.a.o0.a.r1.f());
            hybridUbcFlow.E("callback_on_submit", new b.a());
            hybridUbcFlow.E("callback_on_submit", new b.e());
            hybridUbcFlow.E("callback_on_submit", new a.d());
            hybridUbcFlow.E("fmp_callback", new e("fmp_callback"));
            hybridUbcFlow.E("fmp_callback", new c.a.o0.a.r1.r.d.a());
            hybridUbcFlow.E("callback_on_submit", new e("callback_on_submit"));
            hybridUbcFlow.E("callback_on_submit", new c.a.o0.a.r2.a());
            hybridUbcFlow.E("callback_on_submit", new a(this));
        }
    }
}
