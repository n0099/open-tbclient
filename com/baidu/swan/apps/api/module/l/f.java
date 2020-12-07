package com.baidu.swan.apps.api.module.l;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.statistic.a.g;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mw(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        String optString = jSONObject.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.c.b(201, "empty flowId");
        }
        char c = 65535;
        switch (optString.hashCode()) {
            case 53647:
                if (optString.equals("670")) {
                    c = 0;
                    break;
                }
                break;
            case 53648:
                if (optString.equals("671")) {
                    c = 3;
                    break;
                }
                break;
            case 54610:
                if (optString.equals("772")) {
                    c = 1;
                    break;
                }
                break;
            case 55357:
                if (optString.equals("805")) {
                    c = 2;
                    break;
                }
                break;
            case 56506:
                if (optString.equals("967")) {
                    c = 4;
                    break;
                }
                break;
            case 1529139648:
                if (optString.equals("renderMonitorLog")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                a(jSONObject, aJU);
                break;
            case 1:
                w(jSONObject.optJSONArray("data"));
                break;
            case 2:
                x(jSONObject.optJSONArray("data"));
                break;
            case 3:
                y(jSONObject.optJSONArray("data"));
                break;
            case 4:
                aU(jSONObject);
                break;
            case 5:
                aT(jSONObject);
                break;
            default:
                return new com.baidu.swan.apps.api.c.b(201, "unknown flowId");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public static void a(final JSONObject jSONObject, final com.baidu.swan.apps.runtime.e eVar) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.swan.apps.api.a.d.DEBUG) {
                    Log.d("Api-UbcFlowJar", "handlePerformMsg in thread pool");
                }
                f.b(jSONObject, eVar);
            }
        }, "handlePerformMsg", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONObject jSONObject, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        com.baidu.swan.apps.core.g.a auz = com.baidu.swan.apps.core.turbo.d.aui().auz();
        if (!(auz instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) auz).asu();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.e.gY(true);
        com.baidu.swan.apps.statistic.e.aME();
        HybridUbcFlow rk = i.rk("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy aFW = rk.aFW();
            if (aFW == HybridUbcFlow.SubmitStrategy.HYBRID) {
                rk.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (aFW == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                rk.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                rk.aFP();
            } else {
                rk.aFO();
            }
        }
        a(rk, eVar, str);
        rk.co("codecache", String.valueOf(i)).aP(v(jSONObject.optJSONArray("data"))).aFM();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.turbo.d.aui().auI()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.aFP();
                    return;
                } else {
                    hybridUbcFlow.aFO();
                    return;
                }
            }
            long ajc = com.baidu.swan.apps.t.a.azd().ajc();
            if (ajc > 0) {
                b.a aio = eVar.aio();
                boolean z = false;
                if (aio != null) {
                    long currentTimeMillis = System.currentTimeMillis() - aio.aBs();
                    if (currentTimeMillis >= ajc) {
                        z = true;
                        j = 0;
                    } else {
                        j = ajc - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.aFP();
                    } else {
                        hybridUbcFlow.aFO();
                    }
                } else if (j > 0) {
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.aFP();
                            } else {
                                hybridUbcFlow.aFO();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void aT(JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "upload swan app render log");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        if (optJSONArray == null || optJSONArray.length() < 1) {
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "Render monitor log is null");
                return;
            }
            return;
        }
        k.aGj().br(optJSONArray.optJSONObject(0));
    }

    public static void aU(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow cl = i.cl("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    cl.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                cl.aP(v(jSONObject.optJSONArray("data"))).aFM();
            }
        }
    }

    public static List<UbcFlowEvent> v(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent aV = aV(jSONArray.optJSONObject(i));
            if (aV != null) {
                aV.rB("FE");
                arrayList.add(aV);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent aV(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).cx(optLong);
    }

    public static void w(JSONArray jSONArray) {
        if (jSONArray != null) {
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "SearchFlowEvent from FE, data: " + jSONArray);
            }
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(0);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    String optString2 = optJSONObject.optString("errorType");
                    String optString3 = optJSONObject.optString("timeStamp");
                    SearchFlowEvent searchFlowEvent = new SearchFlowEvent(optString);
                    searchFlowEvent.timestamp = Long.valueOf(optString3).longValue();
                    searchFlowEvent.data = optString2;
                    searchFlowEvent.dFO = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void x(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.e arC = com.baidu.swan.apps.v.f.aCp().arC();
        if (arC != null) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(0);
                if (jSONObject != null) {
                    String string = jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID);
                    String optString = jSONObject.optString("timeStamp");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            longValue = Long.valueOf(optString).longValue();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                        arC.a(new g(string, longValue));
                    }
                    longValue = 0;
                    arC.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void y(@Nullable JSONArray jSONArray) {
        com.baidu.swan.apps.console.c.bt("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.ak.a.aMs().ca(jSONObject);
                    } else {
                        com.baidu.swan.apps.ak.a.aMs().bZ(jSONObject);
                    }
                } catch (JSONException e) {
                    if (DEBUG) {
                        Log.w("Api-UbcFlowJar", "FlowJarAction-671: " + Log.getStackTraceString(e));
                    }
                }
            }
        }
    }
}
