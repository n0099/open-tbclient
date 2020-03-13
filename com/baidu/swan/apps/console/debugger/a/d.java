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
    private static d bkc;
    static Flow bkd;
    private static Timer bke;
    private static boolean bkf;

    public abstract void gD(String str);

    private d() {
    }

    public static d LI() {
        if (bkc == null) {
            synchronized (f.class) {
                if (bkc == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.ER()) {
                        bkc = new a();
                    } else {
                        bkc = new b();
                    }
                }
            }
        }
        return bkc;
    }

    public void LJ() {
        bkf = true;
    }

    String LK() {
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

    void ci(boolean z) {
        if (bkd == null) {
            bkd = s.rb("1153");
            if (!z) {
                bkd.addEvent("downloadstart", LK());
                bkd.addEvent("downloadsuccess", LK());
            }
            bke = new Timer();
            bke.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.LL();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void LL() {
        if (bkd != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
                jSONObject2.putOpt("appid", acG == null ? "" : acG.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            bkd.setValueWithDuration(jSONObject.toString());
            bkd.end();
        }
    }

    void release() {
        if (bke != null) {
            bke.cancel();
            bke = null;
        }
        bkc = null;
        bkd = null;
    }

    public static void v(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bkc != null) {
                bkc.gD(str);
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
        public void gD(String str) {
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
                        ci(true);
                        bkd.addEvent(str, LK());
                        return;
                    case 1:
                        if (bkd != null) {
                            bkd.cancel();
                        }
                        release();
                        return;
                    case 2:
                        LL();
                        release();
                        return;
                    default:
                        if (bkd != null) {
                            bkd.addEvent(str, LK());
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
        public void gD(String str) {
            SwanAppActivity acB;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.LQ()) {
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
                        if (com.baidu.swan.apps.runtime.e.acG() != null && (acB = com.baidu.swan.apps.runtime.e.acG().acB()) != null && !acB.isFinishing()) {
                            z = false;
                        }
                        ci(z);
                        if (!z) {
                            if (d.bkf) {
                                bkd.addEvent(str + "-preload", LK());
                                boolean unused = d.bkf = false;
                                return;
                            }
                            bkd.addEvent(str, LK());
                            return;
                        }
                        bkd.addEvent(str + "-destroy", LK());
                        boolean unused2 = d.bkf = false;
                        return;
                    case 1:
                        if (bkd != null) {
                            bkd.addEvent(str, LK());
                            LL();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bkd != null) {
                            bkd.addEvent(str, LK());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.VP().putString("aiapp_extra_need_download", "1");
        cVar.VP().putString("aiapp_extra_preset_pkg", "0");
        cVar.VP().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.bVr = "1";
        fVar.bVs = "0";
        fVar.mSource = "remote-debug";
        JSONObject lI = com.baidu.swan.apps.statistic.f.lI(cVar.VL());
        fVar.lR(cVar.VP().getString("ubc"));
        fVar.ba(lI);
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

    public static void LM() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void LN() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void LO() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
