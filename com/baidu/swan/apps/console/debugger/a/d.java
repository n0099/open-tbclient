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
    private static d bIC;
    static Flow bID;
    private static Timer bIE;
    private static boolean bIF;

    public abstract void hP(String str);

    private d() {
    }

    public static d Ty() {
        if (bIC == null) {
            synchronized (f.class) {
                if (bIC == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.MF()) {
                        bIC = new a();
                    } else {
                        bIC = new b();
                    }
                }
            }
        }
        return bIC;
    }

    public void Tz() {
        bIF = true;
    }

    String TA() {
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
        if (bID == null) {
            bID = s.sn("1153");
            if (!z) {
                bID.addEvent("downloadstart", TA());
                bID.addEvent("downloadsuccess", TA());
            }
            bIE = new Timer();
            bIE.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.TB();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void TB() {
        if (bID != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
                jSONObject2.putOpt("appid", akN == null ? "" : akN.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            bID.setValueWithDuration(jSONObject.toString());
            bID.end();
        }
    }

    void release() {
        if (bIE != null) {
            bIE.cancel();
            bIE = null;
        }
        bIC = null;
        bID = null;
    }

    public static void w(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bIC != null) {
                bIC.hP(str);
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
                        bID.addEvent(str, TA());
                        return;
                    case 1:
                        if (bID != null) {
                            bID.cancel();
                        }
                        release();
                        return;
                    case 2:
                        TB();
                        release();
                        return;
                    default:
                        if (bID != null) {
                            bID.addEvent(str, TA());
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
            SwanAppActivity akI;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.TG()) {
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
                        if (com.baidu.swan.apps.runtime.e.akN() != null && (akI = com.baidu.swan.apps.runtime.e.akN().akI()) != null && !akI.isFinishing()) {
                            z = false;
                        }
                        df(z);
                        if (!z) {
                            if (d.bIF) {
                                bID.addEvent(str + "-preload", TA());
                                boolean unused = d.bIF = false;
                                return;
                            }
                            bID.addEvent(str, TA());
                            return;
                        }
                        bID.addEvent(str + "-destroy", TA());
                        boolean unused2 = d.bIF = false;
                        return;
                    case 1:
                        if (bID != null) {
                            bID.addEvent(str, TA());
                            TB();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bID != null) {
                            bID.addEvent(str, TA());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.adG().putString("aiapp_extra_need_download", "1");
        cVar.adG().putString("aiapp_extra_preset_pkg", "0");
        cVar.adG().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cuA = "1";
        fVar.cuB = "0";
        fVar.mSource = "remote-debug";
        JSONObject mU = com.baidu.swan.apps.statistic.f.mU(cVar.adC());
        fVar.nd(cVar.adG().getString("ubc"));
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

    public static void TC() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void TD() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void TE() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
