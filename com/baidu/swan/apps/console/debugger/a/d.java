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
/* loaded from: classes3.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d ceN;
    static com.baidu.swan.apps.statistic.a ceO;
    private static Timer ceP;
    private static boolean ceQ;

    public abstract void lc(String str);

    private d() {
    }

    public static d aeH() {
        if (ceN == null) {
            synchronized (f.class) {
                if (ceN == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.WR()) {
                        ceN = new a();
                    } else {
                        ceN = new b();
                    }
                }
            }
        }
        return ceN;
    }

    public void aeI() {
        ceQ = true;
    }

    String aeJ() {
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

    void dI(boolean z) {
        if (ceO == null) {
            ceO = h.rH("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(ceO, "downloadstart", aeJ());
                com.baidu.swan.apps.statistic.b.a(ceO, "downloadsuccess", aeJ());
            }
            ceP = new Timer();
            ceP.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.aeK();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void aeK() {
        if (ceO != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
                jSONObject2.putOpt("appid", aAs == null ? "" : aAs.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(ceO, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(ceO);
        }
    }

    void release() {
        if (ceP != null) {
            ceP.cancel();
            ceP = null;
        }
        ceN = null;
        ceO = null;
    }

    public static void z(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && ceN != null) {
                ceN.lc(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void lc(String str) {
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
                        dI(true);
                        com.baidu.swan.apps.statistic.b.a(ceO, str, aeJ());
                        return;
                    case 1:
                        if (ceO != null) {
                            com.baidu.swan.apps.statistic.b.b(ceO);
                        }
                        release();
                        return;
                    case 2:
                        aeK();
                        release();
                        return;
                    default:
                        if (ceO != null) {
                            com.baidu.swan.apps.statistic.b.a(ceO, str, aeJ());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void lc(String str) {
            SwanAppActivity aAl;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.aeP()) {
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
                        if (com.baidu.swan.apps.runtime.e.aAs() != null && (aAl = com.baidu.swan.apps.runtime.e.aAs().aAl()) != null && !aAl.isFinishing()) {
                            z = false;
                        }
                        dI(z);
                        if (!z) {
                            if (d.ceQ) {
                                com.baidu.swan.apps.statistic.b.a(ceO, str + "-preload", aeJ());
                                boolean unused = d.ceQ = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(ceO, str, aeJ());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(ceO, str + "-destroy", aeJ());
                        boolean unused2 = d.ceQ = false;
                        return;
                    case 1:
                        if (ceO != null) {
                            com.baidu.swan.apps.statistic.b.a(ceO, str, aeJ());
                            aeK();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (ceO != null) {
                            com.baidu.swan.apps.statistic.b.a(ceO, str, aeJ());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.arD().putString("aiapp_extra_need_download", "1");
        cVar.arD().putString("aiapp_extra_preset_pkg", "0");
        cVar.arD().putString("aiapp_extra_pkg_downloading", "0");
        cVar.arD().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.jG(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cZI = "1";
        fVar.cZK = "0";
        fVar.cZJ = "0";
        fVar.mSource = "remote-debug";
        JSONObject rJ = h.rJ(cVar.arz());
        fVar.rS(cVar.arD().getString("ubc"));
        fVar.bR(rJ);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.jG(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void aeL() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void aeM() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void aeN() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
