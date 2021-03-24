package com.baidu.apollon.restnet;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class RestNameValuePair implements Serializable {
    public static final long serialVersionUID = 847806714499261896L;
    public String name;
    public String value;

    public RestNameValuePair() {
        this(null, null);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "name = " + this.name + ", value = " + this.value;
    }

    public RestNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
