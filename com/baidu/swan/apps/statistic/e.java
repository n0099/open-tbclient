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
/* loaded from: classes25.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dEU = false;
    private static volatile boolean dEV = false;
    private static volatile boolean dEW = false;
    private static volatile boolean dEX = false;
    private static volatile boolean dEY = false;
    private static HashMap<String, String> dEZ;
    private static String dFa;

    public static synchronized void gY(boolean z) {
        synchronized (e.class) {
            dEU = z;
        }
    }

    public static synchronized boolean aMC() {
        boolean z;
        synchronized (e.class) {
            z = dEU;
        }
        return z;
    }

    public static void aMD() {
        gY(false);
    }

    public static void aME() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null) {
            n(aJU.aJY());
        }
    }

    public static void aMF() {
        com.baidu.swan.apps.adaptation.b.c arq;
        com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
        if (aim != null) {
            com.baidu.swan.apps.core.d.c arB = aim.arB();
            if ((arB instanceof com.baidu.swan.apps.core.d.e) && (arq = ((com.baidu.swan.apps.core.d.e) arB).arq()) != null) {
                dFa = arq.alj();
            }
        }
    }

    public static void cD(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dEZ == null) {
                dEZ = new HashMap<>();
            }
            dEZ.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle aBj;
        if (bVar != null && aMC() && (aBj = bVar.aBj()) != null && aBj.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kS(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aBe();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.tO(aBj.getString("ubc"));
            h.onEvent(fVar);
            aBj.remove("page_display_flag_for_statistic");
            aMG();
        }
    }

    private static void aMG() {
        HybridUbcFlow rm = com.baidu.swan.apps.performance.i.rm("startup");
        if (rm != null) {
            if (!(rm.aFT() || rm.aFS())) {
                rm.q("value", "fe_success");
            }
        }
    }

    public static synchronized void gZ(boolean z) {
        synchronized (e.class) {
            dEV = z;
        }
    }

    public static void aMH() {
        gZ(false);
    }

    public static void aMI() {
        aMD();
        hb(false);
        aMH();
        aMK();
    }

    private static synchronized void ha(boolean z) {
        synchronized (e.class) {
            dEW = z;
        }
    }

    private static boolean aMJ() {
        return dEW;
    }

    public static void aMK() {
        ha(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gZ(true);
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
        com.baidu.swan.apps.runtime.e aJU;
        b.a aJY;
        if (!aMM() && !aMJ() && dVar != null && (aJU = com.baidu.swan.apps.runtime.e.aJU()) != null && (aJY = aJU.aJY()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            gZ(true);
            ha(true);
            a(aJY, dVar.cAT, "0", dVar.cAU, tA(dVar.cAY), false);
        }
    }

    private static String tA(String str) {
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
        if (aVar != null && !aMJ()) {
            ha(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void hb(boolean z) {
        dEX = z;
    }

    public static boolean aML() {
        return dEX;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dEX) {
            hb(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aMM() {
        return dEV;
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
            fVar.mFrom = h.kS(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.aot()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.aBe();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.t("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.cc(jSONObject);
            }
            Bundle aBj = aVar.aBj();
            if (aBj != null) {
                fVar.tO(aBj.getString("ubc"));
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
        com.baidu.swan.apps.y.e.qV(dFa);
        if (!aMM() && !aMJ()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dEZ != null) {
            str2 = dEZ.get(dFa);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aMH();
        dEY = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kS(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.aBe();
        fVar.mType = "show";
        final String aBg = bVar.aBg();
        final String string = bVar.aBk().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.cd(h.tF(aBg));
                com.baidu.swan.apps.statistic.a.f.this.tO(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.tO(str2);
                com.baidu.swan.apps.statistic.a.f.this.cd(h.tF(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void tB(String str) {
        if (dEY) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qV(str);
            dEY = false;
        }
    }

    public static boolean aMN() {
        return dEY;
    }
}
