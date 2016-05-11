package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FaceLoginResult;
/* loaded from: classes.dex */
public abstract class FaceLoginCallback implements SapiCallback<FaceLoginResult> {
    public abstract void onPwdVerifyFailure(FaceLoginResult faceLoginResult);
}
