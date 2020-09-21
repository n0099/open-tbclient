package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes25.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
    LOGIN(OneKeyLoginSdkCall.k),
    CANCEL("cancel");
    
    private String a;

    QrLoginAction(String str) {
        this.a = str;
    }

    public String getName() {
        return this.a;
    }
}
