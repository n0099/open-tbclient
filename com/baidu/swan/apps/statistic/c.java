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
    private static volatile boolean bUK = false;
    private static volatile boolean bUL = false;
    private static volatile boolean bUM = false;
    private static volatile boolean bUN = false;
    private static volatile boolean bUO = false;
    private static HashMap<String, String> bUP;
    private static String bUQ;

    public static synchronized void dR(boolean z) {
        synchronized (c.class) {
            bUK = z;
        }
    }

    public static synchronized boolean aeL() {
        boolean z;
        synchronized (c.class) {
            z = bUK;
        }
        return z;
    }

    public static void aeM() {
        dR(false);
    }

    public static void aeN() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null) {
            n(acD.acG());
        }
    }

    public static void aeO() {
        com.baidu.swan.apps.adaptation.b.c Ob;
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA != null) {
            com.baidu.swan.apps.core.d.b Ol = GA.Ol();
            if ((Ol instanceof com.baidu.swan.apps.core.d.d) && (Ob = ((com.baidu.swan.apps.core.d.d) Ol).Ob()) != null) {
                bUQ = Ob.IP();
            }
        }
    }

    public static void bn(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (bUP == null) {
                bUP = new HashMap<>();
            }
            bUP.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle VM;
        if (bVar != null && aeL() && (VM = bVar.VM()) != null && VM.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gs(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.VH();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.lR(VM.getString("ubc"));
            f.a("606", fVar);
            VM.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void dS(boolean z) {
        synchronized (c.class) {
            bUL = z;
        }
    }

    public static void aeP() {
        dS(false);
    }

    public static void aeQ() {
        aeM();
        dU(false);
        aeP();
        aeS();
    }

    private static synchronized void dT(boolean z) {
        synchronized (c.class) {
            bUM = z;
        }
    }

    private static boolean aeR() {
        return bUM;
    }

    public static void aeS() {
        dT(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            dS(true);
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
        com.baidu.swan.apps.runtime.e acD;
        b.a acG;
        if (!aeU() && !aeR() && dVar != null && (acD = com.baidu.swan.apps.runtime.e.acD()) != null && (acG = acD.acG()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            dS(true);
            dT(true);
            a(acG, dVar.bbA, "0", dVar.bbB, TextUtils.equals(dVar.bbC, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !aeR()) {
            dT(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void dU(boolean z) {
        bUN = z;
    }

    public static boolean aeT() {
        return bUN;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !bUN) {
            dU(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aeU() {
        return bUL;
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
            if (com.baidu.swan.apps.console.debugger.a.e.LN()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.VH();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.n("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.aZ(jSONObject);
            }
            Bundle VM = aVar.VM();
            if (VM != null) {
                fVar.lR(VM.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.jC(bUQ);
        if (!aeU() && !aeR()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (bUP != null) {
            str2 = bUP.get(bUQ);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        aeP();
        bUO = true;
    }

    public static void lG(String str) {
        if (bUO) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.jC(str);
            bUO = false;
        }
    }

    public static boolean aeV() {
        return bUO;
    }
}
