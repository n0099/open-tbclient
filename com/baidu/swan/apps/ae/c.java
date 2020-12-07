package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.a.am;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.setting.oauth.h;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.e;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
@e
/* loaded from: classes25.dex */
public final class c {
    private static a drR;
    public static final c drS = new c();

    @e
    /* loaded from: classes25.dex */
    public interface a {
        void T(String str, String str2, String str3);

        void U(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aIA() {
        return drR;
    }

    public final void aIB() {
        d aJQ = d.aJQ();
        p.n(aJQ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aJS = aJQ.aJS();
        p.n(aJS, "Swan.get().adaptationProducer");
        aJS.aiF().akw().bT(d.aJQ()).A(b.drT).aLL();
    }

    @e
    /* loaded from: classes25.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<h<JSONObject>> {
        public static final b drT = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(h<JSONObject> hVar) {
            p.n(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aIA = c.drS.aIA();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aIA == null || !ProcessUtils.isMainProcess()) {
                        c.drS.cv(null, optString);
                        return;
                    }
                    p.n(optString, "openId");
                    d aJQ = d.aJQ();
                    p.n(aJQ, "Swan.get()");
                    String appId = aJQ.getAppId();
                    am azM = com.baidu.swan.apps.t.a.azM();
                    p.n(azM, "SwanAppRuntime.getConfig()");
                    aIA.U(optString, appId, azM.getHostName());
                }
            }
        }
    }

    public final void aIC() {
        d aJQ = d.aJQ();
        p.n(aJQ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aJS = aJQ.aJS();
        p.n(aJS, "Swan.get().adaptationProducer");
        aJS.aiF().akw().bS(d.aJQ()).A(C0380c.drU).aLL();
    }

    @e
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    static final class C0380c<MsgType> implements com.baidu.swan.apps.ap.e.b<h<JSONObject>> {
        public static final C0380c drU = new C0380c();

        C0380c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(h<JSONObject> hVar) {
            p.n(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aIA = c.drS.aIA();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aIA == null || !ProcessUtils.isMainProcess()) {
                        c.drS.cv(optString, null);
                        return;
                    }
                    p.n(optString, "swanId");
                    d aJQ = d.aJQ();
                    p.n(aJQ, "Swan.get()");
                    String appId = aJQ.getAppId();
                    am azM = com.baidu.swan.apps.t.a.azM();
                    p.n(azM, "SwanAppRuntime.getConfig()");
                    aIA.T(optString, appId, azM.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cv(String str, String str2) {
        d aJQ = d.aJQ();
        p.n(aJQ, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aJL = aJQ.aJL();
        if (aJL != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aJQ2 = d.aJQ();
            p.n(aJQ2, "Swan.get()");
            bundle.putString("appId", aJQ2.getAppId());
            am azM = com.baidu.swan.apps.t.a.azM();
            p.n(azM, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", azM.getHostName());
            aJL.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
