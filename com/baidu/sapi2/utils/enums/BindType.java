package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    OPTIONAL("optional", "afterauth", "finishbind"),
    IMPLICIT("implicit", "afterauth", "afterauth");
    
    private String a;
    private String b;
    private String c;

    BindType(String str, String str2, String str3) {
        this.a = "";
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getName() {
        return this.a;
    }

    public String getCallbackPage() {
        return this.b;
    }

    public String getFinishBindPage() {
        return this.c;
    }
}
