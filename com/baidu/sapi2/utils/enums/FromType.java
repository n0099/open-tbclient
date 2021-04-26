package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum FromType {
    LOGIN("login"),
    REG("reg");
    
    public int index;
    public String value;

    FromType(String str) {
        this.value = str;
    }

    public static FromType getFromType(String str) {
        if ("reg".equals(str)) {
            return REG;
        }
        return LOGIN;
    }

    public int getIndex() {
        return this.index;
    }

    public String getValue() {
        return this.value;
    }
}
