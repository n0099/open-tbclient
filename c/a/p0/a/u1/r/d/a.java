package c.a.p0.a.u1.r.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.a.h0.u.g;
import c.a.p0.a.o0.d.i;
import c.a.p0.a.u1.h;
import c.a.p0.a.z2.g1.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements c<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final List<String> f8609e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(839467774, "Lc/a/p0/a/u1/r/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(839467774, "Lc/a/p0/a/u1/r/d/a;");
                return;
            }
        }
        f8609e = new ArrayList(5);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.z2.g1.c
    /* renamed from: a */
    public void onCallback(@NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            c.a.p0.a.u1.r.a.g().d(false);
            String h2 = hybridUbcFlow.h("launchid");
            if (!TextUtils.isEmpty(h2)) {
                synchronized (f8609e) {
                    if (!f8609e.contains(h2)) {
                        f8609e.add(h2);
                        c(h2, hybridUbcFlow);
                    }
                }
            }
            String str = (String) hybridUbcFlow.k("routeId");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f8609e) {
                if (!f8609e.contains(str)) {
                    f8609e.add(str);
                    b(str, hybridUbcFlow);
                }
            }
        }
    }

    public final void b(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hybridUbcFlow) == null) {
            d(hybridUbcFlow);
            UbcFlowEvent g2 = hybridUbcFlow.g("na_first_meaningful_paint");
            HybridUbcFlow e2 = h.e(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            if (e2 == null || g2 == null) {
                return;
            }
            e2.F(g2);
            e2.B();
        }
    }

    public final void c(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hybridUbcFlow) == null) {
            d(hybridUbcFlow);
        }
    }

    public final void d(@NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hybridUbcFlow) == null) || hybridUbcFlow.g("na_first_meaningful_paint") == null) {
            return;
        }
        g.U().U0(new i((String) hybridUbcFlow.k(PrefetchEvent.EVENT_DATA_WEBVIEW_ID), (String) hybridUbcFlow.k("pageUrl")));
    }
}
