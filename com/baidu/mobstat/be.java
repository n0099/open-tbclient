package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class be {
    private static final be c = new be();
    private boolean a = false;
    private volatile boolean b;

    public static be a() {
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
