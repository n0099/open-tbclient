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
    public String aWA;
    public String aWD;
    public String aWt;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int aWz = -1;
    private HashMap<String, a> aWE = new HashMap<>();
    public int aWB = 0;
    public String aWC = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.aWE.containsKey(aVar.id)) {
                this.aWE.remove(aVar.id);
            }
            this.aWE.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void NM() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.Ps().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.NN();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.aWE != null) {
            this.aWE.clear();
        }
        this.aWE = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.aWt = null;
        this.aWA = null;
        this.mSource = null;
        this.aWB = 0;
        this.aWC = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void NN() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow lb = s.lb("820");
        if (lb == null || this.aWE == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.aWE.values()) {
                if (aVar.timestamp > 0) {
                    lb.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            NO();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", d.dO(this.aWz));
                jSONObject.put("type", String.valueOf(this.aWB));
                jSONObject.put("source", this.mSource);
                jSONObject.put(UBC.CONTENT_KEY_VALUE, "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.aWA);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.aWt);
                jSONObject2.put("net", SwanAppNetworkUtils.HV().type);
                jSONObject2.put("needdown", this.aWC);
                jSONObject2.put("pkgdown", this.aWD);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            lb.setValueWithDuration(jSONObject.toString());
            lb.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void NO() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.aWA = com.baidu.swan.apps.swancore.b.W(com.baidu.swan.apps.swancore.b.dY(this.aWz).aXe);
            return;
        }
        com.baidu.swan.apps.ae.b AI = e.GJ().AI();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (AI != null) {
            this.mAppVersion = AI.getVersion();
            bVar = AI.vP();
        }
        if (bVar != null) {
            this.aWz = bVar.FU();
            this.mAppId = bVar.getAppId();
            this.mSource = bVar.FK();
            this.aWt = bVar.getVersion();
            Bundle FO = bVar.FO();
            if (FO != null) {
                this.aWC = FO.getString("aiapp_extra_need_download", "");
                this.aWD = FO.getString("aiapp_extra_pkg_download", "0");
            }
            this.aWA = com.baidu.swan.apps.swancore.b.dW(bVar.FU());
        }
        this.aWB = d.NH();
    }
}
