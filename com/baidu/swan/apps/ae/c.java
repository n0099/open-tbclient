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
    private static a dmy;
    public static final c dmz = new c();

    @h
    /* loaded from: classes10.dex */
    public interface a {
        void Q(String str, String str2, String str3);

        void R(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aGa() {
        return dmy;
    }

    public final void aGb() {
        d aHq = d.aHq();
        q.m(aHq, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aHs = aHq.aHs();
        q.m(aHs, "Swan.get().adaptationProducer");
        aHs.agf().ahW().bn(d.aHq()).A(b.dmA).aJl();
    }

    @h
    /* loaded from: classes10.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b dmA = new b();

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
                a aGa = c.dmz.aGa();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aGa == null || !ProcessUtils.isMainProcess()) {
                        c.dmz.cp(null, optString);
                        return;
                    }
                    q.m(optString, "openId");
                    d aHq = d.aHq();
                    q.m(aHq, "Swan.get()");
                    String appId = aHq.getAppId();
                    am axm = com.baidu.swan.apps.t.a.axm();
                    q.m(axm, "SwanAppRuntime.getConfig()");
                    aGa.R(optString, appId, axm.getHostName());
                }
            }
        }
    }

    public final void aGc() {
        d aHq = d.aHq();
        q.m(aHq, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aHs = aHq.aHs();
        q.m(aHs, "Swan.get().adaptationProducer");
        aHs.agf().ahW().bm(d.aHq()).A(C0370c.dmB).aJl();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static final class C0370c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0370c dmB = new C0370c();

        C0370c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.m(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGa = c.dmz.aGa();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aGa == null || !ProcessUtils.isMainProcess()) {
                        c.dmz.cp(optString, null);
                        return;
                    }
                    q.m(optString, "swanId");
                    d aHq = d.aHq();
                    q.m(aHq, "Swan.get()");
                    String appId = aHq.getAppId();
                    am axm = com.baidu.swan.apps.t.a.axm();
                    q.m(axm, "SwanAppRuntime.getConfig()");
                    aGa.Q(optString, appId, axm.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cp(String str, String str2) {
        d aHq = d.aHq();
        q.m(aHq, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aHl = aHq.aHl();
        if (aHl != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aHq2 = d.aHq();
            q.m(aHq2, "Swan.get()");
            bundle.putString("appId", aHq2.getAppId());
            am axm = com.baidu.swan.apps.t.a.axm();
            q.m(axm, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", axm.getHostName());
            aHl.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
