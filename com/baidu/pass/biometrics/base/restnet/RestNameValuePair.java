package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final long f4008a = 847806714499261896L;

    /* renamed from: b  reason: collision with root package name */
    private String f4009b;
    private String c;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f4009b;
    }

    public String getValue() {
        return this.c;
    }

    public void setName(String str) {
        this.f4009b = str;
    }

    public void setValue(String str) {
        this.c = str;
    }

    public String toString() {
        return "name = " + this.f4009b + ", value = " + this.c;
    }

    public RestNameValuePair(String str, String str2) {
        this.f4009b = str;
        this.c = str2;
    }
}
