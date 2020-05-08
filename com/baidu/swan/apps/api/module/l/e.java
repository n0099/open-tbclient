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

    public com.baidu.swan.apps.api.b.b hs(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.b.b bVar = (com.baidu.swan.apps.api.b.b) az.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) az.second;
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
                a(jSONObject, akM);
                break;
            case 1:
                s(jSONObject.optJSONArray("data"));
                break;
            case 2:
                t(jSONObject.optJSONArray("data"));
                break;
            case 3:
                u(jSONObject.optJSONArray("data"));
                break;
            case 4:
                ah(jSONObject);
                break;
            default:
                return new com.baidu.swan.apps.api.b.b(201, "unknown flowId");
        }
        return new com.baidu.swan.apps.api.b.b(0);
    }

    public static void a(JSONObject jSONObject, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        com.baidu.swan.apps.core.g.a YC = com.baidu.swan.apps.core.k.d.Yn().YC();
        if (!(YC instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) YC).WX();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.c.eO(true);
        com.baidu.swan.apps.statistic.c.amW();
        HybridUbcFlow lb = f.lb("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy ahV = lb.ahV();
            if (ahV == HybridUbcFlow.SubmitStrategy.HYBRID) {
                lb.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (ahV == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                lb.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                lb.ahM();
            } else {
                lb.ahL();
            }
        }
        a(lb, eVar, str);
        lb.bk("codecache", String.valueOf(i)).ah(r(jSONObject.optJSONArray("data"))).ahJ();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.k.d.Yn().YM()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.ahM();
                    return;
                } else {
                    hybridUbcFlow.ahL();
                    return;
                }
            }
            long Pk = com.baidu.swan.apps.w.a.abQ().Pk();
            if (Pk > 0) {
                b.a Ov = eVar.Ov();
                boolean z = false;
                if (Ov != null) {
                    long currentTimeMillis = System.currentTimeMillis() - Ov.adO();
                    if (currentTimeMillis >= Pk) {
                        z = true;
                        j = 0;
                    } else {
                        j = Pk - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.ahM();
                    } else {
                        hybridUbcFlow.ahL();
                    }
                } else if (j > 0) {
                    m.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.ahM();
                            } else {
                                hybridUbcFlow.ahL();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void ah(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow bh = f.bh("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    bh.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                bh.ah(r(jSONObject.optJSONArray("data"))).ahJ();
            }
        }
    }

    public static List<UbcFlowEvent> r(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent ai = ai(jSONArray.optJSONObject(i));
            if (ai != null) {
                ai.lq("FE");
                arrayList.add(ai);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent ai(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).aZ(optLong);
    }

    public static void s(JSONArray jSONArray) {
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
                    searchFlowEvent.cuK = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void t(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.d We = com.baidu.swan.apps.y.f.aeJ().We();
        if (We != null) {
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
                        We.a(new g(string, longValue));
                    }
                    longValue = 0;
                    We.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void u(@Nullable JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.an.a.amO().bi(jSONObject);
                    } else {
                        com.baidu.swan.apps.an.a.amO().bh(jSONObject);
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
