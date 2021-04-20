package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8367a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8368b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8369c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8370d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8371e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8372f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8373g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8374h = "";
    public String i = "";
    public String j = "";

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
        return i2 > i;
    }

    public JSONObject dumpToJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f8367a)) {
                jSONObject.put("v1", this.f8367a);
            }
            if (!TextUtils.isEmpty(this.f8368b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8368b);
            }
            if (!TextUtils.isEmpty(this.f8369c)) {
                jSONObject.put("v3", this.f8369c);
            }
            if (!TextUtils.isEmpty(this.f8370d)) {
                jSONObject.put("v4", this.f8370d);
            }
            if (!TextUtils.isEmpty(this.f8371e)) {
                jSONObject.put("v5", this.f8371e);
            }
            if (!TextUtils.isEmpty(this.f8372f)) {
                jSONObject.put("v6", this.f8372f);
            }
            if (!TextUtils.isEmpty(this.f8373g)) {
                jSONObject.put("v7", this.f8373g);
            }
            if (!TextUtils.isEmpty(this.f8374h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8374h);
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

    public String getV1() {
        return this.f8367a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8368b;
    }

    public String getV3() {
        return this.f8369c;
    }

    public String getV4() {
        return this.f8370d;
    }

    public String getV5() {
        return this.f8371e;
    }

    public String getV6() {
        return this.f8372f;
    }

    public String getV7() {
        return this.f8373g;
    }

    public String getV8() {
        return this.f8374h;
    }

    public String getV9() {
        return this.i;
    }

    public void setV1(String str) {
        this.f8367a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8368b = a(str);
    }

    public void setV3(String str) {
        this.f8369c = a(str);
    }

    public void setV4(String str) {
        this.f8370d = a(str);
    }

    public void setV5(String str) {
        this.f8371e = a(str);
    }

    public void setV6(String str) {
        this.f8372f = a(str);
    }

    public void setV7(String str) {
        this.f8373g = a(str);
    }

    public void setV8(String str) {
        this.f8374h = a(str);
    }

    public void setV9(String str) {
        this.i = a(str);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return a(str, 1024) ? "" : str;
    }
}
