package c.a.n0.a.k1.m;

import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.p2.q0;
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
public class f implements c.a.n0.a.p2.g1.c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f5372b = true;

    /* renamed from: c  reason: collision with root package name */
    public static int f5373c = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-774944981, "Lc/a/n0/a/k1/m/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-774944981, "Lc/a/n0/a/k1/m/f;");
        }
    }

    public f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public final void a(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g2;
        UbcFlowEvent a2;
        UbcFlowEvent a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || (g2 = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
            return;
        }
        c.a.n0.a.x.t.h.a aVar = (c.a.n0.a.x.t.h.a) hybridUbcFlow.k("fmp_data_record");
        if ("fmp_callback".equals(this.a)) {
            String name = f.class.getName();
            Log.d(name, "Current Record FMP - " + g2.a + ":" + g2.g());
            if (aVar == null || (a3 = aVar.a()) == null) {
                return;
            }
            String name2 = f.class.getName();
            Log.d(name2, "First Page Record FMP - " + a3.a + ":" + a3.g());
        } else if ("callback_on_submit".equals(this.a)) {
            String name3 = f.class.getName();
            Log.d(name3, "Real Report FMP - " + g2.a + ":" + g2.g());
            if (aVar == null || (a2 = aVar.a()) == null) {
                return;
            }
            String name4 = f.class.getName();
            Log.d(name4, "First Page Report FMP - " + a2.a + ":" + a2.g());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.p2.g1.c
    /* renamed from: b */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            synchronized (this) {
                if (f5372b) {
                    if (f5373c == -1) {
                        c.a.n0.a.s0.a.g0().getSwitch("swan_next_env_delay", 600);
                        f5373c = 600;
                    }
                    q0.b0(new a(this), f5373c);
                }
                if (c.a.n0.a.a.a) {
                    String name = getClass().getName();
                    Log.d(name, "enable=" + f5372b + ", delay=" + f5373c);
                }
                if ("fmp_callback".equals(this.a)) {
                    f5372b = false;
                } else if ("callback_on_submit".equals(this.a)) {
                    f5372b = true;
                }
                if (c.a.n0.a.a.a && hybridUbcFlow != null) {
                    a(hybridUbcFlow);
                }
            }
        }
    }
}
