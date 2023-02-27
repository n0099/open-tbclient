package com.baidu.sapi2.utils.enums;
/* loaded from: classes2.dex */
public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN("login"),
    CANCEL("cancel");
    
    public String name;

    QrLoginAction(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
