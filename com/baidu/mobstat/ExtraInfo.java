package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8440a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8441b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8442c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8443d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8444e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8445f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8446g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8447h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f8448i = "";
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
            if (!TextUtils.isEmpty(this.f8440a)) {
                jSONObject.put("v1", this.f8440a);
            }
            if (!TextUtils.isEmpty(this.f8441b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8441b);
            }
            if (!TextUtils.isEmpty(this.f8442c)) {
                jSONObject.put("v3", this.f8442c);
            }
            if (!TextUtils.isEmpty(this.f8443d)) {
                jSONObject.put("v4", this.f8443d);
            }
            if (!TextUtils.isEmpty(this.f8444e)) {
                jSONObject.put("v5", this.f8444e);
            }
            if (!TextUtils.isEmpty(this.f8445f)) {
                jSONObject.put("v6", this.f8445f);
            }
            if (!TextUtils.isEmpty(this.f8446g)) {
                jSONObject.put("v7", this.f8446g);
            }
            if (!TextUtils.isEmpty(this.f8447h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8447h);
            }
            if (!TextUtils.isEmpty(this.f8448i)) {
                jSONObject.put("v9", this.f8448i);
            }
            if (!TextUtils.isEmpty(this.j)) {
                jSONObject.put("v10", this.j);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String getV1() {
        return this.f8440a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8441b;
    }

    public String getV3() {
        return this.f8442c;
    }

    public String getV4() {
        return this.f8443d;
    }

    public String getV5() {
        return this.f8444e;
    }

    public String getV6() {
        return this.f8445f;
    }

    public String getV7() {
        return this.f8446g;
    }

    public String getV8() {
        return this.f8447h;
    }

    public String getV9() {
        return this.f8448i;
    }

    public void setV1(String str) {
        this.f8440a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8441b = a(str);
    }

    public void setV3(String str) {
        this.f8442c = a(str);
    }

    public void setV4(String str) {
        this.f8443d = a(str);
    }

    public void setV5(String str) {
        this.f8444e = a(str);
    }

    public void setV6(String str) {
        this.f8445f = a(str);
    }

    public void setV7(String str) {
        this.f8446g = a(str);
    }

    public void setV8(String str) {
        this.f8447h = a(str);
    }

    public void setV9(String str) {
        this.f8448i = a(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a(str, 1024) ? "" : str;
    }
}
