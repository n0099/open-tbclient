package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.x.b.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean bQF = false;
    private static volatile boolean bQG = false;
    private static volatile boolean bQH = false;
    private static volatile boolean bQI = false;
    private static volatile boolean bQJ = false;
    private static HashMap<String, String> bQK;
    private static String bQL;

    public static synchronized void dK(boolean z) {
        synchronized (c.class) {
            bQF = z;
        }
    }

    public static synchronized boolean acx() {
        boolean z;
        synchronized (c.class) {
            z = bQF;
        }
        return z;
    }

    public static void acy() {
        dK(false);
    }

    public static void acz() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null) {
            n(aap.aas());
        }
    }

    public static void acA() {
        com.baidu.swan.apps.adaptation.b.c LN;
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El != null) {
            com.baidu.swan.apps.core.d.b LX = El.LX();
            if ((LX instanceof com.baidu.swan.apps.core.d.d) && (LN = ((com.baidu.swan.apps.core.d.d) LX).LN()) != null) {
                bQL = LN.GA();
            }
        }
    }

    public static void be(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (bQK == null) {
                bQK = new HashMap<>();
            }
            bQK.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle Ty;
        if (bVar != null && acx() && (Ty = bVar.Ty()) != null && Ty.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gb(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.Tt();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.lC(Ty.getString("ubc"));
            f.a("606", fVar);
            Ty.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void dL(boolean z) {
        synchronized (c.class) {
            bQG = z;
        }
    }

    public static void acB() {
        dL(false);
    }

    public static void acC() {
        acy();
        dN(false);
        acB();
        acE();
    }

    private static synchronized void dM(boolean z) {
        synchronized (c.class) {
            bQH = z;
        }
    }

    private static boolean acD() {
        return bQH;
    }

    public static void acE() {
        dM(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dL(true);
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
        com.baidu.swan.apps.runtime.e aap;
        b.a aas;
        if (!acG() && !acD() && dVar != null && (aap = com.baidu.swan.apps.runtime.e.aap()) != null && (aas = aap.aas()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            dL(true);
            dM(true);
            a(aas, dVar.aXp, "0", dVar.aXq, TextUtils.equals(dVar.aXr, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !acD()) {
            dM(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void dN(boolean z) {
        bQI = z;
    }

    public static boolean acF() {
        return bQI;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !bQI) {
            dN(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean acG() {
        return bQG;
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
            fVar.mFrom = f.gb(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.Jy()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.Tt();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.n("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.aZ(jSONObject);
            }
            Bundle Ty = aVar.Ty();
            if (Ty != null) {
                fVar.lC(Ty.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.jn(bQL);
        if (!acG() && !acD()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (bQK != null) {
            str2 = bQK.get(bQL);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        acB();
        bQJ = true;
    }

    public static void lr(String str) {
        if (bQJ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.jn(str);
            bQJ = false;
        }
    }

    public static boolean acH() {
        return bQJ;
    }
}
