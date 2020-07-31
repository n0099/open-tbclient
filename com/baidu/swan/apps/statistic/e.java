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
/* loaded from: classes7.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile boolean cNV = false;
    private static volatile boolean cNW = false;
    private static volatile boolean cNX = false;
    private static volatile boolean cNY = false;
    private static volatile boolean cNZ = false;
    private static HashMap<String, String> cOa;
    private static String cOb;

    public static synchronized void fw(boolean z) {
        synchronized (e.class) {
            cNV = z;
        }
    }

    public static synchronized boolean aug() {
        boolean z;
        synchronized (e.class) {
            z = cNV;
        }
        return z;
    }

    public static void auh() {
        fw(false);
    }

    public static void aui() {
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null) {
            n(arv.arz());
        }
    }

    public static void auj() {
        com.baidu.swan.apps.adaptation.b.c aaQ;
        com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
        if (Sc != null) {
            com.baidu.swan.apps.core.d.c aaZ = Sc.aaZ();
            if ((aaZ instanceof com.baidu.swan.apps.core.d.e) && (aaQ = ((com.baidu.swan.apps.core.d.e) aaZ).aaQ()) != null) {
                cOb = aaQ.UR();
            }
        }
    }

    public static void bU(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (cOa == null) {
                cOa = new HashMap<>();
            }
            cOa.put(str, str2);
        }
    }

    public static void n(com.baidu.swan.apps.u.c.b bVar) {
        Bundle ajl;
        if (bVar != null && aug() && (ajl = bVar.ajl()) != null && ajl.getLong("page_display_flag_for_statistic") > 0) {
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.ho(bVar.getAppFrameType());
            fVar.mAppId = bVar.getAppId();
            fVar.mSource = bVar.ajg();
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "realsuccess";
            fVar.py(ajl.getString("ubc"));
            h.onEvent(fVar);
            ajl.remove("page_display_flag_for_statistic");
            auk();
        }
    }

    private static void auk() {
        HybridUbcFlow mZ = com.baidu.swan.apps.performance.i.mZ("startup");
        if (mZ != null) {
            if (!(mZ.anK() || mZ.anJ())) {
                mZ.r("value", "fe_success");
            }
        }
    }

    public static synchronized void fx(boolean z) {
        synchronized (e.class) {
            cNW = z;
        }
    }

    public static void aul() {
        fx(false);
    }

    public static void aum() {
        auh();
        fz(false);
        aul();
        auo();
    }

    private static synchronized void fy(boolean z) {
        synchronized (e.class) {
            cNX = z;
        }
    }

    private static boolean aun() {
        return cNX;
    }

    public static void auo() {
        fy(false);
    }

    private static void a(b.a aVar, long j, String str, long j2, String str2, boolean z) {
        if (aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            fx(true);
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
        com.baidu.swan.apps.runtime.e arv;
        b.a arz;
        if (!auq() && !aun() && dVar != null && (arv = com.baidu.swan.apps.runtime.e.arv()) != null && (arz = arv.arz()) != null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
            }
            fx(true);
            fy(true);
            a(arz, dVar.bNw, "0", dVar.bNx, pk(dVar.bNB), false);
        }
    }

    private static String pk(String str) {
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

    public static void a(b.a aVar) {
        if (aVar != null && !aun()) {
            fy(true);
            a(aVar, "arrivecancel");
        }
    }

    public static void fz(boolean z) {
        cNY = z;
    }

    public static boolean aup() {
        return cNY;
    }

    public static void b(b.a aVar) {
        if (aVar != null && !cNY) {
            fz(true);
            a(aVar, "naarrsuccess");
        }
    }

    public static boolean auq() {
        return cNW;
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
            fVar.mFrom = h.ho(aVar.getAppFrameType());
            fVar.mAppId = appId;
            if (com.baidu.swan.apps.console.debugger.a.e.XY()) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = aVar.ajg();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = str;
            fVar.v("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                fVar.bF(jSONObject);
            }
            Bundle ajl = aVar.ajl();
            if (ajl != null) {
                fVar.py(ajl.getString("ubc"));
            }
            if (DEBUG) {
                Log.d("SwanAppLaunchUbc", "handle record arrival event, arrivalValue " + str + " arrive time : " + j2 + " extJson :" + (jSONObject == null ? "" : jSONObject.toString()));
            }
            h.onEvent(fVar);
        }
    }

    public static void c(b.a aVar) {
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
        }
        com.baidu.swan.apps.z.e.mI(cOb);
        if (!auq() && !aun()) {
            a(aVar, -1L, "1", -1L, "1", true);
        }
    }

    public static void a(String str, b.a aVar) {
        String str2 = "";
        if (cOa != null) {
            str2 = cOa.get(cOb);
        }
        if (DEBUG) {
            Log.d("SwanAppLaunchUbc", "handle relaunch , launchPage : " + str + " lastSlavePath ：" + (str2 == null ? "" : str2));
        }
        if (TextUtils.equals(str, str2)) {
            c(aVar);
            return;
        }
        aul();
        cNZ = true;
    }

    public static void o(@NonNull com.baidu.swan.apps.u.c.b bVar) {
        final com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ho(0);
        fVar.mAppId = bVar.getAppId();
        fVar.mSource = bVar.ajg();
        fVar.mType = "show";
        final String aji = bVar.aji();
        final String string = bVar.ajm().getString("ubc");
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.statistic.a.f.this.bG(h.pp(aji));
                    com.baidu.swan.apps.statistic.a.f.this.py(string);
                    h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
                }
            }, "onShow606", 2);
            return;
        }
        fVar.bG(h.pp(aji));
        fVar.py(string);
        h.onEvent(fVar);
    }

    public static void b(final com.baidu.swan.apps.statistic.a.f fVar, final String str, final String str2) {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.statistic.e.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.statistic.a.f.this.py(str2);
                    com.baidu.swan.apps.statistic.a.f.this.bG(h.pp(str));
                    h.onEvent(com.baidu.swan.apps.statistic.a.f.this);
                }
            }, "onLaunchSuccessUBC", 2);
            return;
        }
        fVar.py(str2);
        fVar.bG(h.pp(str));
        h.onEvent(fVar);
    }

    public static void pl(String str) {
        if (cNZ) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            com.baidu.swan.apps.z.e.mI(str);
            cNZ = false;
        }
    }

    public static boolean aur() {
        return cNZ;
    }
}
