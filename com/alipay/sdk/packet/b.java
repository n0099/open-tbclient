package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1899a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1900b;

    public b(String str, String str2) {
        this.f1899a = str;
        this.f1900b = str2;
    }

    public String a() {
        return this.f1899a;
    }

    public String b() {
        return this.f1900b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f1900b)) {
            return null;
        }
        try {
            return new JSONObject(this.f1900b);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f1899a, this.f1900b);
    }
}
