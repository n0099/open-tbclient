package com.baidu.pass.biometrics.base.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {
    private static final long serialVersionUID = 847806714499261896L;
    private String name;
    private String value;

    public RestNameValuePair() {
        this(null, null);
    }

    public RestNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "name = " + this.name + ", value = " + this.value;
    }
}
