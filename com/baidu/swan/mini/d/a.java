package com.baidu.swan.mini.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<Integer, C0392a> cZJ = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<Integer, C0392a>> cZK = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void record(int i, @Nullable String str) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + i + ", " + str);
        }
        C0392a c0392a = new C0392a(i);
        this.cZJ.put(Integer.valueOf(c0392a.aBA()), c0392a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull String str, int i, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + i + ", " + str2);
        }
        C0392a c0392a = new C0392a(i);
        ConcurrentHashMap<Integer, C0392a> concurrentHashMap = this.cZK.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.cZK.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(c0392a.aBA()), c0392a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray rw(@Nullable String str) {
        ConcurrentHashMap<Integer, C0392a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.cZK.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0392a c0392a : this.cZJ.values()) {
                jSONArray.put(c0392a.toJson());
            }
            for (C0392a c0392a2 : concurrentHashMap.values()) {
                jSONArray.put(c0392a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0392a {
        private int cZL;
        private long mTimestamp = System.currentTimeMillis();

        C0392a(int i) {
            this.cZL = i;
        }

        int aBA() {
            return this.cZL;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.cZL);
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
