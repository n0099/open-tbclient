package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.x.b.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean bPV = false;
    private static volatile boolean bPW = false;
    private static volatile boolean bPX = false;
    private static volatile boolean bPY = false;
    private static volatile boolean bPZ = false;
    private static HashMap<String, String> bQa;
    private static String bQb;

    public static synchronized void dF(boolean z) {
        synchronized (c.class) {
            bPV = z;
        }
    }

    public static synchronized boolean aca() {
        boolean z;
        synchronized (c.class) {
            z = bPV;
        }
        return z;
    }

    public static void acb() {
        dF(false);
    }

    public static void acc() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null) {
            n(ZS.ZV());
        }
    }

    public static void acd() {
        com.baidu.swan.apps.adaptation.b.c Lr;
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP != null) {
            com.baidu.swan.apps.core.d.b LB = DP.LB();
            if ((LB instanceof com.baidu.swan.apps.core.d.d) && (Lr = ((com.baidu.swan.apps.core.d.d) LB).Lr()) != null) {
                bQb = Lr.Ge();
            }
        }
    }

    public static void bd(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (bQa == null) {
                bQa = new HashMap<>();
            }
            bQa.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle Tb;
        if (bVar != null && aca() && (Tb = bVar.Tb()) != null && Tb.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.ga(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.SW();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.lz(Tb.getString("ubc"));
            f.a("606", fVar);
            Tb.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void dG(boolean z) {
        synchronized (c.class) {
            bPW = z;
        }
    }

    public static void ace() {
        dG(false);
    }

    public static void acf() {
        acb();
        dI(false);
        ace();
        ach();
    }

    private static synchronized void dH(boolean z) {
        synchronized (c.class) {
            bPX = z;
        }
    }

    private static boolean acg() {
        return bPX;
    }

    public static void ach() {
        dH(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dG(true);
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
        com.baidu.swan.apps.runtime.e ZS;
        b.a ZV;
        if (!acj() && !acg() && dVar != null && (ZS = com.baidu.swan.apps.runtime.e.ZS()) != null && (ZV = ZS.ZV()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            dG(true);
            dH(true);
            a(ZV, dVar.aWx, "0", dVar.aWy, TextUtils.equals(dVar.aWz, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !acg()) {
            dH(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void dI(boolean z) {
        bPY = z;
    }

    public static boolean aci() {
        return bPY;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !bPY) {
            dI(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean acj() {
        return bPW;
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
            fVar.mFrom = f.ga(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.Jc()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.SW();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.n("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.aZ(jSONObject);
            }
            Bundle Tb = aVar.Tb();
            if (Tb != null) {
                fVar.lz(Tb.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.jk(bQb);
        if (!acj() && !acg()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (bQa != null) {
            str2 = bQa.get(bQb);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        ace();
        bPZ = true;
    }

    public static void lo(String str) {
        if (bPZ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.jk(str);
            bPZ = false;
        }
    }

    public static boolean ack() {
        return bPZ;
    }
}
