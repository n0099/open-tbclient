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
/* loaded from: classes10.dex */
public final class f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static Flow ls(String str) {
        return s.qM(str);
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
        b.a aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas();
        if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
            bVar.lC(aas.Tz().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
        bVar.mFrom = gb(i);
        bVar.n("money", str2);
        bVar.ba(acJ());
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
        if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
            b.a aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas();
            i = aas.getAppFrameType();
            str3 = aas.Tz().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
        bVar.mFrom = gb(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aap().getName());
            bVar.aZ(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.lC(str3);
        }
        bVar.ba(acJ());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.7
            @Override // java.lang.Runnable
            public void run() {
                s.k("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void g(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
            eVar.lC(com.baidu.swan.apps.runtime.d.aam().aaj().aas().Tz().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
        eVar.ba(acJ());
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
        com.baidu.swan.apps.process.messaging.client.a.YF().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.9
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
                    cVar.lw(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar.lx(str4);
                }
                cVar.mType = "request";
                if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.aam().aaj().aas().Tt();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
                cVar.mFrom = f.gb(i2);
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

    public static String acI() {
        return com.baidu.swan.apps.ac.e.Wx() ? "1" : "0";
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
            com.baidu.swan.apps.process.messaging.client.a.YF().a(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.f.10
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
                        cVar.lw(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.lx(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aap().En().Tt();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
                    cVar.mFrom = f.gb(i2);
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

    public static String gb(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    private static JSONObject acJ() {
        b.a En;
        JSONObject TL;
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap == null || (En = aap.En()) == null || (TL = En.TL()) == null || !TextUtils.equals(TL.optString("token"), "swanubc")) {
            return null;
        }
        return TL;
    }

    public static JSONObject lt(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aar();
        if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
            b.a En = com.baidu.swan.apps.runtime.e.aap().En();
            eVar.mSource = En.Tt();
            eVar.mFrom = gb(En.getAppFrameType());
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
        if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
            b.a En = com.baidu.swan.apps.runtime.e.aap().En();
            eVar.mFrom = gb(En.getAppFrameType());
            eVar.mAppId = En.getAppId();
            eVar.mSource = En.Tt();
        }
        a("914", eVar);
    }

    public static void b(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
            b.a En = com.baidu.swan.apps.runtime.e.aap().En();
            eVar.mFrom = gb(En.getAppFrameType());
            eVar.mAppId = En.getAppId();
            eVar.mSource = En.Tt();
        }
        a("936", eVar);
    }

    public static void lu(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = gb(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void F(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
            b.a En = com.baidu.swan.apps.runtime.e.aap().En();
            eVar.mFrom = gb(En.getAppFrameType());
            eVar.mAppId = En.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.n("appkey", En.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aap() != null && com.baidu.swan.apps.runtime.e.aap().En() != null) {
            b.a En = com.baidu.swan.apps.runtime.e.aap().En();
            fVar.mFrom = gb(En.getAppFrameType());
            fVar.mAppId = En.getAppId();
            fVar.n("appkey", En.getAppKey());
            a("1032", fVar);
        }
    }

    public static void acK() {
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        com.baidu.swan.apps.runtime.e aaj = aam.aaj();
        b.a aas = aaj.aas();
        if (aam.YT() && aaj.aat()) {
            Bundle Tz = aas.Tz();
            if (Tz.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aaj.aas().Tn());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = gb(aas.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = UgcUBCUtils.UGC_TIME_CANCEL;
                fVar.bRm = valueOf;
                fVar.b(aas);
                fVar.lC(Tz.getString("ubc"));
                fVar.ba(lt(aas.Tv()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = gb(aas.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.bRm = valueOf;
                fVar2.b(aas);
                fVar2.ba(lt(aas.Tv()));
                fVar2.n(TiebaInitialize.LogFields.REASON, UgcUBCUtils.UGC_TIME_CANCEL);
                if (aas.getAppFrameType() == 1) {
                    fVar.n("errorList", com.baidu.swan.games.u.b.ann().ano());
                }
                fVar2.lC(Tz.getString("ubc"));
                onEvent(fVar2);
                Tz.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas();
        if (com.baidu.swan.apps.runtime.d.aam().aaj().available()) {
            bVar.lC(aas.Tz().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aas.getAppKey();
        bVar.mFrom = gb(aas.getAppFrameType());
        bVar.mValue = z ? "success" : LivenessStat.TYPE_FACE_MATCH_FAIL;
        bVar.n("nativeAppId", com.baidu.swan.apps.w.a.Sr().getHostName());
        bVar.n("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d LY = com.baidu.swan.apps.y.f.UC().LY();
        com.baidu.swan.apps.model.c LC = LY == null ? null : LY.LC();
        if (LC != null && !TextUtils.isEmpty(LC.getPage())) {
            bVar.n("page", LC.getPage());
        }
        bVar.ba(acJ());
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.f.3
            @Override // java.lang.Runnable
            public void run() {
                s.k("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }
}
