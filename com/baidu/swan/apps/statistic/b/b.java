package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.statistic.d;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.s;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aVl;
    public String aVs;
    public String aVv;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int aVr = -1;
    private HashMap<String, a> aVw = new HashMap<>();
    public int aVt = 0;
    public String aVu = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.aVw.containsKey(aVar.id)) {
                this.aVw.remove(aVar.id);
            }
            this.aVw.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void MT() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.Oz().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.MU();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.aVw != null) {
            this.aVw.clear();
        }
        this.aVw = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.aVl = null;
        this.aVs = null;
        this.mSource = null;
        this.aVt = 0;
        this.aVu = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void MU() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow kR = s.kR("820");
        if (kR == null || this.aVw == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.aVw.values()) {
                if (aVar.timestamp > 0) {
                    kR.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            MV();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", d.dK(this.aVr));
                jSONObject.put("type", String.valueOf(this.aVt));
                jSONObject.put("source", this.mSource);
                jSONObject.put(UBC.CONTENT_KEY_VALUE, "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.aVs);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.aVl);
                jSONObject2.put("net", SwanAppNetworkUtils.Hg().type);
                jSONObject2.put("needdown", this.aVu);
                jSONObject2.put("pkgdown", this.aVv);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            kR.setValueWithDuration(jSONObject.toString());
            kR.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void MV() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.aVs = com.baidu.swan.apps.swancore.b.W(com.baidu.swan.apps.swancore.b.dU(this.aVr).aVW);
            return;
        }
        com.baidu.swan.apps.ae.b zX = e.FV().zX();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (zX != null) {
            this.mAppVersion = zX.getVersion();
            bVar = zX.vk();
        }
        if (bVar != null) {
            this.aVr = bVar.Fg();
            this.mAppId = bVar.getAppId();
            this.mSource = bVar.EW();
            this.aVl = bVar.getVersion();
            Bundle Fa = bVar.Fa();
            if (Fa != null) {
                this.aVu = Fa.getString("aiapp_extra_need_download", "");
                this.aVv = Fa.getString("aiapp_extra_pkg_download", "0");
            }
            this.aVs = com.baidu.swan.apps.swancore.b.dS(bVar.Fg());
        }
        this.aVt = d.MO();
    }
}
