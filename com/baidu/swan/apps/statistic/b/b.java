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
    public String aVV;
    public String aWc;
    public String aWf;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int aWb = -1;
    private HashMap<String, a> aWg = new HashMap<>();
    public int aWd = 0;
    public String aWe = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.aWg.containsKey(aVar.id)) {
                this.aWg.remove(aVar.id);
            }
            this.aWg.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void NI() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.Po().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.NJ();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.aWg != null) {
            this.aWg.clear();
        }
        this.aWg = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.aVV = null;
        this.aWc = null;
        this.mSource = null;
        this.aWd = 0;
        this.aWe = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void NJ() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow kZ = s.kZ("820");
        if (kZ == null || this.aWg == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.aWg.values()) {
                if (aVar.timestamp > 0) {
                    kZ.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            NK();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", d.dN(this.aWb));
                jSONObject.put("type", String.valueOf(this.aWd));
                jSONObject.put("source", this.mSource);
                jSONObject.put(UBC.CONTENT_KEY_VALUE, "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.aWc);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.aVV);
                jSONObject2.put("net", SwanAppNetworkUtils.HR().type);
                jSONObject2.put("needdown", this.aWe);
                jSONObject2.put("pkgdown", this.aWf);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            kZ.setValueWithDuration(jSONObject.toString());
            kZ.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void NK() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.aWc = com.baidu.swan.apps.swancore.b.W(com.baidu.swan.apps.swancore.b.dX(this.aWb).aWG);
            return;
        }
        com.baidu.swan.apps.ae.b AE = e.GF().AE();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (AE != null) {
            this.mAppVersion = AE.getVersion();
            bVar = AE.vL();
        }
        if (bVar != null) {
            this.aWb = bVar.FQ();
            this.mAppId = bVar.getAppId();
            this.mSource = bVar.FG();
            this.aVV = bVar.getVersion();
            Bundle FK = bVar.FK();
            if (FK != null) {
                this.aWe = FK.getString("aiapp_extra_need_download", "");
                this.aWf = FK.getString("aiapp_extra_pkg_download", "0");
            }
            this.aWc = com.baidu.swan.apps.swancore.b.dV(bVar.FQ());
        }
        this.aWd = d.ND();
    }
}
