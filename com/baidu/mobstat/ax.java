package com.baidu.mobstat;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ax {

    /* renamed from: c  reason: collision with root package name */
    public static final ax f8738c = new ax();

    /* renamed from: a  reason: collision with root package name */
    public boolean f8739a = false;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f8740b;

    public static ax a() {
        return f8738c;
    }

    public boolean b() {
        return this.f8739a;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(str).opt("full");
            this.f8739a = (jSONObject != null ? jSONObject.optInt(IntentConfig.CLOSE) : 0) != 0;
        } catch (Exception unused) {
        }
        this.f8740b = true;
    }
}
