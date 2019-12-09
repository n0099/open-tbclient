package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS("sms", "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    
    private String b;
    private String c;
    private String d;

    BindType(String str, String str2, String str3) {
        this.b = "";
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public String getCallbackPage() {
        return this.c;
    }

    public String getFinishBindPage() {
        return this.d;
    }

    public String getName() {
        return this.b;
    }
}
