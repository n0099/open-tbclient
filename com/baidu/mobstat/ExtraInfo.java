package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.V8Engine;
import com.facebook.cache.disk.DefaultDiskStorage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ExtraInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8792a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f8793b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f8794c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f8795d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f8796e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f8797f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f8798g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f8799h = "";
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
            if (!TextUtils.isEmpty(this.f8792a)) {
                jSONObject.put("v1", this.f8792a);
            }
            if (!TextUtils.isEmpty(this.f8793b)) {
                jSONObject.put(DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX, this.f8793b);
            }
            if (!TextUtils.isEmpty(this.f8794c)) {
                jSONObject.put("v3", this.f8794c);
            }
            if (!TextUtils.isEmpty(this.f8795d)) {
                jSONObject.put("v4", this.f8795d);
            }
            if (!TextUtils.isEmpty(this.f8796e)) {
                jSONObject.put("v5", this.f8796e);
            }
            if (!TextUtils.isEmpty(this.f8797f)) {
                jSONObject.put("v6", this.f8797f);
            }
            if (!TextUtils.isEmpty(this.f8798g)) {
                jSONObject.put("v7", this.f8798g);
            }
            if (!TextUtils.isEmpty(this.f8799h)) {
                jSONObject.put(V8Engine.TYPE_V8, this.f8799h);
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
        return this.f8792a;
    }

    public String getV10() {
        return this.j;
    }

    public String getV2() {
        return this.f8793b;
    }

    public String getV3() {
        return this.f8794c;
    }

    public String getV4() {
        return this.f8795d;
    }

    public String getV5() {
        return this.f8796e;
    }

    public String getV6() {
        return this.f8797f;
    }

    public String getV7() {
        return this.f8798g;
    }

    public String getV8() {
        return this.f8799h;
    }

    public String getV9() {
        return this.i;
    }

    public void setV1(String str) {
        this.f8792a = a(str);
    }

    public void setV10(String str) {
        this.j = a(str);
    }

    public void setV2(String str) {
        this.f8793b = a(str);
    }

    public void setV3(String str) {
        this.f8794c = a(str);
    }

    public void setV4(String str) {
        this.f8795d = a(str);
    }

    public void setV5(String str) {
        this.f8796e = a(str);
    }

    public void setV6(String str) {
        this.f8797f = a(str);
    }

    public void setV7(String str) {
        this.f8798g = a(str);
    }

    public void setV8(String str) {
        this.f8799h = a(str);
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
