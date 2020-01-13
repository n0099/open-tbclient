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
/* loaded from: classes10.dex */
public abstract class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d bfN;
    static Flow bfO;
    private static Timer bfP;
    private static boolean bfQ;

    public abstract void gn(String str);

    private d() {
    }

    public static d Jr() {
        if (bfN == null) {
            synchronized (f.class) {
                if (bfN == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.Ct()) {
                        bfN = new a();
                    } else {
                        bfN = new b();
                    }
                }
            }
        }
        return bfN;
    }

    public void Js() {
        bfQ = true;
    }

    String Jt() {
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

    void ca(boolean z) {
        if (bfO == null) {
            bfO = s.qM("1153");
            if (!z) {
                bfO.addEvent("downloadstart", Jt());
                bfO.addEvent("downloadsuccess", Jt());
            }
            bfP = new Timer();
            bfP.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.Ju();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void Ju() {
        if (bfO != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aaq = com.baidu.swan.apps.runtime.e.aaq();
                jSONObject2.putOpt("appid", aaq == null ? "" : aaq.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            bfO.setValueWithDuration(jSONObject.toString());
            bfO.end();
        }
    }

    void release() {
        if (bfP != null) {
            bfP.cancel();
            bfP = null;
        }
        bfN = null;
        bfO = null;
    }

    public static void v(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bfN != null) {
                bfN.gn(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends d {
        private a() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void gn(String str) {
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
                        ca(true);
                        bfO.addEvent(str, Jt());
                        return;
                    case 1:
                        if (bfO != null) {
                            bfO.cancel();
                        }
                        release();
                        return;
                    case 2:
                        Ju();
                        release();
                        return;
                    default:
                        if (bfO != null) {
                            bfO.addEvent(str, Jt());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class b extends d {
        private b() {
            super();
        }

        @Override // com.baidu.swan.apps.console.debugger.a.d
        public void gn(String str) {
            SwanAppActivity aal;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.Jz()) {
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
                        if (com.baidu.swan.apps.runtime.e.aaq() != null && (aal = com.baidu.swan.apps.runtime.e.aaq().aal()) != null && !aal.isFinishing()) {
                            z = false;
                        }
                        ca(z);
                        if (!z) {
                            if (d.bfQ) {
                                bfO.addEvent(str + "-preload", Jt());
                                boolean unused = d.bfQ = false;
                                return;
                            }
                            bfO.addEvent(str, Jt());
                            return;
                        }
                        bfO.addEvent(str + "-destroy", Jt());
                        boolean unused2 = d.bfQ = false;
                        return;
                    case 1:
                        if (bfO != null) {
                            bfO.addEvent(str, Jt());
                            Ju();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bfO != null) {
                            bfO.addEvent(str, Jt());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.x.b.c cVar) {
        cVar.Tz().putString("aiapp_extra_need_download", "1");
        cVar.Tz().putString("aiapp_extra_preset_pkg", "0");
        cVar.Tz().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.bRk = "1";
        fVar.bRl = "0";
        fVar.mSource = "remote-debug";
        JSONObject lt = com.baidu.swan.apps.statistic.f.lt(cVar.Tv());
        fVar.lC(cVar.Tz().getString("ubc"));
        fVar.ba(lt);
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.x.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void Jv() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    public static void Jw() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Jx() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        com.baidu.swan.apps.statistic.f.onEvent(fVar);
    }
}
