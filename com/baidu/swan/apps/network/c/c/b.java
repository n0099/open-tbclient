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
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b dnp = new b();
    private final List<d> dnl = new ArrayList();
    private final Map<String, d> dnm = new HashMap();
    private boolean dnn = false;
    private a dno;

    private b() {
    }

    public static b aFx() {
        return dnp;
    }

    public void reset() {
        this.dnn = false;
        synchronized (this.dnl) {
            this.dnl.clear();
            this.dnm.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dnn = true;
        synchronized (this.dnl) {
            this.dnl.clear();
            this.dnm.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dno = aVar;
    }

    public String rc(String str) {
        String str2 = null;
        if (!this.dnn) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.cv(currentTimeMillis);
                synchronized (this.dnl) {
                    this.dnm.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void rd(String str) {
        if (!this.dnn) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dnl) {
                    d dVar = this.dnm.get(str);
                    if (dVar != null) {
                        dVar.cw(currentTimeMillis);
                        this.dnl.add(dVar);
                        this.dnm.remove(str);
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
            JSONArray aFy = aFy();
            if (aFy != null && aFy.length() > 0) {
                hybridUbcFlow.co("ma_update_recorder", aFy.toString());
            }
            done();
        }
    }

    private JSONArray aFy() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dnl) {
            try {
                for (d dVar : this.dnl) {
                    if (dVar != null && (this.dno == null || this.dno.a(dVar))) {
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
