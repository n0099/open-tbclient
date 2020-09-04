package com.baidu.b;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class f {
    public String a;
    public String b;
    public int c = 2;
    private int d = 0;

    public static f N(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        f fVar = new f();
        fVar.a = str;
        fVar.d = TextUtils.isEmpty(str2) ? 0 : str2.length();
        if (fVar.d < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            fVar.b = str2;
        }
        return fVar;
    }

    public static boolean a(int i) {
        return i >= 14;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static f cW(String str) {
        return cX(e(str));
    }

    private static f cX(String str) {
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
                f fVar = new f();
                fVar.a = string;
                fVar.c = i;
                fVar.d = length;
                if (fVar.d < 14) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "0";
                    }
                    fVar.b = str2;
                }
                fVar.c();
                return fVar;
            }
        } catch (JSONException e) {
            com.baidu.b.f.c.a(e);
        }
        return null;
    }

    private static String d(String str) {
        return new String(com.baidu.b.d.a.a(str.getBytes()));
    }

    private static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a = com.baidu.b.c.a.g.a();
            return new String(com.baidu.b.c.a.c.a(a, a, com.baidu.b.d.a.a(str.getBytes())));
        } catch (Exception e) {
            com.baidu.b.f.c.a(e);
            return "";
        }
    }

    boolean a() {
        return a(this.b);
    }

    boolean b() {
        return a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        if (b()) {
            this.b = "O";
            return true;
        } else if (a()) {
            this.b = "0";
            return true;
        } else {
            return false;
        }
    }
}
