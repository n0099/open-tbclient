package com.baidu.sapi2.utils.enums;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes15.dex */
public enum QrLoginAction {
    NOTICE(LogConfig.KEY_NOTICE),
    LOGIN(OneKeyLoginSdkCall.k),
    CANCEL("cancel");
    

    /* renamed from: a  reason: collision with root package name */
    private String f3551a;

    QrLoginAction(String str) {
        this.f3551a = str;
    }

    public String getName() {
        return this.f3551a;
    }
}
