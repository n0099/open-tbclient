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
    private static d bRt;
    static com.baidu.swan.apps.statistic.a bRu;
    private static Timer bRv;
    private static boolean bRw;

    public abstract void iQ(String str);

    private d() {
    }

    public static d Wf() {
        if (bRt == null) {
            synchronized (f.class) {
                if (bRt == null) {
                    if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                        bRt = new a();
                    } else {
                        bRt = new b();
                    }
                }
            }
        }
        return bRt;
    }

    public void Wg() {
        bRw = true;
    }

    String Wh() {
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

    void ds(boolean z) {
        if (bRu == null) {
            bRu = h.ow("1153");
            if (!z) {
                com.baidu.swan.apps.statistic.b.a(bRu, "downloadstart", Wh());
                com.baidu.swan.apps.statistic.b.a(bRu, "downloadsuccess", Wh());
            }
            bRv = new Timer();
            bRv.schedule(new TimerTask() { // from class: com.baidu.swan.apps.console.debugger.a.d.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (d.DEBUG) {
                        Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                    }
                    d.this.Wi();
                    d.this.release();
                }
            }, 40000L);
        }
    }

    protected void Wi() {
        if (bRu != null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
                jSONObject2.putOpt("appid", aoG == null ? "" : aoG.getAppKey());
                jSONObject2.putOpt("from", "remote-debug");
                jSONObject.putOpt("from", "swan");
                jSONObject.putOpt("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
                }
            }
            com.baidu.swan.apps.statistic.b.a(bRu, jSONObject.toString());
            com.baidu.swan.apps.statistic.b.c(bRu);
        }
    }

    void release() {
        if (bRv != null) {
            bRv.cancel();
            bRv = null;
        }
        bRt = null;
        bRu = null;
    }

    public static void x(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            String str = "";
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            }
            if (!TextUtils.isEmpty(str) && bRt != null) {
                bRt.iQ(str);
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
        public void iQ(String str) {
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
                        ds(true);
                        com.baidu.swan.apps.statistic.b.a(bRu, str, Wh());
                        return;
                    case 1:
                        if (bRu != null) {
                            com.baidu.swan.apps.statistic.b.b(bRu);
                        }
                        release();
                        return;
                    case 2:
                        Wi();
                        release();
                        return;
                    default:
                        if (bRu != null) {
                            com.baidu.swan.apps.statistic.b.a(bRu, str, Wh());
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
        public void iQ(String str) {
            SwanAppActivity aoz;
            boolean z = true;
            if (!TextUtils.isEmpty(str) && !e.Wn()) {
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
                        if (com.baidu.swan.apps.runtime.e.aoG() != null && (aoz = com.baidu.swan.apps.runtime.e.aoG().aoz()) != null && !aoz.isFinishing()) {
                            z = false;
                        }
                        ds(z);
                        if (!z) {
                            if (d.bRw) {
                                com.baidu.swan.apps.statistic.b.a(bRu, str + "-preload", Wh());
                                boolean unused = d.bRw = false;
                                return;
                            }
                            com.baidu.swan.apps.statistic.b.a(bRu, str, Wh());
                            return;
                        }
                        com.baidu.swan.apps.statistic.b.a(bRu, str + "-destroy", Wh());
                        boolean unused2 = d.bRw = false;
                        return;
                    case 1:
                        if (bRu != null) {
                            com.baidu.swan.apps.statistic.b.a(bRu, str, Wh());
                            Wi();
                            release();
                            return;
                        }
                        return;
                    default:
                        if (bRu != null) {
                            com.baidu.swan.apps.statistic.b.a(bRu, str, Wh());
                            return;
                        }
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(com.baidu.swan.apps.v.b.c cVar) {
        cVar.agQ().putString("aiapp_extra_need_download", "1");
        cVar.agQ().putString("aiapp_extra_preset_pkg", "0");
        cVar.agQ().putString("aiapp_extra_pkg_downloading", "0");
        cVar.agQ().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = h.gU(cVar.getAppFrameType());
        fVar.b(cVar);
        fVar.mType = Config.LAUNCH;
        fVar.cGz = "1";
        fVar.cGB = "0";
        fVar.cGA = "0";
        fVar.mSource = "remote-debug";
        JSONObject ox = h.ox(cVar.agM());
        fVar.oG(cVar.agQ().getString("ubc"));
        fVar.bu(ox);
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(com.baidu.swan.apps.v.b.c cVar) {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.b(cVar);
        fVar.mFrom = h.gU(cVar.getAppFrameType());
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadsuccess";
        h.onEvent(fVar);
    }

    public static void Wj() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "loadmaster";
        h.onEvent(fVar);
    }

    public static void Wk() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "appready";
        h.onEvent(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void Wl() {
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mFrom = "swan";
        fVar.mType = Config.LAUNCH;
        fVar.mSource = "remote-debug";
        fVar.mValue = "downloadstart";
        h.onEvent(fVar);
    }
}
