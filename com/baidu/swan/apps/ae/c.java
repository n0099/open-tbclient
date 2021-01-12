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
/* loaded from: classes8.dex */
public final class c {
    private static a dsb;
    public static final c dsc = new c();

    @e
    /* loaded from: classes8.dex */
    public interface a {
        void V(String str, String str2, String str3);

        void W(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aGa() {
        return dsb;
    }

    public final void aGb() {
        d aIn = d.aIn();
        p.n(aIn, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aIp = aIn.aIp();
        p.n(aIp, "Swan.get().adaptationProducer");
        aIp.afU().ahN().bZ(d.aIn()).A(b.dsd).aKi();
    }

    @e
    /* loaded from: classes8.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final b dsd = new b();

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
                a aGa = c.dsc.aGa();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aGa == null || !ProcessUtils.isMainProcess()) {
                        c.dsc.ct(null, optString);
                        return;
                    }
                    p.n(optString, "openId");
                    d aIn = d.aIn();
                    p.n(aIn, "Swan.get()");
                    String appId = aIn.getAppId();
                    am axk = com.baidu.swan.apps.t.a.axk();
                    p.n(axk, "SwanAppRuntime.getConfig()");
                    aGa.W(optString, appId, axk.getHostName());
                }
            }
        }
    }

    public final void aGc() {
        d aIn = d.aIn();
        p.n(aIn, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aIp = aIn.aIp();
        p.n(aIp, "Swan.get().adaptationProducer");
        aIp.afU().ahN().bY(d.aIn()).A(C0356c.dse).aKi();
    }

    @e
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static final class C0356c<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final C0356c dse = new C0356c();

        C0356c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void L(h<JSONObject> hVar) {
            p.n(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGa = c.dsc.aGa();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aGa == null || !ProcessUtils.isMainProcess()) {
                        c.dsc.ct(optString, null);
                        return;
                    }
                    p.n(optString, "swanId");
                    d aIn = d.aIn();
                    p.n(aIn, "Swan.get()");
                    String appId = aIn.getAppId();
                    am axk = com.baidu.swan.apps.t.a.axk();
                    p.n(axk, "SwanAppRuntime.getConfig()");
                    aGa.V(optString, appId, axk.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ct(String str, String str2) {
        d aIn = d.aIn();
        p.n(aIn, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aIi = aIn.aIi();
        if (aIi != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aIn2 = d.aIn();
            p.n(aIn2, "Swan.get()");
            bundle.putString("appId", aIn2.getAppId());
            am axk = com.baidu.swan.apps.t.a.axk();
            p.n(axk, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", axk.getHostName());
            aIi.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
