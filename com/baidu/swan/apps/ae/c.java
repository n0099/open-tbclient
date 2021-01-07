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

    public final a aJU() {
        return dwP;
    }

    public final void aJV() {
        d aMh = d.aMh();
        p.n(aMh, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aMj = aMh.aMj();
        p.n(aMj, "Swan.get().adaptationProducer");
        aMj.ajO().alH().ca(d.aMh()).A(b.dwR).aOc();
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
                a aJU = c.dwQ.aJU();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aJU == null || !ProcessUtils.isMainProcess()) {
                        c.dwQ.cu(null, optString);
                        return;
                    }
                    p.n(optString, "openId");
                    d aMh = d.aMh();
                    p.n(aMh, "Swan.get()");
                    String appId = aMh.getAppId();
                    am aBe = com.baidu.swan.apps.t.a.aBe();
                    p.n(aBe, "SwanAppRuntime.getConfig()");
                    aJU.X(optString, appId, aBe.getHostName());
                }
            }
        }
    }

    public final void aJW() {
        d aMh = d.aMh();
        p.n(aMh, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aMj = aMh.aMj();
        p.n(aMj, "Swan.get().adaptationProducer");
        aMj.ajO().alH().bZ(d.aMh()).A(C0373c.dwS).aOc();
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
                a aJU = c.dwQ.aJU();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aJU == null || !ProcessUtils.isMainProcess()) {
                        c.dwQ.cu(optString, null);
                        return;
                    }
                    p.n(optString, "swanId");
                    d aMh = d.aMh();
                    p.n(aMh, "Swan.get()");
                    String appId = aMh.getAppId();
                    am aBe = com.baidu.swan.apps.t.a.aBe();
                    p.n(aBe, "SwanAppRuntime.getConfig()");
                    aJU.W(optString, appId, aBe.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cu(String str, String str2) {
        d aMh = d.aMh();
        p.n(aMh, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aMc = aMh.aMc();
        if (aMc != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aMh2 = d.aMh();
            p.n(aMh2, "Swan.get()");
            bundle.putString("appId", aMh2.getAppId());
            am aBe = com.baidu.swan.apps.t.a.aBe();
            p.n(aBe, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", aBe.getHostName());
            aMc.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
