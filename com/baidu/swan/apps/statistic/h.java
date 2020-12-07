package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.b;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dFd = com.facebook.common.internal.i.N("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> dFe = new CopyOnWriteArrayList<>();

    static {
        dFe.add("https://hmma.baidu.com/mini.gif");
        dFe.add("https://dxp.baidu.com/mini");
        dFe.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a tD(String str) {
        return b.tv(str);
    }

    public static void a(final a aVar, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (aVar != null) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.1
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
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.5
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.aBx())) {
                        com.baidu.swan.apps.statistic.a.d.this.tP(com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBx());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.bt("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore auE = com.baidu.swan.apps.core.turbo.d.aui().auE();
        if (auE != null) {
            fVar.t("extension_ver", auE.extensionCoreVersionName);
        }
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.6
                @Override // java.lang.Runnable
                public void run() {
                    b.onEvent(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(final String str, final String str2, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.7
                @Override // java.lang.Runnable
                public void run() {
                    b.e(str, str2, eVar.toJSONObject());
                }
            }, "SwanAppUbcCeresOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY();
        if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
            bVar.tO(aJY.aBk().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
        bVar.mFrom = kS(i);
        bVar.t("money", str2);
        bVar.cd(aMP());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.8
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
            b.a aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY();
            i = aJY.getAppFrameType();
            str3 = aJY.aBk().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
        bVar.mFrom = kS(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aJU().getName());
            bVar.cc(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.tO(str3);
        }
        bVar.cd(aMP());
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void l(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
            eVar.tO(com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBk().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.e.this.cd(h.aMP());
                b.onEvent("778", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnPagesRoute");
    }

    public static void a(String str, int i, NetworkStatRecord networkStatRecord) {
        a(0, str, i, null, null, null, "0", 0L, 0L, networkStatRecord);
    }

    public static void a(int i, String str, int i2, String str2, long j, long j2) {
        a(i, str, i2, str2, null, null, j, j2);
    }

    public static void a(int i, String str, int i2, String str2, @Nullable String str3, @Nullable String str4, long j, long j2) {
        a(i, str, i2, str2, str3, str4, "1", j, j2, null);
    }

    private static void a(final int i, final String str, final int i2, final String str2, @Nullable final String str3, @Nullable final String str4, final String str5, final long j, final long j2, @Nullable final NetworkStatRecord networkStatRecord) {
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            if (tE(str)) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "onRequest: ignore " + str);
                    return;
                }
                return;
            }
            long j3 = j2 - j;
            boolean z = i == 200;
            if (i2 == 0) {
                if (TextUtils.equals(str5, "1")) {
                    if (z) {
                        com.baidu.swan.apps.core.f.j(str, j3);
                    } else {
                        com.baidu.swan.apps.core.f.P(str, i);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.f.nh(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.aHO().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.11
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
                        cVar.tI(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.tJ(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY().aBe();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
                    cVar.mFrom = h.kS(i2);
                    JSONObject a2 = h.a(networkStatRecord);
                    if (a2 != null) {
                        cVar.cc(a2);
                    }
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.aMT(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.bt("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean tE(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = dFe.size();
        for (int i = 0; i < size; i++) {
            String str2 = dFe.get(i);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a(@Nullable NetworkStatRecord networkStatRecord) {
        if (networkStatRecord == null) {
            return null;
        }
        long j = networkStatRecord.dnsEndTs;
        long j2 = networkStatRecord.dnsStartTs;
        long j3 = networkStatRecord.connTs;
        long j4 = networkStatRecord.startTs;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request_network_start", j4);
            jSONObject.put("request_network_conn", j3);
            jSONObject.put("request_dns_start", j2);
            jSONObject.put("request_dns_end", j);
            jSONObject.put("request_network_response", networkStatRecord.responseTs);
            jSONObject.put("request_send_header", networkStatRecord.sendHeaderTs);
            jSONObject.put("request_receive_header", networkStatRecord.receiveHeaderTs);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("connectTime", jSONObject);
            return jSONObject2;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(String str, String str2, @NonNull JSONObject jSONObject) {
        if (!TextUtils.equals(str, "1")) {
            if (DEBUG) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (DEBUG) {
                Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
            }
        } else {
            HttpUrl parse = HttpUrl.parse(str2);
            if (parse == null) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                    return;
                }
                return;
            }
            String host = parse.host();
            if (TextUtils.isEmpty(host)) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                }
            } else if (dFd.contains(host)) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                }
            } else {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2);
                    Log.d("SwanAppUBCStatistic", "value=" + jSONObject);
                }
                b.e("1415", "66", jSONObject);
            }
        }
    }

    public static String aMO() {
        return com.baidu.swan.apps.y.e.aEW() ? "1" : "0";
    }

    public static void X(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.aHO().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.tI(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.tJ(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aJU().aio().aBe();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
                    cVar.mFrom = h.kS(i2);
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            com.baidu.swan.apps.console.c.bt("SwanAppUBCStatistic", "834-downloadFile event=" + jSONObject.toString());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String kS(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aMP() {
        b.a aio;
        JSONObject aBw;
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU == null || (aio = aJU.aio()) == null || (aBw = aio.aBw()) == null || !TextUtils.equals(aBw.optString("token"), "swanubc")) {
            return null;
        }
        return aBw;
    }

    public static JSONObject tF(String str) {
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
            if (DEBUG) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public static void p(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = str;
        eVar.mValue = str2;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aJW();
        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
            b.a aio = com.baidu.swan.apps.runtime.e.aJU().aio();
            eVar.mSource = aio.aBe();
            eVar.mFrom = kS(aio.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.t("authorize", z ? "success" : "fail");
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
            b.a aio = com.baidu.swan.apps.runtime.e.aJU().aio();
            eVar.mFrom = kS(aio.getAppFrameType());
            eVar.mAppId = aio.getAppId();
            eVar.mSource = aio.aBe();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
            b.a aio = com.baidu.swan.apps.runtime.e.aJU().aio();
            eVar.mFrom = kS(aio.getAppFrameType());
            eVar.mAppId = aio.getAppId();
            eVar.mSource = aio.aBe();
        }
        a("936", eVar);
    }

    public static void tG(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = kS(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void Y(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
            b.a aio = com.baidu.swan.apps.runtime.e.aJU().aio();
            eVar.mFrom = kS(aio.getAppFrameType());
            eVar.mAppId = aio.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.t("appkey", aio.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aJU() != null && com.baidu.swan.apps.runtime.e.aJU().aio() != null) {
            b.a aio = com.baidu.swan.apps.runtime.e.aJU().aio();
            fVar.mFrom = kS(aio.getAppFrameType());
            fVar.mAppId = aio.getAppId();
            fVar.t("appkey", aio.getAppKey());
            a("1032", fVar);
        }
    }

    public static void aMQ() {
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        com.baidu.swan.apps.runtime.e aJM = aJQ.aJM();
        b.a aJY = aJM.aJY();
        if (aJQ.aId() && aJM.aJZ()) {
            Bundle aBk = aJY.aBk();
            if (aBk.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aJM.aJY().aAY());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = kS(aJY.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.dFH = valueOf;
                fVar.b(aJY);
                fVar.tO(aBk.getString("ubc"));
                fVar.cd(tF(aJY.aBg()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = kS(aJY.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.dFH = valueOf;
                fVar2.b(aJY);
                fVar2.cd(tF(aJY.aBg()));
                fVar2.t(TiebaInitialize.LogFields.REASON, "cancel");
                if (aJY.getAppFrameType() == 1) {
                    fVar.t("errorList", com.baidu.swan.games.v.b.aZy().aZz());
                }
                fVar2.tO(aBk.getString("ubc"));
                onEvent(fVar2);
                aBk.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void aMR() {
        b.a aJY;
        Bundle aBj;
        if (com.baidu.swan.apps.runtime.d.aJQ().aId() && (aBj = (aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY()).aBj()) != null && aBj.getLong("launch_flag_for_statistic") > 0) {
            long j = aJY.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = kS(com.baidu.swan.apps.runtime.d.aJQ().aie());
            fVar.mAppId = aJY.getAppId();
            if (com.baidu.swan.apps.ad.a.a.rS(aJY.aBt())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aJY.aBe();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.dFI = String.valueOf(currentTimeMillis - j);
            fVar.t("status", "0");
            e.b(fVar, aJY.aBg(), aJY.aBk().getString("ubc"));
            aBj.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow rm = com.baidu.swan.apps.performance.i.rm("startup");
            if (rm != null) {
                if (!(rm.aFT() || rm.aFS())) {
                    rm.q("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY();
        if (com.baidu.swan.apps.runtime.d.aJQ().aJM().available()) {
            bVar.tO(aJY.aBk().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aJY.getAppKey();
        bVar.mFrom = kS(aJY.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.t("nativeAppId", com.baidu.swan.apps.t.a.azM().getHostName());
        bVar.t("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e arC = com.baidu.swan.apps.v.f.aCp().arC();
        com.baidu.swan.apps.model.c arb = arC == null ? null : arC.arb();
        if (arb != null && !TextUtils.isEmpty(arb.getPage())) {
            bVar.t("page", arb.getPage());
        }
        bVar.cd(aMP());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d tL = new com.baidu.swan.apps.statistic.a.d().kT(i).a(aJV.aio()).tK(kS(aJV.aie())).tL(aJV.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aJV.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.hX(i));
            jSONObject.put("request_id", aJV.aKg().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dDf);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        tL.cc(jSONObject);
        b(tL);
    }
}
