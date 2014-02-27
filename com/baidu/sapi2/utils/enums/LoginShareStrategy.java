package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum LoginShareStrategy {
    DISABLED("disabled"),
    SILENT("silent"),
    CHOICE("choice");
    
    private String a;

    public static LoginShareStrategy getDefault() {
        return CHOICE;
    }

    LoginShareStrategy(String str) {
        this.a = str;
    }

    public final String getStrValue() {
        return this.a;
    }
}
