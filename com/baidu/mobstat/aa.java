package com.baidu.mobstat;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aa {
    public boolean a;
    public String b;
    public boolean c;

    public aa() {
        this.a = false;
        this.b = "";
        this.c = false;
    }

    public aa(JSONObject jSONObject) {
        this.a = false;
        this.b = "";
        this.c = false;
        try {
            this.a = jSONObject.getBoolean("SDK_BPLUS_SERVICE");
        } catch (Exception e) {
            ba.c().b(e);
        }
        try {
            this.b = jSONObject.getString("SDK_PRODUCT_LY");
        } catch (Exception e2) {
            ba.c().b(e2);
        }
        try {
            this.c = jSONObject.getBoolean("SDK_LOCAL_SERVER");
        } catch (Exception e3) {
            ba.c().b(e3);
        }
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SDK_BPLUS_SERVICE", this.a);
        } catch (JSONException e) {
            ba.c().b(e);
        }
        try {
            jSONObject.put("SDK_PRODUCT_LY", this.b);
        } catch (JSONException e2) {
            ba.c().b(e2);
        }
        try {
            jSONObject.put("SDK_LOCAL_SERVER", this.c);
        } catch (JSONException e3) {
            ba.c().b(e3);
        }
        return jSONObject;
    }
}
