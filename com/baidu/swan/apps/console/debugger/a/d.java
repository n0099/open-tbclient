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
/* loaded from: classes11.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d bkp;
    static Flow bkq;
    private static Timer bkr;
    private static boolean bks;

    public abstract void gC(String str);

    private d() {
    }

    public static d LL() {
        if (bkp == null) {
            synchronized (f.class) {
                if (bkp == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.EW()) {
                        bkp = new a();
                    } else {
                        bkp = new b();
                    }
                }
            }
        }
        return bkp;
    }

    public void LM() {
        bks = true;
    }

    String LN() {
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

    void cj(boolean z) {
        if (bkq == null) {
            bkq = s.ra("1153");
            if (!z) {
                bkq.addEvent("downloadstart", LN());
                bkq.addEvent("downloadsuccess", LN());
            }
            bkr = new Timer();
            bkr.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.LO();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void LO() {
        if (bkq != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e acJ = com.baidu.swan.apps.runtime.e.acJ();
                jSONObject2.putOpt("appid", acJ == null ? "" : acJ.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            bkq.setValueWithDuration(jSONObject.toString());
            bkq.end();
        }
    }

    void release() {
        if (bkr != null) {
            bkr.cancel();
            bkr = null;
        }
        bkp = null;
        bkq = null;
    }

    public static void v(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bkp != null) {
                bkp.gC(str);
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
        public void gC(String str) {
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
                        cj(true);
                        bkq.addEvent(str, LN());
                        return;
                    case 1:
                        if (bkq != null) {
                            bkq.cancel();
                        }
                        release();
                        return;
                    case 2:
                        LO();
                        release();
                        return;
                    default:
                        if (bkq != null) {
                            bkq.addEvent(str, LN());
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
        public void gC(String str) {
            SwanAppActivity acE;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.LT()) {
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
                        if (com.baidu.swan.apps.runtime.e.acJ() != null && (acE = com.baidu.swan.apps.runtime.e.acJ().acE()) != null && !acE.isFinishing()) {
                            z = false;
                        }
                        cj(z);
                        if (!z) {
                            if (d.bks) {
                                bkq.addEvent(str + "-preload", LN());
                                boolean unused = d.bks = false;
                                return;
                            }
                            bkq.addEvent(str, LN());
                            return;
                        }
                        bkq.addEvent(str + "-destroy", LN());
                        boolean unused2 = d.bks = false;
                        return;
                    case 1:
                        if (bkq != null) {
                            bkq.addEvent(str, LN());
                            LO();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bkq != null) {
                            bkq.addEvent(str, LN());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.VS().putString("aiapp_extra_need_download", "1");
        cVar.VS().putString("aiapp_extra_preset_pkg", "0");
        cVar.VS().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.bVC = "1";
        fVar.bVD = "0";
        fVar.mSource = "remote-debug";
        JSONObject lH = com.baidu.swan.apps.statistic.f.lH(cVar.VO());
        fVar.lQ(cVar.VS().getString("ubc"));
        fVar.ba(lH);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.x.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void LP() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void LQ() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LR() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
