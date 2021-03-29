package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final String f11520g = "t_open_login";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11521h = "t_view_init_done";
    public static final String i = "t_before_login";
    public static final String j = "t_start_login";
    public static final String k = "t_load_login";
    public static final String l = "is_load_cache";

    /* renamed from: a  reason: collision with root package name */
    public long f11522a;

    /* renamed from: b  reason: collision with root package name */
    public long f11523b;

    /* renamed from: c  reason: collision with root package name */
    public long f11524c;

    /* renamed from: d  reason: collision with root package name */
    public long f11525d;

    /* renamed from: e  reason: collision with root package name */
    public long f11526e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11527f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f11520g, this.f11522a);
            jSONObject.put(f11521h, this.f11523b);
            jSONObject.put(i, this.f11524c);
            jSONObject.put(j, this.f11525d);
            jSONObject.put(k, this.f11526e);
            jSONObject.put(l, this.f11527f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
