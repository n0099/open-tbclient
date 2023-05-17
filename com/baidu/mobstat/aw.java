package com.baidu.mobstat;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class aw {
    public static final aw c = new aw();
    public boolean a = false;
    public volatile boolean b;

    public static aw a() {
        return c;
    }

    public boolean b() {
        return this.a;
    }

    public void a(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
            boolean z = false;
            if (jSONObject != null) {
                i = jSONObject.optInt("close");
            } else {
                i = 0;
            }
            if (i != 0) {
                z = true;
            }
            this.a = z;
        } catch (Exception unused) {
        }
        this.b = true;
    }
}
