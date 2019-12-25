package com.baidu.swan.apps.console.debugger.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d beX;
    static Flow beY;
    private static Timer beZ;
    private static boolean bfa;

    public abstract void gk(String str);

    private d() {
    }

    public static d IV() {
        if (beX == null) {
            synchronized (f.class) {
                if (beX == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.BX()) {
                        beX = new a();
                    } else {
                        beX = new b();
                    }
                }
            }
        }
        return beX;
    }

    public void IW() {
        bfa = true;
    }

    String IX() {
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

    void bV(boolean z) {
        if (beY == null) {
            beY = s.qJ("1153");
            if (!z) {
                beY.addEvent("downloadstart", IX());
                beY.addEvent("downloadsuccess", IX());
            }
            beZ = new Timer();
            beZ.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.IY();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void IY() {
        if (beY != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e ZT = com.baidu.swan.apps.runtime.e.ZT();
                jSONObject2.putOpt("appid", ZT == null ? "" : ZT.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            beY.setValueWithDuration(jSONObject.toString());
            beY.end();
        }
    }

    void release() {
        if (beZ != null) {
            beZ.cancel();
            beZ = null;
        }
        beX = null;
        beY = null;
    }

    public static void u(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && beX != null) {
                beX.gk(str);
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
        public void gk(String str) {
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
                        bV(true);
                        beY.addEvent(str, IX());
                        return;
                    case 1:
                        if (beY != null) {
                            beY.cancel();
                        }
                        release();
                        return;
                    case 2:
                        IY();
                        release();
                        return;
                    default:
                        if (beY != null) {
                            beY.addEvent(str, IX());
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
        public void gk(String str) {
            SwanAppActivity ZO;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.Jd()) {
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
                        if (com.baidu.swan.apps.runtime.e.ZT() != null && (ZO = com.baidu.swan.apps.runtime.e.ZT().ZO()) != null && !ZO.isFinishing()) {
                            z = false;
                        }
                        bV(z);
                        if (!z) {
                            if (d.bfa) {
                                beY.addEvent(str + "-preload", IX());
                                boolean unused = d.bfa = false;
                                return;
                            }
                            beY.addEvent(str, IX());
                            return;
                        }
                        beY.addEvent(str + "-destroy", IX());
                        boolean unused2 = d.bfa = false;
                        return;
                    case 1:
                        if (beY != null) {
                            beY.addEvent(str, IX());
                            IY();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (beY != null) {
                            beY.addEvent(str, IX());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.Tc().putString("aiapp_extra_need_download", "1");
        cVar.Tc().putString("aiapp_extra_preset_pkg", "0");
        cVar.Tc().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.bQA = "1";
        fVar.bQB = "0";
        fVar.mSource = "remote-debug";
        JSONObject lq = com.baidu.swan.apps.statistic.f.lq(cVar.SY());
        fVar.lz(cVar.Tc().getString("ubc"));
        fVar.ba(lq);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.x.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void IZ() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void Ja() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Jb() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
