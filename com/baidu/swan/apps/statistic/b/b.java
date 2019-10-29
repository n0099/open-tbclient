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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String bpE;
    public String bpH;
    public String bpx;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int bpD = -1;
    private HashMap<String, a> bpI = new HashMap<>();
    public int bpF = 0;
    public String bpG = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.bpI.containsKey(aVar.id)) {
                this.bpI.remove(aVar.id);
            }
            this.bpI.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void SC() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.Ui().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.SD();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.bpI != null) {
            this.bpI.clear();
        }
        this.bpI = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.bpx = null;
        this.bpE = null;
        this.mSource = null;
        this.bpF = 0;
        this.bpG = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void SD() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow lD = s.lD("820");
        if (lD == null || this.bpI == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.bpI.values()) {
                if (aVar.timestamp > 0) {
                    lD.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            SE();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", d.eJ(this.bpD));
                jSONObject.put("type", String.valueOf(this.bpF));
                jSONObject.put("source", this.mSource);
                jSONObject.put("value", "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.bpE);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.bpx);
                jSONObject2.put("net", SwanAppNetworkUtils.MP().type);
                jSONObject2.put("needdown", this.bpG);
                jSONObject2.put("pkgdown", this.bpH);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            lD.setValueWithDuration(jSONObject.toString());
            lD.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void SE() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.bpE = com.baidu.swan.apps.swancore.b.ap(com.baidu.swan.apps.swancore.b.eT(this.bpD).bqi);
            return;
        }
        com.baidu.swan.apps.ae.b FD = e.LD().FD();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (FD != null) {
            this.mAppVersion = FD.getVersion();
            bVar = FD.AJ();
        }
        if (bVar != null) {
            this.bpD = bVar.KO();
            this.mAppId = bVar.getAppId();
            this.mSource = bVar.KE();
            this.bpx = bVar.getVersion();
            Bundle KI = bVar.KI();
            if (KI != null) {
                this.bpG = KI.getString("aiapp_extra_need_download", "");
                this.bpH = KI.getString("aiapp_extra_pkg_download", "0");
            }
            this.bpE = com.baidu.swan.apps.swancore.b.eR(bVar.KO());
        }
        this.bpF = d.Sx();
    }
}
