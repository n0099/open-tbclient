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
    private final Map<String, C0454a> dkS = new ConcurrentHashMap();
    private final Map<String, ConcurrentHashMap<String, C0454a>> dkT = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cH(String str, @Nullable String str2) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2);
        }
        C0454a c0454a = new C0454a(str, str2);
        this.dkS.put(c0454a.aFs(), c0454a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(@NonNull String str, String str2, @Nullable String str3) {
        if (DEBUG) {
            Log.v("MiniPerformanceTracer", "(" + System.currentTimeMillis() + ") record: " + str + ", " + str2 + ", " + str3);
        }
        C0454a c0454a = new C0454a(str2, str3);
        ConcurrentHashMap<String, C0454a> concurrentHashMap = this.dkT.get(str);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.dkT.put(str, concurrentHashMap);
        }
        concurrentHashMap.put(c0454a.aFs(), c0454a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public JSONArray sZ(@Nullable String str) {
        ConcurrentHashMap<String, C0454a> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.dkT.get(str)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (C0454a c0454a : this.dkS.values()) {
                jSONArray.put(c0454a.toJson());
            }
            for (C0454a c0454a2 : concurrentHashMap.values()) {
                jSONArray.put(c0454a2.toJson());
            }
            return jSONArray;
        }
        return null;
    }

    /* renamed from: com.baidu.swan.mini.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class C0454a {
        private String dkU;
        private final String mMessage;
        private long mTimestamp = System.currentTimeMillis();

        C0454a(String str, String str2) {
            this.dkU = str;
            this.mMessage = str2;
        }

        String aFs() {
            return this.dkU;
        }

        @NonNull
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.dkU);
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
