package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.v.b.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean cFU = false;
    private static volatile boolean cFV = false;
    private static volatile boolean cFW = false;
    private static volatile boolean cFX = false;
    private static volatile boolean cFY = false;
    private static HashMap<String, String> cFZ;
    private static String cGa;

    public static synchronized void fi(boolean z) {
        synchronized (e.class) {
            cFU = z;
        }
    }

    public static synchronized boolean ard() {
        boolean z;
        synchronized (e.class) {
            z = cFU;
        }
        return z;
    }

    public static void are() {
        fi(false);
    }

    public static void arf() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null) {
            p(aoF.aoJ());
        }
    }

    public static void arg() {
        com.baidu.swan.apps.adaptation.b.c YG;
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH != null) {
            com.baidu.swan.apps.core.d.b YP = QH.YP();
            if ((YP instanceof com.baidu.swan.apps.core.d.d) && (YG = ((com.baidu.swan.apps.core.d.d) YP).YG()) != null) {
                cGa = YG.Tj();
            }
        }
    }

    public static void bR(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (cFZ == null) {
                cFZ = new HashMap<>();
            }
            cFZ.put(str, str2);
        }
    }

    public static void p(com.baidu.swan.apps.v.b.b bVar) {
        Bundle agP;
        if (bVar != null && ard() && (agP = bVar.agP()) != null && agP.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.gS(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.agK();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.oG(agP.getString("ubc"));
            h.a("606", fVar);
            agP.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void fj(boolean z) {
        synchronized (e.class) {
            cFV = z;
        }
    }

    public static void arh() {
        fj(false);
    }

    public static void ari() {
        are();
        fl(false);
        arh();
        ark();
    }

    private static synchronized void fk(boolean z) {
        synchronized (e.class) {
            cFW = z;
        }
    }

    private static boolean arj() {
        return cFW;
    }

    public static void ark() {
        fk(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fj(true);
            if (z || j > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("valuetype", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                a(aVar, "arrivesuccess", j, jSONObject);
            }
            if (z || j2 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("valuetype", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                a(aVar, "fmparrsuccess", j2, jSONObject2);
            }
        }
    }

    public static void a(com.baidu.swan.apps.adaptation.b.a.d dVar) {
        com.baidu.swan.apps.runtime.e aoF;
        b.a aoJ;
        if (!arm() && !arj() && dVar != null && (aoF = com.baidu.swan.apps.runtime.e.aoF()) != null && (aoJ = aoF.aoJ()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            fj(true);
            fk(true);
            a(aoJ, dVar.bHR, "0", dVar.bHS, ot(dVar.bHW), false);
        }
    }

    private static String ot(String str) {
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

    public static void a(b.a aVar) {
        if (aVar != null && !arj()) {
            fk(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void fl(boolean z) {
        cFX = z;
    }

    public static boolean arl() {
        return cFX;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !cFX) {
            fl(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean arm() {
        return cFV;
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
            fVar.mFrom = h.gS(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.Wm()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.agK();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.v("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bt(jSONObject);
            }
            Bundle agP = aVar.agP();
            if (agP != null) {
                fVar.oG(agP.getString("ubc"));
            }
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "handle record arrival event, arrivalValue " + str + " arrive time : " + j2 + " extJson :" + (jSONObject == null ? "" : jSONObject.toString()));
            }
            h.a("606", fVar);
        }
    }

    public static void c(b.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        com.baidu.swan.apps.aa.e.mc(cGa);
        if (!arm() && !arj()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (cFZ != null) {
            str2 = cFZ.get(cGa);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        arh();
        cFY = true;
    }

    public static void ou(String str) {
        if (cFY) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.aa.e.mc(str);
            cFY = false;
        }
    }

    public static boolean arn() {
        return cFY;
    }
}
