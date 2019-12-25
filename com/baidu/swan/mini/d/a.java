package com.baidu.swan.mini.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<Integer, C0350a> cwp = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<Integer, C0350a>> cwq = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void record(int i, @Nullable String str) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + i + ", " + str);
        }
        C0350a c0350a = new C0350a(i);
        this.cwp.put(Integer.valueOf(c0350a.aqE()), c0350a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull String str, int i, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + i + ", " + str2);
        }
        C0350a c0350a = new C0350a(i);
        ConcurrentHashMap<Integer, C0350a> concurrentHashMap = this.cwq.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.cwq.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(c0350a.aqE()), c0350a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray pS(@Nullable String str) {
        ConcurrentHashMap<Integer, C0350a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.cwq.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0350a c0350a : this.cwp.values()) {
                jSONArray.put(c0350a.toJson());
            }
            for (C0350a c0350a2 : concurrentHashMap.values()) {
                jSONArray.put(c0350a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0350a {
        private int cwr;
        private long mTimestamp = System.currentTimeMillis();

        C0350a(int i) {
            this.cwr = i;
        }

        int aqE() {
            return this.cwr;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.cwr);
                jSONObject.put("timestamp", this.mTimestamp);
            } catch (Exception e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
