package com.baidu.android.pushservice.b;

import com.baidu.android.pushservice.PushConstants;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f303a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public JSONObject i;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(PushConstants.EXTRA_APP_ID, this.b);
        jSONObject.put(PushConstants.EXTRA_USER_ID, this.c);
        jSONObject.put(PushConstants.EXTRA_OPENTYPE, this.d);
        jSONObject.put("app_open_time", this.f);
        jSONObject.put("app_close_time", this.g);
        jSONObject.put("use_duration", this.h);
        if (this.e == null) {
            this.e = "";
        }
        jSONObject.put(PushConstants.EXTRA_MSGID, this.e);
        if (this.i == null) {
            this.i = new JSONObject();
        }
        jSONObject.put("extra", this.i);
        return jSONObject;
    }
}
