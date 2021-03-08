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
/* loaded from: classes8.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean dMr = false;
    private static volatile boolean dMs = false;
    private static volatile boolean dMt = false;
    private static volatile boolean dMu = false;
    private static volatile boolean dMv = false;
    private static HashMap<String, String> dMw;
    private static String dMx;

    public static synchronized void ho(boolean z) {
        synchronized (e.class) {
            dMr = z;
        }
    }

    public static synchronized boolean aLv() {
        boolean z;
        synchronized (e.class) {
            z = dMr;
        }
        return z;
    }

    public static void aLw() {
        ho(false);
    }

    public static void aLx() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null) {
            n(aIN.aIR());
        }
    }

    public static void aLy() {
        com.baidu.swan.apps.adaptation.b.c app;
        com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
        if (aga != null) {
            com.baidu.swan.apps.core.d.c apA = aga.apA();
            if ((apA instanceof com.baidu.swan.apps.core.d.e) && (app = ((com.baidu.swan.apps.core.d.e) apA).app()) != null) {
                dMx = app.ajb();
            }
        }
    }

    public static void cv(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dMw == null) {
                dMw = new HashMap<>();
            }
            dMw.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle azi;
        if (bVar != null && aLv() && (azi = bVar.azi()) != null && azi.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jv(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.azd();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.ta(azi.getString("ubc"));
            h.onEvent(fVar);
            azi.remove("page_display_flag_for_statistic");
            aLz();
        }
    }

    private static void aLz() {
        HybridUbcFlow qt = com.baidu.swan.apps.performance.i.qt("startup");
        if (qt != null) {
            if (!(qt.aDT() || qt.aDS())) {
                qt.p("value", "fe_success");
            }
        }
    }

    public static synchronized void hp(boolean z) {
        synchronized (e.class) {
            dMs = z;
        }
    }

    public static void aLA() {
        hp(false);
    }

    public static void aLB() {
        aLw();
        hr(false);
        aLA();
        aLD();
    }

    private static synchronized void hq(boolean z) {
        synchronized (e.class) {
            dMt = z;
        }
    }

    private static boolean aLC() {
        return dMt;
    }

    public static void aLD() {
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
        com.baidu.swan.apps.runtime.e aIN;
        b.a aIR;
        if (!aLF() && !aLC() && dVar != null && (aIN = com.baidu.swan.apps.runtime.e.aIN()) != null && (aIR = aIN.aIR()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            hp(true);
            hq(true);
            a(aIR, dVar.cET, "0", dVar.cEU, sM(dVar.cEY), false);
        }
    }

    private static String sM(String str) {
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
        if (aVar != null && !aLC()) {
            hq(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void hr(boolean z) {
        dMu = z;
    }

    public static boolean aLE() {
        return dMu;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dMu) {
            hr(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aLF() {
        return dMs;
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
            fVar.mFrom = h.jv(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.amn()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.azd();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.s("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.cj(jSONObject);
            }
            Bundle azi = aVar.azi();
            if (azi != null) {
                fVar.ta(azi.getString("ubc"));
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
        com.baidu.swan.apps.y.e.qd(dMx);
        if (!aLF() && !aLC()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dMw != null) {
            str2 = dMw.get(dMx);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aLA();
        dMv = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jv(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.azd();
        fVar.mType = "show";
        final String azf = bVar.azf();
        final String string = bVar.azj().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.ck(h.sR(azf));
                com.baidu.swan.apps.statistic.a.f.this.ta(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.ta(str2);
                com.baidu.swan.apps.statistic.a.f.this.ck(h.sR(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sN(String str) {
        if (dMv) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.qd(str);
            dMv = false;
        }
    }

    public static boolean aLG() {
        return dMv;
    }
}
