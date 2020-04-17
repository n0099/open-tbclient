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
    private static volatile boolean ctN = false;
    private static volatile boolean ctO = false;
    private static volatile boolean ctP = false;
    private static volatile boolean ctQ = false;
    private static volatile boolean ctR = false;
    private static HashMap<String, String> ctS;
    private static String ctT;

    public static synchronized void eO(boolean z) {
        synchronized (c.class) {
            ctN = z;
        }
    }

    public static synchronized boolean amV() {
        boolean z;
        synchronized (c.class) {
            z = ctN;
        }
        return z;
    }

    public static void amW() {
        eO(false);
    }

    public static void amX() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null) {
            n(akN.akQ());
        }
    }

    public static void amY() {
        com.baidu.swan.apps.adaptation.b.c VU;
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou != null) {
            com.baidu.swan.apps.core.d.b We = Ou.We();
            if ((We instanceof com.baidu.swan.apps.core.d.d) && (VU = ((com.baidu.swan.apps.core.d.d) We).VU()) != null) {
                ctT = VU.QG();
            }
        }
    }

    public static void bw(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (ctS == null) {
                ctS = new HashMap<>();
            }
            ctS.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle adG;
        if (bVar != null && amV() && (adG = bVar.adG()) != null && adG.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gz(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.adB();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.nd(adG.getString("ubc"));
            f.a("606", fVar);
            adG.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void eP(boolean z) {
        synchronized (c.class) {
            ctO = z;
        }
    }

    public static void amZ() {
        eP(false);
    }

    public static void ana() {
        amW();
        eR(false);
        amZ();
        anc();
    }

    private static synchronized void eQ(boolean z) {
        synchronized (c.class) {
            ctP = z;
        }
    }

    private static boolean anb() {
        return ctP;
    }

    public static void anc() {
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
        com.baidu.swan.apps.runtime.e akN;
        b.a akQ;
        if (!ane() && !anb() && dVar != null && (akN = com.baidu.swan.apps.runtime.e.akN()) != null && (akQ = akN.akQ()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            eP(true);
            eQ(true);
            a(akQ, dVar.bAd, "0", dVar.bAe, TextUtils.equals(dVar.bAf, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !anb()) {
            eQ(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void eR(boolean z) {
        ctQ = z;
    }

    public static boolean and() {
        return ctQ;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !ctQ) {
            eR(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean ane() {
        return ctO;
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
            if (com.baidu.swan.apps.console.debugger.a.e.TG()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.adB();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.s("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bk(jSONObject);
            }
            Bundle adG = aVar.adG();
            if (adG != null) {
                fVar.nd(adG.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.kO(ctT);
        if (!ane() && !anb()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (ctS != null) {
            str2 = ctS.get(ctT);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        amZ();
        ctR = true;
    }

    public static void mS(String str) {
        if (ctR) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.kO(str);
            ctR = false;
        }
    }

    public static boolean anf() {
        return ctR;
    }
}
