package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cKH;
    static com.baidu.swan.apps.statistic.a cKI;
    private static Timer cKJ;
    private static boolean cKK;

    public abstract void mX(String str);

    private d() {
    }

    public static d aom() {
        if (cKH == null) {
            synchronized (f.class) {
                if (cKH == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.afH()) {
                        cKH = new a();
                    } else {
                        cKH = new b();
                    }
                }
            }
        }
        return cKH;
    }

    public void aon() {
        cKK = true;
    }

    String aoo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e) {
            if (DEBUG) {
                Log.d("RemoteDebugStatistic", "add event content fail", e);
            }
        }
        return jSONObject.toString();
    }

    void eS(boolean z) {
        if (cKI == null) {
            cKI = h.tD("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cKI, "downloadstart", aoo());
                com.baidu.swan.apps.statistic.b.a(cKI, "downloadsuccess", aoo());
            }
            cKJ = new Timer();
            cKJ.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.aop();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void aop() {
        if (cKI != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
                jSONObject2.putOpt("appid", aJV == null ? "" : aJV.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cKI, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cKI);
        }
    }

    void release() {
        if (cKJ != null) {
            cKJ.cancel();
            cKJ = null;
        }
        cKH = null;
        cKI = null;
    }

    public static void A(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cKH != null) {
                cKH.mX(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mX(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (d.DEBUG) {
                    Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
                }
                char c = 65535;
                switch (str.hashCode()) {
                    case 50335962:
                        if (str.equals("downloadstart")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1109597094:
                        if (str.equals("downloadfail")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1158237819:
                        if (str.equals("downloadsuccess")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        eS(true);
                        com.baidu.swan.apps.statistic.b.a(cKI, str, aoo());
                        return;
                    case 1:
                        if (cKI != null) {
                            com.baidu.swan.apps.statistic.b.b(cKI);
                        }
                        release();
                        return;
                    case 2:
                        aop();
                        release();
                        return;
                    default:
                        if (cKI != null) {
                            com.baidu.swan.apps.statistic.b.a(cKI, str, aoo());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mX(String str) {
            SwanAppActivity aJO;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.aou()) {
                if (d.DEBUG) {
                    Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
                }
                char c = 65535;
                switch (str.hashCode()) {
                    case 511060680:
                        if (str.equals("loadmaster")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 900970612:
                        if (str.equals("pageready")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (com.baidu.swan.apps.runtime.e.aJV() != null && (aJO = com.baidu.swan.apps.runtime.e.aJV().aJO()) != null && !aJO.isFinishing()) {
                            z = false;
                        }
                        eS(z);
                        if (!z) {
                            if (d.cKK) {
                                com.baidu.swan.apps.statistic.b.a(cKI, str + "-preload", aoo());
                                boolean unused = d.cKK = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cKI, str, aoo());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cKI, str + "-destroy", aoo());
                        boolean unused2 = d.cKK = false;
                        return;
                    case 1:
                        if (cKI != null) {
                            com.baidu.swan.apps.statistic.b.a(cKI, str, aoo());
                            aop();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cKI != null) {
                            com.baidu.swan.apps.statistic.b.a(cKI, str, aoo());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.aBk().putString("aiapp_extra_need_download", "1");
        cVar.aBk().putString("aiapp_extra_preset_pkg", "0");
        cVar.aBk().putString("aiapp_extra_pkg_downloading", "0");
        cVar.aBk().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kS(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dFE = "1";
        fVar.dFG = "0";
        fVar.dFF = "0";
        fVar.mSource = "remote-debug";
        JSONObject tF = h.tF(cVar.aBg());
        fVar.tO(cVar.aBk().getString("ubc"));
        fVar.cd(tF);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.kS(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void aoq() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void aor() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aos() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
