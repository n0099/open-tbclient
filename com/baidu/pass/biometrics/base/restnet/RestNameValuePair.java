package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final long f9109c = 847806714499261896L;

    /* renamed from: a  reason: collision with root package name */
    public String f9110a;

    /* renamed from: b  reason: collision with root package name */
    public String f9111b;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f9110a;
    }

    public String getValue() {
        return this.f9111b;
    }

    public void setName(String str) {
        this.f9110a = str;
    }

    public void setValue(String str) {
        this.f9111b = str;
    }

    public String toString() {
        return "name = " + this.f9110a + ", value = " + this.f9111b;
    }

    public RestNameValuePair(String str, String str2) {
        this.f9110a = str;
        this.f9111b = str2;
    }
}
