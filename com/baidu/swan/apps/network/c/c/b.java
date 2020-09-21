package com.baidu.swan.apps.network.c.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b cHB = new b();
    private a cHA;
    private final List<d> cHx = new ArrayList();
    private final Map<String, d> cHy = new HashMap();
    private boolean cHz = false;

    private b() {
    }

    public static b avR() {
        return cHB;
    }

    public void reset() {
        this.cHz = false;
        synchronized (this.cHx) {
            this.cHx.clear();
            this.cHy.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.cHz = true;
        synchronized (this.cHx) {
            this.cHx.clear();
            this.cHy.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.cHA = aVar;
    }

    public String pi(String str) {
        String str2 = null;
        if (!this.cHz) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bq(currentTimeMillis);
                synchronized (this.cHx) {
                    this.cHy.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void pj(String str) {
        if (!this.cHz) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.cHx) {
                    d dVar = this.cHy.get(str);
                    if (dVar != null) {
                        dVar.br(currentTimeMillis);
                        this.cHx.add(dVar);
                        this.cHy.remove(str);
                    }
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            JSONArray avS = avS();
            if (avS != null && avS.length() > 0) {
                hybridUbcFlow.bW("ma_update_recorder", avS.toString());
            }
            done();
        }
    }

    private JSONArray avS() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.cHx) {
            try {
                for (d dVar : this.cHx) {
                    if (dVar != null && (this.cHA == null || this.cHA.a(dVar))) {
                        jSONArray.put(dVar.toJson());
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }
}
