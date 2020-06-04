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
    public String afQ() {
        return com.baidu.swan.apps.u.a.afd().SH();
    }

    @Override // com.baidu.swan.pms.b
    public String afR() {
        return com.baidu.swan.apps.u.a.aeW().bc(AppRuntime.getAppContext());
    }

    @Override // com.baidu.swan.pms.b
    public String getUUID() {
        return com.baidu.swan.uuid.b.dy(AppRuntime.getAppContext()).getUUID();
    }

    @Override // com.baidu.swan.pms.b
    public String afS() {
        return com.baidu.swan.apps.h.c.VD();
    }

    @Override // com.baidu.swan.pms.b
    public String afT() {
        return com.baidu.swan.apps.u.a.afB().getHostName();
    }

    @Override // com.baidu.swan.pms.b
    public String afU() {
        return aj.getVersionName();
    }

    @Override // com.baidu.swan.pms.b
    public String afV() {
        return com.baidu.swan.apps.c.getVersion();
    }

    @Override // com.baidu.swan.pms.b
    public String afW() {
        return com.baidu.swan.apps.swancore.b.hb(0);
    }

    @Override // com.baidu.swan.pms.b
    public String afX() {
        return com.baidu.swan.apps.extcore.b.fh(0);
    }

    @Override // com.baidu.swan.pms.b
    public String afY() {
        return com.baidu.swan.apps.swancore.b.hb(1);
    }

    @Override // com.baidu.swan.pms.b
    public String afZ() {
        return com.baidu.swan.apps.extcore.b.fh(1);
    }

    @Override // com.baidu.swan.pms.b
    public CookieManager aga() {
        return com.baidu.swan.apps.u.a.afo().SM();
    }

    @Override // com.baidu.swan.pms.b
    public String agb() {
        return com.baidu.swan.apps.u.a.aeU().Rg();
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
    public com.baidu.swan.pms.c.f agc() {
        return com.baidu.swan.apps.runtime.d.aoB().aoE();
    }

    @Override // com.baidu.swan.pms.b
    public void a(final com.baidu.swan.pms.node.b.f fVar) {
        final Set<String> aHi;
        if (fVar != null && (aHi = fVar.aHi()) != null && aHi.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.u.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    final AtomicInteger atomicInteger = new AtomicInteger(0);
                    for (String str : aHi) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(new b.a(str, 0));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.baidu.swan.apps.core.a.a.a.a(arrayList, "3", new com.baidu.swan.apps.core.pms.a() { // from class: com.baidu.swan.apps.u.a.a.1.1
                            @Override // com.baidu.swan.apps.core.pms.a
                            public void ZK() {
                                if (atomicInteger.get() == 0) {
                                    g.aHj().b(fVar);
                                }
                            }

                            @Override // com.baidu.swan.apps.core.pms.a
                            public void ZL() {
                                if (atomicInteger.get() == 0) {
                                    g.aHj().b(fVar);
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
                JSONObject aHa = aVar.aHa();
                JSONArray aHb = aVar.aHb();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("threshold", aHa.optInt("threshold"));
                jSONObject.put("timeup", aHa.optInt("timeup"));
                jSONObject.put("item", aHb.toString());
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    Log.d(Node.TAG, "ceres adapted config " + jSONObject);
                }
                q qVar = new q("0", jSONObject);
                qVar.aIL();
                n.aID().b(qVar);
            } catch (JSONException e) {
                if (com.baidu.swan.apps.runtime.e.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}
