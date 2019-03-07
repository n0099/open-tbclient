package com.baidu.sapi2.utils.enums;
/* loaded from: classes.dex */
public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN("login"),
    CANCEL("cancel");
    
    private String a;

    QrLoginAction(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }
}
