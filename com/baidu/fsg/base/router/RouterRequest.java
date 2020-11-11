package com.baidu.fsg.base.router;

import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class RouterRequest {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1482a = "RouterRequest";
    private String b = "";
    private String c = "";
    private HashMap d = new HashMap();

    public String getProvider() {
        return this.b;
    }

    public String getAction() {
        return this.c;
    }

    public HashMap getData() {
        return this.d;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("provider", this.b);
            jSONObject.put("action", this.c);
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Object obj : this.d.keySet()) {
                    jSONObject2.put(obj.toString(), this.d.get(obj));
                }
                jSONObject.put("data", jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
                jSONObject.put("data", "{}");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public RouterRequest provider(String str) {
        this.b = str;
        return this;
    }

    public RouterRequest action(String str) {
        this.c = str;
        return this;
    }

    public RouterRequest data(String str, Object obj) {
        this.d.put(str, obj);
        return this;
    }

    public RouterRequest data(HashMap hashMap) {
        this.d = hashMap;
        return this;
    }
}
