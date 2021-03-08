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
/* loaded from: classes8.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cOE;
    static com.baidu.swan.apps.statistic.a cOF;
    private static Timer cOG;
    private static boolean cOH;

    public abstract void me(String str);

    private d() {
    }

    public static d amg() {
        if (cOE == null) {
            synchronized (f.class) {
                if (cOE == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.aee()) {
                        cOE = new a();
                    } else {
                        cOE = new b();
                    }
                }
            }
        }
        return cOE;
    }

    public void amh() {
        cOH = true;
    }

    String ami() {
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
        if (cOF == null) {
            cOF = h.sP("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cOF, "downloadstart", ami());
                com.baidu.swan.apps.statistic.b.a(cOF, "downloadsuccess", ami());
            }
            cOG = new Timer();
            cOG.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.amj();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void amj() {
        if (cOF != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
                jSONObject2.putOpt("appid", aIO == null ? "" : aIO.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cOF, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cOF);
        }
    }

    void release() {
        if (cOG != null) {
            cOG.cancel();
            cOG = null;
        }
        cOE = null;
        cOF = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cOE != null) {
                cOE.me(str);
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
        public void me(String str) {
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
                        com.baidu.swan.apps.statistic.b.a(cOF, str, ami());
                        return;
                    case 1:
                        if (cOF != null) {
                            com.baidu.swan.apps.statistic.b.b(cOF);
                        }
                        release();
                        return;
                    case 2:
                        amj();
                        release();
                        return;
                    default:
                        if (cOF != null) {
                            com.baidu.swan.apps.statistic.b.a(cOF, str, ami());
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
        public void me(String str) {
            SwanAppActivity aIH;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.amo()) {
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
                        if (com.baidu.swan.apps.runtime.e.aIO() != null && (aIH = com.baidu.swan.apps.runtime.e.aIO().aIH()) != null && !aIH.isFinishing()) {
                            z = false;
                        }
                        eZ(z);
                        if (!z) {
                            if (d.cOH) {
                                com.baidu.swan.apps.statistic.b.a(cOF, str + "-preload", ami());
                                boolean unused = d.cOH = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cOF, str, ami());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cOF, str + "-destroy", ami());
                        boolean unused2 = d.cOH = false;
                        return;
                    case 1:
                        if (cOF != null) {
                            com.baidu.swan.apps.statistic.b.a(cOF, str, ami());
                            amj();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cOF != null) {
                            com.baidu.swan.apps.statistic.b.a(cOF, str, ami());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.azj().putString("aiapp_extra_need_download", "1");
        cVar.azj().putString("aiapp_extra_preset_pkg", "0");
        cVar.azj().putString("aiapp_extra_pkg_downloading", "0");
        cVar.azj().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jv(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dNb = "1";
        fVar.dNd = "0";
        fVar.dNc = "0";
        fVar.mSource = "remote-debug";
        JSONObject sR = h.sR(cVar.azf());
        fVar.ta(cVar.azj().getString("ubc"));
        fVar.ck(sR);
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

    public static void amk() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void aml() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void amm() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
