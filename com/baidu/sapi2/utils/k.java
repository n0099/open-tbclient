package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: g  reason: collision with root package name */
    public static final String f11519g = "t_open_login";

    /* renamed from: h  reason: collision with root package name */
    public static final String f11520h = "t_view_init_done";
    public static final String i = "t_before_login";
    public static final String j = "t_start_login";
    public static final String k = "t_load_login";
    public static final String l = "is_load_cache";

    /* renamed from: a  reason: collision with root package name */
    public long f11521a;

    /* renamed from: b  reason: collision with root package name */
    public long f11522b;

    /* renamed from: c  reason: collision with root package name */
    public long f11523c;

    /* renamed from: d  reason: collision with root package name */
    public long f11524d;

    /* renamed from: e  reason: collision with root package name */
    public long f11525e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11526f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f11519g, this.f11521a);
            jSONObject.put(f11520h, this.f11522b);
            jSONObject.put(i, this.f11523c);
            jSONObject.put(j, this.f11524d);
            jSONObject.put(k, this.f11525e);
            jSONObject.put(l, this.f11526f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
