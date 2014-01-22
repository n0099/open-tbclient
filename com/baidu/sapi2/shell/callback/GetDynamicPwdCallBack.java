package com.baidu.sapi2.shell.callback;

import com.baidu.sapi2.shell.response.SapiResponse;
/* loaded from: classes.dex */
public abstract class GetDynamicPwdCallBack implements SapiCallBack<SapiResponse> {
    public abstract void onCannotLogin();

    public abstract void onPhoneFormatError();
}
