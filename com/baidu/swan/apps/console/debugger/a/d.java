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
/* loaded from: classes8.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d ccL;
    static com.baidu.swan.apps.statistic.a ccM;
    private static Timer ccN;
    private static boolean ccO;

    public abstract void kJ(String str);

    private d() {
    }

    public static d adX() {
        if (ccL == null) {
            synchronized (f.class) {
                if (ccL == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.Wi()) {
                        ccL = new a();
                    } else {
                        ccL = new b();
                    }
                }
            }
        }
        return ccL;
    }

    public void adY() {
        ccO = true;
    }

    String adZ() {
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

    void dK(boolean z) {
        if (ccM == null) {
            ccM = h.ro("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(ccM, "downloadstart", adZ());
                com.baidu.swan.apps.statistic.b.a(ccM, "downloadsuccess", adZ());
            }
            ccN = new Timer();
            ccN.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.aea();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void aea() {
        if (ccM != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
                jSONObject2.putOpt("appid", azJ == null ? "" : azJ.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(ccM, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(ccM);
        }
    }

    void release() {
        if (ccN != null) {
            ccN.cancel();
            ccN = null;
        }
        ccL = null;
        ccM = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && ccL != null) {
                ccL.kJ(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void kJ(String str) {
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
                        dK(true);
                        com.baidu.swan.apps.statistic.b.a(ccM, str, adZ());
                        return;
                    case 1:
                        if (ccM != null) {
                            com.baidu.swan.apps.statistic.b.b(ccM);
                        }
                        release();
                        return;
                    case 2:
                        aea();
                        release();
                        return;
                    default:
                        if (ccM != null) {
                            com.baidu.swan.apps.statistic.b.a(ccM, str, adZ());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void kJ(String str) {
            SwanAppActivity azC;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.aef()) {
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
                        if (com.baidu.swan.apps.runtime.e.azJ() != null && (azC = com.baidu.swan.apps.runtime.e.azJ().azC()) != null && !azC.isFinishing()) {
                            z = false;
                        }
                        dK(z);
                        if (!z) {
                            if (d.ccO) {
                                com.baidu.swan.apps.statistic.b.a(ccM, str + "-preload", adZ());
                                boolean unused = d.ccO = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(ccM, str, adZ());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(ccM, str + "-destroy", adZ());
                        boolean unused2 = d.ccO = false;
                        return;
                    case 1:
                        if (ccM != null) {
                            com.baidu.swan.apps.statistic.b.a(ccM, str, adZ());
                            aea();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (ccM != null) {
                            com.baidu.swan.apps.statistic.b.a(ccM, str, adZ());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.aqT().putString("aiapp_extra_need_download", "1");
        cVar.aqT().putString("aiapp_extra_preset_pkg", "0");
        cVar.aqT().putString("aiapp_extra_pkg_downloading", "0");
        cVar.aqT().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jv(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cXI = "1";
        fVar.cXK = "0";
        fVar.cXJ = "0";
        fVar.mSource = "remote-debug";
        JSONObject rq = h.rq(cVar.aqP());
        fVar.rz(cVar.aqT().getString("ubc"));
        fVar.bO(rq);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.jv(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void aeb() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void aec() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aed() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
