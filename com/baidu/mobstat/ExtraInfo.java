package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8666a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8667b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8668c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8669d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8670e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8671f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8672g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8673h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f8674i = "";
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
            if (!TextUtils.isEmpty(this.f8666a)) {
                jSONObject.put("v1", this.f8666a);
            }
            if (!TextUtils.isEmpty(this.f8667b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8667b);
            }
            if (!TextUtils.isEmpty(this.f8668c)) {
                jSONObject.put("v3", this.f8668c);
            }
            if (!TextUtils.isEmpty(this.f8669d)) {
                jSONObject.put("v4", this.f8669d);
            }
            if (!TextUtils.isEmpty(this.f8670e)) {
                jSONObject.put("v5", this.f8670e);
            }
            if (!TextUtils.isEmpty(this.f8671f)) {
                jSONObject.put("v6", this.f8671f);
            }
            if (!TextUtils.isEmpty(this.f8672g)) {
                jSONObject.put("v7", this.f8672g);
            }
            if (!TextUtils.isEmpty(this.f8673h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8673h);
            }
            if (!TextUtils.isEmpty(this.f8674i)) {
                jSONObject.put("v9", this.f8674i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("v10", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f8666a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8667b;
    }

    public String getV3() {
        return this.f8668c;
    }

    public String getV4() {
        return this.f8669d;
    }

    public String getV5() {
        return this.f8670e;
    }

    public String getV6() {
        return this.f8671f;
    }

    public String getV7() {
        return this.f8672g;
    }

    public String getV8() {
        return this.f8673h;
    }

    public String getV9() {
        return this.f8674i;
    }

    public void setV1(String str) {
        this.f8666a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8667b = a(str);
    }

    public void setV3(String str) {
        this.f8668c = a(str);
    }

    public void setV4(String str) {
        this.f8669d = a(str);
    }

    public void setV5(String str) {
        this.f8670e = a(str);
    }

    public void setV6(String str) {
        this.f8671f = a(str);
    }

    public void setV7(String str) {
        this.f8672g = a(str);
    }

    public void setV8(String str) {
        this.f8673h = a(str);
    }

    public void setV9(String str) {
        this.f8674i = a(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a(str, 1024) ? "" : str;
    }
}
