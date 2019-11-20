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
    public String bpf;
    public String bpm;
    public String bpp;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int bpl = -1;
    private HashMap<String, a> bpq = new HashMap<>();
    public int bpn = 0;
    public String bpo = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.bpq.containsKey(aVar.id)) {
                this.bpq.remove(aVar.id);
            }
            this.bpq.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void SE() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.Ug().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.SF();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.bpq != null) {
            this.bpq.clear();
        }
        this.bpq = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.bpf = null;
        this.bpm = null;
        this.mSource = null;
        this.bpn = 0;
        this.bpo = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void SF() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow lD = s.lD("820");
        if (lD == null || this.bpq == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.bpq.values()) {
                if (aVar.timestamp > 0) {
                    lD.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            SG();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", d.eJ(this.bpl));
                jSONObject.put("type", String.valueOf(this.bpn));
                jSONObject.put("source", this.mSource);
                jSONObject.put("value", "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.bpm);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.bpf);
                jSONObject2.put("net", SwanAppNetworkUtils.MQ().type);
                jSONObject2.put("needdown", this.bpo);
                jSONObject2.put("pkgdown", this.bpp);
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

    private void SG() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.bpm = com.baidu.swan.apps.swancore.b.ao(com.baidu.swan.apps.swancore.b.eT(this.bpl).bpQ);
            return;
        }
        com.baidu.swan.apps.ae.b FE = e.LE().FE();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (FE != null) {
            this.mAppVersion = FE.getVersion();
            bVar = FE.AK();
        }
        if (bVar != null) {
            this.bpl = bVar.KP();
            this.mAppId = bVar.getAppId();
            this.mSource = bVar.KF();
            this.bpf = bVar.getVersion();
            Bundle KJ = bVar.KJ();
            if (KJ != null) {
                this.bpo = KJ.getString("aiapp_extra_need_download", "");
                this.bpp = KJ.getString("aiapp_extra_pkg_download", "0");
            }
            this.bpm = com.baidu.swan.apps.swancore.b.eR(bVar.KP());
        }
        this.bpn = d.Sz();
    }
}
