package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final String f11104g = "t_open_login";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11105h = "t_view_init_done";
    public static final String i = "t_before_login";
    public static final String j = "t_start_login";
    public static final String k = "t_load_login";
    public static final String l = "is_load_cache";

    /* renamed from: a  reason: collision with root package name */
    public long f11106a;

    /* renamed from: b  reason: collision with root package name */
    public long f11107b;

    /* renamed from: c  reason: collision with root package name */
    public long f11108c;

    /* renamed from: d  reason: collision with root package name */
    public long f11109d;

    /* renamed from: e  reason: collision with root package name */
    public long f11110e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11111f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f11104g, this.f11106a);
            jSONObject.put(f11105h, this.f11107b);
            jSONObject.put(i, this.f11108c);
            jSONObject.put(j, this.f11109d);
            jSONObject.put(k, this.f11110e);
            jSONObject.put(l, this.f11111f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
