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
    private static volatile boolean dli = false;
    private static volatile boolean dlj = false;
    private static volatile boolean dlk = false;
    private static volatile boolean dll = false;
    private static volatile boolean dlm = false;
    private static HashMap<String, String> dln;
    private static String dlo;

    public static synchronized void gk(boolean z) {
        synchronized (e.class) {
            dli = z;
        }
    }

    public static synchronized boolean aFI() {
        boolean z;
        synchronized (e.class) {
            z = dli;
        }
        return z;
    }

    public static void aFJ() {
        gk(false);
    }

    public static void aFK() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null) {
            n(aDa.aDe());
        }
    }

    public static void aFL() {
        com.baidu.swan.apps.adaptation.b.c akw;
        com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
        if (abs != null) {
            com.baidu.swan.apps.core.d.c akH = abs.akH();
            if ((akH instanceof com.baidu.swan.apps.core.d.e) && (akw = ((com.baidu.swan.apps.core.d.e) akH).akw()) != null) {
                dlo = akw.aep();
            }
        }
    }

    public static void cq(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dln == null) {
                dln = new HashMap<>();
            }
            dln.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle auo;
        if (bVar != null && aFI() && (auo = bVar.auo()) != null && auo.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kd(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.auj();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.sF(auo.getString("ubc"));
            h.onEvent(fVar);
            auo.remove("page_display_flag_for_statistic");
            aFM();
        }
    }

    private static void aFM() {
        HybridUbcFlow qe = com.baidu.swan.apps.performance.i.qe("startup");
        if (qe != null) {
            if (!(qe.ayZ() || qe.ayY())) {
                qe.r("value", "fe_success");
            }
        }
    }

    public static synchronized void gl(boolean z) {
        synchronized (e.class) {
            dlj = z;
        }
    }

    public static void aFN() {
        gl(false);
    }

    public static void aFO() {
        aFJ();
        gn(false);
        aFN();
        aFQ();
    }

    private static synchronized void gm(boolean z) {
        synchronized (e.class) {
            dlk = z;
        }
    }

    private static boolean aFP() {
        return dlk;
    }

    public static void aFQ() {
        gm(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gl(true);
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
        com.baidu.swan.apps.runtime.e aDa;
        b.a aDe;
        if (!aFS() && !aFP() && dVar != null && (aDa = com.baidu.swan.apps.runtime.e.aDa()) != null && (aDe = aDa.aDe()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            gl(true);
            gm(true);
            a(aDe, dVar.chm, "0", dVar.chn, sq(dVar.chr), false);
        }
    }

    private static String sq(String str) {
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
        if (aVar != null && !aFP()) {
            gm(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void gn(boolean z) {
        dll = z;
    }

    public static boolean aFR() {
        return dll;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dll) {
            gn(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aFS() {
        return dlj;
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
            fVar.mFrom = h.kd(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.ahz()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.auj();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bX(jSONObject);
            }
            Bundle auo = aVar.auo();
            if (auo != null) {
                fVar.sF(auo.getString("ubc"));
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
        com.baidu.swan.apps.y.e.pN(dlo);
        if (!aFS() && !aFP()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dln != null) {
            str2 = dln.get(dlo);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aFN();
        dlm = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kd(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.auj();
        fVar.mType = "show";
        final String aul = bVar.aul();
        final String string = bVar.aup().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.bY(h.sw(aul));
                com.baidu.swan.apps.statistic.a.f.this.sF(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.sF(str2);
                com.baidu.swan.apps.statistic.a.f.this.bY(h.sw(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void ss(String str) {
        if (dlm) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.pN(str);
            dlm = false;
        }
    }

    public static boolean aFT() {
        return dlm;
    }
}
