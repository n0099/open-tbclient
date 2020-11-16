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
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b dgq = new b();
    private final List<d> dgm = new ArrayList();
    private final Map<String, d> dgn = new HashMap();
    private boolean dgo = false;
    private a dgp;

    private b() {
    }

    public static b aCo() {
        return dgq;
    }

    public void reset() {
        this.dgo = false;
        synchronized (this.dgm) {
            this.dgm.clear();
            this.dgn.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dgo = true;
        synchronized (this.dgm) {
            this.dgm.clear();
            this.dgn.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dgp = aVar;
    }

    public String qv(String str) {
        String str2 = null;
        if (!this.dgo) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bW(currentTimeMillis);
                synchronized (this.dgm) {
                    this.dgn.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void qw(String str) {
        if (!this.dgo) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dgm) {
                    d dVar = this.dgn.get(str);
                    if (dVar != null) {
                        dVar.bX(currentTimeMillis);
                        this.dgm.add(dVar);
                        this.dgn.remove(str);
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
            JSONArray aCp = aCp();
            if (aCp != null && aCp.length() > 0) {
                hybridUbcFlow.ch("ma_update_recorder", aCp.toString());
            }
            done();
        }
    }

    private JSONArray aCp() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dgm) {
            try {
                for (d dVar : this.dgm) {
                    if (dVar != null && (this.dgp == null || this.dgp.a(dVar))) {
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
