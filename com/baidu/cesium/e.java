package com.baidu.cesium;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class e {
    public String d;
    public String e;
    public int f = 2;
    private int n = 0;

    public static e M(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        eVar.d = str;
        eVar.n = TextUtils.isEmpty(str2) ? 0 : str2.length();
        if (eVar.n < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            eVar.e = str2;
        }
        return eVar;
    }

    public static boolean a(int i) {
        return i >= 14;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static e cd(String str) {
        return ce(e(str));
    }

    private static e ce(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String str2 = "0";
            while (keys.hasNext()) {
                String next = keys.next();
                if (!d("ZGV2aWNlaWQ=").equals(next) && !d("dmVy").equals(next)) {
                    str2 = jSONObject.optString(next, "0");
                }
            }
            String string = jSONObject.getString(d("ZGV2aWNlaWQ="));
            int i = jSONObject.getInt(d("dmVy"));
            int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
            if (!TextUtils.isEmpty(string)) {
                e eVar = new e();
                eVar.d = string;
                eVar.f = i;
                eVar.n = length;
                if (eVar.n < 14) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    eVar.e = str2;
                }
                eVar.e();
                return eVar;
            }
        } catch (JSONException e) {
            com.baidu.cesium.f.c.a(e);
        }
        return null;
    }

    private static String d(String str) {
        return new String(com.baidu.cesium.d.a.a(str.getBytes()));
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a = com.baidu.cesium.c.a.g.a();
            return new String(com.baidu.cesium.c.a.c.c(a, a, com.baidu.cesium.d.a.a(str.getBytes())));
        } catch (Exception e) {
            com.baidu.cesium.f.c.a(e);
            return "";
        }
    }

    private String f() {
        try {
            return new JSONObject().put(d("ZGV2aWNlaWQ="), this.d).put(d("aW1laQ=="), this.e).put(d("dmVy"), this.f).toString();
        } catch (JSONException e) {
            com.baidu.cesium.f.c.a(e);
            return null;
        }
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a = com.baidu.cesium.c.a.g.a();
            return com.baidu.cesium.d.a.a(com.baidu.cesium.c.a.c.a(a, a, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            com.baidu.cesium.f.c.a(e);
            return "";
        } catch (Exception e2) {
            com.baidu.cesium.f.c.a(e2);
            return "";
        }
    }

    boolean a() {
        return a(this.e);
    }

    boolean b() {
        return a(this.n);
    }

    public String c() {
        return f(f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        if (b()) {
            this.e = "O";
            return true;
        } else if (a()) {
            this.e = "0";
            return true;
        } else {
            return false;
        }
    }
}
