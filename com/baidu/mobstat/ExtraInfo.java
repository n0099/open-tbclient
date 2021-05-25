package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8378a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8379b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8380c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8381d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8382e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8383f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8384g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8385h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f8386i = "";
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
            if (!TextUtils.isEmpty(this.f8378a)) {
                jSONObject.put("v1", this.f8378a);
            }
            if (!TextUtils.isEmpty(this.f8379b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8379b);
            }
            if (!TextUtils.isEmpty(this.f8380c)) {
                jSONObject.put("v3", this.f8380c);
            }
            if (!TextUtils.isEmpty(this.f8381d)) {
                jSONObject.put("v4", this.f8381d);
            }
            if (!TextUtils.isEmpty(this.f8382e)) {
                jSONObject.put("v5", this.f8382e);
            }
            if (!TextUtils.isEmpty(this.f8383f)) {
                jSONObject.put("v6", this.f8383f);
            }
            if (!TextUtils.isEmpty(this.f8384g)) {
                jSONObject.put("v7", this.f8384g);
            }
            if (!TextUtils.isEmpty(this.f8385h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8385h);
            }
            if (!TextUtils.isEmpty(this.f8386i)) {
                jSONObject.put("v9", this.f8386i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("v10", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f8378a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8379b;
    }

    public String getV3() {
        return this.f8380c;
    }

    public String getV4() {
        return this.f8381d;
    }

    public String getV5() {
        return this.f8382e;
    }

    public String getV6() {
        return this.f8383f;
    }

    public String getV7() {
        return this.f8384g;
    }

    public String getV8() {
        return this.f8385h;
    }

    public String getV9() {
        return this.f8386i;
    }

    public void setV1(String str) {
        this.f8378a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8379b = a(str);
    }

    public void setV3(String str) {
        this.f8380c = a(str);
    }

    public void setV4(String str) {
        this.f8381d = a(str);
    }

    public void setV5(String str) {
        this.f8382e = a(str);
    }

    public void setV6(String str) {
        this.f8383f = a(str);
    }

    public void setV7(String str) {
        this.f8384g = a(str);
    }

    public void setV8(String str) {
        this.f8385h = a(str);
    }

    public void setV9(String str) {
        this.f8386i = a(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a(str, 1024) ? "" : str;
    }
}
