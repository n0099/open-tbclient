package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.WebLoginResult;
/* loaded from: classes12.dex */
public abstract class WebLoginCallback implements SapiCallback<WebLoginResult> {
    public abstract void onQrAppLogin();

    public abstract void onVoiceLogin();
}
