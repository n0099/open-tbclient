package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes25.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS(LoginConstants.SMS_LOGIN, "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    
    private String a;
    private String b;
    private String c;

    BindType(String str, String str2, String str3) {
        this.a = "";
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String getCallbackPage() {
        return this.b;
    }

    public String getFinishBindPage() {
        return this.c;
    }

    public String getName() {
        return this.a;
    }
}
