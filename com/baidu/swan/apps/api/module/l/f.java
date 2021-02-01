package com.baidu.swan.apps.api.module.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes9.dex */
public class f extends com.baidu.swan.apps.api.a.d {
    public f(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lw(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bh.second;
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
                a(jSONObject, aIK);
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
                aZ(jSONObject);
                break;
            case 5:
                aY(jSONObject);
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
        com.baidu.swan.apps.core.g.a asw = com.baidu.swan.apps.core.turbo.d.ase().asw();
        if (!(asw instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) asw).aqp();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.e.ho(true);
        com.baidu.swan.apps.statistic.e.aLu();
        HybridUbcFlow qk = i.qk("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy aDT = qk.aDT();
            if (aDT == HybridUbcFlow.SubmitStrategy.HYBRID) {
                qk.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (aDT == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                qk.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                qk.aDM();
            } else {
                qk.aDL();
            }
        }
        a(qk, eVar, str);
        qk.cg("codecache", String.valueOf(i)).aN(u(jSONObject.optJSONArray("data"))).aDJ();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.turbo.d.ase().asF()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.aDM();
                    return;
                } else {
                    hybridUbcFlow.aDL();
                    return;
                }
            }
            long agP = com.baidu.swan.apps.t.a.awZ().agP();
            if (agP > 0) {
                b.a afZ = eVar.afZ();
                boolean z = false;
                if (afZ != null) {
                    long currentTimeMillis = System.currentTimeMillis() - afZ.azo();
                    if (currentTimeMillis >= agP) {
                        z = true;
                        j = 0;
                    } else {
                        j = agP - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.aDM();
                    } else {
                        hybridUbcFlow.aDL();
                    }
                } else if (j > 0) {
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.f.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.aDM();
                            } else {
                                hybridUbcFlow.aDL();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void aY(JSONObject jSONObject) {
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
        k.aEe().bw(optJSONArray.optJSONObject(0));
    }

    public static void aZ(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow cd = i.cd("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    cd.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                cd.aN(u(jSONObject.optJSONArray("data"))).aDJ();
            }
        }
    }

    public static List<UbcFlowEvent> u(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent ba = ba(jSONArray.optJSONObject(i));
            if (ba != null) {
                ba.qB("FE");
                arrayList.add(ba);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent ba(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).cE(optLong);
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
                    searchFlowEvent.dLK = SearchFlowEvent.EventType.END;
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
        com.baidu.swan.apps.core.d.e apy = com.baidu.swan.apps.v.f.aAl().apy();
        if (apy != null) {
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
                        apy.a(new g(string, longValue));
                    }
                    longValue = 0;
                    apy.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void x(@Nullable JSONArray jSONArray) {
        com.baidu.swan.apps.console.c.bl("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.aj.a.aLi().cf(jSONObject);
                    } else {
                        com.baidu.swan.apps.aj.a.aLi().ce(jSONObject);
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
