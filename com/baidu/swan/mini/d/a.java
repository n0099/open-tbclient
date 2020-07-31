package com.baidu.swan.mini.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final Map<String, C0472a> dvu = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<String, C0472a>> dvv = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cM(String str, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2);
        }
        C0472a c0472a = new C0472a(str, str2);
        this.dvu.put(c0472a.aKp(), c0472a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(@NonNull String str, String str2, @Nullable String str3) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2 + ", " + str3);
        }
        C0472a c0472a = new C0472a(str2, str3);
        ConcurrentHashMap<String, C0472a> concurrentHashMap = this.dvv.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.dvv.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(c0472a.aKp(), c0472a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray uk(@Nullable String str) {
        ConcurrentHashMap<String, C0472a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.dvv.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0472a c0472a : this.dvu.values()) {
                jSONArray.put(c0472a.toJson());
            }
            for (C0472a c0472a2 : concurrentHashMap.values()) {
                jSONArray.put(c0472a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0472a {
        private String dvw;
        private final String mMessage;
        private long mTimestamp = System.currentTimeMillis();

        C0472a(String str, String str2) {
            this.dvw = str;
            this.mMessage = str2;
        }

        String aKp() {
            return this.dvw;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.dvw);
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
