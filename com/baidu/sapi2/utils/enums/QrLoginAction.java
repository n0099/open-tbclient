package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
/* loaded from: classes3.dex */
public enum QrLoginAction {
    NOTICE("notice"),
    LOGIN(OneKeyLoginSdkCall.k),
    CANCEL("cancel");
    

    /* renamed from: a  reason: collision with root package name */
    private String f5406a;

    QrLoginAction(String str) {
        this.f5406a = str;
    }

    public String getName() {
        return this.f5406a;
    }
}
