package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.w.f;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d bWh;
    static com.baidu.swan.apps.statistic.a bWi;
    private static Timer bWj;
    private static boolean bWk;

    public abstract void iY(String str);

    private d() {
    }

    public static d Xl() {
        if (bWh == null) {
            synchronized (f.class) {
                if (bWh == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.PY()) {
                        bWh = new a();
                    } else {
                        bWh = new b();
                    }
                }
            }
        }
        return bWh;
    }

    public void Xm() {
        bWk = true;
    }

    String Xn() {
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

    void dx(boolean z) {
        if (bWi == null) {
            bWi = h.oE("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(bWi, "downloadstart", Xn());
                com.baidu.swan.apps.statistic.b.a(bWi, "downloadsuccess", Xn());
            }
            bWj = new Timer();
            bWj.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.Xo();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void Xo() {
        if (bWi != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
                jSONObject2.putOpt("appid", apN == null ? "" : apN.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(bWi, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(bWi);
        }
    }

    void release() {
        if (bWj != null) {
            bWj.cancel();
            bWj = null;
        }
        bWh = null;
        bWi = null;
    }

    public static void x(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bWh != null) {
                bWh.iY(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void iY(String str) {
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
                        dx(true);
                        com.baidu.swan.apps.statistic.b.a(bWi, str, Xn());
                        return;
                    case 1:
                        if (bWi != null) {
                            com.baidu.swan.apps.statistic.b.b(bWi);
                        }
                        release();
                        return;
                    case 2:
                        Xo();
                        release();
                        return;
                    default:
                        if (bWi != null) {
                            com.baidu.swan.apps.statistic.b.a(bWi, str, Xn());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void iY(String str) {
            SwanAppActivity apG;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.Xt()) {
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
                        if (com.baidu.swan.apps.runtime.e.apN() != null && (apG = com.baidu.swan.apps.runtime.e.apN().apG()) != null && !apG.isFinishing()) {
                            z = false;
                        }
                        dx(z);
                        if (!z) {
                            if (d.bWk) {
                                com.baidu.swan.apps.statistic.b.a(bWi, str + "-preload", Xn());
                                boolean unused = d.bWk = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(bWi, str, Xn());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(bWi, str + "-destroy", Xn());
                        boolean unused2 = d.bWk = false;
                        return;
                    case 1:
                        if (bWi != null) {
                            com.baidu.swan.apps.statistic.b.a(bWi, str, Xn());
                            Xo();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bWi != null) {
                            com.baidu.swan.apps.statistic.b.a(bWi, str, Xn());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.v.b.c cVar) {
        cVar.ahW().putString("aiapp_extra_need_download", "1");
        cVar.ahW().putString("aiapp_extra_preset_pkg", "0");
        cVar.ahW().putString("aiapp_extra_pkg_downloading", "0");
        cVar.ahW().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.hf(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cLj = "1";
        fVar.cLl = "0";
        fVar.cLk = "0";
        fVar.mSource = "remote-debug";
        JSONObject oF = h.oF(cVar.ahS());
        fVar.oO(cVar.ahW().getString("ubc"));
        fVar.bB(oF);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.hf(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void Xp() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void Xq() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Xr() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
