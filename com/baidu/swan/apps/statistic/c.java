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
    private static volatile boolean bUM = false;
    private static volatile boolean bUN = false;
    private static volatile boolean bUO = false;
    private static volatile boolean bUP = false;
    private static volatile boolean bUQ = false;
    private static HashMap<String, String> bUR;
    private static String bUS;

    public static synchronized void dR(boolean z) {
        synchronized (c.class) {
            bUM = z;
        }
    }

    public static synchronized boolean aeN() {
        boolean z;
        synchronized (c.class) {
            z = bUM;
        }
        return z;
    }

    public static void aeO() {
        dR(false);
    }

    public static void aeP() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null) {
            n(acF.acI());
        }
    }

    public static void aeQ() {
        com.baidu.swan.apps.adaptation.b.c Od;
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC != null) {
            com.baidu.swan.apps.core.d.b On = GC.On();
            if ((On instanceof com.baidu.swan.apps.core.d.d) && (Od = ((com.baidu.swan.apps.core.d.d) On).Od()) != null) {
                bUS = Od.IR();
            }
        }
    }

    public static void bn(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (bUR == null) {
                bUR = new HashMap<>();
            }
            bUR.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.x.b.b bVar) {
        Bundle VO;
        if (bVar != null && aeN() && (VO = bVar.VO()) != null && VO.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = f.gs(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.VJ();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.lR(VO.getString("ubc"));
            f.a("606", fVar);
            VO.remove("page_display_flag_for_statistic");
        }
    }

    public static synchronized void dS(boolean z) {
        synchronized (c.class) {
            bUN = z;
        }
    }

    public static void aeR() {
        dS(false);
    }

    public static void aeS() {
        aeO();
        dU(false);
        aeR();
        aeU();
    }

    private static synchronized void dT(boolean z) {
        synchronized (c.class) {
            bUO = z;
        }
    }

    private static boolean aeT() {
        return bUO;
    }

    public static void aeU() {
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
        com.baidu.swan.apps.runtime.e acF;
        b.a acI;
        if (!aeW() && !aeT() && dVar != null && (acF = com.baidu.swan.apps.runtime.e.acF()) != null && (acI = acF.acI()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            dS(true);
            dT(true);
            a(acI, dVar.bbC, "0", dVar.bbD, TextUtils.equals(dVar.bbE, "1") ? "2" : "0", false);
        }
    }

    public static void a(b.a aVar) {
        if (aVar != null && !aeT()) {
            dT(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void dU(boolean z) {
        bUP = z;
    }

    public static boolean aeV() {
        return bUP;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !bUP) {
            dU(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aeW() {
        return bUN;
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
            if (com.baidu.swan.apps.console.debugger.a.e.LP()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.VJ();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.n("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.aZ(jSONObject);
            }
            Bundle VO = aVar.VO();
            if (VO != null) {
                fVar.lR(VO.getString("ubc"));
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
        com.baidu.swan.apps.ac.e.jC(bUS);
        if (!aeW() && !aeT()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (bUR != null) {
            str2 = bUR.get(bUS);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        aeR();
        bUQ = true;
    }

    public static void lG(String str) {
        if (bUQ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.ac.e.jC(str);
            bUQ = false;
        }
    }

    public static boolean aeX() {
        return bUQ;
    }
}
