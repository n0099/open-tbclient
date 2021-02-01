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
/* loaded from: classes9.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> dKZ = com.facebook.common.internal.i.R("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> dLa = new CopyOnWriteArrayList<>();

    static {
        dLa.add("https://hmma.baidu.com/mini.gif");
        dLa.add("https://dxp.baidu.com/mini");
        dLa.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a sI(String str) {
        return b.sA(str);
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
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.azt())) {
                        com.baidu.swan.apps.statistic.a.d.this.sU(com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().azt());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.bl("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore asB = com.baidu.swan.apps.core.turbo.d.ase().asB();
        if (asB != null) {
            fVar.r("extension_ver", asB.extensionCoreVersionName);
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
        b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
        if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
            bVar.sT(aIO.azg().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
        bVar.mFrom = ju(i);
        bVar.r("money", str2);
        bVar.ci(aLF());
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
        if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
            b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
            i = aIO.getAppFrameType();
            str3 = aIO.azg().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
        bVar.mFrom = ju(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aIK().getName());
            bVar.ch(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.sT(str3);
        }
        bVar.ci(aLF());
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void p(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
            eVar.sT(com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().azg().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.e.this.ci(h.aLF());
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
            if (sJ(str)) {
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
                        com.baidu.swan.apps.core.f.S(str, i);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.f.mh(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.aFJ().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.11
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
                        cVar.sN(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sO(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO().aza();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
                    cVar.mFrom = h.ju(i2);
                    JSONObject a2 = h.a(networkStatRecord);
                    if (a2 != null) {
                        cVar.ch(a2);
                    }
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.aLJ(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.bl("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean sJ(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = dLa.size();
        for (int i = 0; i < size; i++) {
            String str2 = dLa.get(i);
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
            } else if (dKZ.contains(host)) {
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

    public static String aLE() {
        return com.baidu.swan.apps.y.e.aCT() ? "1" : "0";
    }

    public static void ab(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.aFJ().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.sN(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sO(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aIK().afZ().aza();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
                    cVar.mFrom = h.ju(i2);
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

    public static String ju(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aLF() {
        b.a afZ;
        JSONObject azs;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK == null || (afZ = aIK.afZ()) == null || (azs = afZ.azs()) == null || !TextUtils.equals(azs.optString("token"), "swanubc")) {
            return null;
        }
        return azs;
    }

    public static JSONObject sK(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIM();
        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            eVar.mSource = afZ.aza();
            eVar.mFrom = ju(afZ.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.r("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p);
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            eVar.mFrom = ju(afZ.getAppFrameType());
            eVar.mAppId = afZ.getAppId();
            eVar.mSource = afZ.aza();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            eVar.mFrom = ju(afZ.getAppFrameType());
            eVar.mAppId = afZ.getAppId();
            eVar.mSource = afZ.aza();
        }
        a("936", eVar);
    }

    public static void sL(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = ju(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void ab(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            eVar.mFrom = ju(afZ.getAppFrameType());
            eVar.mAppId = afZ.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.r("appkey", afZ.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aIK() != null && com.baidu.swan.apps.runtime.e.aIK().afZ() != null) {
            b.a afZ = com.baidu.swan.apps.runtime.e.aIK().afZ();
            fVar.mFrom = ju(afZ.getAppFrameType());
            fVar.mAppId = afZ.getAppId();
            fVar.r("appkey", afZ.getAppKey());
            a("1032", fVar);
        }
    }

    public static void aLG() {
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        com.baidu.swan.apps.runtime.e aIC = aIG.aIC();
        b.a aIO = aIC.aIO();
        if (aIG.aFY() && aIC.aIP()) {
            Bundle azg = aIO.azg();
            if (azg.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aIC.aIO().ayU());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = ju(aIO.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.dLD = valueOf;
                fVar.b(aIO);
                fVar.sT(azg.getString("ubc"));
                fVar.ci(sK(aIO.azc()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = ju(aIO.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.dLD = valueOf;
                fVar2.b(aIO);
                fVar2.ci(sK(aIO.azc()));
                fVar2.r(TiebaInitialize.LogFields.REASON, "cancel");
                if (aIO.getAppFrameType() == 1) {
                    fVar.r("errorList", com.baidu.swan.games.v.b.aYl().aYm());
                }
                fVar2.sT(azg.getString("ubc"));
                onEvent(fVar2);
                azg.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void aLH() {
        b.a aIO;
        Bundle azf;
        if (com.baidu.swan.apps.runtime.d.aIG().aFY() && (azf = (aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO()).azf()) != null && azf.getLong("launch_flag_for_statistic") > 0) {
            long j = aIO.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = ju(com.baidu.swan.apps.runtime.d.aIG().getFrameType());
            fVar.mAppId = aIO.getAppId();
            if (com.baidu.swan.apps.ad.a.a.qS(aIO.azp())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aIO.aza();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.dLE = String.valueOf(currentTimeMillis - j);
            fVar.r("status", "0");
            e.b(fVar, aIO.azc(), aIO.azg().getString("ubc"));
            azf.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow qm = com.baidu.swan.apps.performance.i.qm("startup");
            if (qm != null) {
                if (!(qm.aDQ() || qm.aDP())) {
                    qm.o("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO();
        if (com.baidu.swan.apps.runtime.d.aIG().aIC().available()) {
            bVar.sT(aIO.azg().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aIO.getAppKey();
        bVar.mFrom = ju(aIO.getAppFrameType());
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.r("nativeAppId", com.baidu.swan.apps.t.a.axI().getHostName());
        bVar.r("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e apy = com.baidu.swan.apps.v.f.aAl().apy();
        com.baidu.swan.apps.model.c aoW = apy == null ? null : apy.aoW();
        if (aoW != null && !TextUtils.isEmpty(aoW.getPage())) {
            bVar.r("page", aoW.getPage());
        }
        bVar.ci(aLF());
        p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sQ = new com.baidu.swan.apps.statistic.a.d().jv(i).a(aIL.afZ()).sP(ju(aIL.getFrameType())).sQ(aIL.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIL.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gn(i));
            jSONObject.put("request_id", aIL.aIW().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dJb);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sQ.ch(jSONObject);
        b(sQ);
    }
}
