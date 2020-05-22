package com.baidu.swan.apps.api.module.l;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ip(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
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
                a(jSONObject, aoF);
                break;
            case 1:
                t(jSONObject.optJSONArray("data"));
                break;
            case 2:
                u(jSONObject.optJSONArray("data"));
                break;
            case 3:
                v(jSONObject.optJSONArray("data"));
                break;
            case 4:
                ap(jSONObject);
                break;
            case 5:
                if (DEBUG) {
                    Log.d("Api-UbcFlowJar", "upload swan app render log");
                }
                i.alA().aM(jSONObject);
                break;
            default:
                return new com.baidu.swan.apps.api.c.b(201, "unknown flowId");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public static void a(JSONObject jSONObject, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        com.baidu.swan.apps.core.g.a abB = com.baidu.swan.apps.core.turbo.d.abl().abB();
        if (!(abB instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) abB).ZJ();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.e.fi(true);
        com.baidu.swan.apps.statistic.e.arf();
        HybridUbcFlow mp = g.mp("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy aln = mp.aln();
            if (aln == HybridUbcFlow.SubmitStrategy.HYBRID) {
                mp.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (aln == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                mp.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                mp.alg();
            } else {
                mp.alf();
            }
        }
        a(mp, eVar, str);
        mp.bD("codecache", String.valueOf(i)).aj(s(jSONObject.optJSONArray("data"))).ald();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.turbo.d.abl().abL()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.alg();
                    return;
                } else {
                    hybridUbcFlow.alf();
                    return;
                }
            }
            long Rw = com.baidu.swan.apps.u.a.aeU().Rw();
            if (Rw > 0) {
                b.a QJ = eVar.QJ();
                boolean z = false;
                if (QJ != null) {
                    long currentTimeMillis = System.currentTimeMillis() - QJ.agY();
                    if (currentTimeMillis >= Rw) {
                        z = true;
                        j = 0;
                    } else {
                        j = Rw - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.alg();
                    } else {
                        hybridUbcFlow.alf();
                    }
                } else if (j > 0) {
                    n.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.alg();
                            } else {
                                hybridUbcFlow.alf();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void ap(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow bA = g.bA("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    bA.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                bA.aj(s(jSONObject.optJSONArray("data"))).ald();
            }
        }
    }

    public static List<UbcFlowEvent> s(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent aq = aq(jSONArray.optJSONObject(i));
            if (aq != null) {
                aq.mF("FE");
                arrayList.add(aq);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent aq(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).bg(optLong);
    }

    public static void t(JSONArray jSONArray) {
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
                    searchFlowEvent.cGJ = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void u(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.d YQ = f.ahV().YQ();
        if (YQ != null) {
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
                        YQ.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                    }
                    longValue = 0;
                    YQ.a(new com.baidu.swan.apps.statistic.a.g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void v(@Nullable JSONArray jSONArray) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        }
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.al.a.aqT().br(jSONObject);
                    } else {
                        com.baidu.swan.apps.al.a.aqT().bq(jSONObject);
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
