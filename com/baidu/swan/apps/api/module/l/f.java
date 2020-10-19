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
/* loaded from: classes10.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ln(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
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
                a(jSONObject, aDa);
                break;
            case 1:
                v(jSONObject.optJSONArray("data"));
                break;
            case 2:
                w(jSONObject.optJSONArray("data"));
                break;
            case 3:
                x(jSONObject.optJSONArray("data"));
                break;
            case 4:
                aP(jSONObject);
                break;
            case 5:
                aO(jSONObject);
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
        com.baidu.swan.apps.core.g.a anE = com.baidu.swan.apps.core.turbo.d.ann().anE();
        if (!(anE instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) anE).alz();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.e.gk(true);
        com.baidu.swan.apps.statistic.e.aFK();
        HybridUbcFlow qc = i.qc("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy azc = qc.azc();
            if (azc == HybridUbcFlow.SubmitStrategy.HYBRID) {
                qc.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (azc == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                qc.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                qc.ayV();
            } else {
                qc.ayU();
            }
        }
        a(qc, eVar, str);
        qc.cb("codecache", String.valueOf(i)).av(u(jSONObject.optJSONArray("data"))).ayS();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.turbo.d.ann().anN()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.ayV();
                    return;
                } else {
                    hybridUbcFlow.ayU();
                    return;
                }
            }
            long aci = com.baidu.swan.apps.t.a.asi().aci();
            if (aci > 0) {
                b.a abu = eVar.abu();
                boolean z = false;
                if (abu != null) {
                    long currentTimeMillis = System.currentTimeMillis() - abu.aux();
                    if (currentTimeMillis >= aci) {
                        z = true;
                        j = 0;
                    } else {
                        j = aci - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.ayV();
                    } else {
                        hybridUbcFlow.ayU();
                    }
                } else if (j > 0) {
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.ayV();
                            } else {
                                hybridUbcFlow.ayU();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void aO(JSONObject jSONObject) {
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
        k.azp().bm(optJSONArray.optJSONObject(0));
    }

    public static void aP(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow bY = i.bY("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    bY.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                bY.av(u(jSONObject.optJSONArray("data"))).ayS();
            }
        }
    }

    public static List<UbcFlowEvent> u(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent aQ = aQ(jSONArray.optJSONObject(i));
            if (aQ != null) {
                aQ.qt("FE");
                arrayList.add(aQ);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent aQ(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).bA(optLong);
    }

    public static void v(JSONArray jSONArray) {
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
                    searchFlowEvent.dmc = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void w(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.e akI = com.baidu.swan.apps.v.f.avu().akI();
        if (akI != null) {
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
                        akI.a(new g(string, longValue));
                    }
                    longValue = 0;
                    akI.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void x(@Nullable JSONArray jSONArray) {
        com.baidu.swan.apps.console.c.bg("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.ak.a.aFy().bV(jSONObject);
                    } else {
                        com.baidu.swan.apps.ak.a.aFy().bU(jSONObject);
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
