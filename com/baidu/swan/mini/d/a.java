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
    private final Map<Integer, C0413a> cZO = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<Integer, C0413a>> cZP = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void record(int i, @Nullable String str) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + i + ", " + str);
        }
        C0413a c0413a = new C0413a(i);
        this.cZO.put(Integer.valueOf(c0413a.aBA()), c0413a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(@NonNull String str, int i, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + i + ", " + str2);
        }
        C0413a c0413a = new C0413a(i);
        ConcurrentHashMap<Integer, C0413a> concurrentHashMap = this.cZP.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.cZP.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(Integer.valueOf(c0413a.aBA()), c0413a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray rw(@Nullable String str) {
        ConcurrentHashMap<Integer, C0413a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.cZP.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0413a c0413a : this.cZO.values()) {
                jSONArray.put(c0413a.toJson());
            }
            for (C0413a c0413a2 : concurrentHashMap.values()) {
                jSONArray.put(c0413a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0413a {
        private int cZQ;
        private long mTimestamp = System.currentTimeMillis();

        C0413a(int i) {
            this.cZQ = i;
        }

        int aBA() {
            return this.cZQ;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.cZQ);
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
