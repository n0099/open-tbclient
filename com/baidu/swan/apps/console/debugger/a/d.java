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
/* loaded from: classes7.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cDN;
    static com.baidu.swan.apps.statistic.a cDO;
    private static Timer cDP;
    private static boolean cDQ;

    public abstract void mq(String str);

    private d() {
    }

    public static d ale() {
        if (cDN == null) {
            synchronized (f.class) {
                if (cDN == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.acx()) {
                        cDN = new a();
                    } else {
                        cDN = new b();
                    }
                }
            }
        }
        return cDN;
    }

    public void alf() {
        cDQ = true;
    }

    String alg() {
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

    void eD(boolean z) {
        if (cDO == null) {
            cDO = h.sW("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(cDO, "downloadstart", alg());
                com.baidu.swan.apps.statistic.b.a(cDO, "downloadsuccess", alg());
            }
            cDP = new Timer();
            cDP.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.alh();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void alh() {
        if (cDO != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
                jSONObject2.putOpt("appid", aGN == null ? "" : aGN.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(cDO, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(cDO);
        }
    }

    void release() {
        if (cDP != null) {
            cDP.cancel();
            cDP = null;
        }
        cDN = null;
        cDO = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && cDN != null) {
                cDN.mq(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mq(String str) {
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
                        eD(true);
                        com.baidu.swan.apps.statistic.b.a(cDO, str, alg());
                        return;
                    case 1:
                        if (cDO != null) {
                            com.baidu.swan.apps.statistic.b.b(cDO);
                        }
                        release();
                        return;
                    case 2:
                        alh();
                        release();
                        return;
                    default:
                        if (cDO != null) {
                            com.baidu.swan.apps.statistic.b.a(cDO, str, alg());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void mq(String str) {
            SwanAppActivity aGG;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.alm()) {
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
                        if (com.baidu.swan.apps.runtime.e.aGN() != null && (aGG = com.baidu.swan.apps.runtime.e.aGN().aGG()) != null && !aGG.isFinishing()) {
                            z = false;
                        }
                        eD(z);
                        if (!z) {
                            if (d.cDQ) {
                                com.baidu.swan.apps.statistic.b.a(cDO, str + "-preload", alg());
                                boolean unused = d.cDQ = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(cDO, str, alg());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(cDO, str + "-destroy", alg());
                        boolean unused2 = d.cDQ = false;
                        return;
                    case 1:
                        if (cDO != null) {
                            com.baidu.swan.apps.statistic.b.a(cDO, str, alg());
                            alh();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (cDO != null) {
                            com.baidu.swan.apps.statistic.b.a(cDO, str, alg());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.ayb().putString("aiapp_extra_need_download", "1");
        cVar.ayb().putString("aiapp_extra_preset_pkg", "0");
        cVar.ayb().putString("aiapp_extra_pkg_downloading", "0");
        cVar.ayb().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ku(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.dyF = "1";
        fVar.dyH = "0";
        fVar.dyG = "0";
        fVar.mSource = "remote-debug";
        JSONObject sY = h.sY(cVar.axX());
        fVar.th(cVar.ayb().getString("ubc"));
        fVar.cb(sY);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.ku(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void ali() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void alj() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void alk() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
