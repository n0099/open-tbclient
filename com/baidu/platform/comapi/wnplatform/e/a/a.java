package com.baidu.platform.comapi.wnplatform.e.a;

import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f4619a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private boolean f4620b = false;

    public a a() {
        d();
        this.f4619a.append("{");
        e();
        return this;
    }

    public a b() {
        this.f4619a.append("}");
        f();
        return this;
    }

    public a a(String str) {
        d();
        this.f4619a.append(JSONObject.quote(str));
        this.f4619a.append(":");
        e();
        return this;
    }

    public a a(boolean z) {
        d();
        this.f4619a.append(z);
        f();
        return this;
    }

    public a a(int i) {
        d();
        this.f4619a.append(i);
        f();
        return this;
    }

    public a a(long j) {
        d();
        this.f4619a.append(j);
        f();
        return this;
    }

    public a a(double d) {
        d();
        this.f4619a.append(String.format("%f", Double.valueOf(d)));
        f();
        return this;
    }

    public a b(String str) {
        d();
        this.f4619a.append(JSONObject.quote(str));
        f();
        return this;
    }

    public a a(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return a((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return a((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return a(number.intValue());
            }
            if (obj instanceof Long) {
                return a(number.longValue());
            }
            if (obj instanceof Float) {
                return a(number.floatValue());
            }
            if (obj instanceof Double) {
                return a(number.doubleValue());
            }
        }
        return b(obj.toString());
    }

    private void d() {
        if (this.f4620b) {
            this.f4619a.append(",");
        }
    }

    private void e() {
        this.f4620b = false;
    }

    private void f() {
        this.f4620b = true;
    }

    public String c() {
        return this.f4619a.toString();
    }

    public String toString() {
        return c();
    }
}
