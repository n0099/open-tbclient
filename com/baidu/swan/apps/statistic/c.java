package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.x.b.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean bUX = false;
    private static volatile boolean bUY = false;
    private static volatile boolean bUZ = false;
    private static volatile boolean bVa = false;
    private static volatile boolean bVb = false;
    private static HashMap<String, String> bVc;
    private static String bVd;

    public static synchronized void dS(boolean z) {
        synchronized (c.class) {
            bUX = z;
        }
    }

    public static synchronized boolean aeQ() {
        boolean z;
        synchronized (c.class) {
            z = bUX;
        }
        return z;
    }

    public static void aeR() {
        dS(false);
    }

    public static void aeS() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null) {
            n(acI.acL());
        }
    }

    public static void aeT() {
        com.baidu.swan.apps.adaptation.b.c Og;
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH != null) {
            com.baidu.swan.apps.core.d.b Oq = GH.Oq();
            if ((Oq instanceof com.baidu.swan.apps.core.d.d) && (Og = ((com.baidu.swan.apps.core.d.d) Oq).Og()) != null) {
                bVd = Og.IU();
            }
        }
    }

    public static void bm(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (bVc == null) {
                bVc = new HashMap<>();
            }
            bVc.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle VR;
        if (bVar != null && aeQ() && (VR = bVar.VR()) != null && VR.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gs(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.VM();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.lQ(VR.getString("ubc"));
            f.a("606", fVar);
            VR.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void dT(boolean z) {
        synchronized (c.class) {
            bUY = z;
        }
    }

    public static void aeU() {
        dT(false);
    }

    public static void aeV() {
        aeR();
        dV(false);
        aeU();
        aeX();
    }

    private static synchronized void dU(boolean z) {
        synchronized (c.class) {
            bUZ = z;
        }
    }

    private static boolean aeW() {
        return bUZ;
    }

    public static void aeX() {
        dU(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dT(true);
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
        com.baidu.swan.apps.runtime.e acI;
        b.a acL;
        if (!aeZ() && !aeW() && dVar != null && (acI = com.baidu.swan.apps.runtime.e.acI()) != null && (acL = acI.acL()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            dT(true);
            dU(true);
            a(acL, dVar.bbP, "0", dVar.bbQ, TextUtils.equals(dVar.bbR, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !aeW()) {
            dU(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void dV(boolean z) {
        bVa = z;
    }

    public static boolean aeY() {
        return bVa;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !bVa) {
            dV(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aeZ() {
        return bUY;
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
            fVar.mFrom = f.gs(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.LS()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.VM();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.n("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.aZ(jSONObject);
            }
            Bundle VR = aVar.VR();
            if (VR != null) {
                fVar.lQ(VR.getString("ubc"));
            }
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "handle record arrival event, arrivalValue " + str + " arrive time : " + j2 + " extJson :" + (jSONObject == null ? "" : jSONObject.toString()));
            }
            f.a("606", fVar);
        }
    }

    public static void c(b.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        com.baidu.swan.apps.ac.e.jB(bVd);
        if (!aeZ() && !aeW()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (bVc != null) {
            str2 = bVc.get(bVd);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        aeU();
        bVb = true;
    }

    public static void lF(String str) {
        if (bVb) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.jB(str);
            bVb = false;
        }
    }

    public static boolean afa() {
        return bVb;
    }
}
