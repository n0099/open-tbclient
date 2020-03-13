package com.baidu.swan.apps.api.module.l;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.statistic.a.g;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.api.a.c {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b gf(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) ar.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) ar.second;
        String optString = jSONObject.optString("flowId");
        if (TextUtils.isEmpty(optString)) {
            return new com.baidu.swan.apps.api.b.b(201, "empty flowId");
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
        }
        switch (c) {
            case 0:
                a(jSONObject, acF);
                break;
            case 1:
                r(jSONObject.optJSONArray("data"));
                break;
            case 2:
                s(jSONObject.optJSONArray("data"));
                break;
            case 3:
                t(jSONObject.optJSONArray("data"));
                break;
            case 4:
                W(jSONObject);
                break;
            default:
                return new com.baidu.swan.apps.api.b.b(201, "unknown flowId");
        }
        return new com.baidu.swan.apps.api.b.b(0);
    }

    public static void a(JSONObject jSONObject, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        com.baidu.swan.apps.core.g.a QL = com.baidu.swan.apps.core.k.d.Qw().QL();
        if (!(QL instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) QL).Pg();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.c.dR(true);
        com.baidu.swan.apps.statistic.c.aeP();
        HybridUbcFlow jP = f.jP("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy ZO = jP.ZO();
            if (ZO == HybridUbcFlow.SubmitStrategy.HYBRID) {
                jP.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (ZO == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                jP.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                jP.ZF();
            } else {
                jP.ZE();
            }
        }
        a(jP, eVar, str);
        jP.bb("codecache", String.valueOf(i)).Z(q(jSONObject.optJSONArray("data"))).ZC();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.k.d.Qw().QV()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.ZF();
                    return;
                } else {
                    hybridUbcFlow.ZE();
                    return;
                }
            }
            long Ht = com.baidu.swan.apps.w.a.TZ().Ht();
            if (Ht > 0) {
                b.a GE = eVar.GE();
                boolean z = false;
                if (GE != null) {
                    long currentTimeMillis = System.currentTimeMillis() - GE.VX();
                    if (currentTimeMillis >= Ht) {
                        z = true;
                        j = 0;
                    } else {
                        j = Ht - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.ZF();
                    } else {
                        hybridUbcFlow.ZE();
                    }
                } else if (j > 0) {
                    m.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.ZF();
                            } else {
                                hybridUbcFlow.ZE();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void W(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow aY = f.aY("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    aY.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                aY.Z(q(jSONObject.optJSONArray("data"))).ZC();
            }
        }
    }

    public static List<UbcFlowEvent> q(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent X = X(jSONArray.optJSONObject(i));
            if (X != null) {
                X.ke("FE");
                arrayList.add(X);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent X(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).au(optLong);
    }

    public static void r(JSONArray jSONArray) {
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
                    searchFlowEvent.bVB = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void s(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.d Oo = com.baidu.swan.apps.y.f.WS().Oo();
        if (Oo != null) {
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
                        Oo.a(new g(string, longValue));
                    }
                    longValue = 0;
                    Oo.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void t(@Nullable JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.an.a.aeH().aX(jSONObject);
                    } else {
                        com.baidu.swan.apps.an.a.aeH().aW(jSONObject);
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
