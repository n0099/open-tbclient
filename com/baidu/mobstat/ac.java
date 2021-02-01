package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3644a;

    /* renamed from: b  reason: collision with root package name */
    public String f3645b;
    public boolean c;

    public ac() {
        this.f3644a = false;
        this.f3645b = "";
        this.c = false;
    }

    public ac(JSONObject jSONObject) {
        this.f3644a = false;
        this.f3645b = "";
        this.c = false;
        try {
            this.f3644a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e) {
            bb.c().b(e);
        }
        try {
            this.f3645b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e2) {
            bb.c().b(e2);
        }
        try {
            this.c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e3) {
            bb.c().b(e3);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f3644a);
        } catch (JSONException e) {
            bb.c().b(e);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f3645b);
        } catch (JSONException e2) {
            bb.c().b(e2);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.c);
        } catch (JSONException e3) {
            bb.c().b(e3);
        }
        return jSONObject;
    }
}
