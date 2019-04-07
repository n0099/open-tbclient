package com.baidu.swan.apps.statistic.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.w.e;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.q;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public String aSC;
    public String aSF;
    public String aSv;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int aSB = -1;
    private HashMap<String, a> aSG = new HashMap<>();
    public int aSD = 0;
    public String aSE = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.aSG.containsKey(aVar.id)) {
                this.aSG.remove(aVar.id);
            }
            this.aSG.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void Ks() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.LS().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.Kt();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.aSG != null) {
            this.aSG.clear();
        }
        this.aSG = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.aSv = null;
        this.aSC = null;
        this.mSource = null;
        this.aSD = 0;
        this.aSE = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Kt() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow jT = q.jT("820");
        if (jT == null || this.aSG == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.aSG.values()) {
                if (aVar.timestamp > 0) {
                    jT.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            Ku();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", com.baidu.swan.apps.statistic.b.dz(this.aSB));
                jSONObject.put("type", String.valueOf(this.aSD));
                jSONObject.put("source", this.mSource);
                jSONObject.put(UBC.CONTENT_KEY_VALUE, "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.aSC);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.aSv);
                jSONObject2.put("net", SwanAppNetworkUtils.Fb().type);
                jSONObject2.put("needdown", this.aSE);
                jSONObject2.put("pkgdown", this.aSF);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            jT.setValueWithDuration(jSONObject.toString());
            jT.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void Ku() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.aSC = com.baidu.swan.apps.swancore.b.J(com.baidu.swan.apps.swancore.b.dJ(this.aSB).aTg);
            return;
        }
        com.baidu.swan.apps.ae.b za = e.Ea().za();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (za != null) {
            this.mAppVersion = za.getVersion();
            bVar = za.uA();
        }
        if (bVar != null) {
            this.aSB = bVar.aya;
            this.mAppId = bVar.mAppId;
            this.mSource = bVar.axJ;
            this.aSv = bVar.auk;
            Bundle bundle = bVar.axT;
            if (bundle != null) {
                this.aSE = bundle.getString("aiapp_extra_need_download", "");
                this.aSF = bundle.getString("aiapp_extra_pkg_download", "0");
            }
            this.aSC = com.baidu.swan.apps.swancore.b.dH(bVar.aya);
        }
        this.aSD = com.baidu.swan.apps.statistic.b.Kp();
    }
}
