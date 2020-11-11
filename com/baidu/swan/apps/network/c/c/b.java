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
    private static final b dhX = new b();
    private final List<d> dhT = new ArrayList();
    private final Map<String, d> dhU = new HashMap();
    private boolean dhV = false;
    private a dhW;

    private b() {
    }

    public static b aCW() {
        return dhX;
    }

    public void reset() {
        this.dhV = false;
        synchronized (this.dhT) {
            this.dhT.clear();
            this.dhU.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dhV = true;
        synchronized (this.dhT) {
            this.dhT.clear();
            this.dhU.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dhW = aVar;
    }

    public String qB(String str) {
        String str2 = null;
        if (!this.dhV) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bW(currentTimeMillis);
                synchronized (this.dhT) {
                    this.dhU.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void qC(String str) {
        if (!this.dhV) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dhT) {
                    d dVar = this.dhU.get(str);
                    if (dVar != null) {
                        dVar.bX(currentTimeMillis);
                        this.dhT.add(dVar);
                        this.dhU.remove(str);
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
            JSONArray aCX = aCX();
            if (aCX != null && aCX.length() > 0) {
                hybridUbcFlow.ci("ma_update_recorder", aCX.toString());
            }
            done();
        }
    }

    private JSONArray aCX() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dhT) {
            try {
                for (d dVar : this.dhT) {
                    if (dVar != null && (this.dhW == null || this.dhW.a(dVar))) {
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
