package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum FromType {
    LOGIN("login"),
    REG("reg");
    
    public int index;
    public String value;

    public int getIndex() {
        return this.index;
    }

    public String getValue() {
        return this.value;
    }

    FromType(String str) {
        this.value = str;
    }

    public static FromType getFromType(String str) {
        if ("reg".equals(str)) {
            return REG;
        }
        return LOGIN;
    }
}
