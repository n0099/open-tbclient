package com.baidu.swan.apps.statistic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean cYY = false;
    private static volatile boolean cYZ = false;
    private static volatile boolean cZa = false;
    private static volatile boolean cZb = false;
    private static volatile boolean cZc = false;
    private static HashMap<String, String> cZd;
    private static String cZe;

    public static synchronized void fO(boolean z) {
        synchronized (e.class) {
            cYY = z;
        }
    }

    public static synchronized boolean aCZ() {
        boolean z;
        synchronized (e.class) {
            z = cYY;
        }
        return z;
    }

    public static void aDa() {
        fO(false);
    }

    public static void aDb() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null) {
            n(aAr.aAv());
        }
    }

    public static void aDc() {
        com.baidu.swan.apps.adaptation.b.c ahL;
        com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
        if (YG != null) {
            com.baidu.swan.apps.core.d.c ahW = YG.ahW();
            if ((ahW instanceof com.baidu.swan.apps.core.d.e) && (ahL = ((com.baidu.swan.apps.core.d.e) ahW).ahL()) != null) {
                cZe = ahL.abD();
            }
        }
    }

    public static void cl(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (cZd == null) {
                cZd = new HashMap<>();
            }
            cZd.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle arC;
        if (bVar != null && aCZ() && (arC = bVar.arC()) != null && arC.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jG(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.arx();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.rS(arC.getString("ubc"));
            h.onEvent(fVar);
            arC.remove("page_display_flag_for_statistic");
            aDd();
        }
    }

    private static void aDd() {
        HybridUbcFlow ps = com.baidu.swan.apps.performance.i.ps("startup");
        if (ps != null) {
            if (!(ps.awo() || ps.awn())) {
                ps.r("value", "fe_success");
            }
        }
    }

    public static synchronized void fP(boolean z) {
        synchronized (e.class) {
            cYZ = z;
        }
    }

    public static void aDe() {
        fP(false);
    }

    public static void aDf() {
        aDa();
        fR(false);
        aDe();
        aDh();
    }

    private static synchronized void fQ(boolean z) {
        synchronized (e.class) {
            cZa = z;
        }
    }

    private static boolean aDg() {
        return cZa;
    }

    public static void aDh() {
        fQ(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fP(true);
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
        com.baidu.swan.apps.runtime.e aAr;
        b.a aAv;
        if (!aDj() && !aDg() && dVar != null && (aAr = com.baidu.swan.apps.runtime.e.aAr()) != null && (aAv = aAr.aAv()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            fP(true);
            fQ(true);
            a(aAv, dVar.bUY, "0", dVar.bUZ, rE(dVar.bVd), false);
        }
    }

    private static String rE(String str) {
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
        if (aVar != null && !aDg()) {
            fQ(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void fR(boolean z) {
        cZb = z;
    }

    public static boolean aDi() {
        return cZb;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !cZb) {
            fR(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aDj() {
        return cYZ;
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
            fVar.mFrom = h.jG(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.aeO()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.arx();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.u("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bQ(jSONObject);
            }
            Bundle arC = aVar.arC();
            if (arC != null) {
                fVar.rS(arC.getString("ubc"));
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
        com.baidu.swan.apps.y.e.pb(cZe);
        if (!aDj() && !aDg()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (cZd != null) {
            str2 = cZd.get(cZe);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aDe();
        cZc = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jG(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.arx();
        fVar.mType = "show";
        final String arz = bVar.arz();
        final String string = bVar.arD().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.bR(h.rJ(arz));
                com.baidu.swan.apps.statistic.a.f.this.rS(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.rS(str2);
                com.baidu.swan.apps.statistic.a.f.this.bR(h.rJ(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void rF(String str) {
        if (cZc) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.pb(str);
            cZc = false;
        }
    }

    public static boolean aDk() {
        return cZc;
    }
}
