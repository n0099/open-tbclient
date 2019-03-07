package com.baidu.sapi2.dto;
/* loaded from: classes.dex */
public class PassNameValuePair {
    public String name;
    public String value;

    public PassNameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PassNameValuePair passNameValuePair = (PassNameValuePair) obj;
        if (this.name == null ? passNameValuePair.name != null : !this.name.equals(passNameValuePair.name)) {
            return false;
        }
        return this.value != null ? this.value.equals(passNameValuePair.value) : passNameValuePair.value == null;
    }

    public int hashCode() {
        return ((this.name != null ? this.name.hashCode() : 0) * 31) + (this.value != null ? this.value.hashCode() : 0);
    }
}
