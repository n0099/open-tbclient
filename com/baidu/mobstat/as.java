package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class as {

    /* renamed from: e  reason: collision with root package name */
    public static final as f8963e = new as();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8964a = false;

    /* renamed from: b  reason: collision with root package name */
    public float f8965b = 50.0f;

    /* renamed from: c  reason: collision with root package name */
    public long f8966c = 500;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f8967d;

    public static as a() {
        return f8963e;
    }

    public boolean b() {
        return this.f8964a;
    }

    public float c() {
        float f2 = this.f8965b;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 100.0f) {
            f2 = 100.0f;
        }
        return f2 / 100.0f;
    }

    public long d() {
        return this.f8966c;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("sv");
            if (jSONObject != null) {
                int optInt = jSONObject.optInt(IntentConfig.CLOSE);
                String optString = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_AREA);
                String optString2 = jSONObject.optString("duration");
                this.f8964a = optInt != 0;
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        this.f8965b = Float.valueOf(optString).floatValue();
                    } catch (Exception unused) {
                    }
                }
                if (!TextUtils.isEmpty(optString2)) {
                    this.f8966c = Long.valueOf(optString2).longValue();
                }
            }
        } catch (Exception unused2) {
        }
        this.f8967d = true;
    }
}
