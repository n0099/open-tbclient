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
    private final Map<String, C0460a> dpD = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<String, C0460a>> dpE = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cJ(String str, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2);
        }
        C0460a c0460a = new C0460a(str, str2);
        this.dpD.put(c0460a.aGy(), c0460a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(@NonNull String str, String str2, @Nullable String str3) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2 + ", " + str3);
        }
        C0460a c0460a = new C0460a(str2, str3);
        ConcurrentHashMap<String, C0460a> concurrentHashMap = this.dpE.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.dpE.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(c0460a.aGy(), c0460a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray th(@Nullable String str) {
        ConcurrentHashMap<String, C0460a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.dpE.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0460a c0460a : this.dpD.values()) {
                jSONArray.put(c0460a.toJson());
            }
            for (C0460a c0460a2 : concurrentHashMap.values()) {
                jSONArray.put(c0460a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0460a {
        private String dpF;
        private final String mMessage;
        private long mTimestamp = System.currentTimeMillis();

        C0460a(String str, String str2) {
            this.dpF = str;
            this.mMessage = str2;
        }

        String aGy() {
            return this.dpF;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.dpF);
                jSONObject.put("timestamp", this.mTimestamp);
                jSONObject.put("message", this.mMessage);
            } catch (Exception e) {
                if (a.DEBUG) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
    }
}
