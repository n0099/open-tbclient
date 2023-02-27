package com.baidu.sapi2.utils.enums;

import com.baidu.searchbox.account.contants.LoginConstants;
/* loaded from: classes2.dex */
public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    SMS(LoginConstants.SMS_LOGIN, "afterauth", "finishbind"),
    BIND_MOBILE("bind_mobile", "afterauth", "afterauth");
    
    public String callbackPage;
    public String finishBindPage;
    public String name;

    BindType(String str, String str2, String str3) {
        this.name = "";
        this.name = str;
        this.callbackPage = str2;
        this.finishBindPage = str3;
    }

    public String getCallbackPage() {
        return this.callbackPage;
    }

    public String getFinishBindPage() {
        return this.finishBindPage;
    }

    public String getName() {
        return this.name;
    }
}
