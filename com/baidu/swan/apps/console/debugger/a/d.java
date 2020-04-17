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
    private static boolean bIA;
    private static d bIx;
    static Flow bIy;
    private static Timer bIz;

    public abstract void hP(String str);

    private d() {
    }

    public static d Tz() {
        if (bIx == null) {
            synchronized (f.class) {
                if (bIx == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.MG()) {
                        bIx = new a();
                    } else {
                        bIx = new b();
                    }
                }
            }
        }
        return bIx;
    }

    public void TA() {
        bIA = true;
    }

    String TB() {
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

    void df(boolean z) {
        if (bIy == null) {
            bIy = s.sn("1153");
            if (!z) {
                bIy.addEvent("downloadstart", TB());
                bIy.addEvent("downloadsuccess", TB());
            }
            bIz = new Timer();
            bIz.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.TC();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void TC() {
        if (bIy != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e akO = com.baidu.swan.apps.runtime.e.akO();
                jSONObject2.putOpt("appid", akO == null ? "" : akO.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            bIy.setValueWithDuration(jSONObject.toString());
            bIy.end();
        }
    }

    void release() {
        if (bIz != null) {
            bIz.cancel();
            bIz = null;
        }
        bIx = null;
        bIy = null;
    }

    public static void w(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bIx != null) {
                bIx.hP(str);
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
        public void hP(String str) {
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
                        df(true);
                        bIy.addEvent(str, TB());
                        return;
                    case 1:
                        if (bIy != null) {
                            bIy.cancel();
                        }
                        release();
                        return;
                    case 2:
                        TC();
                        release();
                        return;
                    default:
                        if (bIy != null) {
                            bIy.addEvent(str, TB());
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
        public void hP(String str) {
            SwanAppActivity akJ;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.TH()) {
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
                        if (com.baidu.swan.apps.runtime.e.akO() != null && (akJ = com.baidu.swan.apps.runtime.e.akO().akJ()) != null && !akJ.isFinishing()) {
                            z = false;
                        }
                        df(z);
                        if (!z) {
                            if (d.bIA) {
                                bIy.addEvent(str + "-preload", TB());
                                boolean unused = d.bIA = false;
                                return;
                            }
                            bIy.addEvent(str, TB());
                            return;
                        }
                        bIy.addEvent(str + "-destroy", TB());
                        boolean unused2 = d.bIA = false;
                        return;
                    case 1:
                        if (bIy != null) {
                            bIy.addEvent(str, TB());
                            TC();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bIy != null) {
                            bIy.addEvent(str, TB());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.adH().putString("aiapp_extra_need_download", "1");
        cVar.adH().putString("aiapp_extra_preset_pkg", "0");
        cVar.adH().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cuu = "1";
        fVar.cuv = "0";
        fVar.mSource = "remote-debug";
        JSONObject mU = com.baidu.swan.apps.statistic.f.mU(cVar.adD());
        fVar.nd(cVar.adH().getString("ubc"));
        fVar.bl(mU);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.x.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void TD() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void TE() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void TF() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
