package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.FastRegResponse;
/* loaded from: classes.dex */
public abstract class FastRegCallBack implements SapiCallBack<FastRegResponse> {
    public abstract void onCannotLogin();

    public abstract void onWaitingLogin();
}
