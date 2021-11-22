package b.a.p0.a.p1.r.d;

import androidx.annotation.NonNull;
import b.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements b.a.p0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f7811e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.p1.r.d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f7812a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UbcFlowEvent f7813b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f7814c;

        public a(c cVar, UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, ubcFlowEvent, ubcFlowEvent2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7814c = cVar;
            this.f7812a = ubcFlowEvent;
            this.f7813b = ubcFlowEvent2;
        }

        @Override // b.a.p0.a.p1.r.d.a
        public boolean a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar == null) {
                    return false;
                }
                return this.f7814c.b(dVar, this.f7812a, this.f7813b);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2011089384, "Lb/a/p0/a/p1/r/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2011089384, "Lb/a/p0/a/p1/r/d/c;");
                return;
            }
        }
        f7811e = k.f6863a;
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b.f().g();
        if (f7811e) {
            String str = "MaUpdateReporter init - " + System.currentTimeMillis();
        }
    }

    public final boolean b(@NonNull d dVar, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dVar, ubcFlowEvent, ubcFlowEvent2)) == null) {
            long b2 = dVar.b();
            return b2 >= ubcFlowEvent.g() && b2 <= ubcFlowEvent2.g();
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z2.g1.c
    /* renamed from: c */
    public void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            if (f7811e) {
                String str = "report: flow=" + hybridUbcFlow;
            }
            if (hybridUbcFlow == null) {
                return;
            }
            UbcFlowEvent g2 = hybridUbcFlow.g("naStart");
            UbcFlowEvent g3 = hybridUbcFlow.g("na_first_meaningful_paint");
            if (g2 != null && g3 != null) {
                b.f().h(new a(this, g2, g3));
                b.f().a(hybridUbcFlow);
                if (f7811e) {
                    String str2 = "na_start ts - " + g2.g();
                    r0 = "fmp_end ts - " + g3.g();
                    return;
                }
                return;
            }
            boolean z = f7811e;
            b.f().c();
        }
    }
}
