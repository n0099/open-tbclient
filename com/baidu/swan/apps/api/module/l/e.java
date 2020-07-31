package com.baidu.swan.apps.api.module.l;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.statistic.a.g;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.v.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends com.baidu.swan.apps.api.a.d {
    public e(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b iH(String str) {
        if (DEBUG) {
            Log.d("Api-UbcFlowJar", "start handle ubc");
        }
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "swan app is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-UbcFlowJar", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-UbcFlowJar", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
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
                a(jSONObject, arv);
                break;
            case 1:
                u(jSONObject.optJSONArray("data"));
                break;
            case 2:
                v(jSONObject.optJSONArray("data"));
                break;
            case 3:
                w(jSONObject.optJSONArray("data"));
                break;
            case 4:
                az(jSONObject);
                break;
            case 5:
                ay(jSONObject);
                break;
            default:
                return new com.baidu.swan.apps.api.c.b(201, "unknown flowId");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public static void a(final JSONObject jSONObject, final com.baidu.swan.apps.runtime.e eVar) {
        if (!com.baidu.swan.apps.performance.b.b.aon()) {
            b(jSONObject, eVar);
        } else {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.api.a.d.DEBUG) {
                        Log.d("Api-UbcFlowJar", "handlePerformMsg in thread pool");
                    }
                    e.b(jSONObject, eVar);
                }
            }, "handlePerformMsg", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONObject jSONObject, com.baidu.swan.apps.runtime.e eVar) {
        int i;
        com.baidu.swan.apps.core.g.a adM = com.baidu.swan.apps.core.turbo.d.adw().adM();
        if (!(adM instanceof com.baidu.swan.apps.core.g.e)) {
            i = 0;
        } else {
            i = ((com.baidu.swan.apps.core.g.e) adM).abR();
            if (DEBUG) {
                Log.d("Api-UbcFlowJar", "ID_PERFORMANCED_FLOW CodeCache status: " + i);
            }
        }
        com.baidu.swan.apps.statistic.e.fw(true);
        com.baidu.swan.apps.statistic.e.aui();
        HybridUbcFlow mX = i.mX("startup");
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        String str = "0";
        String str2 = "";
        if (optJSONObject != null) {
            str = optJSONObject.optString("hasWebView", "0");
            str2 = optJSONObject.optString("hasRelaunch");
        }
        if (TextUtils.equals(str, "1")) {
            HybridUbcFlow.SubmitStrategy anN = mX.anN();
            if (anN == HybridUbcFlow.SubmitStrategy.HYBRID) {
                mX.a(HybridUbcFlow.SubmitStrategy.HYBRID_WEB);
            } else if (anN == HybridUbcFlow.SubmitStrategy.RELAUNCH) {
                mX.a(HybridUbcFlow.SubmitStrategy.RELAUNCH_WEB);
            }
        }
        if (TextUtils.equals(str2, "none")) {
            if (TextUtils.equals(str, "1")) {
                mX.anG();
            } else {
                mX.anF();
            }
        }
        a(mX, eVar, str);
        mX.bH("codecache", String.valueOf(i)).an(t(jSONObject.optJSONArray("data"))).anD();
    }

    private static void a(final HybridUbcFlow hybridUbcFlow, com.baidu.swan.apps.runtime.e eVar, final String str) {
        long j;
        if (hybridUbcFlow != null && eVar != null) {
            if (!com.baidu.swan.apps.core.turbo.d.adw().adV()) {
                if (TextUtils.equals(str, "1")) {
                    hybridUbcFlow.anG();
                    return;
                } else {
                    hybridUbcFlow.anF();
                    return;
                }
            }
            long SS = com.baidu.swan.apps.t.a.ahm().SS();
            if (SS > 0) {
                b.a Se = eVar.Se();
                boolean z = false;
                if (Se != null) {
                    long currentTimeMillis = System.currentTimeMillis() - Se.aju();
                    if (currentTimeMillis >= SS) {
                        z = true;
                        j = 0;
                    } else {
                        j = SS - currentTimeMillis;
                    }
                } else {
                    j = 0;
                }
                if (z) {
                    if (TextUtils.equals(str, "1")) {
                        hybridUbcFlow.anG();
                    } else {
                        hybridUbcFlow.anF();
                    }
                } else if (j > 0) {
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.api.module.l.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TextUtils.equals(str, "1")) {
                                hybridUbcFlow.anG();
                            } else {
                                hybridUbcFlow.anF();
                            }
                        }
                    }, "waitFcp", j, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    public static void ay(JSONObject jSONObject) {
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
        k.aoa().aV(optJSONArray.optJSONObject(0));
    }

    public static void az(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("ext")) != null) {
            String optString = optJSONObject.optString("routeId");
            if (!TextUtils.isEmpty(optString)) {
                HybridUbcFlow bE = i.bE("route", optString);
                if (TextUtils.equals(optJSONObject.optString("hasWebView"), "1")) {
                    bE.a(HybridUbcFlow.SubmitStrategy.ROUTE_WEB);
                }
                bE.an(t(jSONObject.optJSONArray("data"))).anD();
            }
        }
    }

    public static List<UbcFlowEvent> t(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            UbcFlowEvent aA = aA(jSONArray.optJSONObject(i));
            if (aA != null) {
                aA.np("FE");
                arrayList.add(aA);
            }
        }
        return arrayList;
    }

    public static UbcFlowEvent aA(JSONObject jSONObject) {
        String optString = jSONObject.optString("actionId");
        long optLong = jSONObject.optLong("timestamp");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new UbcFlowEvent(optString).bm(optLong);
    }

    public static void u(JSONArray jSONArray) {
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
                    searchFlowEvent.cOO = SearchFlowEvent.EventType.END;
                    com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
                }
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void v(JSONArray jSONArray) {
        long longValue;
        com.baidu.swan.apps.core.d.e aba = f.akr().aba();
        if (aba != null) {
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
                        aba.a(new g(string, longValue));
                    }
                    longValue = 0;
                    aba.a(new g(string, longValue));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void w(@Nullable JSONArray jSONArray) {
        com.baidu.swan.apps.console.c.aW("Api-UbcFlowJar", "FlowJarAction-671: " + (jSONArray == null ? "null" : jSONArray));
        if (jSONArray != null && jSONArray.length() != 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (TextUtils.equals(jSONObject.optString("type"), "feTraceError")) {
                        com.baidu.swan.apps.al.a.atW().bD(jSONObject);
                    } else {
                        com.baidu.swan.apps.al.a.atW().bC(jSONObject);
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
