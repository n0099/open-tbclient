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
    private static a cYc;
    public static final c cYd = new c();

    @h
    /* loaded from: classes10.dex */
    public interface a {
        void J(String str, String str2, String str3);

        void K(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aBG() {
        return cYc;
    }

    public final void aBH() {
        d aCW = d.aCW();
        q.m(aCW, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aCY = aCW.aCY();
        q.m(aCY, "Swan.get().adaptationProducer");
        aCY.abL().adC().bn(d.aCW()).A(b.cYe).aER();
    }

    @h
    /* loaded from: classes10.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b cYe = new b();

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
                a aBG = c.cYd.aBG();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aBG == null || !ProcessUtils.isMainProcess()) {
                        c.cYd.ci(null, optString);
                        return;
                    }
                    q.m(optString, "openId");
                    d aCW = d.aCW();
                    q.m(aCW, "Swan.get()");
                    String appId = aCW.getAppId();
                    am asS = com.baidu.swan.apps.t.a.asS();
                    q.m(asS, "SwanAppRuntime.getConfig()");
                    aBG.K(optString, appId, asS.getHostName());
                }
            }
        }
    }

    public final void aBI() {
        d aCW = d.aCW();
        q.m(aCW, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aCY = aCW.aCY();
        q.m(aCY, "Swan.get().adaptationProducer");
        aCY.abL().adC().bm(d.aCW()).A(C0344c.cYf).aER();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static final class C0344c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0344c cYf = new C0344c();

        C0344c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.m(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aBG = c.cYd.aBG();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aBG == null || !ProcessUtils.isMainProcess()) {
                        c.cYd.ci(optString, null);
                        return;
                    }
                    q.m(optString, "swanId");
                    d aCW = d.aCW();
                    q.m(aCW, "Swan.get()");
                    String appId = aCW.getAppId();
                    am asS = com.baidu.swan.apps.t.a.asS();
                    q.m(asS, "SwanAppRuntime.getConfig()");
                    aBG.J(optString, appId, asS.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ci(String str, String str2) {
        d aCW = d.aCW();
        q.m(aCW, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aCR = aCW.aCR();
        if (aCR != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aCW2 = d.aCW();
            q.m(aCW2, "Swan.get()");
            bundle.putString("appId", aCW2.getAppId());
            am asS = com.baidu.swan.apps.t.a.asS();
            q.m(asS, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", asS.getHostName());
            aCR.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
