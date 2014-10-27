package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.VoiceCheckResponse;
/* loaded from: classes.dex */
public abstract class VoiceCheckCallBack implements SapiCallBack<VoiceCheckResponse> {
    public abstract void onBdussInvalid();

    public abstract void onLoginMergeConfirm();

    public abstract void onUserForbidden();

    public abstract void onUserNotNormalized();

    public abstract void onUsernameNotExist();

    public void onFinish() {
    }

    public void onNotEnabled() {
    }
}
