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
/* loaded from: classes8.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean cWY = false;
    private static volatile boolean cWZ = false;
    private static volatile boolean cXa = false;
    private static volatile boolean cXb = false;
    private static volatile boolean cXc = false;
    private static HashMap<String, String> cXd;
    private static String cXe;

    public static synchronized void fQ(boolean z) {
        synchronized (e.class) {
            cWY = z;
        }
    }

    public static synchronized boolean aCp() {
        boolean z;
        synchronized (e.class) {
            z = cWY;
        }
        return z;
    }

    public static void aCq() {
        fQ(false);
    }

    public static void aCr() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null) {
            n(azI.azM());
        }
    }

    public static void aCs() {
        com.baidu.swan.apps.adaptation.b.c ahb;
        com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
        if (XX != null) {
            com.baidu.swan.apps.core.d.c ahm = XX.ahm();
            if ((ahm instanceof com.baidu.swan.apps.core.d.e) && (ahb = ((com.baidu.swan.apps.core.d.e) ahm).ahb()) != null) {
                cXe = ahb.aaU();
            }
        }
    }

    public static void cl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (cXd == null) {
                cXd = new HashMap<>();
            }
            cXd.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle aqS;
        if (bVar != null && aCp() && (aqS = bVar.aqS()) != null && aqS.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jv(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aqN();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.rz(aqS.getString("ubc"));
            h.onEvent(fVar);
            aqS.remove("page_display_flag_for_statistic");
            aCt();
        }
    }

    private static void aCt() {
        HybridUbcFlow oZ = com.baidu.swan.apps.performance.i.oZ("startup");
        if (oZ != null) {
            if (!(oZ.avF() || oZ.avE())) {
                oZ.r("value", "fe_success");
            }
        }
    }

    public static synchronized void fR(boolean z) {
        synchronized (e.class) {
            cWZ = z;
        }
    }

    public static void aCu() {
        fR(false);
    }

    public static void aCv() {
        aCq();
        fT(false);
        aCu();
        aCx();
    }

    private static synchronized void fS(boolean z) {
        synchronized (e.class) {
            cXa = z;
        }
    }

    private static boolean aCw() {
        return cXa;
    }

    public static void aCx() {
        fS(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fR(true);
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
        com.baidu.swan.apps.runtime.e azI;
        b.a azM;
        if (!aCz() && !aCw() && dVar != null && (azI = com.baidu.swan.apps.runtime.e.azI()) != null && (azM = azI.azM()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            fR(true);
            fS(true);
            a(azM, dVar.bSY, "0", dVar.bSZ, rl(dVar.bTd), false);
        }
    }

    private static String rl(String str) {
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
        if (aVar != null && !aCw()) {
            fS(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void fT(boolean z) {
        cXb = z;
    }

    public static boolean aCy() {
        return cXb;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !cXb) {
            fT(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aCz() {
        return cWZ;
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
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.aee()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.aqN();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bN(jSONObject);
            }
            Bundle aqS = aVar.aqS();
            if (aqS != null) {
                fVar.rz(aqS.getString("ubc"));
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
        com.baidu.swan.apps.y.e.oI(cXe);
        if (!aCz() && !aCw()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (cXd != null) {
            str2 = cXd.get(cXe);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aCu();
        cXc = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jv(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.aqN();
        fVar.mType = "show";
        final String aqP = bVar.aqP();
        final String string = bVar.aqT().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.bO(h.rq(aqP));
                com.baidu.swan.apps.statistic.a.f.this.rz(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.rz(str2);
                com.baidu.swan.apps.statistic.a.f.this.bO(h.rq(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void rm(String str) {
        if (cXc) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.oI(str);
            cXc = false;
        }
    }

    public static boolean aCA() {
        return cXc;
    }
}
