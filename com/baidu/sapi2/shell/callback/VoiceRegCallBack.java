package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiResponse;
/* loaded from: classes.dex */
public abstract class VoiceRegCallBack implements SapiCallBack<SapiResponse> {
    public abstract void onAuthExpired();

    public void onFinish() {
    }

    public void onNotEnabled() {
    }
}
