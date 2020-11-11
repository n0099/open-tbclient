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
    private static volatile boolean dzC = false;
    private static volatile boolean dzD = false;
    private static volatile boolean dzE = false;
    private static volatile boolean dzF = false;
    private static volatile boolean dzG = false;
    private static HashMap<String, String> dzH;
    private static String dzI;

    public static synchronized void gG(boolean z) {
        synchronized (e.class) {
            dzC = z;
        }
    }

    public static synchronized boolean aKc() {
        boolean z;
        synchronized (e.class) {
            z = dzC;
        }
        return z;
    }

    public static void aKd() {
        gG(false);
    }

    public static void aKe() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null) {
            n(aHu.aHy());
        }
    }

    public static void aKf() {
        com.baidu.swan.apps.adaptation.b.c aoQ;
        com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
        if (afM != null) {
            com.baidu.swan.apps.core.d.c apb = afM.apb();
            if ((apb instanceof com.baidu.swan.apps.core.d.e) && (aoQ = ((com.baidu.swan.apps.core.d.e) apb).aoQ()) != null) {
                dzI = aoQ.aiJ();
            }
        }
    }

    public static void cx(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dzH == null) {
                dzH = new HashMap<>();
            }
            dzH.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle ayI;
        if (bVar != null && aKc() && (ayI = bVar.ayI()) != null && ayI.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ky(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ayD();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.tm(ayI.getString("ubc"));
            h.onEvent(fVar);
            ayI.remove("page_display_flag_for_statistic");
            aKg();
        }
    }

    private static void aKg() {
        HybridUbcFlow qL = com.baidu.swan.apps.performance.i.qL("startup");
        if (qL != null) {
            if (!(qL.aDt() || qL.aDs())) {
                qL.r("value", "fe_success");
            }
        }
    }

    public static synchronized void gH(boolean z) {
        synchronized (e.class) {
            dzD = z;
        }
    }

    public static void aKh() {
        gH(false);
    }

    public static void aKi() {
        aKd();
        gJ(false);
        aKh();
        aKk();
    }

    private static synchronized void gI(boolean z) {
        synchronized (e.class) {
            dzE = z;
        }
    }

    private static boolean aKj() {
        return dzE;
    }

    public static void aKk() {
        gI(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gH(true);
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
        com.baidu.swan.apps.runtime.e aHu;
        b.a aHy;
        if (!aKm() && !aKj() && dVar != null && (aHu = com.baidu.swan.apps.runtime.e.aHu()) != null && (aHy = aHu.aHy()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            gH(true);
            gI(true);
            a(aHy, dVar.cvL, "0", dVar.cvM, sY(dVar.cvQ), false);
        }
    }

    private static String sY(String str) {
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
        if (aVar != null && !aKj()) {
            gI(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void gJ(boolean z) {
        dzF = z;
    }

    public static boolean aKl() {
        return dzF;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dzF) {
            gJ(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aKm() {
        return dzD;
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
            fVar.mFrom = h.ky(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.alT()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.ayD();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.cg(jSONObject);
            }
            Bundle ayI = aVar.ayI();
            if (ayI != null) {
                fVar.tm(ayI.getString("ubc"));
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
        com.baidu.swan.apps.y.e.qu(dzI);
        if (!aKm() && !aKj()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dzH != null) {
            str2 = dzH.get(dzI);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aKh();
        dzG = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ky(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.ayD();
        fVar.mType = "show";
        final String ayF = bVar.ayF();
        final String string = bVar.ayJ().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.ch(h.td(ayF));
                com.baidu.swan.apps.statistic.a.f.this.tm(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.tm(str2);
                com.baidu.swan.apps.statistic.a.f.this.ch(h.td(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sZ(String str) {
        if (dzG) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qu(str);
            dzG = false;
        }
    }

    public static boolean aKn() {
        return dzG;
    }
}
