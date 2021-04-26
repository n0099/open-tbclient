package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1886a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1887b;

    public b(String str, String str2) {
        this.f1886a = str;
        this.f1887b = str2;
    }

    public String a() {
        return this.f1886a;
    }

    public String b() {
        return this.f1887b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f1887b)) {
            return null;
        }
        try {
            return new JSONObject(this.f1887b);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f1886a, this.f1887b);
    }
}
