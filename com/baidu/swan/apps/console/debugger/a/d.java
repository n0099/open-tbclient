package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cNe;
    static com.baidu.swan.apps.statistic.a cNf;
    private static Timer cNg;
    private static boolean cNh;

    public abstract void lX(String str);

    private d() {
    }

    public static d amd() {
        if (cNe == null) {
            synchronized (f.class) {
                if (cNe == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.aeb()) {
                        cNe = new a();
                    } else {
                        cNe = new b();
                    }
                }
            }
        }
        return cNe;
    }

    public void ame() {
        cNh = true;
    }

    String amf() {
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

    void eZ(boolean z) {
        if (cNf == null) {
            cNf = h.sI("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cNf, "downloadstart", amf());
                com.baidu.swan.apps.statistic.b.a(cNf, "downloadsuccess", amf());
            }
            cNg = new Timer();
            cNg.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.amg();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void amg() {
        if (cNf != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
                jSONObject2.putOpt("appid", aIL == null ? "" : aIL.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cNf, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cNf);
        }
    }

    void release() {
        if (cNg != null) {
            cNg.cancel();
            cNg = null;
        }
        cNe = null;
        cNf = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cNe != null) {
                cNe.lX(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void lX(String str) {
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
                        eZ(true);
                        com.baidu.swan.apps.statistic.b.a(cNf, str, amf());
                        return;
                    case 1:
                        if (cNf != null) {
                            com.baidu.swan.apps.statistic.b.b(cNf);
                        }
                        release();
                        return;
                    case 2:
                        amg();
                        release();
                        return;
                    default:
                        if (cNf != null) {
                            com.baidu.swan.apps.statistic.b.a(cNf, str, amf());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void lX(String str) {
            SwanAppActivity aIE;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.aml()) {
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
                        if (com.baidu.swan.apps.runtime.e.aIL() != null && (aIE = com.baidu.swan.apps.runtime.e.aIL().aIE()) != null && !aIE.isFinishing()) {
                            z = false;
                        }
                        eZ(z);
                        if (!z) {
                            if (d.cNh) {
                                com.baidu.swan.apps.statistic.b.a(cNf, str + "-preload", amf());
                                boolean unused = d.cNh = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cNf, str, amf());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cNf, str + "-destroy", amf());
                        boolean unused2 = d.cNh = false;
                        return;
                    case 1:
                        if (cNf != null) {
                            com.baidu.swan.apps.statistic.b.a(cNf, str, amf());
                            amg();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cNf != null) {
                            com.baidu.swan.apps.statistic.b.a(cNf, str, amf());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.azg().putString("aiapp_extra_need_download", "1");
        cVar.azg().putString("aiapp_extra_preset_pkg", "0");
        cVar.azg().putString("aiapp_extra_pkg_downloading", "0");
        cVar.azg().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ju(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dLA = "1";
        fVar.dLC = "0";
        fVar.dLB = "0";
        fVar.mSource = "remote-debug";
        JSONObject sK = h.sK(cVar.azc());
        fVar.sT(cVar.azg().getString("ubc"));
        fVar.ci(sK);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.ju(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void amh() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void ami() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void amj() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
