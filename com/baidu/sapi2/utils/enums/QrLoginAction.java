package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
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
