package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes3.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS(LoginConstants.SMS_LOGIN, "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    

    /* renamed from: a  reason: collision with root package name */
    private String f5394a;

    /* renamed from: b  reason: collision with root package name */
    private String f5395b;
    private String c;

    BindType(String str, String str2, String str3) {
        this.f5394a = "";
        this.f5394a = str;
        this.f5395b = str2;
        this.c = str3;
    }

    public String getCallbackPage() {
        return this.f5395b;
    }

    public String getFinishBindPage() {
        return this.c;
    }

    public String getName() {
        return this.f5394a;
    }
}
