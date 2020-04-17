package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static Flow mT(String str) {
        return s.sn(str);
    }

    public static void a(final Flow flow, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (flow != null) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.statistic.a.e.this != null) {
                        flow.setValueWithDuration(com.baidu.swan.apps.statistic.a.e.this.toJSONObject().toString());
                    }
                    flow.end();
                }
            }, "SwanAppUBCEndFlow");
        }
    }

    public static void b(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar != null) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.4
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.5
                @Override // java.lang.Runnable
                public void run() {
                    s.onEvent(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a akQ = com.baidu.swan.apps.runtime.d.akK().akH().akQ();
        if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
            bVar.nd(akQ.adH().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
        bVar.mFrom = gz(i);
        bVar.s("money", str2);
        bVar.bl(anh());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.6
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
            b.a akQ = com.baidu.swan.apps.runtime.d.akK().akH().akQ();
            i = akQ.getAppFrameType();
            str3 = akQ.adH().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
        bVar.mFrom = gz(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.akN().getName());
            bVar.bk(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.nd(str3);
        }
        bVar.bl(anh());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.7
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void i(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
            eVar.nd(com.baidu.swan.apps.runtime.d.akK().akH().akQ().adH().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
        eVar.bl(anh());
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.8
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("778", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void N(String str, int i) {
        a(0, str, i, null, null, null, "0", 0L, 0L);
    }

    public static void a(int i, String str, int i2, String str2, long j, long j2) {
        a(i, str, i2, str2, null, null, j, j2);
    }

    public static void a(int i, String str, int i2, String str2, @Nullable String str3, @Nullable String str4, long j, long j2) {
        a(i, str, i2, str2, str3, str4, "1", j, j2);
    }

    private static void a(final int i, final String str, final int i2, final String str2, @Nullable final String str3, @Nullable final String str4, final String str5, final long j, final long j2) {
        if (i == 200 && j2 - j < 5000) {
            if (DEBUG) {
                Log.v("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                return;
            }
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a.ajd().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                final com.baidu.swan.apps.statistic.a.c cVar;
                int i3 = -1;
                if (bVar.getResult() != null) {
                    i3 = bVar.getResult().getInt("net_quality");
                }
                if (f.DEBUG) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i3);
                }
                if (TextUtils.equals(str5, "1")) {
                    cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2, i3, j, j2);
                } else {
                    cVar = new com.baidu.swan.apps.statistic.a.c(str, i3);
                }
                if (!TextUtils.isEmpty(str3)) {
                    cVar.mX(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar.mY(str4);
                }
                cVar.mType = "request";
                if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.akK().akH().akQ().adB();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
                cVar.mFrom = f.gz(i2);
                m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.DEBUG) {
                            Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                        }
                        s.onEvent("834", cVar.toJSONObject());
                    }
                }, "SwanAppUBCRequest");
            }
        });
    }

    public static String ang() {
        return com.baidu.swan.apps.ac.e.agW() ? "1" : "0";
    }

    public static void O(String str, int i) {
        a(0, str, i, null, null, null, "0");
    }

    public static void a(int i, String str, int i2, String str2) {
        a(i, str, i2, str2, null, null, "1");
    }

    public static void a(int i, String str, int i2, String str2, @Nullable String str3, @Nullable String str4) {
        a(i, str, i2, str2, str3, str4, "1");
    }

    private static void a(final int i, final String str, final int i2, final String str2, @Nullable final String str3, @Nullable final String str4, final String str5) {
        if (i != 200) {
            com.baidu.swan.apps.process.messaging.client.a.ajd().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    final com.baidu.swan.apps.statistic.a.c cVar;
                    int i3 = -1;
                    if (bVar.getResult() != null) {
                        i3 = bVar.getResult().getInt("net_quality");
                    }
                    if (f.DEBUG) {
                        Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i3);
                    }
                    if (TextUtils.equals(str5, "1")) {
                        cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2, i3);
                    } else {
                        cVar = new com.baidu.swan.apps.statistic.a.c(str, i3);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        cVar.mX(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.mY(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.akN().Ow().adB();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
                    cVar.mFrom = f.gz(i2);
                    m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s.onEvent("834", cVar.toJSONObject());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String gz(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    private static JSONObject anh() {
        b.a Ow;
        JSONObject adT;
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN == null || (Ow = akN.Ow()) == null || (adT = Ow.adT()) == null || !TextUtils.equals(adT.optString("token"), "swanubc")) {
            return null;
        }
        return adT;
    }

    public static JSONObject mU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
        if (TextUtils.isEmpty(queryParameter)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
            if (optJSONObject != null) {
                if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                    return optJSONObject;
                }
                return null;
            }
            return null;
        } catch (JSONException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static void l(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = str;
        eVar.mValue = str2;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.akP();
        if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
            b.a Ow = com.baidu.swan.apps.runtime.e.akN().Ow();
            eVar.mSource = Ow.adB();
            eVar.mFrom = gz(Ow.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.s("authorize", z ? "success" : "fail");
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.2
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void a(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
            b.a Ow = com.baidu.swan.apps.runtime.e.akN().Ow();
            eVar.mFrom = gz(Ow.getAppFrameType());
            eVar.mAppId = Ow.getAppId();
            eVar.mSource = Ow.adB();
        }
        a("914", eVar);
    }

    public static void b(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
            b.a Ow = com.baidu.swan.apps.runtime.e.akN().Ow();
            eVar.mFrom = gz(Ow.getAppFrameType());
            eVar.mAppId = Ow.getAppId();
            eVar.mSource = Ow.adB();
        }
        a("936", eVar);
    }

    public static void mV(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = gz(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void G(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
            b.a Ow = com.baidu.swan.apps.runtime.e.akN().Ow();
            eVar.mFrom = gz(Ow.getAppFrameType());
            eVar.mAppId = Ow.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.s("appkey", Ow.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.akN() != null && com.baidu.swan.apps.runtime.e.akN().Ow() != null) {
            b.a Ow = com.baidu.swan.apps.runtime.e.akN().Ow();
            fVar.mFrom = gz(Ow.getAppFrameType());
            fVar.mAppId = Ow.getAppId();
            fVar.s("appkey", Ow.getAppKey());
            a("1032", fVar);
        }
    }

    public static void ani() {
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        com.baidu.swan.apps.runtime.e akH = akK.akH();
        b.a akQ = akH.akQ();
        if (akK.ajr() && akH.akR()) {
            Bundle adH = akQ.adH();
            if (adH.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - akH.akQ().adv());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = gz(akQ.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cuw = valueOf;
                fVar.b(akQ);
                fVar.nd(adH.getString("ubc"));
                fVar.bl(mU(akQ.adD()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = gz(akQ.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cuw = valueOf;
                fVar2.b(akQ);
                fVar2.bl(mU(akQ.adD()));
                fVar2.s(TiebaInitialize.LogFields.REASON, "cancel");
                if (akQ.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.u.b.axS().axT());
                }
                fVar2.nd(adH.getString("ubc"));
                onEvent(fVar2);
                adH.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a akQ = com.baidu.swan.apps.runtime.d.akK().akH().akQ();
        if (com.baidu.swan.apps.runtime.d.akK().akH().available()) {
            bVar.nd(akQ.adH().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = akQ.getAppKey();
        bVar.mFrom = gz(akQ.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.s("nativeAppId", com.baidu.swan.apps.w.a.acz().getHostName());
        bVar.s("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d Wf = com.baidu.swan.apps.y.f.aeK().Wf();
        com.baidu.swan.apps.model.c VJ = Wf == null ? null : Wf.VJ();
        if (VJ != null && !TextUtils.isEmpty(VJ.getPage())) {
            bVar.s("page", VJ.getPage());
        }
        bVar.bl(anh());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.3
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }
}
