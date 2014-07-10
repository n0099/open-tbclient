package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.OAuthResponse;
/* loaded from: classes.dex */
public abstract class OAuthCallBack implements SapiCallBack<OAuthResponse> {
    public abstract void onFinish();
}
