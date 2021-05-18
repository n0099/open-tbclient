package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8478a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8479b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8480c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8481d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8482e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8483f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8484g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8485h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f8486i = "";
    public String j = "";

    public static boolean a(String str, int i2) {
        int i3;
        if (str == null) {
            return false;
        }
        try {
            i3 = str.getBytes().length;
        } catch (Exception unused) {
            i3 = 0;
        }
        return i3 > i2;
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f8478a)) {
                jSONObject.put("v1", this.f8478a);
            }
            if (!TextUtils.isEmpty(this.f8479b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8479b);
            }
            if (!TextUtils.isEmpty(this.f8480c)) {
                jSONObject.put("v3", this.f8480c);
            }
            if (!TextUtils.isEmpty(this.f8481d)) {
                jSONObject.put("v4", this.f8481d);
            }
            if (!TextUtils.isEmpty(this.f8482e)) {
                jSONObject.put("v5", this.f8482e);
            }
            if (!TextUtils.isEmpty(this.f8483f)) {
                jSONObject.put("v6", this.f8483f);
            }
            if (!TextUtils.isEmpty(this.f8484g)) {
                jSONObject.put("v7", this.f8484g);
            }
            if (!TextUtils.isEmpty(this.f8485h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8485h);
            }
            if (!TextUtils.isEmpty(this.f8486i)) {
                jSONObject.put("v9", this.f8486i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("v10", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f8478a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8479b;
    }

    public String getV3() {
        return this.f8480c;
    }

    public String getV4() {
        return this.f8481d;
    }

    public String getV5() {
        return this.f8482e;
    }

    public String getV6() {
        return this.f8483f;
    }

    public String getV7() {
        return this.f8484g;
    }

    public String getV8() {
        return this.f8485h;
    }

    public String getV9() {
        return this.f8486i;
    }

    public void setV1(String str) {
        this.f8478a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8479b = a(str);
    }

    public void setV3(String str) {
        this.f8480c = a(str);
    }

    public void setV4(String str) {
        this.f8481d = a(str);
    }

    public void setV5(String str) {
        this.f8482e = a(str);
    }

    public void setV6(String str) {
        this.f8483f = a(str);
    }

    public void setV7(String str) {
        this.f8484g = a(str);
    }

    public void setV8(String str) {
        this.f8485h = a(str);
    }

    public void setV9(String str) {
        this.f8486i = a(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a(str, 1024) ? "" : str;
    }
}
