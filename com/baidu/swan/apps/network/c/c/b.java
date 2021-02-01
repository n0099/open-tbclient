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
    private static final b dpM = new b();
    private final List<d> dpI = new ArrayList();
    private final Map<String, d> dpJ = new HashMap();
    private boolean dpK = false;
    private a dpL;

    private b() {
    }

    public static b aDu() {
        return dpM;
    }

    public void reset() {
        this.dpK = false;
        synchronized (this.dpI) {
            this.dpI.clear();
            this.dpJ.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dpK = true;
        synchronized (this.dpI) {
            this.dpI.clear();
            this.dpJ.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dpL = aVar;
    }

    public String qd(String str) {
        String str2 = null;
        if (!this.dpK) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.cC(currentTimeMillis);
                synchronized (this.dpI) {
                    this.dpJ.put(str2, dVar);
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
        if (!this.dpK) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dpI) {
                    d dVar = this.dpJ.get(str);
                    if (dVar != null) {
                        dVar.cD(currentTimeMillis);
                        this.dpI.add(dVar);
                        this.dpJ.remove(str);
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
            JSONArray aDv = aDv();
            if (aDv != null && aDv.length() > 0) {
                hybridUbcFlow.cg("ma_update_recorder", aDv.toString());
            }
            done();
        }
    }

    private JSONArray aDv() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dpI) {
            try {
                for (d dVar : this.dpI) {
                    if (dVar != null && (this.dpL == null || this.dpL.a(dVar))) {
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
