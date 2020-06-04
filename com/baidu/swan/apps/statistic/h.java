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

    public static a ow(String str) {
        return b.op(str);
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
        b.a aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ();
        if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
            bVar.oG(aoJ.agQ().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
        bVar.mFrom = gU(i);
        bVar.v("money", str2);
        bVar.bu(arp());
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
        if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
            b.a aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ();
            i = aoJ.getAppFrameType();
            str3 = aoJ.agQ().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
        bVar.mFrom = gU(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aoF().getName());
            bVar.bt(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.oG(str3);
        }
        bVar.bu(arp());
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.7
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void i(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
            eVar.oG(com.baidu.swan.apps.runtime.d.aoB().aox().aoJ().agQ().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
        eVar.bu(arp());
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
        com.baidu.swan.apps.process.messaging.client.a.amQ().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.9
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
                    cVar.oA(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    cVar.oB(str4);
                }
                cVar.mType = "request";
                if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
                    cVar.mSource = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ().agK();
                }
                cVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
                cVar.mFrom = h.gU(i2);
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

    public static String aro() {
        return com.baidu.swan.apps.aa.e.ako() ? "1" : "0";
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
            com.baidu.swan.apps.process.messaging.client.a.amQ().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.10
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
                        cVar.oA(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.oB(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aoF().QJ().agK();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
                    cVar.mFrom = h.gU(i2);
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

    public static String gU(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    private static JSONObject arp() {
        b.a QJ;
        JSONObject ahc;
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null || (QJ = aoF.QJ()) == null || (ahc = QJ.ahc()) == null || !TextUtils.equals(ahc.optString("token"), "swanubc")) {
            return null;
        }
        return ahc;
    }

    public static JSONObject ox(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aoH();
        if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
            b.a QJ = com.baidu.swan.apps.runtime.e.aoF().QJ();
            eVar.mSource = QJ.agK();
            eVar.mFrom = gU(QJ.getAppFrameType());
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
        if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
            b.a QJ = com.baidu.swan.apps.runtime.e.aoF().QJ();
            eVar.mFrom = gU(QJ.getAppFrameType());
            eVar.mAppId = QJ.getAppId();
            eVar.mSource = QJ.agK();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
            b.a QJ = com.baidu.swan.apps.runtime.e.aoF().QJ();
            eVar.mFrom = gU(QJ.getAppFrameType());
            eVar.mAppId = QJ.getAppId();
            eVar.mSource = QJ.agK();
        }
        a("936", eVar);
    }

    public static void oy(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = gU(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void J(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
            b.a QJ = com.baidu.swan.apps.runtime.e.aoF().QJ();
            eVar.mFrom = gU(QJ.getAppFrameType());
            eVar.mAppId = QJ.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.v("appkey", QJ.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aoF() != null && com.baidu.swan.apps.runtime.e.aoF().QJ() != null) {
            b.a QJ = com.baidu.swan.apps.runtime.e.aoF().QJ();
            fVar.mFrom = gU(QJ.getAppFrameType());
            fVar.mAppId = QJ.getAppId();
            fVar.v("appkey", QJ.getAppKey());
            a("1032", fVar);
        }
    }

    public static void arq() {
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        com.baidu.swan.apps.runtime.e aox = aoB.aox();
        b.a aoJ = aox.aoJ();
        if (aoB.ane() && aox.aoK()) {
            Bundle agQ = aoJ.agQ();
            if (agQ.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aox.aoJ().agE());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = gU(aoJ.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cGC = valueOf;
                fVar.b(aoJ);
                fVar.oG(agQ.getString("ubc"));
                fVar.bu(ox(aoJ.agM()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = gU(aoJ.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cGC = valueOf;
                fVar2.b(aoJ);
                fVar2.bu(ox(aoJ.agM()));
                fVar2.v(TiebaInitialize.LogFields.REASON, "cancel");
                if (aoJ.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aBJ().aBK());
                }
                fVar2.oG(agQ.getString("ubc"));
                onEvent(fVar2);
                agQ.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ();
        if (com.baidu.swan.apps.runtime.d.aoB().aox().available()) {
            bVar.oG(aoJ.agQ().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aoJ.getAppKey();
        bVar.mFrom = gU(aoJ.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.v("nativeAppId", com.baidu.swan.apps.u.a.afB().getHostName());
        bVar.v("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
        com.baidu.swan.apps.model.c Yt = YQ == null ? null : YQ.Yt();
        if (Yt != null && !TextUtils.isEmpty(Yt.getPage())) {
            bVar.v("page", Yt.getPage());
        }
        bVar.bu(arp());
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d oD = new com.baidu.swan.apps.statistic.a.d().gV(i).a(aoG.QJ()).oC(gU(aoG.Qz())).oD(aoG.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aoG.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gO(i));
            jSONObject.put("version", aoG.aoR().getString("update_nodes_version", ""));
            jSONObject.put("lastUpdateDate", com.baidu.swan.apps.network.c.a.akD().akL());
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cEp);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        oD.bt(jSONObject);
        b(oD);
    }
}
