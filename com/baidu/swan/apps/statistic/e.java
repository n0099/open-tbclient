package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dtK = false;
    private static volatile boolean dtL = false;
    private static volatile boolean dtM = false;
    private static volatile boolean dtN = false;
    private static volatile boolean dtO = false;
    private static HashMap<String, String> dtP;
    private static String dtQ;

    public static synchronized void gx(boolean z) {
        synchronized (e.class) {
            dtK = z;
        }
    }

    public static synchronized boolean aHC() {
        boolean z;
        synchronized (e.class) {
            z = dtK;
        }
        return z;
    }

    public static void aHD() {
        gx(false);
    }

    public static void aHE() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null) {
            n(aEU.aEY());
        }
    }

    public static void aHF() {
        com.baidu.swan.apps.adaptation.b.c amq;
        com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
        if (adm != null) {
            com.baidu.swan.apps.core.d.c amB = adm.amB();
            if ((amB instanceof com.baidu.swan.apps.core.d.e) && (amq = ((com.baidu.swan.apps.core.d.e) amB).amq()) != null) {
                dtQ = amq.agj();
            }
        }
    }

    public static void cx(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dtP == null) {
                dtP = new HashMap<>();
            }
            dtP.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle awi;
        if (bVar != null && aHC() && (awi = bVar.awi()) != null && awi.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ko(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.awd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.sY(awi.getString("ubc"));
            h.onEvent(fVar);
            awi.remove("page_display_flag_for_statistic");
            aHG();
        }
    }

    private static void aHG() {
        HybridUbcFlow qx = com.baidu.swan.apps.performance.i.qx("startup");
        if (qx != null) {
            if (!(qx.aAT() || qx.aAS())) {
                qx.r("value", "fe_success");
            }
        }
    }

    public static synchronized void gy(boolean z) {
        synchronized (e.class) {
            dtL = z;
        }
    }

    public static void aHH() {
        gy(false);
    }

    public static void aHI() {
        aHD();
        gA(false);
        aHH();
        aHK();
    }

    private static synchronized void gz(boolean z) {
        synchronized (e.class) {
            dtM = z;
        }
    }

    private static boolean aHJ() {
        return dtM;
    }

    public static void aHK() {
        gz(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gy(true);
            if (z || j > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("valuetype", str);
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
                a(aVar, "arrivesuccess", j, jSONObject);
            }
            if (z || j2 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("valuetype", str2);
                } catch (JSONException e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                }
                a(aVar, "fmparrsuccess", j2, jSONObject2);
            }
        }
    }

    public static void a(com.baidu.swan.apps.adaptation.b.a.d dVar) {
        com.baidu.swan.apps.runtime.e aEU;
        b.a aEY;
        if (!aHM() && !aHJ() && dVar != null && (aEU = com.baidu.swan.apps.runtime.e.aEU()) != null && (aEY = aEU.aEY()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            gy(true);
            gz(true);
            a(aEY, dVar.cpN, "0", dVar.cpO, sK(dVar.cpS), false);
        }
    }

    private static String sK(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "0";
            case 1:
                return "2";
            case 2:
                return "3";
            case 3:
                return "4";
            default:
                return "0";
        }
    }

    public static void b(b.a aVar) {
        if (aVar != null && !aHJ()) {
            gz(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void gA(boolean z) {
        dtN = z;
    }

    public static boolean aHL() {
        return dtN;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dtN) {
            gA(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aHM() {
        return dtL;
    }

    private static void a(b.a aVar, String str) {
        a(aVar, str, System.currentTimeMillis(), null);
    }

    private static void a(b.a aVar, String str, long j, JSONObject jSONObject) {
        long j2 = 0;
        String appId = aVar.getAppId();
        if (appId != null && aVar != null) {
            if (j != -1) {
                long j3 = aVar.getLong("launch_time", 0L);
                if (j <= 0) {
                    j = System.currentTimeMillis();
                }
                j2 = j - j3;
            }
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ko(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.ajt()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.awd();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.ca(jSONObject);
            }
            Bundle awi = aVar.awi();
            if (awi != null) {
                fVar.sY(awi.getString("ubc"));
            }
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "handle record arrival event, arrivalValue " + str + " arrive time : " + j2 + " extJson :" + (jSONObject == null ? "" : jSONObject.toString()));
            }
            h.onEvent(fVar);
        }
    }

    public static void d(b.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        com.baidu.swan.apps.y.e.qg(dtQ);
        if (!aHM() && !aHJ()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dtP != null) {
            str2 = dtP.get(dtQ);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aHH();
        dtO = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ko(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.awd();
        fVar.mType = "show";
        final String awf = bVar.awf();
        final String string = bVar.awj().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.cb(h.sP(awf));
                com.baidu.swan.apps.statistic.a.f.this.sY(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.sY(str2);
                com.baidu.swan.apps.statistic.a.f.this.cb(h.sP(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sL(String str) {
        if (dtO) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qg(str);
            dtO = false;
        }
    }

    public static boolean aHN() {
        return dtO;
    }
}
