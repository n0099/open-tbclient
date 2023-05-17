package com.baidu.sapi2.utils.enums;
/* loaded from: classes3.dex */
public enum BindInfoAction {
    BIND_MOBILE("0", "绑定手机"),
    BIND_EMAIL("1", "绑定邮箱");
    
    public String name;
    public String value;

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    BindInfoAction(String str, String str2) {
        this.value = str;
        this.name = str2;
    }
}
