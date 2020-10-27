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
    public String avh() {
        return com.baidu.swan.apps.t.a.aum().afB();
    }

    @Override // com.baidu.swan.pms.b
    public String avi() {
        return com.baidu.swan.apps.t.a.auf().bq(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dO(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String avj() {
        return com.baidu.swan.apps.i.c.aiK();
    }

    @Override // com.baidu.swan.pms.b
    public String avk() {
        return com.baidu.swan.apps.t.a.auM().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String avl() {
        return ak.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String avm() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String avn() {
        return com.baidu.swan.apps.swancore.b.kv(0);
    }

    @Override // com.baidu.swan.pms.b
    public String avo() {
        return com.baidu.swan.apps.extcore.b.ip(0);
    }

    @Override // com.baidu.swan.pms.b
    public String avp() {
        return com.baidu.swan.apps.swancore.b.kv(1);
    }

    @Override // com.baidu.swan.pms.b
    public String avq() {
        return com.baidu.swan.apps.extcore.b.ip(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager avr() {
        return com.baidu.swan.apps.t.a.auz().afJ();
    }

    @Override // com.baidu.swan.pms.b
    public String avs() {
        return com.baidu.swan.apps.t.a.aud().adN();
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
    public com.baidu.swan.pms.c.f avt() {
        return com.baidu.swan.apps.runtime.d.aEQ().aET();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> aZT;
        if (fVar != null && (aZT = fVar.aZT()) != null && aZT.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : aZT) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.t.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void anG() {
                                if (atomicInteger.get() == 0) {
                                    g.aZU().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void akQ() {
                                if (atomicInteger.get() == 0) {
                                    g.aZU().b(fVar);
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
                JSONObject aZL = aVar.aZL();
                JSONArray aZM = aVar.aZM();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", aZL.optInt("threshold"));
                jSONObject.put("timeup", aZL.optInt("timeup"));
                jSONObject.put(MapController.ITEM_LAYER_TAG, aZM.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.bbv();
                n.bbo().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.b
    public void b(JSONArray jSONArray, String str, String str2) {
        com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().c(jSONArray, str, str2);
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
        final com.baidu.swan.apps.storage.c.b tz = h.tz(com.baidu.swan.apps.storage.b.V(str, pMSAppInfo.type));
        tz.putBoolean("swan_service_update_degraded", z);
        if (com.baidu.swan.apps.runtime.e.DEBUG) {
            Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
        }
        if (!com.baidu.swan.apps.performance.b.c.aBy()) {
            if (com.baidu.swan.apps.runtime.e.DEBUG) {
                Log.e("SwanAppUpdateManager", "async update ab is closed");
                return;
            }
            return;
        }
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aAk().a(tz, jSONObject);
            }
        }, "parseAccreditList");
    }
}
