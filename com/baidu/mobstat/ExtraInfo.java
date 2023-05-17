package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ExtraInfo {
    public String a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";

    public String getV1() {
        return this.a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.b;
    }

    public String getV3() {
        return this.c;
    }

    public String getV4() {
        return this.d;
    }

    public String getV5() {
        return this.e;
    }

    public String getV6() {
        return this.f;
    }

    public String getV7() {
        return this.g;
    }

    public String getV8() {
        return this.h;
    }

    public String getV9() {
        return this.i;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (a(str, 1024)) {
            return "";
        }
        return str;
    }

    public void setV1(String str) {
        this.a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.b = a(str);
    }

    public void setV3(String str) {
        this.c = a(str);
    }

    public void setV4(String str) {
        this.d = a(str);
    }

    public void setV5(String str) {
        this.e = a(str);
    }

    public void setV6(String str) {
        this.f = a(str);
    }

    public void setV7(String str) {
        this.g = a(str);
    }

    public void setV8(String str) {
        this.h = a(str);
    }

    public void setV9(String str) {
        this.i = a(str);
    }

    public static boolean a(String str, int i) {
        int i2;
        if (str == null) {
            return false;
        }
        try {
            i2 = str.getBytes().length;
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 <= i) {
            return false;
        }
        return true;
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.a)) {
                jSONObject.put("v1", this.a);
            }
            if (!TextUtils.isEmpty(this.b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.b);
            }
            if (!TextUtils.isEmpty(this.c)) {
                jSONObject.put("v3", this.c);
            }
            if (!TextUtils.isEmpty(this.d)) {
                jSONObject.put("v4", this.d);
            }
            if (!TextUtils.isEmpty(this.e)) {
                jSONObject.put("v5", this.e);
            }
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put("v6", this.f);
            }
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put("v7", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.h);
            }
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put("v9", this.i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("v10", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
