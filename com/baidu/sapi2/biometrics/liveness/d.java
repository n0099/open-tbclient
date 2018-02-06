package com.baidu.sapi2.biometrics.liveness;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final String a = "stat_items";
    private static d c;
    private SharedPreferences b;
    private Context d;

    public static d a(Context context) {
        synchronized (d.class) {
            if (c == null) {
                c = new d(context.getApplicationContext());
            }
        }
        return c;
    }

    private d(Context context) {
        this.d = context;
        this.b = context.getSharedPreferences("rim_liveness_system", 0);
    }

    private void a(String str, String str2) {
        if (Build.VERSION.SDK_INT > 8) {
            this.b.edit().putString(str, str2).apply();
        } else {
            this.b.edit().putString(str, str2).commit();
        }
    }

    private String b(String str) {
        return this.b.getString(str, "");
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            try {
                Map<String, Map<String, String>> a2 = a();
                a2.put(str, map);
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, Map<String, String>> entry : a2.entrySet()) {
                    jSONObject.put(entry.getKey(), new JSONObject(entry.getValue()));
                }
                a(a, jSONObject.toString());
            } catch (Throwable th) {
                com.baidu.fsg.biometrics.base.d.c.a(th);
            }
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Map<String, Map<String, String>> a2 = a();
                if (a2.containsKey(str)) {
                    a2.remove(str);
                }
                a(a, new JSONObject(a2).toString());
            } catch (Throwable th) {
                com.baidu.fsg.biometrics.base.d.c.a(th);
            }
        }
    }

    public Map<String, Map<String, String>> a() {
        HashMap hashMap = new HashMap();
        String b = b(a);
        if (!TextUtils.isEmpty(b)) {
            try {
                JSONObject jSONObject = new JSONObject(b);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject(next);
                    if (optJSONObject != null) {
                        Iterator<String> keys2 = optJSONObject.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            String optString = optJSONObject.optString(next2);
                            if (!TextUtils.isEmpty(next2) && !TextUtils.isEmpty(optString)) {
                                hashMap2.put(next2, optString);
                            }
                        }
                    }
                    hashMap.put(next, hashMap2);
                }
            } catch (Throwable th) {
                com.baidu.fsg.biometrics.base.d.c.a(th);
            }
        }
        return hashMap;
    }
}
