package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j {
    public static final String g = "t_open_login";
    public static final String h = "t_view_init_done";
    public static final String i = "t_before_login";
    public static final String j = "t_start_login";
    public static final String k = "t_load_login";
    public static final String l = "is_load_cache";

    /* renamed from: a  reason: collision with root package name */
    public long f5138a;

    /* renamed from: b  reason: collision with root package name */
    public long f5139b;
    public long c;
    public long d;
    public long e;
    public boolean f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(g, this.f5138a);
            jSONObject.put(h, this.f5139b);
            jSONObject.put(i, this.c);
            jSONObject.put(j, this.d);
            jSONObject.put(k, this.e);
            jSONObject.put(l, this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
