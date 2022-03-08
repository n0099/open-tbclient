package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes4.dex */
public interface CaptchaAware<R extends SapiResult> extends SapiCallback<R> {
    void onCaptchaRequired(R r);
}
