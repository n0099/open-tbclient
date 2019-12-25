package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static Flow lp(String str) {
        return s.qJ(str);
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
                    s.k("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
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
                    s.k(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a ZV = com.baidu.swan.apps.runtime.d.ZP().ZM().ZV();
        if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
            bVar.lz(ZV.Tc().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
        bVar.mFrom = ga(i);
        bVar.n("money", str2);
        bVar.ba(acm());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.6
            @Override // java.lang.Runnable
            public void run() {
                s.k("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
            b.a ZV = com.baidu.swan.apps.runtime.d.ZP().ZM().ZV();
            i = ZV.getAppFrameType();
            str3 = ZV.Tc().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
        bVar.mFrom = ga(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.ZS().getName());
            bVar.aZ(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.lz(str3);
        }
        bVar.ba(acm());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.7
            @Override // java.lang.Runnable
            public void run() {
                s.k("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void g(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
            eVar.lz(com.baidu.swan.apps.runtime.d.ZP().ZM().ZV().Tc().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
        eVar.ba(acm());
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.8
            @Override // java.lang.Runnable
            public void run() {
                s.k("778", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void H(String str, int i) {
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
        com.baidu.swan.apps.process.messaging.client.a.Yi().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.9
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
                    cVar.lt(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar.lu(str4);
                }
                cVar.mType = "request";
                if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.ZP().ZM().ZV().SW();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
                cVar.mFrom = f.ga(i2);
                m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (f.DEBUG) {
                            Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                        }
                        s.k("834", cVar.toJSONObject());
                    }
                }, "SwanAppUBCRequest");
            }
        });
    }

    public static String acl() {
        return com.baidu.swan.apps.ac.e.Wa() ? "1" : "0";
    }

    public static void I(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.Yi().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.10
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
                        cVar.lt(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.lu(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.ZS().DR().SW();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
                    cVar.mFrom = f.ga(i2);
                    m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            s.k("834", cVar.toJSONObject());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String ga(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    private static JSONObject acm() {
        b.a DR;
        JSONObject To;
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS == null || (DR = ZS.DR()) == null || (To = DR.To()) == null || !TextUtils.equals(To.optString("token"), "swanubc")) {
            return null;
        }
        return To;
    }

    public static JSONObject lq(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.ZU();
        if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
            b.a DR = com.baidu.swan.apps.runtime.e.ZS().DR();
            eVar.mSource = DR.SW();
            eVar.mFrom = ga(DR.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.n("authorize", z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL);
        }
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.2
            @Override // java.lang.Runnable
            public void run() {
                s.k("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void a(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
            b.a DR = com.baidu.swan.apps.runtime.e.ZS().DR();
            eVar.mFrom = ga(DR.getAppFrameType());
            eVar.mAppId = DR.getAppId();
            eVar.mSource = DR.SW();
        }
        a("914", eVar);
    }

    public static void b(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
            b.a DR = com.baidu.swan.apps.runtime.e.ZS().DR();
            eVar.mFrom = ga(DR.getAppFrameType());
            eVar.mAppId = DR.getAppId();
            eVar.mSource = DR.SW();
        }
        a("936", eVar);
    }

    public static void lr(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = ga(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void F(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
            b.a DR = com.baidu.swan.apps.runtime.e.ZS().DR();
            eVar.mFrom = ga(DR.getAppFrameType());
            eVar.mAppId = DR.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.n("appkey", DR.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.ZS() != null && com.baidu.swan.apps.runtime.e.ZS().DR() != null) {
            b.a DR = com.baidu.swan.apps.runtime.e.ZS().DR();
            fVar.mFrom = ga(DR.getAppFrameType());
            fVar.mAppId = DR.getAppId();
            fVar.n("appkey", DR.getAppKey());
            a("1032", fVar);
        }
    }

    public static void acn() {
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        com.baidu.swan.apps.runtime.e ZM = ZP.ZM();
        b.a ZV = ZM.ZV();
        if (ZP.Yw() && ZM.ZW()) {
            Bundle Tc = ZV.Tc();
            if (Tc.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - ZM.ZV().SQ());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = ga(ZV.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = UgcUBCUtils.UGC_TIME_CANCEL;
                fVar.bQC = valueOf;
                fVar.b(ZV);
                fVar.lz(Tc.getString("ubc"));
                fVar.ba(lq(ZV.SY()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = ga(ZV.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.bQC = valueOf;
                fVar2.b(ZV);
                fVar2.ba(lq(ZV.SY()));
                fVar2.n(TiebaInitialize.LogFields.REASON, UgcUBCUtils.UGC_TIME_CANCEL);
                if (ZV.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.amU().amV());
                }
                fVar2.lz(Tc.getString("ubc"));
                onEvent(fVar2);
                Tc.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a ZV = com.baidu.swan.apps.runtime.d.ZP().ZM().ZV();
        if (com.baidu.swan.apps.runtime.d.ZP().ZM().available()) {
            bVar.lz(ZV.Tc().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = ZV.getAppKey();
        bVar.mFrom = ga(ZV.getAppFrameType());
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.n("nativeAppId", com.baidu.swan.apps.w.a.RV().getHostName());
        bVar.n("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d LC = com.baidu.swan.apps.y.f.Uf().LC();
        com.baidu.swan.apps.model.c Lg = LC == null ? null : LC.Lg();
        if (Lg != null && !TextUtils.isEmpty(Lg.getPage())) {
            bVar.n("page", Lg.getPage());
        }
        bVar.ba(acm());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.3
            @Override // java.lang.Runnable
            public void run() {
                s.k("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }
}
