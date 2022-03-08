package c.a.p0.j.g0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.d2.n;
import c.a.p0.a.v0.e.b;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.v8.NodeJS;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && c.a.p0.a.t1.d.J().l() == 1 && !d()) {
            c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME).F(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = c.a.p0.a.k1.h.p(NodeJS.STARTUP_SCRIPT_NAME);
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    p.F(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
            if (L == null || (x = L.x()) == null) {
                return 0L;
            }
            c.a.p0.a.j0.c frame = x.getFrame();
            if (frame instanceof c.a.p0.j.o.d) {
                return ((c.a.p0.j.o.d) frame).f1();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.p0.a.t1.e L = c.a.p0.a.t1.e.L();
            if (L == null || (x = L.x()) == null) {
                return false;
            }
            c.a.p0.a.j0.c frame = x.getFrame();
            if (frame instanceof c.a.p0.j.o.d) {
                return ((c.a.p0.j.o.d) frame).j1();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void e(String str, b.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, aVar) == null) || aVar == null || d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
        fVar.a = n.n(aVar.G());
        fVar.f4951f = aVar.H();
        fVar.f4948c = aVar.T();
        fVar.f4947b = "launch";
        fVar.f4950e = "realcancel";
        fVar.q = String.valueOf(currentTimeMillis - l);
        fVar.a("reason", str);
        fVar.a("errorList", b.c().d());
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        n.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(b.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.p0.a.d2.s.f fVar = new c.a.p0.a.d2.s.f();
        fVar.a = n.n(aVar.G());
        fVar.f4951f = aVar.H();
        fVar.f4948c = aVar.T();
        fVar.f4947b = "launch";
        fVar.f4950e = "realsuccess";
        fVar.r = String.valueOf(currentTimeMillis - l);
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        n.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }
}
