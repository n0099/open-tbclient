package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.ubc.UBC;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class as {
    private static final as e = new as();
    private boolean a = false;
    private float b = 50.0f;
    private long c = 500;
    private volatile boolean d;

    public static as a() {
        return e;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("sv");
                if (jSONObject != null) {
                    int optInt = jSONObject.optInt("close");
                    String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                    String optString2 = jSONObject.optString(UBC.CONTENT_KEY_DURATION);
                    this.a = optInt != 0;
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            this.b = Float.valueOf(optString).floatValue();
                        } catch (Exception e2) {
                        }
                    }
                    if (!TextUtils.isEmpty(optString2)) {
                        try {
                            this.c = Long.valueOf(optString2).longValue();
                        } catch (Exception e3) {
                        }
                    }
                }
            } catch (Exception e4) {
            }
            this.d = true;
        }
    }

    public boolean b() {
        return this.a;
    }

    public float c() {
        float f = 0.0f;
        float f2 = this.b;
        if (f2 >= 0.0f) {
            f = f2 > 100.0f ? 100.0f : f2;
        }
        return f / 100.0f;
    }

    public long d() {
        return this.c;
    }
}
