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
/* loaded from: classes8.dex */
public final class c {
    private static a cJV;
    public static final c cJW = new c();

    @h
    /* loaded from: classes8.dex */
    public interface a {
        void I(String str, String str2, String str3);

        void J(String str, String str2, String str3);
    }

    private c() {
    }

    public final a ayo() {
        return cJV;
    }

    public final void ayp() {
        d azE = d.azE();
        q.l((Object) azE, "Swan.get()");
        com.baidu.swan.apps.adaptation.a azG = azE.azG();
        q.l((Object) azG, "Swan.get().adaptationProducer");
        azG.Yq().aah().bi(d.azE()).A(b.cJX).aBy();
    }

    @h
    /* loaded from: classes8.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b cJX = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void I(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.l((Object) hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a ayo = c.cJW.ayo();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (ayo == null || !ProcessUtils.isMainProcess()) {
                        c.cJW.cd(null, optString);
                        return;
                    }
                    q.l((Object) optString, "openId");
                    d azE = d.azE();
                    q.l((Object) azE, "Swan.get()");
                    String appId = azE.getAppId();
                    am apw = com.baidu.swan.apps.t.a.apw();
                    q.l((Object) apw, "SwanAppRuntime.getConfig()");
                    ayo.J(optString, appId, apw.getHostName());
                }
            }
        }
    }

    public final void ayq() {
        d azE = d.azE();
        q.l((Object) azE, "Swan.get()");
        com.baidu.swan.apps.adaptation.a azG = azE.azG();
        q.l((Object) azG, "Swan.get().adaptationProducer");
        azG.Yq().aah().bh(d.azE()).A(C0332c.cJY).aBy();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static final class C0332c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0332c cJY = new C0332c();

        C0332c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void I(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.l((Object) hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a ayo = c.cJW.ayo();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (ayo == null || !ProcessUtils.isMainProcess()) {
                        c.cJW.cd(optString, null);
                        return;
                    }
                    q.l((Object) optString, "swanId");
                    d azE = d.azE();
                    q.l((Object) azE, "Swan.get()");
                    String appId = azE.getAppId();
                    am apw = com.baidu.swan.apps.t.a.apw();
                    q.l((Object) apw, "SwanAppRuntime.getConfig()");
                    ayo.I(optString, appId, apw.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cd(String str, String str2) {
        d azE = d.azE();
        q.l((Object) azE, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a azz = azE.azz();
        if (azz != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d azE2 = d.azE();
            q.l((Object) azE2, "Swan.get()");
            bundle.putString("appId", azE2.getAppId());
            am apw = com.baidu.swan.apps.t.a.apw();
            q.l((Object) apw, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", apw.getHostName());
            azz.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
