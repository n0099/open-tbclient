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
/* loaded from: classes3.dex */
public final class c {
    private static a cLZ;
    public static final c cMa = new c();

    @h
    /* loaded from: classes3.dex */
    public interface a {
        void I(String str, String str2, String str3);

        void J(String str, String str2, String str3);
    }

    private c() {
    }

    public final a ayX() {
        return cLZ;
    }

    public final void ayY() {
        d aAn = d.aAn();
        q.l((Object) aAn, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aAp = aAn.aAp();
        q.l((Object) aAp, "Swan.get().adaptationProducer");
        aAp.YZ().aaQ().bh(d.aAn()).A(b.cMb).aCi();
    }

    @h
    /* loaded from: classes3.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b cMb = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void J(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.l((Object) hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a ayX = c.cMa.ayX();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (ayX == null || !ProcessUtils.isMainProcess()) {
                        c.cMa.cd(null, optString);
                        return;
                    }
                    q.l((Object) optString, "openId");
                    d aAn = d.aAn();
                    q.l((Object) aAn, "Swan.get()");
                    String appId = aAn.getAppId();
                    am aqg = com.baidu.swan.apps.t.a.aqg();
                    q.l((Object) aqg, "SwanAppRuntime.getConfig()");
                    ayX.J(optString, appId, aqg.getHostName());
                }
            }
        }
    }

    public final void ayZ() {
        d aAn = d.aAn();
        q.l((Object) aAn, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aAp = aAn.aAp();
        q.l((Object) aAp, "Swan.get().adaptationProducer");
        aAp.YZ().aaQ().bg(d.aAn()).A(C0327c.cMc).aCi();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static final class C0327c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0327c cMc = new C0327c();

        C0327c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void J(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.l((Object) hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a ayX = c.cMa.ayX();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (ayX == null || !ProcessUtils.isMainProcess()) {
                        c.cMa.cd(optString, null);
                        return;
                    }
                    q.l((Object) optString, "swanId");
                    d aAn = d.aAn();
                    q.l((Object) aAn, "Swan.get()");
                    String appId = aAn.getAppId();
                    am aqg = com.baidu.swan.apps.t.a.aqg();
                    q.l((Object) aqg, "SwanAppRuntime.getConfig()");
                    ayX.I(optString, appId, aqg.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cd(String str, String str2) {
        d aAn = d.aAn();
        q.l((Object) aAn, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aAi = aAn.aAi();
        if (aAi != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aAn2 = d.aAn();
            q.l((Object) aAn2, "Swan.get()");
            bundle.putString("appId", aAn2.getAppId());
            am aqg = com.baidu.swan.apps.t.a.aqg();
            q.l((Object) aqg, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", aqg.getHostName());
            aAi.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
