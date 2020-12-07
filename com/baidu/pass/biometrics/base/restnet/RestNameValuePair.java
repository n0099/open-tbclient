package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes9.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final long f2711a = 847806714499261896L;
    private String b;
    private String c;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.b;
    }

    public String getValue() {
        return this.c;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setValue(String str) {
        this.c = str;
    }

    public String toString() {
        return "name = " + this.b + ", value = " + this.c;
    }

    public RestNameValuePair(String str, String str2) {
        this.b = str;
        this.c = str2;
    }
}
