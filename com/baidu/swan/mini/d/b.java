package com.baidu.swan.mini.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.ubc.s;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cAD = new a();

    public void M(int i, @Nullable String str) {
        this.cAD.record(i, str);
    }

    public void m(@NonNull String str, int i, @Nullable String str2) {
        this.cAD.l(str, i, str2);
    }

    public void f(@NonNull final String str, @Nullable final Map<String, String> map) {
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.mini.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                JSONArray qk = b.this.cAD.qk(str);
                if (qk != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("from", "swan");
                        JSONObject jSONObject2 = new JSONObject();
                        if (map != null) {
                            for (String str2 : map.keySet()) {
                                jSONObject2.put(str2, map.get(str2));
                            }
                        }
                        jSONObject2.put("info", qk);
                        jSONObject.put("ext", jSONObject2);
                        b.this.j("1181", jSONObject);
                    } catch (Exception e) {
                        if (b.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "SwanMiniReportPerformance");
    }

    public void d(final int i, @Nullable final String str, @Nullable final String str2, @Nullable final String str3) {
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.mini.d.b.2
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("from", "swan");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("errCode", i);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject2.put("errMessage", str);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject2.put("appKey", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("bundleId", str3);
                    }
                    jSONObject.put("ext", jSONObject2);
                    b.this.j("1182", jSONObject);
                } catch (Exception e) {
                    if (b.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }, "SwanMiniReportError");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(@NonNull final String str, @NonNull final JSONObject jSONObject) {
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.mini.d.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.i("MiniStatisticsProcessor", "SwanMiniUbc == type(" + str + "), content:" + jSONObject.toString());
                }
                s.k(str, jSONObject);
            }
        }, "SwanMiniUbcReport");
    }
}
