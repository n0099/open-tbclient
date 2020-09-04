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
    private static final b cFB = new b();
    private a cFA;
    private final List<d> cFx = new ArrayList();
    private final Map<String, d> cFy = new HashMap();
    private boolean cFz = false;

    private b() {
    }

    public static b avi() {
        return cFB;
    }

    public void reset() {
        this.cFz = false;
        synchronized (this.cFx) {
            this.cFx.clear();
            this.cFy.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.cFz = true;
        synchronized (this.cFx) {
            this.cFx.clear();
            this.cFy.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.cFA = aVar;
    }

    public String oP(String str) {
        String str2 = null;
        if (!this.cFz) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.bp(currentTimeMillis);
                synchronized (this.cFx) {
                    this.cFy.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void oQ(String str) {
        if (!this.cFz) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.cFx) {
                    d dVar = this.cFy.get(str);
                    if (dVar != null) {
                        dVar.bq(currentTimeMillis);
                        this.cFx.add(dVar);
                        this.cFy.remove(str);
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
            JSONArray avj = avj();
            if (avj != null && avj.length() > 0) {
                hybridUbcFlow.bW("ma_update_recorder", avj.toString());
            }
            done();
        }
    }

    private JSONArray avj() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.cFx) {
            try {
                for (d dVar : this.cFx) {
                    if (dVar != null && (this.cFA == null || this.cFA.a(dVar))) {
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
