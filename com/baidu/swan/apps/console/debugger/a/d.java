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
    private static d cPC;
    static com.baidu.swan.apps.statistic.a cPD;
    private static Timer cPE;
    private static boolean cPF;

    public abstract void mQ(String str);

    private d() {
    }

    public static d apA() {
        if (cPC == null) {
            synchronized (f.class) {
                if (cPC == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.ahE()) {
                        cPC = new a();
                    } else {
                        cPC = new b();
                    }
                }
            }
        }
        return cPC;
    }

    public void apB() {
        cPF = true;
    }

    String apC() {
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

    void fb(boolean z) {
        if (cPD == null) {
            cPD = h.tA("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cPD, "downloadstart", apC());
                com.baidu.swan.apps.statistic.b.a(cPD, "downloadsuccess", apC());
            }
            cPE = new Timer();
            cPE.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.apD();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void apD() {
        if (cPD != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
                jSONObject2.putOpt("appid", aMm == null ? "" : aMm.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cPD, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cPD);
        }
    }

    void release() {
        if (cPE != null) {
            cPE.cancel();
            cPE = null;
        }
        cPC = null;
        cPD = null;
    }

    public static void A(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cPC != null) {
                cPC.mQ(str);
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
        public void mQ(String str) {
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
                        fb(true);
                        com.baidu.swan.apps.statistic.b.a(cPD, str, apC());
                        return;
                    case 1:
                        if (cPD != null) {
                            com.baidu.swan.apps.statistic.b.b(cPD);
                        }
                        release();
                        return;
                    case 2:
                        apD();
                        release();
                        return;
                    default:
                        if (cPD != null) {
                            com.baidu.swan.apps.statistic.b.a(cPD, str, apC());
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
        public void mQ(String str) {
            SwanAppActivity aMf;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.apI()) {
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
                        if (com.baidu.swan.apps.runtime.e.aMm() != null && (aMf = com.baidu.swan.apps.runtime.e.aMm().aMf()) != null && !aMf.isFinishing()) {
                            z = false;
                        }
                        fb(z);
                        if (!z) {
                            if (d.cPF) {
                                com.baidu.swan.apps.statistic.b.a(cPD, str + "-preload", apC());
                                boolean unused = d.cPF = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cPD, str, apC());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cPD, str + "-destroy", apC());
                        boolean unused2 = d.cPF = false;
                        return;
                    case 1:
                        if (cPD != null) {
                            com.baidu.swan.apps.statistic.b.a(cPD, str, apC());
                            apD();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cPD != null) {
                            com.baidu.swan.apps.statistic.b.a(cPD, str, apC());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.aCC().putString("aiapp_extra_need_download", "1");
        cVar.aCC().putString("aiapp_extra_preset_pkg", "0");
        cVar.aCC().putString("aiapp_extra_pkg_downloading", "0");
        cVar.aCC().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.kX(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dOi = "1";
        fVar.dOk = "0";
        fVar.dOj = "0";
        fVar.mSource = "remote-debug";
        JSONObject tC = h.tC(cVar.aCy());
        fVar.tL(cVar.aCC().getString("ubc"));
        fVar.cl(tC);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.kX(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void apE() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void apF() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void apG() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
