package com.baidu.sapi2.utils;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class o {
    public static final String a = "t_open_login";
    public static final String b = "t_view_init_done";
    public static final String c = "t_before_login";
    public static final String d = "t_start_login";
    public static final String e = "t_load_login";
    public static final String f = "is_load_cache";
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public boolean l;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.g);
            jSONObject.put(b, this.h);
            jSONObject.put(c, this.i);
            jSONObject.put(d, this.j);
            jSONObject.put(e, this.k);
            jSONObject.put(f, this.l);
        } catch (JSONException e2) {
        }
        return jSONObject;
    }
}
