package com.baidu.swan.apps.u.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.aj;
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
/* loaded from: classes11.dex */
public class a implements com.baidu.swan.pms.b {
    @Override // com.baidu.swan.pms.b
    public boolean isDebug() {
        return com.baidu.swan.apps.b.DEBUG;
    }

    @Override // com.baidu.swan.pms.b
    public String agW() {
        return com.baidu.swan.apps.u.a.agj().TN();
    }

    @Override // com.baidu.swan.pms.b
    public String agX() {
        return com.baidu.swan.apps.u.a.agc().bd(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dz(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String agY() {
        return com.baidu.swan.apps.h.c.WJ();
    }

    @Override // com.baidu.swan.pms.b
    public String agZ() {
        return com.baidu.swan.apps.u.a.agH().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String aha() {
        return aj.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String ahb() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String ahc() {
        return com.baidu.swan.apps.swancore.b.hm(0);
    }

    @Override // com.baidu.swan.pms.b
    public String ahd() {
        return com.baidu.swan.apps.extcore.b.fs(0);
    }

    @Override // com.baidu.swan.pms.b
    public String ahe() {
        return com.baidu.swan.apps.swancore.b.hm(1);
    }

    @Override // com.baidu.swan.pms.b
    public String ahf() {
        return com.baidu.swan.apps.extcore.b.fs(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager ahg() {
        return com.baidu.swan.apps.u.a.agu().TS();
    }

    @Override // com.baidu.swan.pms.b
    public String ahh() {
        return com.baidu.swan.apps.u.a.aga().Sm();
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
    public com.baidu.swan.pms.c.f ahi() {
        return com.baidu.swan.apps.runtime.d.apI().apL();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> aIo;
        if (fVar != null && (aIo = fVar.aIo()) != null && aIo.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.u.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : aIo) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.u.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void aaQ() {
                                if (atomicInteger.get() == 0) {
                                    g.aIp().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void aaR() {
                                if (atomicInteger.get() == 0) {
                                    g.aIp().b(fVar);
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
                JSONObject aIg = aVar.aIg();
                JSONArray aIh = aVar.aIh();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", aIg.optInt("threshold"));
                jSONObject.put("timeup", aIg.optInt("timeup"));
                jSONObject.put("item", aIh.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.aJR();
                n.aJJ().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
