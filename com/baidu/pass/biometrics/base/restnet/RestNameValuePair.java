package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final long f9027c = 847806714499261896L;

    /* renamed from: a  reason: collision with root package name */
    public String f9028a;

    /* renamed from: b  reason: collision with root package name */
    public String f9029b;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f9028a;
    }

    public String getValue() {
        return this.f9029b;
    }

    public void setName(String str) {
        this.f9028a = str;
    }

    public void setValue(String str) {
        this.f9029b = str;
    }

    public String toString() {
        return "name = " + this.f9028a + ", value = " + this.f9029b;
    }

    public RestNameValuePair(String str, String str2) {
        this.f9028a = str;
        this.f9029b = str2;
    }
}
