package c.a.n0.a.r1.r.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.a.h0.u.g;
import c.a.n0.a.r1.h;
import c.a.n0.a.v2.e1.b;
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
public class a implements b<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final List<String> f8212e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1316986179, "Lc/a/n0/a/r1/r/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1316986179, "Lc/a/n0/a/r1/r/d/a;");
                return;
            }
        }
        f8212e = new ArrayList(5);
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
    @Override // c.a.n0.a.v2.e1.b
    /* renamed from: a */
    public void onCallback(@NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
            c.a.n0.a.r1.r.a.f().c(false);
            String g2 = hybridUbcFlow.g("launchid");
            if (!TextUtils.isEmpty(g2)) {
                synchronized (f8212e) {
                    if (!f8212e.contains(g2)) {
                        f8212e.add(g2);
                        c(g2, hybridUbcFlow);
                    }
                }
            }
            String str = (String) hybridUbcFlow.i("routeId");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f8212e) {
                if (!f8212e.contains(str)) {
                    f8212e.add(str);
                    b(str, hybridUbcFlow);
                }
            }
        }
    }

    public final void b(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hybridUbcFlow) == null) {
            d(hybridUbcFlow);
            UbcFlowEvent f2 = hybridUbcFlow.f("na_first_meaningful_paint");
            HybridUbcFlow e2 = h.e(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, str);
            if (e2 == null || f2 == null) {
                return;
            }
            e2.C(f2);
            e2.y();
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
        if (!(interceptable == null || interceptable.invokeL(1048579, this, hybridUbcFlow) == null) || hybridUbcFlow.f("na_first_meaningful_paint") == null) {
            return;
        }
        g.N().H0(new c.a.n0.a.o0.d.h((String) hybridUbcFlow.i(PrefetchEvent.EVENT_DATA_WEBVIEW_ID), (String) hybridUbcFlow.i("pageUrl")));
    }
}
