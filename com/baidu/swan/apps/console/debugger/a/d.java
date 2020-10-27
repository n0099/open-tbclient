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
/* loaded from: classes10.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d czE;
    static com.baidu.swan.apps.statistic.a czF;
    private static Timer czG;
    private static boolean czH;

    public abstract void mh(String str);

    private d() {
    }

    public static d ajm() {
        if (czE == null) {
            synchronized (f.class) {
                if (czE == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.aaH()) {
                        czE = new a();
                    } else {
                        czE = new b();
                    }
                }
            }
        }
        return czE;
    }

    public void ajn() {
        czH = true;
    }

    String ajo() {
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

    void er(boolean z) {
        if (czF == null) {
            czF = h.sN("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(czF, "downloadstart", ajo());
                com.baidu.swan.apps.statistic.b.a(czF, "downloadsuccess", ajo());
            }
            czG = new Timer();
            czG.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.ajp();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void ajp() {
        if (czF != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
                jSONObject2.putOpt("appid", aEV == null ? "" : aEV.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(czF, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(czF);
        }
    }

    void release() {
        if (czG != null) {
            czG.cancel();
            czG = null;
        }
        czE = null;
        czF = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && czE != null) {
                czE.mh(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mh(String str) {
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
                        er(true);
                        com.baidu.swan.apps.statistic.b.a(czF, str, ajo());
                        return;
                    case 1:
                        if (czF != null) {
                            com.baidu.swan.apps.statistic.b.b(czF);
                        }
                        release();
                        return;
                    case 2:
                        ajp();
                        release();
                        return;
                    default:
                        if (czF != null) {
                            com.baidu.swan.apps.statistic.b.a(czF, str, ajo());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mh(String str) {
            SwanAppActivity aEO;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.aju()) {
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
                        if (com.baidu.swan.apps.runtime.e.aEV() != null && (aEO = com.baidu.swan.apps.runtime.e.aEV().aEO()) != null && !aEO.isFinishing()) {
                            z = false;
                        }
                        er(z);
                        if (!z) {
                            if (d.czH) {
                                com.baidu.swan.apps.statistic.b.a(czF, str + "-preload", ajo());
                                boolean unused = d.czH = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(czF, str, ajo());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(czF, str + "-destroy", ajo());
                        boolean unused2 = d.czH = false;
                        return;
                    case 1:
                        if (czF != null) {
                            com.baidu.swan.apps.statistic.b.a(czF, str, ajo());
                            ajp();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (czF != null) {
                            com.baidu.swan.apps.statistic.b.a(czF, str, ajo());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.awj().putString("aiapp_extra_need_download", "1");
        cVar.awj().putString("aiapp_extra_preset_pkg", "0");
        cVar.awj().putString("aiapp_extra_pkg_downloading", "0");
        cVar.awj().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ko(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.duu = "1";
        fVar.duw = "0";
        fVar.duv = "0";
        fVar.mSource = "remote-debug";
        JSONObject sP = h.sP(cVar.awf());
        fVar.sY(cVar.awj().getString("ubc"));
        fVar.cb(sP);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.ko(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void ajq() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void ajr() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ajs() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
