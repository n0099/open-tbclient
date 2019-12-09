package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
/* loaded from: classes2.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
    LOGIN("login"),
    CANCEL("cancel");
    
    private String b;

    QrLoginAction(String str) {
        this.b = str;
    }

    public String getName() {
        return this.b;
    }
}
