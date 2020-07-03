package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.b.b;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static a oE(String str) {
        return b.ox(str);
    }

    public static void a(final a aVar, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (aVar != null) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.swan.apps.statistic.a.e.this != null) {
                        b.a(aVar, com.baidu.swan.apps.statistic.a.e.this.toJSONObject().toString());
                    }
                    b.c(aVar);
                }
            }, "SwanAppUBCEndFlow");
        }
    }

    public static void b(final com.baidu.swan.apps.statistic.a.d dVar) {
        if (dVar != null) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
                @Override // java.lang.Runnable
                public void run() {
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.5
                @Override // java.lang.Runnable
                public void run() {
                    b.onEvent(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ();
        if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
            bVar.oO(apQ.ahW().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
        bVar.mFrom = hf(i);
        bVar.v("money", str2);
        bVar.bB(asw());
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.6
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
            b.a apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ();
            i = apQ.getAppFrameType();
            str3 = apQ.ahW().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
        bVar.mFrom = hf(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.apM().getName());
            bVar.bA(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.oO(str3);
        }
        bVar.bB(asw());
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.7
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void j(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
            eVar.oO(com.baidu.swan.apps.runtime.d.apI().apE().apQ().ahW().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
        eVar.bB(asw());
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.8
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("778", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void R(String str, int i) {
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
        com.baidu.swan.apps.process.messaging.client.a.anW().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                final com.baidu.swan.apps.statistic.a.c cVar;
                int i3 = -1;
                if (bVar.getResult() != null) {
                    i3 = bVar.getResult().getInt("net_quality");
                }
                if (h.DEBUG) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i3);
                }
                if (TextUtils.equals(str5, "1")) {
                    cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2, i3, j, j2);
                } else {
                    cVar = new com.baidu.swan.apps.statistic.a.c(str, i3);
                }
                if (!TextUtils.isEmpty(str3)) {
                    cVar.oI(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar.oJ(str4);
                }
                cVar.mType = "request";
                if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.apI().apE().apQ().ahQ();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
                cVar.mFrom = h.hf(i2);
                n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.DEBUG) {
                            Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                        }
                        b.onEvent("834", cVar.toJSONObject());
                    }
                }, "SwanAppUBCRequest");
            }
        });
    }

    public static String asv() {
        return com.baidu.swan.apps.aa.e.alu() ? "1" : "0";
    }

    public static void S(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.anW().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.10
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.process.a.b.c.a
                public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                    final com.baidu.swan.apps.statistic.a.c cVar;
                    int i3 = -1;
                    if (bVar.getResult() != null) {
                        i3 = bVar.getResult().getInt("net_quality");
                    }
                    if (h.DEBUG) {
                        Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + i3);
                    }
                    if (TextUtils.equals(str5, "1")) {
                        cVar = new com.baidu.swan.apps.statistic.a.c(i, str, str2, i3);
                    } else {
                        cVar = new com.baidu.swan.apps.statistic.a.c(str, i3);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        cVar.oI(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.oJ(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.apM().RP().ahQ();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
                    cVar.mFrom = h.hf(i2);
                    n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.onEvent("834", cVar.toJSONObject());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String hf(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    private static JSONObject asw() {
        b.a RP;
        JSONObject aii;
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM == null || (RP = apM.RP()) == null || (aii = RP.aii()) == null || !TextUtils.equals(aii.optString("token"), "swanubc")) {
            return null;
        }
        return aii;
    }

    public static JSONObject oF(String str) {
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

    public static void n(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = str;
        eVar.mValue = str2;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.apO();
        if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
            b.a RP = com.baidu.swan.apps.runtime.e.apM().RP();
            eVar.mSource = RP.ahQ();
            eVar.mFrom = hf(RP.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.v("authorize", z ? "success" : "fail");
        }
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
            b.a RP = com.baidu.swan.apps.runtime.e.apM().RP();
            eVar.mFrom = hf(RP.getAppFrameType());
            eVar.mAppId = RP.getAppId();
            eVar.mSource = RP.ahQ();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
            b.a RP = com.baidu.swan.apps.runtime.e.apM().RP();
            eVar.mFrom = hf(RP.getAppFrameType());
            eVar.mAppId = RP.getAppId();
            eVar.mSource = RP.ahQ();
        }
        a("936", eVar);
    }

    public static void oG(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = hf(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void K(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
            b.a RP = com.baidu.swan.apps.runtime.e.apM().RP();
            eVar.mFrom = hf(RP.getAppFrameType());
            eVar.mAppId = RP.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.v("appkey", RP.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.apM() != null && com.baidu.swan.apps.runtime.e.apM().RP() != null) {
            b.a RP = com.baidu.swan.apps.runtime.e.apM().RP();
            fVar.mFrom = hf(RP.getAppFrameType());
            fVar.mAppId = RP.getAppId();
            fVar.v("appkey", RP.getAppKey());
            a("1032", fVar);
        }
    }

    public static void asx() {
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        com.baidu.swan.apps.runtime.e apE = apI.apE();
        b.a apQ = apE.apQ();
        if (apI.aok() && apE.apR()) {
            Bundle ahW = apQ.ahW();
            if (ahW.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - apE.apQ().ahK());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = hf(apQ.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cLm = valueOf;
                fVar.b(apQ);
                fVar.oO(ahW.getString("ubc"));
                fVar.bB(oF(apQ.ahS()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = hf(apQ.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cLm = valueOf;
                fVar2.b(apQ);
                fVar2.bB(oF(apQ.ahS()));
                fVar2.v(TiebaInitialize.LogFields.REASON, "cancel");
                if (apQ.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aCP().aCQ());
                }
                fVar2.oO(ahW.getString("ubc"));
                onEvent(fVar2);
                ahW.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ();
        if (com.baidu.swan.apps.runtime.d.apI().apE().available()) {
            bVar.oO(apQ.ahW().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = apQ.getAppKey();
        bVar.mFrom = hf(apQ.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.v("nativeAppId", com.baidu.swan.apps.u.a.agH().getHostName());
        bVar.v("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d ZW = com.baidu.swan.apps.w.f.ajb().ZW();
        com.baidu.swan.apps.model.c Zz = ZW == null ? null : ZW.Zz();
        if (Zz != null && !TextUtils.isEmpty(Zz.getPage())) {
            bVar.v("page", Zz.getPage());
        }
        bVar.bB(asw());
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d oL = new com.baidu.swan.apps.statistic.a.d().hg(i).a(apN.RP()).oK(hf(apN.RF())).oL(apN.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", apN.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gZ(i));
            jSONObject.put("version", apN.apY().getString("update_nodes_version", ""));
            jSONObject.put("lastUpdateDate", com.baidu.swan.apps.network.c.a.alJ().alR());
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cIZ);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        oL.bA(jSONObject);
        b(oL);
    }
}
