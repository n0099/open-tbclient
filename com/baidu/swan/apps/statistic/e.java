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
    private static volatile boolean cKE = false;
    private static volatile boolean cKF = false;
    private static volatile boolean cKG = false;
    private static volatile boolean cKH = false;
    private static volatile boolean cKI = false;
    private static HashMap<String, String> cKJ;
    private static String cKK;

    public static synchronized void fn(boolean z) {
        synchronized (e.class) {
            cKE = z;
        }
    }

    public static synchronized boolean asj() {
        boolean z;
        synchronized (e.class) {
            z = cKE;
        }
        return z;
    }

    public static void ask() {
        fn(false);
    }

    public static void asl() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null) {
            p(apM.apQ());
        }
    }

    public static void asn() {
        com.baidu.swan.apps.adaptation.b.c ZM;
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN != null) {
            com.baidu.swan.apps.core.d.b ZV = RN.ZV();
            if ((ZV instanceof com.baidu.swan.apps.core.d.d) && (ZM = ((com.baidu.swan.apps.core.d.d) ZV).ZM()) != null) {
                cKK = ZM.Up();
            }
        }
    }

    public static void bT(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (cKJ == null) {
                cKJ = new HashMap<>();
            }
            cKJ.put(str, str2);
        }
    }

    public static void p(com.baidu.swan.apps.v.b.b bVar) {
        Bundle ahV;
        if (bVar != null && asj() && (ahV = bVar.ahV()) != null && ahV.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.hf(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ahQ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.oO(ahV.getString("ubc"));
            h.a("606", fVar);
            ahV.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void fo(boolean z) {
        synchronized (e.class) {
            cKF = z;
        }
    }

    public static void aso() {
        fo(false);
    }

    public static void asp() {
        ask();
        fq(false);
        aso();
        asr();
    }

    private static synchronized void fp(boolean z) {
        synchronized (e.class) {
            cKG = z;
        }
    }

    private static boolean asq() {
        return cKG;
    }

    public static void asr() {
        fp(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fo(true);
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
        com.baidu.swan.apps.runtime.e apM;
        b.a apQ;
        if (!ast() && !asq() && dVar != null && (apM = com.baidu.swan.apps.runtime.e.apM()) != null && (apQ = apM.apQ()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            fo(true);
            fp(true);
            a(apQ, dVar.bMF, "0", dVar.bMG, oB(dVar.bMK), false);
        }
    }

    private static String oB(String str) {
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
        if (aVar != null && !asq()) {
            fp(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void fq(boolean z) {
        cKH = z;
    }

    public static boolean ass() {
        return cKH;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !cKH) {
            fq(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean ast() {
        return cKF;
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
            fVar.mFrom = h.hf(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.Xs()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.ahQ();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.v("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bA(jSONObject);
            }
            Bundle ahV = aVar.ahV();
            if (ahV != null) {
                fVar.oO(ahV.getString("ubc"));
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
        com.baidu.swan.apps.aa.e.mk(cKK);
        if (!ast() && !asq()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (cKJ != null) {
            str2 = cKJ.get(cKK);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        aso();
        cKI = true;
    }

    public static void oC(String str) {
        if (cKI) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.aa.e.mk(str);
            cKI = false;
        }
    }

    public static boolean asu() {
        return cKI;
    }
}
