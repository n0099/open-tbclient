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
    private final Map<Integer, C0362a> cAL = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<Integer, C0362a>> cAM = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void record(int i, @Nullable String str) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + i + ", " + str);
        }
        C0362a c0362a = new C0362a(i);
        this.cAL.put(Integer.valueOf(c0362a.atq()), c0362a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull String str, int i, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + i + ", " + str2);
        }
        C0362a c0362a = new C0362a(i);
        ConcurrentHashMap<Integer, C0362a> concurrentHashMap = this.cAM.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.cAM.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(c0362a.atq()), c0362a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray qj(@Nullable String str) {
        ConcurrentHashMap<Integer, C0362a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.cAM.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0362a c0362a : this.cAL.values()) {
                jSONArray.put(c0362a.toJson());
            }
            for (C0362a c0362a2 : concurrentHashMap.values()) {
                jSONArray.put(c0362a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0362a {
        private int cAN;
        private long mTimestamp = System.currentTimeMillis();

        C0362a(int i) {
            this.cAN = i;
        }

        int atq() {
            return this.cAN;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.cAN);
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
