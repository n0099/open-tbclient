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
    private static final Set<String> dIV = com.facebook.common.internal.i.R("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> dIW = new CopyOnWriteArrayList<>();

    static {
        dIW.add("https://hmma.baidu.com/mini.gif");
        dIW.add("https://dxp.baidu.com/mini");
        dIW.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a so(String str) {
        return b.sg(str);
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
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.ayV())) {
                        com.baidu.swan.apps.statistic.a.d.this.sB(com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayV());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.br("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore asc = com.baidu.swan.apps.core.turbo.d.arG().asc();
        if (asc != null) {
            fVar.t("extension_ver", asc.extensionCoreVersionName);
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
        b.a aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv();
        if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
            bVar.sA(aIv.ayI().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
        bVar.mFrom = jr(i);
        bVar.t("money", str2);
        bVar.cl(aLm());
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
        if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
            b.a aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv();
            i = aIv.getAppFrameType();
            str3 = aIv.ayI().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
        bVar.mFrom = jr(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aIr().getName());
            bVar.ck(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.sA(str3);
        }
        bVar.cl(aLm());
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void l(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
            eVar.sA(com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayI().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.e.this.cl(h.aLm());
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
            if (sp(str)) {
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
                        com.baidu.swan.apps.core.f.Q(str, i);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.f.lP(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.aFo().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.11
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
                        cVar.su(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sv(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv().ayC();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
                    cVar.mFrom = h.jr(i2);
                    JSONObject a2 = h.a(networkStatRecord);
                    if (a2 != null) {
                        cVar.ck(a2);
                    }
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.aLq(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.br("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean sp(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = dIW.size();
        for (int i = 0; i < size; i++) {
            String str2 = dIW.get(i);
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
            } else if (dIV.contains(host)) {
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

    public static String aLl() {
        return com.baidu.swan.apps.y.e.aCx() ? "1" : "0";
    }

    public static void Z(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.aFo().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.su(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.sv(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aIr().afB().ayC();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
                    cVar.mFrom = h.jr(i2);
                    p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            com.baidu.swan.apps.console.c.br("SwanAppUBCStatistic", "834-downloadFile event=" + jSONObject.toString());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String jr(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aLm() {
        b.a afB;
        JSONObject ayU;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr == null || (afB = aIr.afB()) == null || (ayU = afB.ayU()) == null || !TextUtils.equals(ayU.optString("token"), "swanubc")) {
            return null;
        }
        return ayU;
    }

    public static JSONObject sq(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aIt();
        if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
            b.a afB = com.baidu.swan.apps.runtime.e.aIr().afB();
            eVar.mSource = afB.ayC();
            eVar.mFrom = jr(afB.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.t("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p);
        }
        p.a(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
            b.a afB = com.baidu.swan.apps.runtime.e.aIr().afB();
            eVar.mFrom = jr(afB.getAppFrameType());
            eVar.mAppId = afB.getAppId();
            eVar.mSource = afB.ayC();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
            b.a afB = com.baidu.swan.apps.runtime.e.aIr().afB();
            eVar.mFrom = jr(afB.getAppFrameType());
            eVar.mAppId = afB.getAppId();
            eVar.mSource = afB.ayC();
        }
        a("936", eVar);
    }

    public static void ss(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = jr(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void aa(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
            b.a afB = com.baidu.swan.apps.runtime.e.aIr().afB();
            eVar.mFrom = jr(afB.getAppFrameType());
            eVar.mAppId = afB.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.t("appkey", afB.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aIr() != null && com.baidu.swan.apps.runtime.e.aIr().afB() != null) {
            b.a afB = com.baidu.swan.apps.runtime.e.aIr().afB();
            fVar.mFrom = jr(afB.getAppFrameType());
            fVar.mAppId = afB.getAppId();
            fVar.t("appkey", afB.getAppKey());
            a("1032", fVar);
        }
    }

    public static void aLn() {
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        com.baidu.swan.apps.runtime.e aIj = aIn.aIj();
        b.a aIv = aIj.aIv();
        if (aIn.aFD() && aIj.aIw()) {
            Bundle ayI = aIv.ayI();
            if (ayI.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aIj.aIv().ayw());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = jr(aIv.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.dJz = valueOf;
                fVar.b(aIv);
                fVar.sA(ayI.getString("ubc"));
                fVar.cl(sq(aIv.ayE()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = jr(aIv.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.dJz = valueOf;
                fVar2.b(aIv);
                fVar2.cl(sq(aIv.ayE()));
                fVar2.t(TiebaInitialize.LogFields.REASON, "cancel");
                if (aIv.getAppFrameType() == 1) {
                    fVar.t("errorList", com.baidu.swan.games.v.b.aXZ().aYa());
                }
                fVar2.sA(ayI.getString("ubc"));
                onEvent(fVar2);
                ayI.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void aLo() {
        b.a aIv;
        Bundle ayH;
        if (com.baidu.swan.apps.runtime.d.aIn().aFD() && (ayH = (aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv()).ayH()) != null && ayH.getLong("launch_flag_for_statistic") > 0) {
            long j = aIv.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = jr(com.baidu.swan.apps.runtime.d.aIn().afr());
            fVar.mAppId = aIv.getAppId();
            if (com.baidu.swan.apps.ad.a.a.qA(aIv.ayR())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aIv.ayC();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.dJA = String.valueOf(currentTimeMillis - j);
            fVar.t("status", "0");
            e.b(fVar, aIv.ayE(), aIv.ayI().getString("ubc"));
            ayH.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow pU = com.baidu.swan.apps.performance.i.pU("startup");
            if (pU != null) {
                if (!(pU.aDu() || pU.aDt())) {
                    pU.q("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv();
        if (com.baidu.swan.apps.runtime.d.aIn().aIj().available()) {
            bVar.sA(aIv.ayI().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aIv.getAppKey();
        bVar.mFrom = jr(aIv.getAppFrameType());
        bVar.mValue = z ? "success" : com.baidu.pass.biometrics.face.liveness.c.a.p;
        bVar.t("nativeAppId", com.baidu.swan.apps.t.a.axk().getHostName());
        bVar.t("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e aoZ = com.baidu.swan.apps.v.f.azN().aoZ();
        com.baidu.swan.apps.model.c aoy = aoZ == null ? null : aoZ.aoy();
        if (aoy != null && !TextUtils.isEmpty(aoy.getPage())) {
            bVar.t("page", aoy.getPage());
        }
        bVar.cl(aLm());
        p.b(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d sx = new com.baidu.swan.apps.statistic.a.d().js(i).a(aIs.afB()).sw(jr(aIs.afr())).sx(aIs.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aIs.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gk(i));
            jSONObject.put("request_id", aIs.aID().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.dGX);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        sx.ck(jSONObject);
        b(sx);
    }
}
