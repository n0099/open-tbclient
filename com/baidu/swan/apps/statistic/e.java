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
    private static HashMap<String, String> dND;
    private static String dNE;
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dNy = false;
    private static volatile boolean dNz = false;
    private static volatile boolean dNA = false;
    private static volatile boolean dNB = false;
    private static volatile boolean dNC = false;

    public static synchronized void hq(boolean z) {
        synchronized (e.class) {
            dNy = z;
        }
    }

    public static synchronized boolean aOT() {
        boolean z;
        synchronized (e.class) {
            z = dNy;
        }
        return z;
    }

    public static void aOU() {
        hq(false);
    }

    public static void aOV() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null) {
            n(aMl.aMp());
        }
    }

    public static void aOW() {
        com.baidu.swan.apps.adaptation.b.c asJ;
        com.baidu.swan.apps.core.d.f ajt = com.baidu.swan.apps.v.f.aDH().ajt();
        if (ajt != null) {
            com.baidu.swan.apps.core.d.c asU = ajt.asU();
            if ((asU instanceof com.baidu.swan.apps.core.d.e) && (asJ = ((com.baidu.swan.apps.core.d.e) asU).asJ()) != null) {
                dNE = asJ.amu();
            }
        }
    }

    public static void cC(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dND == null) {
                dND = new HashMap<>();
            }
            dND.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle aCB;
        if (bVar != null && aOT() && (aCB = bVar.aCB()) != null && aCB.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.kX(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.aCw();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.tL(aCB.getString("ubc"));
            h.onEvent(fVar);
            aCB.remove("page_display_flag_for_statistic");
            aOX();
        }
    }

    private static void aOX() {
        HybridUbcFlow rf = com.baidu.swan.apps.performance.i.rf("startup");
        if (rf != null) {
            if (!(rf.aHo() || rf.aHn())) {
                rf.q("value", "fe_success");
            }
        }
    }

    public static synchronized void hr(boolean z) {
        synchronized (e.class) {
            dNz = z;
        }
    }

    public static void aOY() {
        hr(false);
    }

    public static void aOZ() {
        aOU();
        ht(false);
        aOY();
        aPb();
    }

    private static synchronized void hs(boolean z) {
        synchronized (e.class) {
            dNA = z;
        }
    }

    private static boolean aPa() {
        return dNA;
    }

    public static void aPb() {
        hs(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hr(true);
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
        com.baidu.swan.apps.runtime.e aMl;
        b.a aMp;
        if (!aPd() && !aPa() && dVar != null && (aMl = com.baidu.swan.apps.runtime.e.aMl()) != null && (aMp = aMl.aMp()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            hr(true);
            hs(true);
            a(aMp, dVar.cFJ, "0", dVar.cFK, tx(dVar.cFO), false);
        }
    }

    private static String tx(String str) {
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
        if (aVar != null && !aPa()) {
            hs(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void ht(boolean z) {
        dNB = z;
    }

    public static boolean aPc() {
        return dNB;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dNB) {
            ht(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aPd() {
        return dNz;
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
            fVar.mFrom = h.kX(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.apH()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.aCw();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.t("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.ck(jSONObject);
            }
            Bundle aCB = aVar.aCB();
            if (aCB != null) {
                fVar.tL(aCB.getString("ubc"));
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
        com.baidu.swan.apps.y.e.qP(dNE);
        if (!aPd() && !aPa()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dND != null) {
            str2 = dND.get(dNE);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aOY();
        dNC = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kX(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.aCw();
        fVar.mType = "show";
        final String aCy = bVar.aCy();
        final String string = bVar.aCC().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.cl(h.tC(aCy));
                com.baidu.swan.apps.statistic.a.f.this.tL(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.tL(str2);
                com.baidu.swan.apps.statistic.a.f.this.cl(h.tC(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void ty(String str) {
        if (dNC) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qP(str);
            dNC = false;
        }
    }

    public static boolean aPe() {
        return dNC;
    }
}
