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
    private static boolean cFA;
    private static d cFx;
    static com.baidu.swan.apps.statistic.a cFy;
    private static Timer cFz;

    public abstract void mw(String str);

    private d() {
    }

    public static d alM() {
        if (cFx == null) {
            synchronized (f.class) {
                if (cFx == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.adg()) {
                        cFx = new a();
                    } else {
                        cFx = new b();
                    }
                }
            }
        }
        return cFx;
    }

    public void alN() {
        cFA = true;
    }

    String alO() {
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

    void eA(boolean z) {
        if (cFy == null) {
            cFy = h.tb("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cFy, "downloadstart", alO());
                com.baidu.swan.apps.statistic.b.a(cFy, "downloadsuccess", alO());
            }
            cFz = new Timer();
            cFz.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.alP();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void alP() {
        if (cFy != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
                jSONObject2.putOpt("appid", aHv == null ? "" : aHv.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cFy, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cFy);
        }
    }

    void release() {
        if (cFz != null) {
            cFz.cancel();
            cFz = null;
        }
        cFx = null;
        cFy = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cFx != null) {
                cFx.mw(str);
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
        public void mw(String str) {
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
                        eA(true);
                        com.baidu.swan.apps.statistic.b.a(cFy, str, alO());
                        return;
                    case 1:
                        if (cFy != null) {
                            com.baidu.swan.apps.statistic.b.b(cFy);
                        }
                        release();
                        return;
                    case 2:
                        alP();
                        release();
                        return;
                    default:
                        if (cFy != null) {
                            com.baidu.swan.apps.statistic.b.a(cFy, str, alO());
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
        public void mw(String str) {
            SwanAppActivity aHo;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.alU()) {
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
                        if (com.baidu.swan.apps.runtime.e.aHv() != null && (aHo = com.baidu.swan.apps.runtime.e.aHv().aHo()) != null && !aHo.isFinishing()) {
                            z = false;
                        }
                        eA(z);
                        if (!z) {
                            if (d.cFA) {
                                com.baidu.swan.apps.statistic.b.a(cFy, str + "-preload", alO());
                                boolean unused = d.cFA = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cFy, str, alO());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cFy, str + "-destroy", alO());
                        boolean unused2 = d.cFA = false;
                        return;
                    case 1:
                        if (cFy != null) {
                            com.baidu.swan.apps.statistic.b.a(cFy, str, alO());
                            alP();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cFy != null) {
                            com.baidu.swan.apps.statistic.b.a(cFy, str, alO());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.ayJ().putString("aiapp_extra_need_download", "1");
        cVar.ayJ().putString("aiapp_extra_preset_pkg", "0");
        cVar.ayJ().putString("aiapp_extra_pkg_downloading", "0");
        cVar.ayJ().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ky(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dAm = "1";
        fVar.dAo = "0";
        fVar.dAn = "0";
        fVar.mSource = "remote-debug";
        JSONObject td = h.td(cVar.ayF());
        fVar.tm(cVar.ayJ().getString("ubc"));
        fVar.ch(td);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.ky(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void alQ() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void alR() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alS() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
