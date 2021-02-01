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
/* loaded from: classes9.dex */
public final class c {
    private static a dun;
    public static final c duo = new c();

    @e
    /* loaded from: classes9.dex */
    public interface a {
        void W(String str, String str2, String str3);

        void X(String str, String str2, String str3);
    }

    private c() {
    }

    public final a aGv() {
        return dun;
    }

    public final void aGw() {
        d aIG = d.aIG();
        p.n(aIG, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aII = aIG.aII();
        p.n(aII, "Swan.get().adaptationProducer");
        aII.ags().ail().bY(d.aIG()).A(b.dup).aKB();
    }

    @e
    /* loaded from: classes9.dex */
    static final class b<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final b dup = new b();

        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void L(h<JSONObject> hVar) {
            p.n(hVar, "it");
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGv = c.duo.aGv();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("openid");
                    if (aGv == null || !ProcessUtils.isMainProcess()) {
                        c.duo.cn(null, optString);
                        return;
                    }
                    p.n(optString, "openId");
                    d aIG = d.aIG();
                    p.n(aIG, "Swan.get()");
                    String appId = aIG.getAppId();
                    am axI = com.baidu.swan.apps.t.a.axI();
                    p.n(axI, "SwanAppRuntime.getConfig()");
                    aGv.X(optString, appId, axI.getHostName());
                }
            }
        }
    }

    public final void aGx() {
        d aIG = d.aIG();
        p.n(aIG, "Swan.get()");
        com.baidu.swan.apps.adaptation.a aII = aIG.aII();
        p.n(aII, "Swan.get().adaptationProducer");
        aII.ags().ail().bX(d.aIG()).A(C0353c.duq).aKB();
    }

    @e
    /* renamed from: com.baidu.swan.apps.ae.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    static final class C0353c<MsgType> implements com.baidu.swan.apps.ao.e.b<h<JSONObject>> {
        public static final C0353c duq = new C0353c();

        C0353c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: a */
        public final void L(h<JSONObject> hVar) {
            p.n(hVar, "it");
            if (hVar.isOk()) {
                JSONObject jSONObject = hVar.mData;
                JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("data") : null;
                a aGv = c.duo.aGv();
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("swanid");
                    if (aGv == null || !ProcessUtils.isMainProcess()) {
                        c.duo.cn(optString, null);
                        return;
                    }
                    p.n(optString, "swanId");
                    d aIG = d.aIG();
                    p.n(aIG, "Swan.get()");
                    String appId = aIG.getAppId();
                    am axI = com.baidu.swan.apps.t.a.axI();
                    p.n(axI, "SwanAppRuntime.getConfig()");
                    aGv.W(optString, appId, axI.getHostName());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cn(String str, String str2) {
        d aIG = d.aIG();
        p.n(aIG, "Swan.get()");
        com.baidu.swan.apps.process.messaging.client.a aIB = aIG.aIB();
        if (aIB != null) {
            Bundle bundle = new Bundle();
            bundle.putString("swanId", str);
            bundle.putString("openId", str2);
            d aIG2 = d.aIG();
            p.n(aIG2, "Swan.get()");
            bundle.putString("appId", aIG2.getAppId());
            am axI = com.baidu.swan.apps.t.a.axI();
            p.n(axI, "SwanAppRuntime.getConfig()");
            bundle.putString("hostName", axI.getHostName());
            aIB.b(bundle, com.baidu.swan.apps.ae.b.class);
        }
    }
}
