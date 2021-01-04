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
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b dsp = new b();
    private final List<d> dsl = new ArrayList();
    private final Map<String, d> dsm = new HashMap();
    private boolean dsn = false;
    private a dso;

    private b() {
    }

    public static b aGR() {
        return dsp;
    }

    public void reset() {
        this.dsn = false;
        synchronized (this.dsl) {
            this.dsl.clear();
            this.dsm.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dsn = true;
        synchronized (this.dsl) {
            this.dsl.clear();
            this.dsm.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dso = aVar;
    }

    public String qW(String str) {
        String str2 = null;
        if (!this.dsn) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.cw(currentTimeMillis);
                synchronized (this.dsl) {
                    this.dsm.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void end(String str) {
        if (!this.dsn) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dsl) {
                    d dVar = this.dsm.get(str);
                    if (dVar != null) {
                        dVar.cx(currentTimeMillis);
                        this.dsl.add(dVar);
                        this.dsm.remove(str);
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
            JSONArray aGS = aGS();
            if (aGS != null && aGS.length() > 0) {
                hybridUbcFlow.cn("ma_update_recorder", aGS.toString());
            }
            done();
        }
    }

    private JSONArray aGS() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dsl) {
            try {
                for (d dVar : this.dsl) {
                    if (dVar != null && (this.dso == null || this.dso.a(dVar))) {
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
