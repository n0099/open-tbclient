package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum BindType {
    EXPLICIT("explicit"),
    OPTIONAL("optional"),
    IMPLICIT("implicit");
    
    private String a;

    BindType(String str) {
        this.a = "";
        this.a = str;
    }

    public final String getName() {
        return this.a;
    }
}
