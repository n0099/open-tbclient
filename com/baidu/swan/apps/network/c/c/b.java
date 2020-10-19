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
    private static final b cTE = new b();
    private final List<d> cTA = new ArrayList();
    private final Map<String, d> cTB = new HashMap();
    private boolean cTC = false;
    private a cTD;

    private b() {
    }

    public static b ayC() {
        return cTE;
    }

    public void reset() {
        this.cTC = false;
        synchronized (this.cTA) {
            this.cTA.clear();
            this.cTB.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void done() {
        this.cTC = true;
        synchronized (this.cTA) {
            this.cTA.clear();
            this.cTB.clear();
        }
        if (DEBUG) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void a(a aVar) {
        this.cTD = aVar;
    }

    public String pU(String str) {
        String str2 = null;
        if (!this.cTC) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "begin update scope id - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                str2 = Thread.currentThread().getName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + UUID.randomUUID().toString();
                d dVar = new d(str);
                dVar.by(currentTimeMillis);
                synchronized (this.cTA) {
                    this.cTB.put(str2, dVar);
                }
                if (DEBUG) {
                    Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
                    Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
                }
            }
        }
        return str2;
    }

    public void pV(String str) {
        if (!this.cTC) {
            if (DEBUG) {
                Log.d("MaUpdateRecorder", "end update uni tag - " + str);
            }
            if (!TextUtils.isEmpty(str)) {
                long currentTimeMillis = System.currentTimeMillis();
                synchronized (this.cTA) {
                    d dVar = this.cTB.get(str);
                    if (dVar != null) {
                        dVar.bz(currentTimeMillis);
                        this.cTA.add(dVar);
                        this.cTB.remove(str);
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
            JSONArray ayD = ayD();
            if (ayD != null && ayD.length() > 0) {
                hybridUbcFlow.cb("ma_update_recorder", ayD.toString());
            }
            done();
        }
    }

    private JSONArray ayD() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.cTA) {
            try {
                for (d dVar : this.cTA) {
                    if (dVar != null && (this.cTD == null || this.cTD.a(dVar))) {
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
