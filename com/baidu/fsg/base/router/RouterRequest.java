package com.baidu.fsg.base.router;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RouterRequest {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5282a = "RouterRequest";

    /* renamed from: b  reason: collision with root package name */
    public String f5283b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f5284c = "";

    /* renamed from: d  reason: collision with root package name */
    public HashMap f5285d = new HashMap();

    public RouterRequest action(String str) {
        this.f5284c = str;
        return this;
    }

    public RouterRequest data(String str, Object obj) {
        this.f5285d.put(str, obj);
        return this;
    }

    public String getAction() {
        return this.f5284c;
    }

    public HashMap getData() {
        return this.f5285d;
    }

    public String getProvider() {
        return this.f5283b;
    }

    public RouterRequest provider(String str) {
        this.f5283b = str;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("provider", this.f5283b);
            jSONObject.put("action", this.f5284c);
            try {
                JSONObject jSONObject2 = new JSONObject();
                for (Object obj : this.f5285d.keySet()) {
                    jSONObject2.put(obj.toString(), this.f5285d.get(obj));
                }
                jSONObject.put("data", jSONObject2);
            } catch (Exception e2) {
                e2.printStackTrace();
                jSONObject.put("data", StringUtil.EMPTY_ARRAY);
            }
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    public RouterRequest data(HashMap hashMap) {
        this.f5285d = hashMap;
        return this;
    }
}
