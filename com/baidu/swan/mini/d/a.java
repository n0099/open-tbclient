package com.baidu.swan.mini.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<Integer, C0352a> cwA = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<Integer, C0352a>> cwB = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void record(int i, @Nullable String str) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + i + ", " + str);
        }
        C0352a c0352a = new C0352a(i);
        this.cwA.put(Integer.valueOf(c0352a.aqX()), c0352a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@NonNull String str, int i, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + i + ", " + str2);
        }
        C0352a c0352a = new C0352a(i);
        ConcurrentHashMap<Integer, C0352a> concurrentHashMap = this.cwB.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.cwB.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(c0352a.aqX()), c0352a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray pV(@Nullable String str) {
        ConcurrentHashMap<Integer, C0352a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.cwB.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0352a c0352a : this.cwA.values()) {
                jSONArray.put(c0352a.toJson());
            }
            for (C0352a c0352a2 : concurrentHashMap.values()) {
                jSONArray.put(c0352a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0352a {
        private int cwC;
        private long mTimestamp = System.currentTimeMillis();

        C0352a(int i) {
            this.cwC = i;
        }

        int aqX() {
            return this.cwC;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.cwC);
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
