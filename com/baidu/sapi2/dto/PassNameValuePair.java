package com.baidu.sapi2.dto;
/* loaded from: classes15.dex */
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

    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PassNameValuePair.class != obj.getClass()) {
            return false;
        }
        PassNameValuePair passNameValuePair = (PassNameValuePair) obj;
        String str = this.name;
        if (str == null ? passNameValuePair.name != null : !str.equals(passNameValuePair.name)) {
            return false;
        }
        String str2 = this.value;
        return str2 != null ? str2.equals(passNameValuePair.value) : passNameValuePair.value == null;
    }
}
