package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes3.dex */
public class RestNameValuePair implements Serializable {
    public static final long c = 847806714499261896L;
    public String a;
    public String b;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.a;
    }

    public String getValue() {
        return this.b;
    }

    public String toString() {
        return "name = " + this.a + ", value = " + this.b;
    }

    public RestNameValuePair(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void setName(String str) {
        this.a = str;
    }

    public void setValue(String str) {
        this.b = str;
    }
}
