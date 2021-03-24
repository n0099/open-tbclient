package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8879a;

    /* renamed from: b  reason: collision with root package name */
    public String f8880b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8881c;

    public ac() {
        this.f8879a = false;
        this.f8880b = "";
        this.f8881c = false;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f8879a);
        } catch (JSONException e2) {
            bb.c().b(e2);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f8880b);
        } catch (JSONException e3) {
            bb.c().b(e3);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.f8881c);
        } catch (JSONException e4) {
            bb.c().b(e4);
        }
        return jSONObject;
    }

    public ac(JSONObject jSONObject) {
        this.f8879a = false;
        this.f8880b = "";
        this.f8881c = false;
        try {
            this.f8879a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e2) {
            bb.c().b(e2);
        }
        try {
            this.f8880b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e3) {
            bb.c().b(e3);
        }
        try {
            this.f8881c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e4) {
            bb.c().b(e4);
        }
    }
}
