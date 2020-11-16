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
/* loaded from: classes7.dex */
public final class c {
    private static a dkR;
    public static final c dkS = new c();

    @h
    /* loaded from: classes7.dex */
    public interface a {
        void Q(String str, String str2, String str3);

        void R(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aFs() {
        return dkR;
    }

    public final void aFt() {
        d aGI = d.aGI();
        q.m(aGI, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aGK = aGI.aGK();
        q.m(aGK, "Swan.get().adaptationProducer");
        aGK.afx().aho().bn(d.aGI()).A(b.dkT).aID();
    }

    @h
    /* loaded from: classes7.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final b dkT = new b();

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
                a aFs = c.dkS.aFs();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aFs == null || !ProcessUtils.isMainProcess()) {
                        c.dkS.co(null, optString);
                        return;
                    }
                    q.m(optString, "openId");
                    d aGI = d.aGI();
                    q.m(aGI, "Swan.get()");
                    String appId = aGI.getAppId();
                    am awE = com.baidu.swan.apps.t.a.awE();
                    q.m(awE, "SwanAppRuntime.getConfig()");
                    aFs.R(optString, appId, awE.getHostName());
                }
            }
        }
    }

    public final void aFu() {
        d aGI = d.aGI();
        q.m(aGI, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aGK = aGI.aGK();
        q.m(aGK, "Swan.get().adaptationProducer");
        aGK.afx().aho().bm(d.aGI()).A(C0368c.dkU).aID();
    }

    @h
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class C0368c<MsgType> implements com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<JSONObject>> {
        public static final C0368c dkU = new C0368c();

        C0368c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: a */
        public final void M(com.baidu.swan.apps.setting.oauth.h<JSONObject> hVar) {
            q.m(hVar, AdvanceSetting.NETWORK_TYPE);
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aFs = c.dkS.aFs();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aFs == null || !ProcessUtils.isMainProcess()) {
                        c.dkS.co(optString, null);
                        return;
                    }
                    q.m(optString, "swanId");
                    d aGI = d.aGI();
                    q.m(aGI, "Swan.get()");
                    String appId = aGI.getAppId();
                    am awE = com.baidu.swan.apps.t.a.awE();
                    q.m(awE, "SwanAppRuntime.getConfig()");
                    aFs.Q(optString, appId, awE.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void co(String str, String str2) {
        d aGI = d.aGI();
        q.m(aGI, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aGD = aGI.aGD();
        if (aGD != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aGI2 = d.aGI();
            q.m(aGI2, "Swan.get()");
            bundle.putString("appId", aGI2.getAppId());
            am awE = com.baidu.swan.apps.t.a.awE();
            q.m(awE, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", awE.getHostName());
            aGD.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
