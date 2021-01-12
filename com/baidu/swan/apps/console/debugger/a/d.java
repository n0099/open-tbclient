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
    private static d cKQ;
    static com.baidu.swan.apps.statistic.a cKR;
    private static Timer cKS;
    private static boolean cKT;

    public abstract void lF(String str);

    private d() {
    }

    public static d alF() {
        if (cKQ == null) {
            synchronized (f.class) {
                if (cKQ == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.adK()) {
                        cKQ = new a();
                    } else {
                        cKQ = new b();
                    }
                }
            }
        }
        return cKQ;
    }

    public void alG() {
        cKT = true;
    }

    String alH() {
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

    void eX(boolean z) {
        if (cKR == null) {
            cKR = h.so("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cKR, "downloadstart", alH());
                com.baidu.swan.apps.statistic.b.a(cKR, "downloadsuccess", alH());
            }
            cKS = new Timer();
            cKS.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.alI();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void alI() {
        if (cKR != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
                jSONObject2.putOpt("appid", aIs == null ? "" : aIs.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cKR, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cKR);
        }
    }

    void release() {
        if (cKS != null) {
            cKS.cancel();
            cKS = null;
        }
        cKQ = null;
        cKR = null;
    }

    public static void A(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cKQ != null) {
                cKQ.lF(str);
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
        public void lF(String str) {
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
                        eX(true);
                        com.baidu.swan.apps.statistic.b.a(cKR, str, alH());
                        return;
                    case 1:
                        if (cKR != null) {
                            com.baidu.swan.apps.statistic.b.b(cKR);
                        }
                        release();
                        return;
                    case 2:
                        alI();
                        release();
                        return;
                    default:
                        if (cKR != null) {
                            com.baidu.swan.apps.statistic.b.a(cKR, str, alH());
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
        public void lF(String str) {
            SwanAppActivity aIl;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.alN()) {
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
                        if (com.baidu.swan.apps.runtime.e.aIs() != null && (aIl = com.baidu.swan.apps.runtime.e.aIs().aIl()) != null && !aIl.isFinishing()) {
                            z = false;
                        }
                        eX(z);
                        if (!z) {
                            if (d.cKT) {
                                com.baidu.swan.apps.statistic.b.a(cKR, str + "-preload", alH());
                                boolean unused = d.cKT = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cKR, str, alH());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cKR, str + "-destroy", alH());
                        boolean unused2 = d.cKT = false;
                        return;
                    case 1:
                        if (cKR != null) {
                            com.baidu.swan.apps.statistic.b.a(cKR, str, alH());
                            alI();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cKR != null) {
                            com.baidu.swan.apps.statistic.b.a(cKR, str, alH());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.ayI().putString("aiapp_extra_need_download", "1");
        cVar.ayI().putString("aiapp_extra_preset_pkg", "0");
        cVar.ayI().putString("aiapp_extra_pkg_downloading", "0");
        cVar.ayI().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jr(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dJw = "1";
        fVar.dJy = "0";
        fVar.dJx = "0";
        fVar.mSource = "remote-debug";
        JSONObject sq = h.sq(cVar.ayE());
        fVar.sA(cVar.ayI().getString("ubc"));
        fVar.cl(sq);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.jr(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void alJ() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void alK() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alL() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME;
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
