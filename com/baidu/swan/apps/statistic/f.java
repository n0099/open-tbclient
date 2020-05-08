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
        b.a akP = com.baidu.swan.apps.runtime.d.akJ().akG().akP();
        if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
            bVar.nd(akP.adG().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
        bVar.mFrom = gz(i);
        bVar.s("money", str2);
        bVar.bl(ang());
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
        if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
            b.a akP = com.baidu.swan.apps.runtime.d.akJ().akG().akP();
            i = akP.getAppFrameType();
            str3 = akP.adG().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
        bVar.mFrom = gz(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.akM().getName());
            bVar.bk(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.nd(str3);
        }
        bVar.bl(ang());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.7
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void i(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
            eVar.nd(com.baidu.swan.apps.runtime.d.akJ().akG().akP().adG().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
        eVar.bl(ang());
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
        com.baidu.swan.apps.process.messaging.client.a.ajc().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.9
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
                if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.akJ().akG().akP().adA();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
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

    public static String anf() {
        return com.baidu.swan.apps.ac.e.agV() ? "1" : "0";
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
            com.baidu.swan.apps.process.messaging.client.a.ajc().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.10
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
                    if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.akM().Ov().adA();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
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

    private static JSONObject ang() {
        b.a Ov;
        JSONObject adS;
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM == null || (Ov = akM.Ov()) == null || (adS = Ov.adS()) == null || !TextUtils.equals(adS.optString("token"), "swanubc")) {
            return null;
        }
        return adS;
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.akO();
        if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
            b.a Ov = com.baidu.swan.apps.runtime.e.akM().Ov();
            eVar.mSource = Ov.adA();
            eVar.mFrom = gz(Ov.getAppFrameType());
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
        if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
            b.a Ov = com.baidu.swan.apps.runtime.e.akM().Ov();
            eVar.mFrom = gz(Ov.getAppFrameType());
            eVar.mAppId = Ov.getAppId();
            eVar.mSource = Ov.adA();
        }
        a("914", eVar);
    }

    public static void b(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
            b.a Ov = com.baidu.swan.apps.runtime.e.akM().Ov();
            eVar.mFrom = gz(Ov.getAppFrameType());
            eVar.mAppId = Ov.getAppId();
            eVar.mSource = Ov.adA();
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
        if (com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
            b.a Ov = com.baidu.swan.apps.runtime.e.akM().Ov();
            eVar.mFrom = gz(Ov.getAppFrameType());
            eVar.mAppId = Ov.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.s("appkey", Ov.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.akM() != null && com.baidu.swan.apps.runtime.e.akM().Ov() != null) {
            b.a Ov = com.baidu.swan.apps.runtime.e.akM().Ov();
            fVar.mFrom = gz(Ov.getAppFrameType());
            fVar.mAppId = Ov.getAppId();
            fVar.s("appkey", Ov.getAppKey());
            a("1032", fVar);
        }
    }

    public static void anh() {
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        com.baidu.swan.apps.runtime.e akG = akJ.akG();
        b.a akP = akG.akP();
        if (akJ.ajq() && akG.akQ()) {
            Bundle adG = akP.adG();
            if (adG.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - akG.akP().adu());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = gz(akP.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cuC = valueOf;
                fVar.b(akP);
                fVar.nd(adG.getString("ubc"));
                fVar.bl(mU(akP.adC()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = gz(akP.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cuC = valueOf;
                fVar2.b(akP);
                fVar2.bl(mU(akP.adC()));
                fVar2.s(TiebaInitialize.LogFields.REASON, "cancel");
                if (akP.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.u.b.axS().axT());
                }
                fVar2.nd(adG.getString("ubc"));
                onEvent(fVar2);
                adG.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a akP = com.baidu.swan.apps.runtime.d.akJ().akG().akP();
        if (com.baidu.swan.apps.runtime.d.akJ().akG().available()) {
            bVar.nd(akP.adG().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = akP.getAppKey();
        bVar.mFrom = gz(akP.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.s("nativeAppId", com.baidu.swan.apps.w.a.acy().getHostName());
        bVar.s("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d We = com.baidu.swan.apps.y.f.aeJ().We();
        com.baidu.swan.apps.model.c VI = We == null ? null : We.VI();
        if (VI != null && !TextUtils.isEmpty(VI.getPage())) {
            bVar.s("page", VI.getPage());
        }
        bVar.bl(ang());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.3
            @Override // java.lang.Runnable
            public void run() {
                s.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }
}
