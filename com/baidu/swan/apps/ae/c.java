package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.a.am;
import com.baidu.swan.apps.runtime.d;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
@h
/* loaded from: classes10.dex */
public final class c {
    private static a dgD;
    public static final c dgE = new c();

    @h
    /* loaded from: classes10.dex */
    public interface a {
        void Q(String str, String str2, String str3);

        void R(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aDA() {
        return dgD;
    }

    public final void aDB() {
        d aEQ = d.aEQ();
        q.m(aEQ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aES = aEQ.aES();
        q.m(aES, "Swan.get().adaptationProducer");
        aES.adF().afw().bn(d.aEQ()).A(b.dgF).aGL();
    }

    @h
    /* loaded from: classes10.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b dgF = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.m(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aDA = c.dgE.aDA();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aDA == null || !ProcessUtils.isMainProcess()) {
                        c.dgE.cp(null, optString);
                        return;
                    }
                    q.m(optString, "openId");
                    d aEQ = d.aEQ();
                    q.m(aEQ, "Swan.get()");
                    String appId = aEQ.getAppId();
                    am auM = com.baidu.swan.apps.t.a.auM();
                    q.m(auM, "SwanAppRuntime.getConfig()");
                    aDA.R(optString, appId, auM.getHostName());
                }
            }
        }
    }

    public final void aDC() {
        d aEQ = d.aEQ();
        q.m(aEQ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aES = aEQ.aES();
        q.m(aES, "Swan.get().adaptationProducer");
        aES.adF().afw().bm(d.aEQ()).A(C0358c.dgG).aGL();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static final class C0358c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0358c dgG = new C0358c();

        C0358c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.m(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aDA = c.dgE.aDA();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aDA == null || !ProcessUtils.isMainProcess()) {
                        c.dgE.cp(optString, null);
                        return;
                    }
                    q.m(optString, "swanId");
                    d aEQ = d.aEQ();
                    q.m(aEQ, "Swan.get()");
                    String appId = aEQ.getAppId();
                    am auM = com.baidu.swan.apps.t.a.auM();
                    q.m(auM, "SwanAppRuntime.getConfig()");
                    aDA.Q(optString, appId, auM.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cp(String str, String str2) {
        d aEQ = d.aEQ();
        q.m(aEQ, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aEL = aEQ.aEL();
        if (aEL != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aEQ2 = d.aEQ();
            q.m(aEQ2, "Swan.get()");
            bundle.putString("appId", aEQ2.getAppId());
            am auM = com.baidu.swan.apps.t.a.auM();
            q.m(auM, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", auM.getHostName());
            aEL.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
