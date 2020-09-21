package com.baidu.platform.comapi.util;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonBuilder {
    private StringBuilder a = new StringBuilder();
    private boolean b = false;

    private void a() {
        if (this.b) {
            this.a.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }

    private void b() {
        this.b = false;
    }

    private void c() {
        this.b = true;
    }

    public JsonBuilder arrayValue() {
        a();
        this.a.append("[");
        b();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.a.append("]");
        c();
        return this;
    }

    public JsonBuilder endObject() {
        this.a.append("}");
        c();
        return this;
    }

    public String getJson() {
        return this.a.toString();
    }

    public JsonBuilder key(String str) {
        a();
        this.a.append(JSONObject.quote(str));
        this.a.append(":");
        b();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.a.append("{");
        b();
        return this;
    }

    public JsonBuilder objectValue(String str) {
        a();
        this.a.append(str);
        c();
        return this;
    }

    public JsonBuilder putObjectValue(String str, String str2) {
        if (str2 != null) {
            key(str).objectValue(str2);
        }
        return this;
    }

    public JsonBuilder putStringValue(String str, String str2) {
        if (str2 != null) {
            key(str).value(str2);
        }
        return this;
    }

    public void reset() {
        this.a.setLength(0);
        this.b = false;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder value(double d) {
        a();
        this.a.append(String.format("%f", Double.valueOf(d)));
        c();
        return this;
    }

    public JsonBuilder value(int i) {
        a();
        this.a.append(i);
        c();
        return this;
    }

    public JsonBuilder value(long j) {
        a();
        this.a.append(j);
        c();
        return this;
    }

    public JsonBuilder value(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return value((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return value((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return value(number.intValue());
            }
            if (obj instanceof Long) {
                return value(number.longValue());
            }
            if (obj instanceof Float) {
                return value(number.floatValue());
            }
            if (obj instanceof Double) {
                return value(number.doubleValue());
            }
        }
        return value(obj.toString());
    }

    public JsonBuilder value(String str) {
        a();
        this.a.append(JSONObject.quote(str));
        c();
        return this;
    }

    public JsonBuilder value(boolean z) {
        a();
        this.a.append(z);
        c();
        return this;
    }

    public JsonBuilder valueDirect(String str) {
        a();
        this.a.append(str);
        c();
        return this;
    }
}
