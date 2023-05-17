package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ar {
    public static final ar e = new ar();
    public boolean a = false;
    public float b = 50.0f;
    public long c = 500;
    public volatile boolean d;

    public static ar a() {
        return e;
    }

    public boolean b() {
        return this.a;
    }

    public float c() {
        float f = this.b;
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 100.0f) {
            f = 100.0f;
        }
        return f / 100.0f;
    }

    public long d() {
        return this.c;
    }

    public void a(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("sv");
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("close");
                String optString = jSONObject.optString(DnsModel.AREA_KEY);
                String optString2 = jSONObject.optString("duration");
                if (optInt != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.a = z;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.b = Float.valueOf(optString).floatValue();
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(optString2)) {
                    this.c = Long.valueOf(optString2).longValue();
                }
            }
        } catch (Exception unused2) {
        }
        this.d = true;
    }
}
