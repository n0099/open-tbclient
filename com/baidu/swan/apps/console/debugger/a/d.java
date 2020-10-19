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
    private static d cre;
    static com.baidu.swan.apps.statistic.a crf;
    private static Timer crg;
    private static boolean crh;

    public abstract void lO(String str);

    private d() {
    }

    public static d ahs() {
        if (cre == null) {
            synchronized (f.class) {
                if (cre == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.YO()) {
                        cre = new a();
                    } else {
                        cre = new b();
                    }
                }
            }
        }
        return cre;
    }

    public void aht() {
        crh = true;
    }

    String ahu() {
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

    void ee(boolean z) {
        if (crf == null) {
            crf = h.su("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(crf, "downloadstart", ahu());
                com.baidu.swan.apps.statistic.b.a(crf, "downloadsuccess", ahu());
            }
            crg = new Timer();
            crg.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.ahv();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void ahv() {
        if (crf != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
                jSONObject2.putOpt("appid", aDb == null ? "" : aDb.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(crf, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(crf);
        }
    }

    void release() {
        if (crg != null) {
            crg.cancel();
            crg = null;
        }
        cre = null;
        crf = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cre != null) {
                cre.lO(str);
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
        public void lO(String str) {
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
                        ee(true);
                        com.baidu.swan.apps.statistic.b.a(crf, str, ahu());
                        return;
                    case 1:
                        if (crf != null) {
                            com.baidu.swan.apps.statistic.b.b(crf);
                        }
                        release();
                        return;
                    case 2:
                        ahv();
                        release();
                        return;
                    default:
                        if (crf != null) {
                            com.baidu.swan.apps.statistic.b.a(crf, str, ahu());
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
        public void lO(String str) {
            SwanAppActivity aCU;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.ahA()) {
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
                        if (com.baidu.swan.apps.runtime.e.aDb() != null && (aCU = com.baidu.swan.apps.runtime.e.aDb().aCU()) != null && !aCU.isFinishing()) {
                            z = false;
                        }
                        ee(z);
                        if (!z) {
                            if (d.crh) {
                                com.baidu.swan.apps.statistic.b.a(crf, str + "-preload", ahu());
                                boolean unused = d.crh = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(crf, str, ahu());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(crf, str + "-destroy", ahu());
                        boolean unused2 = d.crh = false;
                        return;
                    case 1:
                        if (crf != null) {
                            com.baidu.swan.apps.statistic.b.a(crf, str, ahu());
                            ahv();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (crf != null) {
                            com.baidu.swan.apps.statistic.b.a(crf, str, ahu());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.aup().putString("aiapp_extra_need_download", "1");
        cVar.aup().putString("aiapp_extra_preset_pkg", "0");
        cVar.aup().putString("aiapp_extra_pkg_downloading", "0");
        cVar.aup().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kd(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dlS = "1";
        fVar.dlU = "0";
        fVar.dlT = "0";
        fVar.mSource = "remote-debug";
        JSONObject sw = h.sw(cVar.aul());
        fVar.sF(cVar.aup().getString("ubc"));
        fVar.bY(sw);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.kd(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void ahw() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void ahx() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void ahy() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
