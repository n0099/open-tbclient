package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ax {

    /* renamed from: c  reason: collision with root package name */
    public static final ax f9043c = new ax();

    /* renamed from: a  reason: collision with root package name */
    public boolean f9044a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f9045b;

    public static ax a() {
        return f9043c;
    }

    public boolean b() {
        return this.f9044a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
            this.f9044a = (jSONObject != null ? jSONObject.optInt(IntentConfig.CLOSE) : 0) != 0;
        } catch (Exception unused) {
        }
        this.f9045b = true;
    }
}
