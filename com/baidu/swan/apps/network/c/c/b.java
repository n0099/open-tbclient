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
    private static final b cxD = new b();
    private a cxC;
    private final List<d> cxz = new ArrayList();
    private final Map<String, d> cxA = new HashMap();
    private boolean cxB = false;

    private b() {
    }

    public static b ann() {
        return cxD;
    }

    public void reset() {
        this.cxB = false;
        synchronized (this.cxz) {
            this.cxz.clear();
            this.cxA.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.cxB = true;
        synchronized (this.cxz) {
            this.cxz.clear();
            this.cxA.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.cxC = aVar;
    }

    public String mP(String str) {
        String str2 = null;
        if (!this.cxB) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bk(currentTimeMillis);
                synchronized (this.cxz) {
                    this.cxA.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void mQ(String str) {
        if (!this.cxB) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.cxz) {
                    d dVar = this.cxA.get(str);
                    if (dVar != null) {
                        dVar.bl(currentTimeMillis);
                        this.cxz.add(dVar);
                        this.cxA.remove(str);
                    }
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow != null) {
            JSONArray ano = ano();
            if (ano != null && ano.length() > 0) {
                hybridUbcFlow.bH("ma_update_recorder", ano.toString());
            }
            done();
        }
    }

    private JSONArray ano() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.cxz) {
            try {
                for (d dVar : this.cxz) {
                    if (dVar != null && (this.cxC == null || this.cxC.a(dVar))) {
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
