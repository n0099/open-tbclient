package com.baidu.mobads.cid.cesium;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f8283a;

    /* renamed from: b  reason: collision with root package name */
    public String f8284b;

    /* renamed from: c  reason: collision with root package name */
    public int f8285c = 2;

    /* renamed from: d  reason: collision with root package name */
    public int f8286d = 0;

    public static e a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = new e();
        eVar.f8283a = str;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        eVar.f8286d = length;
        if (length < 14) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            eVar.f8284b = str2;
        }
        return eVar;
    }

    public static boolean a(int i2) {
        return i2 >= 14;
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }

    public static e b(String str) {
        return c(e(str));
    }

    public static e c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            String str2 = "0";
            String str3 = "0";
            while (keys.hasNext()) {
                String next = keys.next();
                if (!d("ZGV2aWNlaWQ=").equals(next) && !d("dmVy").equals(next)) {
                    str3 = jSONObject.optString(next, "0");
                }
            }
            String string = jSONObject.getString(d("ZGV2aWNlaWQ="));
            int i2 = jSONObject.getInt(d("dmVy"));
            int length = TextUtils.isEmpty(str3) ? 0 : str3.length();
            if (!TextUtils.isEmpty(string)) {
                e eVar = new e();
                eVar.f8283a = string;
                eVar.f8285c = i2;
                eVar.f8286d = length;
                if (length < 14) {
                    if (!TextUtils.isEmpty(str3)) {
                        str2 = str3;
                    }
                    eVar.f8284b = str2;
                }
                eVar.c();
                return eVar;
            }
        } catch (JSONException e2) {
            com.baidu.mobads.cid.cesium.f.c.a(e2);
        }
        return null;
    }

    public static String d(String str) {
        return new String(com.baidu.mobads.cid.cesium.d.a.a(str.getBytes()));
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] a2 = com.baidu.mobads.cid.cesium.c.a.g.a();
            return new String(com.baidu.mobads.cid.cesium.c.a.c.a(a2, a2, com.baidu.mobads.cid.cesium.d.a.a(str.getBytes())));
        } catch (Exception e2) {
            com.baidu.mobads.cid.cesium.f.c.a(e2);
            return "";
        }
    }

    public boolean a() {
        return a(this.f8284b);
    }

    public boolean b() {
        return a(this.f8286d);
    }

    public boolean c() {
        String str;
        if (b()) {
            str = "O";
        } else if (!a()) {
            return false;
        } else {
            str = "0";
        }
        this.f8284b = str;
        return true;
    }
}
