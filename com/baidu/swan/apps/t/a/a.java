package com.baidu.swan.apps.t.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.pms.c.d.b;
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
/* loaded from: classes7.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String ail() {
        return com.baidu.swan.apps.t.a.ahv().Uk();
    }

    @Override // com.baidu.swan.pms.b
    public String aim() {
        return com.baidu.swan.apps.t.a.aho().bf(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dD(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String ain() {
        return com.baidu.swan.apps.h.c.Xp();
    }

    @Override // com.baidu.swan.pms.b
    public String aio() {
        return com.baidu.swan.apps.t.a.ahU().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String aip() {
        return al.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String aiq() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String air() {
        return com.baidu.swan.apps.swancore.b.hv(0);
    }

    @Override // com.baidu.swan.pms.b
    public String ais() {
        return com.baidu.swan.apps.extcore.b.fB(0);
    }

    @Override // com.baidu.swan.pms.b
    public String ait() {
        return com.baidu.swan.apps.swancore.b.hv(1);
    }

    @Override // com.baidu.swan.pms.b
    public String aiu() {
        return com.baidu.swan.apps.extcore.b.fB(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager aiv() {
        return com.baidu.swan.apps.t.a.ahH().Us();
    }

    @Override // com.baidu.swan.pms.b
    public String aiw() {
        return com.baidu.swan.apps.t.a.ahm().SD();
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
    public com.baidu.swan.pms.c.f aix() {
        return com.baidu.swan.apps.runtime.d.arr().aru();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> aMg;
        if (fVar != null && (aMg = fVar.aMg()) != null && aMg.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.t.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : aMg) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.t.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void abS() {
                                if (atomicInteger.get() == 0) {
                                    g.aMh().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void Zs() {
                                if (atomicInteger.get() == 0) {
                                    g.aMh().b(fVar);
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
                JSONObject aLY = aVar.aLY();
                JSONArray aLZ = aVar.aLZ();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", aLY.optInt("threshold"));
                jSONObject.put("timeup", aLY.optInt("timeup"));
                jSONObject.put("item", aLZ.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.aNI();
                n.aNB().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.swan.pms.b
    public void b(JSONArray jSONArray, String str, String str2) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().d(jSONArray, str, str2);
        } else {
            com.baidu.swan.apps.scheme.actions.forbidden.a.asG().c(jSONArray, str, str2);
        }
    }
}
