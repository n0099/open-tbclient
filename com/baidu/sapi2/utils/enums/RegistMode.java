package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum RegistMode {
    NORMAL("normal"),
    FAST("fast");
    
    private String a;

    public static RegistMode getDefault() {
        return NORMAL;
    }

    RegistMode(String str) {
        this.a = str;
    }

    public String getStrValue() {
        return this.a;
    }
}
