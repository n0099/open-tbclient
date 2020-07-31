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
    private static d bWY;
    static com.baidu.swan.apps.statistic.a bWZ;
    private static Timer bXa;
    private static boolean bXb;

    public abstract void ji(String str);

    private d() {
    }

    public static d XR() {
        if (bWY == null) {
            synchronized (f.class) {
                if (bWY == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.Qn()) {
                        bWY = new a();
                    } else {
                        bWY = new b();
                    }
                }
            }
        }
        return bWY;
    }

    public void XS() {
        bXb = true;
    }

    String XT() {
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

    void dA(boolean z) {
        if (bWZ == null) {
            bWZ = h.pn("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(bWZ, "downloadstart", XT());
                com.baidu.swan.apps.statistic.b.a(bWZ, "downloadsuccess", XT());
            }
            bXa = new Timer();
            bXa.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.XU();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void XU() {
        if (bWZ != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
                jSONObject2.putOpt("appid", arw == null ? "" : arw.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(bWZ, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(bWZ);
        }
    }

    void release() {
        if (bXa != null) {
            bXa.cancel();
            bXa = null;
        }
        bWY = null;
        bWZ = null;
    }

    public static void y(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bWY != null) {
                bWY.ji(str);
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
        public void ji(String str) {
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
                        dA(true);
                        com.baidu.swan.apps.statistic.b.a(bWZ, str, XT());
                        return;
                    case 1:
                        if (bWZ != null) {
                            com.baidu.swan.apps.statistic.b.b(bWZ);
                        }
                        release();
                        return;
                    case 2:
                        XU();
                        release();
                        return;
                    default:
                        if (bWZ != null) {
                            com.baidu.swan.apps.statistic.b.a(bWZ, str, XT());
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
        public void ji(String str) {
            SwanAppActivity arp;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.XZ()) {
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
                        if (com.baidu.swan.apps.runtime.e.arw() != null && (arp = com.baidu.swan.apps.runtime.e.arw().arp()) != null && !arp.isFinishing()) {
                            z = false;
                        }
                        dA(z);
                        if (!z) {
                            if (d.bXb) {
                                com.baidu.swan.apps.statistic.b.a(bWZ, str + "-preload", XT());
                                boolean unused = d.bXb = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(bWZ, str, XT());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(bWZ, str + "-destroy", XT());
                        boolean unused2 = d.bXb = false;
                        return;
                    case 1:
                        if (bWZ != null) {
                            com.baidu.swan.apps.statistic.b.a(bWZ, str, XT());
                            XU();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bWZ != null) {
                            com.baidu.swan.apps.statistic.b.a(bWZ, str, XT());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.u.c.c cVar) {
        cVar.ajm().putString("aiapp_extra_need_download", "1");
        cVar.ajm().putString("aiapp_extra_preset_pkg", "0");
        cVar.ajm().putString("aiapp_extra_pkg_downloading", "0");
        cVar.ajm().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.ho(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cOE = "1";
        fVar.cOG = "0";
        fVar.cOF = "0";
        fVar.mSource = "remote-debug";
        JSONObject pp = h.pp(cVar.aji());
        fVar.py(cVar.ajm().getString("ubc"));
        fVar.bG(pp);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.u.c.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.ho(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void XV() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void XW() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void XX() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
