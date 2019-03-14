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
    public String aSs;
    public String aSz;
    public String mAppId;
    public String mAppVersion;
    public String mSource;
    public int aSy = -1;
    private HashMap<String, a> aSD = new HashMap<>();
    public int aSA = 0;
    public String aSB = "";

    public synchronized void a(a aVar) {
        if (b(aVar)) {
            if (DEBUG) {
                Log.d("FunnelFlow", "event is invalid");
            }
        } else {
            if (this.aSD.containsKey(aVar.id)) {
                this.aSD.remove(aVar.id);
            }
            this.aSD.put(aVar.id, aVar);
            if (DEBUG) {
                Log.d("FunnelFlow", "add event: " + aVar.toString());
            }
        }
    }

    public void Ku() {
        if (DEBUG) {
            Log.d("FunnelFlow", "sendUBC: start new thread");
        }
        j.LU().execute(new Runnable() { // from class: com.baidu.swan.apps.statistic.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.Kv();
            }
        });
    }

    public synchronized void clearAll() {
        if (this.aSD != null) {
            this.aSD.clear();
        }
        this.aSD = null;
        this.mAppId = null;
        this.mAppVersion = null;
        this.aSs = null;
        this.aSz = null;
        this.mSource = null;
        this.aSA = 0;
        this.aSB = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Kv() {
        if (DEBUG) {
            Log.d("FunnelFlow", "ubc: begin flow");
        }
        Flow jS = q.jS("820");
        if (jS == null || this.aSD == null) {
            if (DEBUG) {
                Log.w("FunnelFlow", "UBC Flow create failed, or events is null");
            }
        } else {
            for (a aVar : this.aSD.values()) {
                if (aVar.timestamp > 0) {
                    jS.addEvent(aVar.id, aVar.value, aVar.timestamp);
                    if (DEBUG) {
                        Log.d("FunnelFlow", "ubc: add event=" + aVar.toString());
                    }
                }
            }
            Kw();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", com.baidu.swan.apps.statistic.b.dA(this.aSy));
                jSONObject.put("type", String.valueOf(this.aSA));
                jSONObject.put("source", this.mSource);
                jSONObject.put(UBC.CONTENT_KEY_VALUE, "");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.mAppId);
                jSONObject2.put("swan", this.aSz);
                jSONObject2.put("appversion", this.mAppVersion);
                jSONObject2.put("thirdversion", this.aSs);
                jSONObject2.put("net", SwanAppNetworkUtils.Fd().type);
                jSONObject2.put("needdown", this.aSB);
                jSONObject2.put("pkgdown", this.aSC);
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.w("FunnelFlow", Log.getStackTraceString(e));
                }
            }
            jS.setValueWithDuration(jSONObject.toString());
            jS.end();
            if (DEBUG) {
                Log.d("FunnelFlow", "ubc: end flow");
            }
        }
    }

    private boolean b(a aVar) {
        return aVar != null && TextUtils.isEmpty(aVar.id);
    }

    private void Kw() {
        boolean isMainProcess = ProcessUtils.isMainProcess();
        if (DEBUG) {
            Log.d("FunnelFlow", "genInfo: isMainProcess=" + isMainProcess);
        }
        if (isMainProcess) {
            this.aSz = com.baidu.swan.apps.swancore.b.J(com.baidu.swan.apps.swancore.b.dK(this.aSy).aTd);
            return;
        }
        com.baidu.swan.apps.ae.b zb = e.Ec().zb();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (zb != null) {
            this.mAppVersion = zb.getVersion();
            bVar = zb.uB();
        }
        if (bVar != null) {
            this.aSy = bVar.axX;
            this.mAppId = bVar.mAppId;
            this.mSource = bVar.axG;
            this.aSs = bVar.aug;
            Bundle bundle = bVar.axQ;
            if (bundle != null) {
                this.aSB = bundle.getString("aiapp_extra_need_download", "");
                this.aSC = bundle.getString("aiapp_extra_pkg_download", "0");
            }
            this.aSz = com.baidu.swan.apps.swancore.b.dI(bVar.axX);
        }
        this.aSA = com.baidu.swan.apps.statistic.b.Kr();
    }
}
