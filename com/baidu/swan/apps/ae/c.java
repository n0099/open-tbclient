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
/* loaded from: classes9.dex */
public final class c {
    private static a dwP;
    public static final c dwQ = new c();

    @e
    /* loaded from: classes9.dex */
    public interface a {
        void W(String str, String str2, String str3);

        void X(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aJT() {
        return dwP;
    }

    public final void aJU() {
        d aMg = d.aMg();
        p.n(aMg, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aMi = aMg.aMi();
        p.n(aMi, "Swan.get().adaptationProducer");
        aMi.ajN().alG().ca(d.aMg()).A(b.dwR).aOb();
    }

    @e
    /* loaded from: classes9.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final b dwR = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void L(h<JSONObject> hVar) {
            p.n(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aJT = c.dwQ.aJT();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aJT == null || !ProcessUtils.isMainProcess()) {
                        c.dwQ.cu(null, optString);
                        return;
                    }
                    p.n(optString, "openId");
                    d aMg = d.aMg();
                    p.n(aMg, "Swan.get()");
                    String appId = aMg.getAppId();
                    am aBd = com.baidu.swan.apps.t.a.aBd();
                    p.n(aBd, "SwanAppRuntime.getConfig()");
                    aJT.X(optString, appId, aBd.getHostName());
                }
            }
        }
    }

    public final void aJV() {
        d aMg = d.aMg();
        p.n(aMg, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aMi = aMg.aMi();
        p.n(aMi, "Swan.get().adaptationProducer");
        aMi.ajN().alG().bZ(d.aMg()).A(C0373c.dwS).aOb();
    }

    @e
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static final class C0373c<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final C0373c dwS = new C0373c();

        C0373c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void L(h<JSONObject> hVar) {
            p.n(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aJT = c.dwQ.aJT();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aJT == null || !ProcessUtils.isMainProcess()) {
                        c.dwQ.cu(optString, null);
                        return;
                    }
                    p.n(optString, "swanId");
                    d aMg = d.aMg();
                    p.n(aMg, "Swan.get()");
                    String appId = aMg.getAppId();
                    am aBd = com.baidu.swan.apps.t.a.aBd();
                    p.n(aBd, "SwanAppRuntime.getConfig()");
                    aJT.W(optString, appId, aBd.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cu(String str, String str2) {
        d aMg = d.aMg();
        p.n(aMg, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aMb = aMg.aMb();
        if (aMb != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aMg2 = d.aMg();
            p.n(aMg2, "Swan.get()");
            bundle.putString("appId", aMg2.getAppId());
            am aBd = com.baidu.swan.apps.t.a.aBd();
            p.n(aBd, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", aBd.getHostName());
            aMb.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
