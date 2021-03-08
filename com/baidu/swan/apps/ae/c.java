package com.baidu.swan.apps.ae;

import android.os.Bundle;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.a.am;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.setting.oauth.h;
import kotlin.e;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
@e
/* loaded from: classes8.dex */
public final class c {
    private static a dvO;
    public static final c dvP = new c();

    @e
    /* loaded from: classes8.dex */
    public interface a {
        void W(String str, String str2, String str3);

        void X(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aGy() {
        return dvO;
    }

    public final void aGz() {
        d aIJ = d.aIJ();
        p.o(aIJ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aIL = aIJ.aIL();
        p.o(aIL, "Swan.get().adaptationProducer");
        aIL.agv().aio().bX(d.aIJ()).A(b.dvQ).aKE();
    }

    @e
    /* loaded from: classes8.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final b dvQ = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void N(h<JSONObject> hVar) {
            p.o(hVar, "it");
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGy = c.dvP.aGy();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aGy == null || !ProcessUtils.isMainProcess()) {
                        c.dvP.cn(null, optString);
                        return;
                    }
                    p.o(optString, "openId");
                    d aIJ = d.aIJ();
                    p.o(aIJ, "Swan.get()");
                    String appId = aIJ.getAppId();
                    am axL = com.baidu.swan.apps.t.a.axL();
                    p.o(axL, "SwanAppRuntime.getConfig()");
                    aGy.X(optString, appId, axL.getHostName());
                }
            }
        }
    }

    public final void aGA() {
        d aIJ = d.aIJ();
        p.o(aIJ, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aIL = aIJ.aIL();
        p.o(aIL, "Swan.get().adaptationProducer");
        aIL.agv().aio().bW(d.aIJ()).A(C0359c.dvR).aKE();
    }

    @e
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static final class C0359c<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final C0359c dvR = new C0359c();

        C0359c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void N(h<JSONObject> hVar) {
            p.o(hVar, "it");
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGy = c.dvP.aGy();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aGy == null || !ProcessUtils.isMainProcess()) {
                        c.dvP.cn(optString, null);
                        return;
                    }
                    p.o(optString, "swanId");
                    d aIJ = d.aIJ();
                    p.o(aIJ, "Swan.get()");
                    String appId = aIJ.getAppId();
                    am axL = com.baidu.swan.apps.t.a.axL();
                    p.o(axL, "SwanAppRuntime.getConfig()");
                    aGy.W(optString, appId, axL.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cn(String str, String str2) {
        d aIJ = d.aIJ();
        p.o(aIJ, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aIE = aIJ.aIE();
        if (aIE != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aIJ2 = d.aIJ();
            p.o(aIJ2, "Swan.get()");
            bundle.putString("appId", aIJ2.getAppId());
            am axL = com.baidu.swan.apps.t.a.axL();
            p.o(axL, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", axL.getHostName());
            aIE.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
