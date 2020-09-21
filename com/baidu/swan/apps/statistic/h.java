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
/* loaded from: classes3.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cZh = com.facebook.common.internal.i.N("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> cZi = new CopyOnWriteArrayList<>();

    static {
        cZi.add("https://hmma.baidu.com/mini.gif");
        cZi.add("https://dxp.baidu.com/mini");
        cZi.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a rH(String str) {
        return b.rz(str);
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
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.arQ())) {
                        com.baidu.swan.apps.statistic.a.d.this.rT(com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arQ());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.bb("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore akY = com.baidu.swan.apps.core.turbo.d.akC().akY();
        if (akY != null) {
            fVar.u("extension_ver", akY.extensionCoreVersionName);
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
        b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
        if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
            bVar.rS(aAv.arD().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
        bVar.mFrom = jG(i);
        bVar.u("money", str2);
        bVar.bR(aDn());
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
        if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
            b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
            i = aAv.getAppFrameType();
            str3 = aAv.arD().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
        bVar.mFrom = jG(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.aAr().getName());
            bVar.bQ(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.rS(str3);
        }
        bVar.bR(aDn());
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void j(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
            eVar.rS(com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arD().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.e.this.bR(h.aDn());
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
            if (rI(str)) {
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
                        com.baidu.swan.apps.core.f.h(str, j3);
                    } else {
                        com.baidu.swan.apps.core.f.L(str, i);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.f.lm(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.ayl().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.11
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
                        cVar.rM(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.rN(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv().arx();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
                    cVar.mFrom = h.jG(i2);
                    JSONObject a = h.a(networkStatRecord);
                    if (a != null) {
                        cVar.bQ(a);
                    }
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.aDr(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.bb("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean rI(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = cZi.size();
        for (int i = 0; i < size; i++) {
            String str2 = cZi.get(i);
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
            } else if (cZh.contains(host)) {
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

    public static String aDm() {
        return com.baidu.swan.apps.y.e.avq() ? "1" : "0";
    }

    public static void T(String str, int i) {
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
            com.baidu.swan.apps.process.messaging.client.a.ayl().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.rM(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.rN(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.aAr().YI().arx();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
                    cVar.mFrom = h.jG(i2);
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            com.baidu.swan.apps.console.c.bb("SwanAppUBCStatistic", "834-downloadFile event=" + jSONObject.toString());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String jG(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject aDn() {
        b.a YI;
        JSONObject arP;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr == null || (YI = aAr.YI()) == null || (arP = YI.arP()) == null || !TextUtils.equals(arP.optString("token"), "swanubc")) {
            return null;
        }
        return arP;
    }

    public static JSONObject rJ(String str) {
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

    public static void n(String str, String str2, boolean z) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mType = str;
        eVar.mValue = str2;
        eVar.mAppId = com.baidu.swan.apps.runtime.e.aAt();
        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
            b.a YI = com.baidu.swan.apps.runtime.e.aAr().YI();
            eVar.mSource = YI.arx();
            eVar.mFrom = jG(YI.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.u("authorize", z ? "success" : "fail");
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
            b.a YI = com.baidu.swan.apps.runtime.e.aAr().YI();
            eVar.mFrom = jG(YI.getAppFrameType());
            eVar.mAppId = YI.getAppId();
            eVar.mSource = YI.arx();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
            b.a YI = com.baidu.swan.apps.runtime.e.aAr().YI();
            eVar.mFrom = jG(YI.getAppFrameType());
            eVar.mAppId = YI.getAppId();
            eVar.mSource = YI.arx();
        }
        a("936", eVar);
    }

    public static void rK(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = jG(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void N(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
            b.a YI = com.baidu.swan.apps.runtime.e.aAr().YI();
            eVar.mFrom = jG(YI.getAppFrameType());
            eVar.mAppId = YI.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.u("appkey", YI.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.aAr() != null && com.baidu.swan.apps.runtime.e.aAr().YI() != null) {
            b.a YI = com.baidu.swan.apps.runtime.e.aAr().YI();
            fVar.mFrom = jG(YI.getAppFrameType());
            fVar.mAppId = YI.getAppId();
            fVar.u("appkey", YI.getAppKey());
            a("1032", fVar);
        }
    }

    public static void aDo() {
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        com.baidu.swan.apps.runtime.e aAj = aAn.aAj();
        b.a aAv = aAj.aAv();
        if (aAn.ayA() && aAj.aAw()) {
            Bundle arD = aAv.arD();
            if (arD.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - aAj.aAv().arr());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = jG(aAv.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cZL = valueOf;
                fVar.b(aAv);
                fVar.rS(arD.getString("ubc"));
                fVar.bR(rJ(aAv.arz()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = jG(aAv.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cZL = valueOf;
                fVar2.b(aAv);
                fVar2.bR(rJ(aAv.arz()));
                fVar2.u(TiebaInitialize.LogFields.REASON, "cancel");
                if (aAv.getAppFrameType() == 1) {
                    fVar.u("errorList", com.baidu.swan.games.v.b.aPY().aPZ());
                }
                fVar2.rS(arD.getString("ubc"));
                onEvent(fVar2);
                arD.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void aDp() {
        b.a aAv;
        Bundle arC;
        if (com.baidu.swan.apps.runtime.d.aAn().ayA() && (arC = (aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv()).arC()) != null && arC.getLong("launch_flag_for_statistic") > 0) {
            long j = aAv.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = jG(com.baidu.swan.apps.runtime.d.aAn().Yy());
            fVar.mAppId = aAv.getAppId();
            if (com.baidu.swan.apps.ad.a.a.pY(aAv.arM())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aAv.arx();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cZM = String.valueOf(currentTimeMillis - j);
            fVar.u("status", "0");
            e.b(fVar, aAv.arz(), aAv.arD().getString("ubc"));
            arC.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow ps = com.baidu.swan.apps.performance.i.ps("startup");
            if (ps != null) {
                if (!(ps.awo() || ps.awn())) {
                    ps.r("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv();
        if (com.baidu.swan.apps.runtime.d.aAn().aAj().available()) {
            bVar.rS(aAv.arD().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = aAv.getAppKey();
        bVar.mFrom = jG(aAv.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.u("nativeAppId", com.baidu.swan.apps.t.a.aqg().getHostName());
        bVar.u("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e ahX = com.baidu.swan.apps.v.f.asJ().ahX();
        com.baidu.swan.apps.model.c ahw = ahX == null ? null : ahX.ahw();
        if (ahw != null && !TextUtils.isEmpty(ahw.getPage())) {
            bVar.u("page", ahw.getPage());
        }
        bVar.bR(aDn());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d rP = new com.baidu.swan.apps.statistic.a.d().jH(i).a(aAs.YI()).rO(jG(aAs.Yy())).rP(aAs.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", aAs.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.gL(i));
            jSONObject.put("request_id", aAs.aAD().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cXj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        rP.bQ(jSONObject);
        b(rP);
    }
}
