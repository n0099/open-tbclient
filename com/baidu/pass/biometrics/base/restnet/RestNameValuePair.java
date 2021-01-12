package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes5.dex */
public class RestNameValuePair implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final long f3971a = 847806714499261896L;

    /* renamed from: b  reason: collision with root package name */
    private String f3972b;
    private String c;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.f3972b;
    }

    public String getValue() {
        return this.c;
    }

    public void setName(String str) {
        this.f3972b = str;
    }

    public void setValue(String str) {
        this.c = str;
    }

    public String toString() {
        return "name = " + this.f3972b + ", value = " + this.c;
    }

    public RestNameValuePair(String str, String str2) {
        this.f3972b = str;
        this.c = str2;
    }
}
