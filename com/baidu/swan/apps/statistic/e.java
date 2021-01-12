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
    private static volatile boolean dIM = false;
    private static volatile boolean dIN = false;
    private static volatile boolean dIO = false;
    private static volatile boolean dIP = false;
    private static volatile boolean dIQ = false;
    private static HashMap<String, String> dIR;
    private static String dIS;

    public static synchronized void hm(boolean z) {
        synchronized (e.class) {
            dIM = z;
        }
    }

    public static synchronized boolean aKZ() {
        boolean z;
        synchronized (e.class) {
            z = dIM;
        }
        return z;
    }

    public static void aLa() {
        hm(false);
    }

    public static void aLb() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null) {
            n(aIr.aIv());
        }
    }

    public static void aLc() {
        com.baidu.swan.apps.adaptation.b.c aoN;
        com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
        if (afz != null) {
            com.baidu.swan.apps.core.d.c aoY = afz.aoY();
            if ((aoY instanceof com.baidu.swan.apps.core.d.e) && (aoN = ((com.baidu.swan.apps.core.d.e) aoY).aoN()) != null) {
                dIS = aoN.aiA();
            }
        }
    }

    public static void cB(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (dIR == null) {
                dIR = new HashMap<>();
            }
            dIR.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle ayH;
        if (bVar != null && aKZ() && (ayH = bVar.ayH()) != null && ayH.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.jr(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ayC();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.sA(ayH.getString("ubc"));
            h.onEvent(fVar);
            ayH.remove("page_display_flag_for_statistic");
            aLd();
        }
    }

    private static void aLd() {
        HybridUbcFlow pU = com.baidu.swan.apps.performance.i.pU("startup");
        if (pU != null) {
            if (!(pU.aDu() || pU.aDt())) {
                pU.q("value", "fe_success");
            }
        }
    }

    public static synchronized void hn(boolean z) {
        synchronized (e.class) {
            dIN = z;
        }
    }

    public static void aLe() {
        hn(false);
    }

    public static void aLf() {
        aLa();
        hp(false);
        aLe();
        aLh();
    }

    private static synchronized void ho(boolean z) {
        synchronized (e.class) {
            dIO = z;
        }
    }

    private static boolean aLg() {
        return dIO;
    }

    public static void aLh() {
        ho(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            hn(true);
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
        com.baidu.swan.apps.runtime.e aIr;
        b.a aIv;
        if (!aLj() && !aLg() && dVar != null && (aIr = com.baidu.swan.apps.runtime.e.aIr()) != null && (aIv = aIr.aIv()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            hn(true);
            ho(true);
            a(aIv, dVar.cAX, "0", dVar.cAY, sl(dVar.cBc), false);
        }
    }

    private static String sl(String str) {
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
        if (aVar != null && !aLg()) {
            ho(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void hp(boolean z) {
        dIP = z;
    }

    public static boolean aLi() {
        return dIP;
    }

    public static void c(b.a aVar) {
        if (aVar != null && !dIP) {
            hp(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean aLj() {
        return dIN;
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
            fVar.mFrom = h.jr(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.alM()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.ayC();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.t("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.ck(jSONObject);
            }
            Bundle ayH = aVar.ayH();
            if (ayH != null) {
                fVar.sA(ayH.getString("ubc"));
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
        com.baidu.swan.apps.y.e.pE(dIS);
        if (!aLj() && !aLg()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (dIR != null) {
            str2 = dIR.get(dIS);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            d(aVar);
            return;
        }
        aLe();
        dIQ = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jr(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.ayC();
        fVar.mType = "show";
        final String ayE = bVar.ayE();
        final String string = bVar.ayI().getString("ubc");
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.cl(h.sq(ayE));
                com.baidu.swan.apps.statistic.a.f.this.sA(string);
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onShow606", 2);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.statistic.a.f.this.sA(str2);
                com.baidu.swan.apps.statistic.a.f.this.cl(h.sq(str));
                h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
            }
        }, "onLaunchSuccessUBC", 2);
    }

    public static void sm(String str) {
        if (dIQ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.y.e.pE(str);
            dIQ = false;
        }
    }

    public static boolean aLk() {
        return dIQ;
    }
}
