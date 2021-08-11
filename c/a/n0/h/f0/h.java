package c.a.n0.h.f0;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.f1.e.b;
import c.a.n0.a.j2.k;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, str) == null) && c.a.n0.a.a2.d.g().l() == 1 && !d()) {
            c.a.n0.a.r1.h.p("startup").C(new UbcFlowEvent(str));
        }
    }

    public static void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, jSONArray) == null) || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        HybridUbcFlow p = c.a.n0.a.r1.h.p("startup");
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("id");
                long optLong = optJSONObject.optLong("timestamp");
                if (!TextUtils.isEmpty(optString) && optJSONObject.has("timestamp")) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                    ubcFlowEvent.h(optLong);
                    p.C(ubcFlowEvent);
                }
            }
        }
    }

    public static long c() {
        InterceptResult invokeV;
        SwanAppActivity x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
            if (i2 == null || (x = i2.x()) == null) {
                return 0L;
            }
            c.a.n0.a.t0.c frame = x.getFrame();
            if (frame instanceof c.a.n0.h.o.d) {
                return ((c.a.n0.h.o.d) frame).W0();
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
            c.a.n0.a.a2.e i2 = c.a.n0.a.a2.e.i();
            if (i2 == null || (x = i2.x()) == null) {
                return false;
            }
            c.a.n0.a.t0.c frame = x.getFrame();
            if (frame instanceof c.a.n0.h.o.d) {
                return ((c.a.n0.h.o.d) frame).a1();
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
        c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
        fVar.f6789a = k.m(aVar.G());
        fVar.f6794f = aVar.H();
        fVar.f6791c = aVar.T();
        fVar.f6790b = "launch";
        fVar.f6793e = "realcancel";
        fVar.q = String.valueOf(currentTimeMillis - l);
        fVar.a("reason", str);
        fVar.a("errorList", b.c().d());
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        k.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }

    public static void f(b.a aVar) {
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, aVar) == null) || aVar == null || !d() || (P = aVar.P()) == null || P.getLong("page_display_flag_for_statistic") <= 0) {
            return;
        }
        long l = aVar.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        c.a.n0.a.j2.p.f fVar = new c.a.n0.a.j2.p.f();
        fVar.f6789a = k.m(aVar.G());
        fVar.f6794f = aVar.H();
        fVar.f6791c = aVar.T();
        fVar.f6790b = "launch";
        fVar.f6793e = "realsuccess";
        fVar.r = String.valueOf(currentTimeMillis - l);
        fVar.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
        k.onEvent(fVar);
        P.remove("page_display_flag_for_statistic");
    }
}
