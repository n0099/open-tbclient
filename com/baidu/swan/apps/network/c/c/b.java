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
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final b drn = new b();
    private final List<d> drj = new ArrayList();
    private final Map<String, d> drk = new HashMap();
    private boolean drl = false;
    private a drm;

    private b() {
    }

    public static b aDx() {
        return drn;
    }

    public void reset() {
        this.drl = false;
        synchronized (this.drj) {
            this.drj.clear();
            this.drk.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.drl = true;
        synchronized (this.drj) {
            this.drj.clear();
            this.drk.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.drm = aVar;
    }

    public String qk(String str) {
        String str2 = null;
        if (!this.drl) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.cC(currentTimeMillis);
                synchronized (this.drj) {
                    this.drk.put(str2, dVar);
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
        if (!this.drl) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.drj) {
                    d dVar = this.drk.get(str);
                    if (dVar != null) {
                        dVar.cD(currentTimeMillis);
                        this.drj.add(dVar);
                        this.drk.remove(str);
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
            JSONArray aDy = aDy();
            if (aDy != null && aDy.length() > 0) {
                hybridUbcFlow.cg("ma_update_recorder", aDy.toString());
            }
            done();
        }
    }

    private JSONArray aDy() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.drj) {
            try {
                for (d dVar : this.drj) {
                    if (dVar != null && (this.drm == null || this.drm.a(dVar))) {
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
