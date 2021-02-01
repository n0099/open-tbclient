package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes15.dex */
public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN(OneKeyLoginSdkCall.k),
    CANCEL("cancel");
    

    /* renamed from: a  reason: collision with root package name */
    private String f5126a;

    QrLoginAction(String str) {
        this.f5126a = str;
    }

    public String getName() {
        return this.f5126a;
    }
}
