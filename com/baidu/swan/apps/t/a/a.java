package com.baidu.swan.apps.t.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes8.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String axF() {
        return com.baidu.swan.apps.t.a.awK().ahS();
    }

    @Override // com.baidu.swan.pms.b
    public String axG() {
        return com.baidu.swan.apps.t.a.awD().cc(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.eL(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String axH() {
        return com.baidu.swan.apps.i.c.alc();
    }

    @Override // com.baidu.swan.pms.b
    public String axI() {
        return com.baidu.swan.apps.t.a.axk().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String axJ() {
        return ak.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String axK() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String axL() {
        return com.baidu.swan.apps.swancore.b.jy(0);
    }

    @Override // com.baidu.swan.pms.b
    public String axM() {
        return com.baidu.swan.apps.extcore.b.hi(0);
    }

    @Override // com.baidu.swan.pms.b
    public String axN() {
        return com.baidu.swan.apps.swancore.b.jy(1);
    }

    @Override // com.baidu.swan.pms.b
    public String axO() {
        return com.baidu.swan.apps.extcore.b.hi(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager axP() {
        return com.baidu.swan.apps.t.a.awX().aia();
    }

    @Override // com.baidu.swan.pms.b
    public String axQ() {
        return com.baidu.swan.apps.t.a.awB().agc();
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
    public com.baidu.swan.pms.c.f axR() {
        return com.baidu.swan.apps.runtime.d.aIn().aIq();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> bdt;
        if (fVar != null && (bdt = fVar.bdt()) != null && bdt.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : bdt) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.t.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void aqe() {
                                if (atomicInteger.get() == 0) {
                                    g.bdu().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void ani() {
                                if (atomicInteger.get() == 0) {
                                    g.bdu().b(fVar);
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
                JSONObject bdl = aVar.bdl();
                JSONArray bdm = aVar.bdm();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", bdl.optInt("threshold"));
                jSONObject.put("timeup", bdl.optInt("timeup"));
                jSONObject.put("item", bdm.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.beX();
                n.beQ().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.b
    public void b(JSONArray jSONArray, String str, String str2) {
        com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().c(jSONArray, str, str2);
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
        final com.baidu.swan.apps.storage.c.b tb = h.tb(com.baidu.swan.apps.storage.b.aa(str, pMSAppInfo.type));
        tb.putBoolean("swan_service_update_degraded", z);
        if (com.baidu.swan.apps.runtime.e.DEBUG) {
            Log.d("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
        }
        if (!com.baidu.swan.apps.performance.b.c.aDY()) {
            if (com.baidu.swan.apps.runtime.e.DEBUG) {
                Log.e("SwanAppUpdateManager", "async update ab is closed");
                return;
            }
            return;
        }
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aCM().a(tb, jSONObject);
            }
        }, "parseAccreditList");
    }
}
