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
/* loaded from: classes7.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dxV = false;
    private static volatile boolean dxW = false;
    private static volatile boolean dxX = false;
    private static volatile boolean dxY = false;
    private static volatile boolean dxZ = false;
    private static HashMap<String, String> dya;
    private static String dyb;

    public static synchronized void gJ(boolean z) {
        synchronized (e.class) {
            dxV = z;
        }
    }

    public static synchronized boolean aJu() {
        boolean z;
        synchronized (e.class) {
            z = dxV;
        }
        return z;
    }

    public static void aJv() {
        gJ(false);
    }

    public static void aJw() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null) {
            n(aGM.aGQ());
        }
    }

    public static void aJx() {
        com.baidu.swan.apps.adaptation.b.c aoi;
        com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
        if (afe != null) {
            com.baidu.swan.apps.core.d.c aot = afe.aot();
            if ((aot instanceof com.baidu.swan.apps.core.d.e) && (aoi = ((com.baidu.swan.apps.core.d.e) aot).aoi()) != null) {
                dyb = aoi.aib();
            }
        }
    }

    public static void cw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dya == null) {
                dya = new HashMap<>();
            }
            dya.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle aya;
        if (bVar != null && aJu() && (aya = bVar.aya()) != null && aya.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ku(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.axV();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.th(aya.getString("ubc"));
            h.onEvent(fVar);
            aya.remove("page_display_flag_for_statistic");
            aJy();
        }
    }

    private static void aJy() {
        HybridUbcFlow qF = com.baidu.swan.apps.performance.i.qF("startup");
        if (qF != null) {
            if (!(qF.aCL() || qF.aCK())) {
                qF.r("value", "fe_success");
            }
        }
    }

    public static synchronized void gK(boolean z) {
        synchronized (e.class) {
            dxW = z;
        }
    }

    public static void aJz() {
        gK(false);
    }

    public static void aJA() {
        aJv();
        gM(false);
        aJz();
        aJC();
    }

    private static synchronized void gL(boolean z) {
        synchronized (e.class) {
            dxX = z;
        }
    }

    private static boolean aJB() {
        return dxX;
    }

    public static void aJC() {
        gL(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            gK(true);
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
        com.baidu.swan.apps.runtime.e aGM;
        b.a aGQ;
        if (!aJE() && !aJB() && dVar != null && (aGM = com.baidu.swan.apps.runtime.e.aGM()) != null && (aGQ = aGM.aGQ()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            gK(true);
            gL(true);
            a(aGQ, dVar.ctZ, "0", dVar.cua, sT(dVar.cue), false);
        }
    }

    private static String sT(String str) {
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
        if (aVar != null && !aJB()) {
            gL(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void gM(boolean z) {
        dxY = z;
    }

    public static boolean aJD() {
        return dxY;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dxY) {
            gM(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aJE() {
        return dxW;
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
            fVar.mFrom = h.ku(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.all()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.axV();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.ca(jSONObject);
            }
            Bundle aya = aVar.aya();
            if (aya != null) {
                fVar.th(aya.getString("ubc"));
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
        com.baidu.swan.apps.y.e.qo(dyb);
        if (!aJE() && !aJB()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dya != null) {
            str2 = dya.get(dyb);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aJz();
        dxZ = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ku(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.axV();
        fVar.mType = "show";
        final String axX = bVar.axX();
        final String string = bVar.ayb().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.cb(h.sY(axX));
                com.baidu.swan.apps.statistic.a.f.this.th(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.th(str2);
                com.baidu.swan.apps.statistic.a.f.this.cb(h.sY(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sU(String str) {
        if (dxZ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qo(str);
            dxZ = false;
        }
    }

    public static boolean aJF() {
        return dxZ;
    }
}
