package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dMA = com.facebook.common.internal.i.Q("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> dMB = new CopyOnWriteArrayList<>();

    static {
        dMB.add("https://hmma.baidu.com/mini.gif");
        dMB.add("https://dxp.baidu.com/mini");
        dMB.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a sP(String str) {
        return b.sH(str);
    }

    public static void a(final a aVar, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (aVar != null) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.1
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
            p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.5
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.azw())) {
                        com.baidu.swan.apps.statistic.a.d.this.tb(com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azw());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.bl("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore asE = com.baidu.swan.apps.core.turbo.d.ash().asE();
        if (asE != null) {
            fVar.s("extension_ver", asE.extensionCoreVersionName);
        }
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.6
                @Override // java.lang.Runnable
                public void run() {
                    b.onEvent(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(final String str, final String str2, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.7
                @Override // java.lang.Runnable
                public void run() {
                    b.e(str, str2, eVar.toJSONObject());
                }
            }, "SwanAppUbcCeresOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR();
        if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
            bVar.ta(aIR.azj().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
        bVar.mFrom = jv(i);
        bVar.s("money", str2);
        bVar.ck(aLI());
        p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.8
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
            b.a aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR();
            i = aIR.getAppFrameType();
            str3 = aIR.azj().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
        bVar.mFrom = jv(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aIN().getName());
            bVar.cj(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.ta(str3);
        }
        bVar.ck(aLI());
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void p(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
            eVar.ta(com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azj().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.e.this.ck(h.aLI());
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
            if (sQ(str)) {
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
                        com.baidu.swan.apps.core.f.i(str, j3);
                    } else {
                        com.baidu.swan.apps.core.f.T(str, i);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.f.mo(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.aFM().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.11
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
                        cVar.sU(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sV(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR().azd();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
                    cVar.mFrom = h.jv(i2);
                    JSONObject a2 = h.a(networkStatRecord);
                    if (a2 != null) {
                        cVar.cj(a2);
                    }
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.aLM(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.bl("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean sQ(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = dMB.size();
        for (int i = 0; i < size; i++) {
            String str2 = dMB.get(i);
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
            } else if (dMA.contains(host)) {
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

    public static String aLH() {
        return com.baidu.swan.apps.y.e.aCW() ? "1" : "0";
    }

    public static void ac(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.aFM().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.sU(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sV(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aIN().agc().azd();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
                    cVar.mFrom = h.jv(i2);
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            com.baidu.swan.apps.console.c.bl("SwanAppUBCStatistic", "834-downloadFile event=" + jSONObject.toString());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String jv(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aLI() {
        b.a agc;
        JSONObject azv;
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN == null || (agc = aIN.agc()) == null || (azv = agc.azv()) == null || !TextUtils.equals(azv.optString("token"), "swanubc")) {
            return null;
        }
        return azv;
    }

    public static JSONObject sR(String str) {
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

    public static void r(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = str;
        eVar.mValue = str2;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIP();
        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
            b.a agc = com.baidu.swan.apps.runtime.e.aIN().agc();
            eVar.mSource = agc.azd();
            eVar.mFrom = jv(agc.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.s("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p);
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
            b.a agc = com.baidu.swan.apps.runtime.e.aIN().agc();
            eVar.mFrom = jv(agc.getAppFrameType());
            eVar.mAppId = agc.getAppId();
            eVar.mSource = agc.azd();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
            b.a agc = com.baidu.swan.apps.runtime.e.aIN().agc();
            eVar.mFrom = jv(agc.getAppFrameType());
            eVar.mAppId = agc.getAppId();
            eVar.mSource = agc.azd();
        }
        a("936", eVar);
    }

    public static void sS(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = jv(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void ab(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
            b.a agc = com.baidu.swan.apps.runtime.e.aIN().agc();
            eVar.mFrom = jv(agc.getAppFrameType());
            eVar.mAppId = agc.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.s("appkey", agc.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aIN() != null && com.baidu.swan.apps.runtime.e.aIN().agc() != null) {
            b.a agc = com.baidu.swan.apps.runtime.e.aIN().agc();
            fVar.mFrom = jv(agc.getAppFrameType());
            fVar.mAppId = agc.getAppId();
            fVar.s("appkey", agc.getAppKey());
            a("1032", fVar);
        }
    }

    public static void aLJ() {
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        com.baidu.swan.apps.runtime.e aIF = aIJ.aIF();
        b.a aIR = aIF.aIR();
        if (aIJ.aGb() && aIF.aIS()) {
            Bundle azj = aIR.azj();
            if (azj.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aIF.aIR().ayX());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = jv(aIR.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.dNe = valueOf;
                fVar.b(aIR);
                fVar.ta(azj.getString("ubc"));
                fVar.ck(sR(aIR.azf()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = jv(aIR.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.dNe = valueOf;
                fVar2.b(aIR);
                fVar2.ck(sR(aIR.azf()));
                fVar2.s(TiebaInitialize.LogFields.REASON, "cancel");
                if (aIR.getAppFrameType() == 1) {
                    fVar.s("errorList", com.baidu.swan.games.v.b.aYo().aYp());
                }
                fVar2.ta(azj.getString("ubc"));
                onEvent(fVar2);
                azj.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void aLK() {
        b.a aIR;
        Bundle azi;
        if (com.baidu.swan.apps.runtime.d.aIJ().aGb() && (azi = (aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR()).azi()) != null && azi.getLong("launch_flag_for_statistic") > 0) {
            long j = aIR.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = jv(com.baidu.swan.apps.runtime.d.aIJ().getFrameType());
            fVar.mAppId = aIR.getAppId();
            if (com.baidu.swan.apps.ad.a.a.qZ(aIR.azs())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aIR.azd();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.dNf = String.valueOf(currentTimeMillis - j);
            fVar.s("status", "0");
            e.b(fVar, aIR.azf(), aIR.azj().getString("ubc"));
            azi.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow qt = com.baidu.swan.apps.performance.i.qt("startup");
            if (qt != null) {
                if (!(qt.aDT() || qt.aDS())) {
                    qt.p("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR();
        if (com.baidu.swan.apps.runtime.d.aIJ().aIF().available()) {
            bVar.ta(aIR.azj().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aIR.getAppKey();
        bVar.mFrom = jv(aIR.getAppFrameType());
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.s("nativeAppId", com.baidu.swan.apps.t.a.axL().getHostName());
        bVar.s("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e apB = com.baidu.swan.apps.v.f.aAo().apB();
        com.baidu.swan.apps.model.c aoZ = apB == null ? null : apB.aoZ();
        if (aoZ != null && !TextUtils.isEmpty(aoZ.getPage())) {
            bVar.s("page", aoZ.getPage());
        }
        bVar.ck(aLI());
        p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sX = new com.baidu.swan.apps.statistic.a.d().jw(i).a(aIO.agc()).sW(jv(aIO.getFrameType())).sX(aIO.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIO.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gp(i));
            jSONObject.put("request_id", aIO.aIZ().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dKC);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sX.cj(jSONObject);
        b(sX);
    }
}
