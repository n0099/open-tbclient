package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ax {
    private static final ax c = new ax();
    private boolean a = false;
    private volatile boolean b;

    public static ax a() {
        return c;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
                this.a = (jSONObject != null ? jSONObject.optInt("close") : 0) != 0;
            } catch (Exception e) {
            }
            this.b = true;
        }
    }

    public boolean b() {
        return this.a;
    }
}
