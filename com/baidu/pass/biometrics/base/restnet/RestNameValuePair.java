package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final long f8965c = 847806714499261896L;

    /* renamed from: a  reason: collision with root package name */
    public String f8966a;

    /* renamed from: b  reason: collision with root package name */
    public String f8967b;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f8966a;
    }

    public String getValue() {
        return this.f8967b;
    }

    public void setName(String str) {
        this.f8966a = str;
    }

    public void setValue(String str) {
        this.f8967b = str;
    }

    public String toString() {
        return "name = " + this.f8966a + ", value = " + this.f8967b;
    }

    public RestNameValuePair(String str, String str2) {
        this.f8966a = str;
        this.f8967b = str2;
    }
}
