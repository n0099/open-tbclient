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
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b dcc = new b();
    private final List<d> dbY = new ArrayList();
    private final Map<String, d> dbZ = new HashMap();
    private boolean dca = false;
    private a dcb;

    private b() {
    }

    public static b aAw() {
        return dcc;
    }

    public void reset() {
        this.dca = false;
        synchronized (this.dbY) {
            this.dbY.clear();
            this.dbZ.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dca = true;
        synchronized (this.dbY) {
            this.dbY.clear();
            this.dbZ.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dcb = aVar;
    }

    public String qn(String str) {
        String str2 = null;
        if (!this.dca) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bA(currentTimeMillis);
                synchronized (this.dbY) {
                    this.dbZ.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void qo(String str) {
        if (!this.dca) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dbY) {
                    d dVar = this.dbZ.get(str);
                    if (dVar != null) {
                        dVar.bB(currentTimeMillis);
                        this.dbY.add(dVar);
                        this.dbZ.remove(str);
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
            JSONArray aAx = aAx();
            if (aAx != null && aAx.length() > 0) {
                hybridUbcFlow.ci("ma_update_recorder", aAx.toString());
            }
            done();
        }
    }

    private JSONArray aAx() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dbY) {
            try {
                for (d dVar : this.dbY) {
                    if (dVar != null && (this.dcb == null || this.dcb.a(dVar))) {
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
