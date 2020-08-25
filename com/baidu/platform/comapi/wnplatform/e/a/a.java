package com.baidu.platform.comapi.wnplatform.e.a;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class a {
    private StringBuilder a = new StringBuilder();
    private boolean b = false;

    public a a() {
        d();
        this.a.append("{");
        e();
        return this;
    }

    public a b() {
        this.a.append("}");
        f();
        return this;
    }

    public a a(String str) {
        d();
        this.a.append(JSONObject.quote(str));
        this.a.append(":");
        e();
        return this;
    }

    public a a(boolean z) {
        d();
        this.a.append(z);
        f();
        return this;
    }

    public a a(int i) {
        d();
        this.a.append(i);
        f();
        return this;
    }

    public a a(long j) {
        d();
        this.a.append(j);
        f();
        return this;
    }

    public a a(double d) {
        d();
        this.a.append(String.format("%f", Double.valueOf(d)));
        f();
        return this;
    }

    public a b(String str) {
        d();
        this.a.append(JSONObject.quote(str));
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
        if (this.b) {
            this.a.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }

    private void e() {
        this.b = false;
    }

    private void f() {
        this.b = true;
    }

    public String c() {
        return this.a.toString();
    }

    public String toString() {
        return c();
    }
}
