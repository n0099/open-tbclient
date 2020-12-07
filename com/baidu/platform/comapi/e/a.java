package com.baidu.platform.comapi.e;

import com.baidu.platform.comapi.b.c;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class a {
    private c c = null;
    private static JSONObject b = null;

    /* renamed from: a  reason: collision with root package name */
    public static a f2863a = null;

    public static a a() {
        if (f2863a == null) {
            f2863a = new a();
        }
        if (b == null) {
            b = new JSONObject();
        }
        return f2863a;
    }

    private void b() {
        b = null;
        b = new JSONObject();
    }

    public synchronized void a(String str, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (String str2 : map.keySet()) {
                try {
                    jSONObject.put(str2, map.get(str2));
                } catch (JSONException e) {
                }
            }
        }
        a(str, jSONObject);
    }

    public synchronized boolean a(String str) {
        boolean z;
        if (this.c == null) {
            this.c = c.a();
        }
        z = false;
        if (this.c != null) {
            z = (b == null || b.length() <= 0) ? this.c.a(1100, 1, str, null) : this.c.a(1100, 1, str, b.toString());
            b();
        }
        return z;
    }

    public synchronized boolean a(String str, JSONObject jSONObject) {
        if (this.c == null) {
            this.c = c.a();
        }
        return this.c != null ? (jSONObject == null || jSONObject.length() <= 0) ? this.c.a(1100, 1, str, null) : this.c.a(1100, 1, str, jSONObject.toString()) : false;
    }
}
