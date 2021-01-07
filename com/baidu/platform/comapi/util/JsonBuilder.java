package com.baidu.platform.comapi.util;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class JsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f4375a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private boolean f4376b = false;

    private void a() {
        if (this.f4376b) {
            this.f4375a.append(",");
        }
    }

    private void b() {
        this.f4376b = false;
    }

    private void c() {
        this.f4376b = true;
    }

    public JsonBuilder arrayValue() {
        a();
        this.f4375a.append("[");
        b();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.f4375a.append("]");
        c();
        return this;
    }

    public JsonBuilder endObject() {
        this.f4375a.append("}");
        c();
        return this;
    }

    public String getJson() {
        return this.f4375a.toString();
    }

    public JsonBuilder key(String str) {
        a();
        this.f4375a.append(JSONObject.quote(str));
        this.f4375a.append(":");
        b();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.f4375a.append("{");
        b();
        return this;
    }

    public JsonBuilder objectValue(String str) {
        a();
        this.f4375a.append(str);
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
        this.f4375a.setLength(0);
        this.f4376b = false;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder value(double d) {
        a();
        this.f4375a.append(String.format("%f", Double.valueOf(d)));
        c();
        return this;
    }

    public JsonBuilder value(int i) {
        a();
        this.f4375a.append(i);
        c();
        return this;
    }

    public JsonBuilder value(long j) {
        a();
        this.f4375a.append(j);
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
        this.f4375a.append(JSONObject.quote(str));
        c();
        return this;
    }

    public JsonBuilder value(boolean z) {
        a();
        this.f4375a.append(z);
        c();
        return this;
    }

    public JsonBuilder valueDirect(String str) {
        a();
        this.f4375a.append(str);
        c();
        return this;
    }
}
