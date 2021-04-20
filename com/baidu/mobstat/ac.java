package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ac {

    /* renamed from: a  reason: collision with root package name */
    public boolean f8454a;

    /* renamed from: b  reason: collision with root package name */
    public String f8455b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8456c;

    public ac() {
        this.f8454a = false;
        this.f8455b = "";
        this.f8456c = false;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.f8454a);
        } catch (JSONException e2) {
            bb.c().b(e2);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.f8455b);
        } catch (JSONException e3) {
            bb.c().b(e3);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.f8456c);
        } catch (JSONException e4) {
            bb.c().b(e4);
        }
        return jSONObject;
    }

    public ac(JSONObject jSONObject) {
        this.f8454a = false;
        this.f8455b = "";
        this.f8456c = false;
        try {
            this.f8454a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e2) {
            bb.c().b(e2);
        }
        try {
            this.f8455b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e3) {
            bb.c().b(e3);
        }
        try {
            this.f8456c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e4) {
            bb.c().b(e4);
        }
    }
}
