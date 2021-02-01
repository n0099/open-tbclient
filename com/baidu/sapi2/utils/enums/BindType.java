package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes15.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS(LoginConstants.SMS_LOGIN, "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    private String f5113a;

    /* renamed from: b  reason: collision with root package name */
    private String f5114b;
    private String c;

    BindType(String str, String str2, String str3) {
        this.f5113a = "";
        this.f5113a = str;
        this.f5114b = str2;
        this.c = str3;
    }

    public String getCallbackPage() {
        return this.f5114b;
    }

    public String getFinishBindPage() {
        return this.c;
    }

    public String getName() {
        return this.f5113a;
    }
}
