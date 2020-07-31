package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.sapi2.outsdk.c;
/* loaded from: classes19.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
    LOGIN(c.k),
    CANCEL("cancel");
    
    private String b;

    QrLoginAction(String str) {
        this.b = str;
    }

    public String getName() {
        return this.b;
    }
}
