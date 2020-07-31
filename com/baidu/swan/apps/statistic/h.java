package com.baidu.swan.apps.statistic;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.aq.p;
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
/* loaded from: classes7.dex */
public final class h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final Set<String> cOe = com.facebook.common.internal.i.O("hmma.baidu.com");
    private static final CopyOnWriteArrayList<String> cOf = new CopyOnWriteArrayList<>();

    static {
        cOf.add("https://hmma.baidu.com/mini.gif");
        cOf.add("https://dxp.baidu.com/mini");
        cOf.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
    }

    public static a pn(String str) {
        return b.pg(str);
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
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.6
                @Override // java.lang.Runnable
                public void run() {
                    if (TextUtils.isEmpty(com.baidu.swan.apps.statistic.a.d.this.ajz())) {
                        com.baidu.swan.apps.statistic.a.d.this.pz(com.baidu.swan.apps.runtime.d.arr().arn().arz().ajz());
                    }
                    b.onEvent("671", com.baidu.swan.apps.statistic.a.d.this.toJSONObject());
                    com.baidu.swan.apps.console.c.aW("SwanAppUBCStatistic", "671 event=" + com.baidu.swan.apps.statistic.a.d.this.toJSONObject().toString());
                }
            }, "SwanAppUBCStability");
        }
    }

    public static void onEvent(com.baidu.swan.apps.statistic.a.f fVar) {
        ExtensionCore adR = com.baidu.swan.apps.core.turbo.d.adw().adR();
        if (adR != null) {
            fVar.v("extension_ver", adR.extensionCoreVersionName);
        }
        a("606", fVar);
    }

    public static void a(final String str, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.7
                @Override // java.lang.Runnable
                public void run() {
                    b.onEvent(str, eVar.toJSONObject());
                }
            }, "SwanAppUBCOnEvent");
        }
    }

    public static void a(final String str, final String str2, final com.baidu.swan.apps.statistic.a.e eVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.8
                @Override // java.lang.Runnable
                public void run() {
                    b.e(str, str2, eVar.toJSONObject());
                }
            }, "SwanAppUbcCeresOnEvent");
        }
    }

    public static void a(boolean z, String str, String str2, int i) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a arz = com.baidu.swan.apps.runtime.d.arr().arn().arz();
        if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
            bVar.py(arz.ajm().getString("ubc"));
        }
        bVar.mType = "pay";
        bVar.mValue = z ? "success" : "fail";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
        bVar.mFrom = ho(i);
        bVar.v("money", str2);
        bVar.bG(auu());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.9
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void a(String str, String str2, ArrayList<String> arrayList) {
        int i = 0;
        String str3 = "";
        if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
            b.a arz = com.baidu.swan.apps.runtime.d.arr().arn().arz();
            i = arz.getAppFrameType();
            str3 = arz.ajm().getString("ubc");
        }
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        bVar.mType = "pay";
        bVar.mSource = str;
        bVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
        bVar.mFrom = ho(i);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("paymenturl", str2);
            }
            if (arrayList != null) {
                jSONObject.put("whitelist", arrayList);
            }
            jSONObject.put("appname", com.baidu.swan.apps.runtime.e.arv().getName());
            bVar.bF(jSONObject);
        } catch (JSONException e) {
            e.printStackTrace();
            bVar.py(str3);
        }
        bVar.bG(auu());
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.10
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPay");
    }

    public static void j(boolean z, String str) {
        final com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
            eVar.py(com.baidu.swan.apps.runtime.d.arr().arn().arz().ajm().getString("ubc"));
        }
        eVar.mType = "show";
        eVar.mSource = str;
        eVar.mValue = z ? "success" : "fail";
        eVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.11
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.statistic.a.e.this.bG(h.auu());
                    b.onEvent("778", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
                }
            }, "SwanAppUBCOnPagesRoute");
            return;
        }
        eVar.bG(auu());
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.12
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
        if (SwanAppNetworkUtils.isNetworkConnected(null)) {
            if (po(str)) {
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
                        com.baidu.swan.apps.core.d.i(str, j3);
                    } else {
                        com.baidu.swan.apps.core.d.jt(str);
                    }
                } else if (TextUtils.equals(str5, "0")) {
                    com.baidu.swan.apps.core.d.js(str);
                }
            }
            if (z && j3 < 5000) {
                if (DEBUG) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (j2 - j) + ") is ok, don't report");
                    return;
                }
                return;
            }
            com.baidu.swan.apps.process.messaging.client.a.apG().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.2
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
                        cVar.ps(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.pt(str4);
                    }
                    cVar.mType = "request";
                    if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
                        cVar.mSource = com.baidu.swan.apps.runtime.d.arr().arn().arz().ajg();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
                    cVar.mFrom = h.ho(i2);
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.DEBUG) {
                                Log.d("SwanAppUBCStatistic", "Reporting: " + cVar.toJSONObject());
                            }
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            h.f(cVar.auy(), cVar.getRequestUrl(), jSONObject);
                            com.baidu.swan.apps.console.c.aW("SwanAppUBCStatistic", "834-request event=" + jSONObject.toString());
                        }
                    }, "SwanAppUBCRequest");
                }
            });
        }
    }

    private static boolean po(String str) {
        if (DEBUG) {
            Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = cOf.size();
        for (int i = 0; i < size; i++) {
            String str2 = cOf.get(i);
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
            } else if (cOe.contains(host)) {
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

    public static String aut() {
        return com.baidu.swan.apps.z.e.amL() ? "1" : "0";
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
            com.baidu.swan.apps.process.messaging.client.a.apG().b(null, com.baidu.swan.games.network.d.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.apps.statistic.h.3
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
                        cVar.ps(str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        cVar.pt(str4);
                    }
                    cVar.mType = "downloadFile";
                    if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
                        cVar.mSource = com.baidu.swan.apps.runtime.e.arv().Se().ajg();
                    }
                    cVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
                    cVar.mFrom = h.ho(i2);
                    p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONObject jSONObject = cVar.toJSONObject();
                            b.onEvent("834", jSONObject);
                            com.baidu.swan.apps.console.c.aW("SwanAppUBCStatistic", "834-downloadFile event=" + jSONObject.toString());
                        }
                    }, "SwanAppDownloadFile");
                }
            });
        }
    }

    public static String ho(int i) {
        switch (i) {
            case 1:
                return "swangame";
            default:
                return "swan";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject auu() {
        b.a Se;
        JSONObject ajy;
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv == null || (Se = arv.Se()) == null || (ajy = Se.ajy()) == null || !TextUtils.equals(ajy.optString("token"), "swanubc")) {
            return null;
        }
        return ajy;
    }

    public static JSONObject pp(String str) {
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
        eVar.mAppId = com.baidu.swan.apps.runtime.e.arx();
        if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            eVar.mSource = Se.ajg();
            eVar.mFrom = ho(Se.getAppFrameType());
        }
        if (TextUtils.equals("click", str)) {
            eVar.v("authorize", z ? "success" : "fail");
        }
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.4
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("894", com.baidu.swan.apps.statistic.a.e.this.toJSONObject());
            }
        }, "SwanAppUBCOnAuthDialog");
    }

    public static void d(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            eVar.mFrom = ho(Se.getAppFrameType());
            eVar.mAppId = Se.getAppId();
            eVar.mSource = Se.ajg();
        }
        a("914", eVar);
    }

    public static void e(com.baidu.swan.apps.statistic.a.e eVar) {
        if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            eVar.mFrom = ho(Se.getAppFrameType());
            eVar.mAppId = Se.getAppId();
            eVar.mSource = Se.ajg();
        }
        a("936", eVar);
    }

    public static void pq(String str) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        eVar.mFrom = ho(0);
        eVar.mType = str;
        a("956", eVar);
    }

    public static void K(String str, String str2, String str3) {
        com.baidu.swan.apps.statistic.a.e eVar = new com.baidu.swan.apps.statistic.a.e();
        if (com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            eVar.mFrom = ho(Se.getAppFrameType());
            eVar.mAppId = Se.getAppId();
            eVar.mType = str;
            eVar.mSource = str2;
            eVar.mValue = str3;
            eVar.v("appkey", Se.getAppKey());
        }
        a("923", eVar);
    }

    public static void c(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && com.baidu.swan.apps.runtime.e.arv() != null && com.baidu.swan.apps.runtime.e.arv().Se() != null) {
            b.a Se = com.baidu.swan.apps.runtime.e.arv().Se();
            fVar.mFrom = ho(Se.getAppFrameType());
            fVar.mAppId = Se.getAppId();
            fVar.v("appkey", Se.getAppKey());
            a("1032", fVar);
        }
    }

    public static void auv() {
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        com.baidu.swan.apps.runtime.e arn = arr.arn();
        b.a arz = arn.arz();
        if (arr.apU() && arn.arA()) {
            Bundle ajm = arz.ajm();
            if (ajm.getLong("launch_flag_for_statistic") > 0) {
                String valueOf = String.valueOf(System.currentTimeMillis() - arn.arz().aja());
                com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
                fVar.mFrom = ho(arz.getAppFrameType());
                fVar.mType = Config.LAUNCH;
                fVar.mValue = "cancel";
                fVar.cOH = valueOf;
                fVar.b(arz);
                fVar.py(ajm.getString("ubc"));
                fVar.bG(pp(arz.aji()));
                onEvent(fVar);
                com.baidu.swan.apps.statistic.a.f fVar2 = new com.baidu.swan.apps.statistic.a.f();
                fVar2.mFrom = ho(arz.getAppFrameType());
                fVar2.mType = Config.LAUNCH;
                fVar2.mValue = "realcancel";
                fVar2.cOH = valueOf;
                fVar2.b(arz);
                fVar2.bG(pp(arz.aji()));
                fVar2.v(TiebaInitialize.LogFields.REASON, "cancel");
                if (arz.getAppFrameType() == 1) {
                    fVar.v("errorList", com.baidu.swan.games.v.b.aGw().aGx());
                }
                fVar2.py(ajm.getString("ubc"));
                onEvent(fVar2);
                ajm.remove("launch_flag_for_statistic");
            }
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "custom_return", "", SearchFlowEvent.EventType.END));
        }
    }

    public static void auw() {
        b.a arz;
        Bundle ajl;
        if (com.baidu.swan.apps.runtime.d.arr().apU() && (ajl = (arz = com.baidu.swan.apps.runtime.d.arr().arn().arz()).ajl()) != null && ajl.getLong("launch_flag_for_statistic") > 0) {
            long j = arz.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = ho(com.baidu.swan.apps.runtime.d.arr().RU());
            fVar.mAppId = arz.getAppId();
            if (com.baidu.swan.apps.ae.a.a.nG(arz.ajv())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = arz.ajg();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cOI = String.valueOf(currentTimeMillis - j);
            fVar.v("status", "0");
            e.b(fVar, arz.aji(), arz.ajm().getString("ubc"));
            ajl.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow mZ = com.baidu.swan.apps.performance.i.mZ("startup");
            if (mZ != null) {
                if (!(mZ.anK() || mZ.anJ())) {
                    mZ.r("value", "na_success");
                }
            }
        }
    }

    public static void a(String str, boolean z, boolean z2) {
        final com.baidu.swan.apps.statistic.a.b bVar = new com.baidu.swan.apps.statistic.a.b();
        b.a arz = com.baidu.swan.apps.runtime.d.arr().arn().arz();
        if (com.baidu.swan.apps.runtime.d.arr().arn().available()) {
            bVar.py(arz.ajm().getString("ubc"));
        }
        bVar.mType = "paylogin";
        bVar.mSource = str;
        bVar.mAppId = arz.getAppKey();
        bVar.mFrom = ho(arz.getAppFrameType());
        bVar.mValue = z ? "success" : "fail";
        bVar.v("nativeAppId", com.baidu.swan.apps.t.a.ahU().getHostName());
        bVar.v("paylogin", z2 ? "1" : "0");
        com.baidu.swan.apps.core.d.e aba = com.baidu.swan.apps.v.f.akr().aba();
        com.baidu.swan.apps.model.c aaC = aba == null ? null : aba.aaC();
        if (aaC != null && !TextUtils.isEmpty(aaC.getPage())) {
            bVar.v("page", aaC.getPage());
        }
        bVar.bG(auu());
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.statistic.h.5
            @Override // java.lang.Runnable
            public void run() {
                b.onEvent("751", com.baidu.swan.apps.statistic.a.b.this.toJSONObject());
            }
        }, "SwanAppUBCOnPayLogin");
    }

    public static void b(int i, com.baidu.swan.apps.setting.oauth.e eVar) {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null) {
            if (DEBUG) {
                Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                return;
            }
            return;
        }
        com.baidu.swan.apps.statistic.a.d pv = new com.baidu.swan.apps.statistic.a.d().hp(i).a(arw.Se()).pu(ho(arw.RU())).pv(arw.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", arw.getAppId());
            jSONObject.put("msg", com.baidu.swan.apps.setting.oauth.c.eE(i));
            jSONObject.put("request_id", arw.arH().getString("cur_request_id", ""));
            if (eVar != null) {
                jSONObject.put("scope", eVar.id);
                jSONObject.put("scopeData", eVar.cMj);
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        pv.bF(jSONObject);
        b(pv);
    }
}
