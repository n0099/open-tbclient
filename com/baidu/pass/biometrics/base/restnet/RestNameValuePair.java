package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final long f9550c = 847806714499261896L;

    /* renamed from: a  reason: collision with root package name */
    public String f9551a;

    /* renamed from: b  reason: collision with root package name */
    public String f9552b;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f9551a;
    }

    public String getValue() {
        return this.f9552b;
    }

    public void setName(String str) {
        this.f9551a = str;
    }

    public void setValue(String str) {
        this.f9552b = str;
    }

    public String toString() {
        return "name = " + this.f9551a + ", value = " + this.f9552b;
    }

    public RestNameValuePair(String str, String str2) {
        this.f9551a = str;
        this.f9552b = str2;
    }
}
