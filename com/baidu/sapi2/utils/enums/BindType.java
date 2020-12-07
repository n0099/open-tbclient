package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes6.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS(LoginConstants.SMS_LOGIN, "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    private String f3548a;
    private String b;
    private String c;

    BindType(String str, String str2, String str3) {
        this.f3548a = "";
        this.f3548a = str;
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
        return this.f3548a;
    }
}
