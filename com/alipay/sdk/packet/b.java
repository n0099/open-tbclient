package com.alipay.sdk.packet;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f1909a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1910b;

    public b(String str, String str2) {
        this.f1909a = str;
        this.f1910b = str2;
    }

    public String a() {
        return this.f1909a;
    }

    public String b() {
        return this.f1910b;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f1910b)) {
            return null;
        }
        try {
            return new JSONObject(this.f1910b);
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f1909a, this.f1910b);
    }
}
