package b.a.p0.a.u.e.p;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.f1.e.b;
import b.a.p0.a.r1.j;
import b.a.p0.a.v2.q;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.core.slave.SwanAppSlaveManager;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h extends b.a.p0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f8395e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.a2.e f8396f;

        public a(JSONObject jSONObject, b.a.p0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8395e = jSONObject;
            this.f8396f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = b.a.p0.a.u.c.d.f8000c;
                h.r(this.f8395e, this.f8396f);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8397e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ HybridUbcFlow f8398f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.p.e.b f8399g;

        public b(String str, HybridUbcFlow hybridUbcFlow, b.a.p0.a.p.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, hybridUbcFlow, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8397e = str;
            this.f8398f = hybridUbcFlow;
            this.f8399g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.equals(this.f8397e, "1")) {
                    this.f8398f.O();
                } else {
                    this.f8398f.z(this.f8399g);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull b.a.p0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b.a.p0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void r(JSONObject jSONObject, b.a.p0.a.a2.e eVar) {
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, eVar) == null) {
            b.a.p0.a.h0.l.a O = b.a.p0.a.h0.u.g.M().O();
            if (O instanceof b.a.p0.a.h0.l.e) {
                i2 = ((b.a.p0.a.h0.l.e) O).k();
                if (b.a.p0.a.u.c.d.f8000c) {
                    String str2 = "ID_PERFORMANCED_FLOW CodeCache status: " + i2;
                }
            } else {
                i2 = 0;
            }
            b.a.p0.a.j2.e.C(true);
            b.a.p0.a.j2.e.r();
            HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
            JSONObject optJSONObject = jSONObject.optJSONObject("ext");
            b.a.p0.a.p.e.b bVar = null;
            String str3 = "0";
            if (optJSONObject != null) {
                str3 = optJSONObject.optString("hasWebView", "0");
                str = optJSONObject.optString("hasRelaunch");
                b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.T().A(optJSONObject.optString("slaveId"));
                if (A instanceof b.a.p0.a.p.e.b) {
                    bVar = (b.a.p0.a.p.e.b) A;
                }
            } else {
                str = "";
            }
            if (TextUtils.equals(str3, "1")) {
                HybridUbcFlow.SubmitStrategy h2 = p.h();
                if (h2 == HybridUbcFlow.SubmitStrategy.HYBRID) {
                    p.F(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
                } else if (h2 == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                    p.F(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
                }
            }
            if (TextUtils.equals(str, "none")) {
                if (TextUtils.equals(str3, "1")) {
                    p.O();
                } else {
                    p.z(bVar);
                }
            }
            s(p, eVar, str3, bVar);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            p.A("codecache", String.valueOf(i2));
            p.D(z(optJSONArray));
            p.l();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void s(HybridUbcFlow hybridUbcFlow, b.a.p0.a.a2.e eVar, String str, @Nullable b.a.p0.a.p.e.b bVar) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65539, null, hybridUbcFlow, eVar, str, bVar) == null) || hybridUbcFlow == null || eVar == null) {
            return;
        }
        if (!b.a.p0.a.h0.u.g.M().e0()) {
            if (TextUtils.equals(str, "1")) {
                hybridUbcFlow.O();
                return;
            } else {
                hybridUbcFlow.z(bVar);
                return;
            }
        }
        long K = b.a.p0.a.c1.a.Z().K();
        if (K <= 0) {
            return;
        }
        b.a M = eVar.M();
        boolean z = false;
        if (M != null) {
            long currentTimeMillis = System.currentTimeMillis() - M.M();
            if (currentTimeMillis < K) {
                j = K - currentTimeMillis;
                if (z) {
                    if (j <= 0) {
                        return;
                    }
                    q.c(new b(str, hybridUbcFlow, bVar), "waitFcp", j, TimeUnit.MILLISECONDS);
                    return;
                } else if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.O();
                    return;
                } else {
                    hybridUbcFlow.z(bVar);
                    return;
                }
            }
            z = true;
        }
        j = 0;
        if (z) {
        }
    }

    public static void t(JSONObject jSONObject, b.a.p0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, eVar) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jSONObject, eVar), "handlePerformMsg", 2);
        }
    }

    public static void u(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, jSONObject) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() >= 1) {
                j.e().c(optJSONArray.optJSONObject(0));
            } else {
                boolean z2 = b.a.p0.a.u.c.d.f8000c;
            }
        }
    }

    public static void v(JSONObject jSONObject) {
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, jSONObject) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("ext")) == null) {
            return;
        }
        String optString = optJSONObject.optString("routeId");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        HybridUbcFlow q = b.a.p0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, optString);
        if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
            q.F(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
        }
        q.D(z(jSONObject.optJSONArray("data")));
        q.l();
        b.a.p0.a.p.e.d A = b.a.p0.a.g1.f.T().A(optJSONObject.optString("slaveId"));
        if (A instanceof SwanAppSlaveManager) {
            ((SwanAppSlaveManager) A).f1();
        }
    }

    public static void w(@Nullable JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, jSONArray) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FlowJarAction-671: ");
            sb.append(jSONArray == null ? StringUtil.NULL_STRING : jSONArray);
            b.a.p0.a.e0.d.h("Api-UbcFlowJar", sb.toString());
            if (jSONArray == null || jSONArray.length() == 0) {
                return;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        b.a.p0.a.i2.a.d().h(jSONObject);
                    } else {
                        b.a.p0.a.i2.a.d().k(jSONObject);
                    }
                } catch (JSONException e2) {
                    if (b.a.p0.a.u.c.d.f8000c) {
                        String str = "FlowJarAction-671: " + Log.getStackTraceString(e2);
                    }
                }
            }
        }
    }

    public static void x(JSONArray jSONArray) {
        b.a.p0.a.h0.g.f H;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) || (H = b.a.p0.a.g1.f.T().H()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject != null) {
                String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                String optString = jSONObject.optString(PmsConstant.Statistic.Key.REV_TIMESTAMP);
                long j = 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        j = Long.valueOf(optString).longValue();
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                H.s3(new b.a.p0.a.j2.p.g(string, j));
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    public static UbcFlowEvent y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            String optString = jSONObject.optString("actionId");
            long optLong = jSONObject.optLong("timestamp");
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(optString);
            ubcFlowEvent.h(optLong);
            return ubcFlowEvent;
        }
        return (UbcFlowEvent) invokeL.objValue;
    }

    public static List<UbcFlowEvent> z(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                UbcFlowEvent y = y(jSONArray.optJSONObject(i2));
                if (y != null) {
                    y.e("FE");
                    arrayList.add(y);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public b.a.p0.a.u.h.b A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            boolean z = b.a.p0.a.u.c.d.f8000c;
            b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
            if (i2 == null) {
                return new b.a.p0.a.u.h.b(1001, "swan app is null");
            }
            Pair<b.a.p0.a.u.h.b, JSONObject> b2 = b.a.p0.a.u.i.b.b("Api-UbcFlowJar", str);
            b.a.p0.a.u.h.b bVar = (b.a.p0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (b.a.p0.a.u.c.d.f8000c) {
                    b.a.p0.a.e0.d.b("Api-UbcFlowJar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("flowId");
            if (TextUtils.isEmpty(optString)) {
                return new b.a.p0.a.u.h.b(201, "empty flowId");
            }
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 53647:
                    if (optString.equals("670")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 53648:
                    if (optString.equals("671")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 55357:
                    if (optString.equals("805")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 56506:
                    if (optString.equals("967")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1529139648:
                    if (optString.equals("renderMonitorLog")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                t(jSONObject, i2);
            } else if (c2 == 1) {
                x(jSONObject.optJSONArray("data"));
            } else if (c2 == 2) {
                w(jSONObject.optJSONArray("data"));
            } else if (c2 == 3) {
                v(jSONObject);
            } else if (c2 != 4) {
                return new b.a.p0.a.u.h.b(201, "unknown flowId");
            } else {
                u(jSONObject);
            }
            return new b.a.p0.a.u.h.b(0);
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }
}
