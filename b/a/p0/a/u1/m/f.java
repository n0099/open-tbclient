package b.a.p0.a.u1.m;

import androidx.annotation.NonNull;
import b.a.p0.a.k;
import b.a.p0.a.z2.q0;
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
public class f implements b.a.p0.a.z2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f9082f = true;

    /* renamed from: g  reason: collision with root package name */
    public static int f9083g = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f9084e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q0.Y();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(278856852, "Lb/a/p0/a/u1/m/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(278856852, "Lb/a/p0/a/u1/m/f;");
        }
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9084e = str;
    }

    public final void a(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        UbcFlowEvent a2;
        UbcFlowEvent a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
            return;
        }
        b.a.p0.a.h0.t.h.a aVar = (b.a.p0.a.h0.t.h.a) hybridUbcFlow.k("fmp_data_record");
        if ("fmp_callback".equals(this.f9084e)) {
            String str = "Current Record FMP - " + g2.f44679a + ":" + g2.g();
            if (aVar == null || (a3 = aVar.a()) == null) {
                return;
            }
            String str2 = "First Page Record FMP - " + a3.f44679a + ":" + a3.g();
        } else if ("callback_on_submit".equals(this.f9084e)) {
            String str3 = "Real Report FMP - " + g2.f44679a + ":" + g2.g();
            if (aVar == null || (a2 = aVar.a()) == null) {
                return;
            }
            String str4 = "First Page Report FMP - " + a2.f44679a + ":" + a2.g();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z2.g1.c
    /* renamed from: b */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            synchronized (this) {
                if (f9082f) {
                    if (f9083g == -1) {
                        b.a.p0.a.c1.a.g0().getSwitch("swan_next_env_delay", 600);
                        f9083g = 600;
                    }
                    q0.b0(new a(this), f9083g);
                }
                if (k.f6863a) {
                    getClass().getName();
                    String str = "enable=" + f9082f + ", delay=" + f9083g;
                }
                if ("fmp_callback".equals(this.f9084e)) {
                    f9082f = false;
                } else if ("callback_on_submit".equals(this.f9084e)) {
                    f9082f = true;
                }
                if (k.f6863a && hybridUbcFlow != null) {
                    a(hybridUbcFlow);
                }
            }
        }
    }
}
