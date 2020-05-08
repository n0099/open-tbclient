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
    private static volatile boolean ctT = false;
    private static volatile boolean ctU = false;
    private static volatile boolean ctV = false;
    private static volatile boolean ctW = false;
    private static volatile boolean ctX = false;
    private static HashMap<String, String> ctY;
    private static String ctZ;

    public static synchronized void eO(boolean z) {
        synchronized (c.class) {
            ctT = z;
        }
    }

    public static synchronized boolean amU() {
        boolean z;
        synchronized (c.class) {
            z = ctT;
        }
        return z;
    }

    public static void amV() {
        eO(false);
    }

    public static void amW() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null) {
            n(akM.akP());
        }
    }

    public static void amX() {
        com.baidu.swan.apps.adaptation.b.c VT;
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot != null) {
            com.baidu.swan.apps.core.d.b Wd = Ot.Wd();
            if ((Wd instanceof com.baidu.swan.apps.core.d.d) && (VT = ((com.baidu.swan.apps.core.d.d) Wd).VT()) != null) {
                ctZ = VT.QF();
            }
        }
    }

    public static void bw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (ctY == null) {
                ctY = new HashMap<>();
            }
            ctY.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle adF;
        if (bVar != null && amU() && (adF = bVar.adF()) != null && adF.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gz(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.adA();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.nd(adF.getString("ubc"));
            f.a("606", fVar);
            adF.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void eP(boolean z) {
        synchronized (c.class) {
            ctU = z;
        }
    }

    public static void amY() {
        eP(false);
    }

    public static void amZ() {
        amV();
        eR(false);
        amY();
        anb();
    }

    private static synchronized void eQ(boolean z) {
        synchronized (c.class) {
            ctV = z;
        }
    }

    private static boolean ana() {
        return ctV;
    }

    public static void anb() {
        eQ(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            eP(true);
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
        com.baidu.swan.apps.runtime.e akM;
        b.a akP;
        if (!and() && !ana() && dVar != null && (akM = com.baidu.swan.apps.runtime.e.akM()) != null && (akP = akM.akP()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            eP(true);
            eQ(true);
            a(akP, dVar.bAi, "0", dVar.bAj, TextUtils.equals(dVar.bAk, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !ana()) {
            eQ(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void eR(boolean z) {
        ctW = z;
    }

    public static boolean anc() {
        return ctW;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !ctW) {
            eR(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean and() {
        return ctU;
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
            fVar.mFrom = f.gz(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.TF()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.adA();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.s("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bk(jSONObject);
            }
            Bundle adF = aVar.adF();
            if (adF != null) {
                fVar.nd(adF.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.kO(ctZ);
        if (!and() && !ana()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (ctY != null) {
            str2 = ctY.get(ctZ);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        amY();
        ctX = true;
    }

    public static void mS(String str) {
        if (ctX) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.kO(str);
            ctX = false;
        }
    }

    public static boolean ane() {
        return ctX;
    }
}
