package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dKQ = false;
    private static volatile boolean dKR = false;
    private static volatile boolean dKS = false;
    private static volatile boolean dKT = false;
    private static volatile boolean dKU = false;
    private static HashMap<String, String> dKV;
    private static String dKW;

    public static synchronized void ho(boolean z) {
        synchronized (e.class) {
            dKQ = z;
        }
    }

    public static synchronized boolean aLs() {
        boolean z;
        synchronized (e.class) {
            z = dKQ;
        }
        return z;
    }

    public static void aLt() {
        ho(false);
    }

    public static void aLu() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null) {
            n(aIK.aIO());
        }
    }

    public static void aLv() {
        com.baidu.swan.apps.adaptation.b.c apm;
        com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
        if (afX != null) {
            com.baidu.swan.apps.core.d.c apx = afX.apx();
            if ((apx instanceof com.baidu.swan.apps.core.d.e) && (apm = ((com.baidu.swan.apps.core.d.e) apx).apm()) != null) {
                dKW = apm.aiY();
            }
        }
    }

    public static void cv(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dKV == null) {
                dKV = new HashMap<>();
            }
            dKV.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle azf;
        if (bVar != null && aLs() && (azf = bVar.azf()) != null && azf.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ju(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aza();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.sT(azf.getString("ubc"));
            h.onEvent(fVar);
            azf.remove("page_display_flag_for_statistic");
            aLw();
        }
    }

    private static void aLw() {
        HybridUbcFlow qm = com.baidu.swan.apps.performance.i.qm("startup");
        if (qm != null) {
            if (!(qm.aDQ() || qm.aDP())) {
                qm.o("value", "fe_success");
            }
        }
    }

    public static synchronized void hp(boolean z) {
        synchronized (e.class) {
            dKR = z;
        }
    }

    public static void aLx() {
        hp(false);
    }

    public static void aLy() {
        aLt();
        hr(false);
        aLx();
        aLA();
    }

    private static synchronized void hq(boolean z) {
        synchronized (e.class) {
            dKS = z;
        }
    }

    private static boolean aLz() {
        return dKS;
    }

    public static void aLA() {
        hq(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hp(true);
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
        com.baidu.swan.apps.runtime.e aIK;
        b.a aIO;
        if (!aLC() && !aLz() && dVar != null && (aIK = com.baidu.swan.apps.runtime.e.aIK()) != null && (aIO = aIK.aIO()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            hp(true);
            hq(true);
            a(aIO, dVar.cDt, "0", dVar.cDu, sF(dVar.cDy), false);
        }
    }

    private static String sF(String str) {
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
        if (aVar != null && !aLz()) {
            hq(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void hr(boolean z) {
        dKT = z;
    }

    public static boolean aLB() {
        return dKT;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dKT) {
            hr(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aLC() {
        return dKR;
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
            fVar.mFrom = h.ju(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.amk()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.aza();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.r("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.ch(jSONObject);
            }
            Bundle azf = aVar.azf();
            if (azf != null) {
                fVar.sT(azf.getString("ubc"));
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
        com.baidu.swan.apps.y.e.pW(dKW);
        if (!aLC() && !aLz()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dKV != null) {
            str2 = dKV.get(dKW);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aLx();
        dKU = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ju(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.aza();
        fVar.mType = "show";
        final String azc = bVar.azc();
        final String string = bVar.azg().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.ci(h.sK(azc));
                com.baidu.swan.apps.statistic.a.f.this.sT(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.sT(str2);
                com.baidu.swan.apps.statistic.a.f.this.ci(h.sK(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sG(String str) {
        if (dKU) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.pW(str);
            dKU = false;
        }
    }

    public static boolean aLD() {
        return dKU;
    }
}
