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
    private static final b dnz = new b();
    private final List<d> dnv = new ArrayList();
    private final Map<String, d> dnw = new HashMap();
    private boolean dnx = false;
    private a dny;

    private b() {
    }

    public static b aCY() {
        return dnz;
    }

    public void reset() {
        this.dnx = false;
        synchronized (this.dnv) {
            this.dnv.clear();
            this.dnw.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.dnx = true;
        synchronized (this.dnv) {
            this.dnv.clear();
            this.dnw.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.dny = aVar;
    }

    public String pL(String str) {
        String str2 = null;
        if (!this.dnx) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.cw(currentTimeMillis);
                synchronized (this.dnv) {
                    this.dnw.put(str2, dVar);
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
        if (!this.dnx) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.dnv) {
                    d dVar = this.dnw.get(str);
                    if (dVar != null) {
                        dVar.cx(currentTimeMillis);
                        this.dnv.add(dVar);
                        this.dnw.remove(str);
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
            JSONArray aCZ = aCZ();
            if (aCZ != null && aCZ.length() > 0) {
                hybridUbcFlow.cm("ma_update_recorder", aCZ.toString());
            }
            done();
        }
    }

    private JSONArray aCZ() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.dnv) {
            try {
                for (d dVar : this.dnv) {
                    if (dVar != null && (this.dny == null || this.dny.a(dVar))) {
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
