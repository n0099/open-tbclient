package com.baidu.swan.apps.t.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.pms.c.d.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import com.baidu.swan.pms.node.b.g;
import com.baidu.swan.ubc.n;
import com.baidu.swan.ubc.q;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String atn() {
        return com.baidu.swan.apps.t.a.ass().adH();
    }

    @Override // com.baidu.swan.pms.b
    public String ato() {
        return com.baidu.swan.apps.t.a.ask().bq(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dO(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String atp() {
        return com.baidu.swan.apps.i.c.agQ();
    }

    @Override // com.baidu.swan.pms.b
    public String atq() {
        return com.baidu.swan.apps.t.a.asS().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String atr() {
        return ak.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String ats() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String att() {
        return com.baidu.swan.apps.swancore.b.kk(0);
    }

    @Override // com.baidu.swan.pms.b
    public String atu() {
        return com.baidu.swan.apps.extcore.b.ie(0);
    }

    @Override // com.baidu.swan.pms.b
    public String atv() {
        return com.baidu.swan.apps.swancore.b.kk(1);
    }

    @Override // com.baidu.swan.pms.b
    public String atw() {
        return com.baidu.swan.apps.extcore.b.ie(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager atx() {
        return com.baidu.swan.apps.t.a.asF().adP();
    }

    @Override // com.baidu.swan.pms.b
    public String aty() {
        return com.baidu.swan.apps.t.a.asi().abT();
    }

    @Override // com.baidu.swan.pms.b
    public void a(String str, String str2, String str3, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("from", str);
            jSONObject2.put("type", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("page", str3);
            }
            jSONObject2.put("value", String.valueOf(i));
            if (jSONObject != null) {
                jSONObject2.put("ext", jSONObject);
            }
            com.baidu.swan.apps.statistic.b.onEvent("874", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.swan.pms.b
    public String getProcessName() {
        return ProcessUtils.getCurProcessName();
    }

    @Override // com.baidu.swan.pms.b
    public com.baidu.swan.pms.c.f atz() {
        return com.baidu.swan.apps.runtime.d.aCW().aCZ();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> aYa;
        if (fVar != null && (aYa = fVar.aYa()) != null && aYa.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : aYa) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.t.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void alM() {
                                if (atomicInteger.get() == 0) {
                                    g.aYb().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void aiW() {
                                if (atomicInteger.get() == 0) {
                                    g.aYb().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void a(com.baidu.swan.pms.model.a aVar) {
                                super.a(aVar);
                                if (aVar != null && aVar.errorNo != 1010 && aVar.errorNo != 1015) {
                                    atomicInteger.incrementAndGet();
                                }
                            }
                        });
                    }
                }
            }, "preloadPkg", 2);
        }
    }

    @Override // com.baidu.swan.pms.b
    public void a(com.baidu.swan.pms.node.a.a aVar) {
        if (aVar != null) {
            try {
                JSONObject aXS = aVar.aXS();
                JSONArray aXT = aVar.aXT();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", aXS.optInt("threshold"));
                jSONObject.put("timeup", aXS.optInt("timeup"));
                jSONObject.put(MapController.ITEM_LAYER_TAG, aXT.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.aZC();
                n.aZv().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.b
    public void b(JSONArray jSONArray, String str, String str2) {
        com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().c(jSONArray, str, str2);
    }

    @Override // com.baidu.swan.pms.b
    public void a(PMSAppInfo pMSAppInfo, final JSONObject jSONObject, boolean z) {
        if (pMSAppInfo == null) {
            if (com.baidu.swan.apps.runtime.e.DEBUG) {
                Log.e("SwanAppUpdateManager", "pms app info is null");
                return;
            }
            return;
        }
        String str = pMSAppInfo.appKey;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            if (com.baidu.swan.apps.runtime.e.DEBUG) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
                return;
            }
            return;
        }
        int i = pMSAppInfo.type;
        final com.baidu.swan.apps.storage.c.b tg = h.tg(com.baidu.swan.apps.storage.b.V(str, pMSAppInfo.type));
        tg.putBoolean("swan_service_update_degraded", z);
        if (com.baidu.swan.apps.runtime.e.DEBUG) {
            Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
        }
        if (!com.baidu.swan.apps.performance.b.c.azE()) {
            if (com.baidu.swan.apps.runtime.e.DEBUG) {
                Log.e("SwanAppUpdateManager", "async update ab is closed");
                return;
            }
            return;
        }
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.ayq().a(tg, jSONObject);
            }
        }, "parseAccreditList");
    }
}
