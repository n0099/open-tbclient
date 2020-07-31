package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.FillUsernameResult;
/* loaded from: classes19.dex */
public abstract class FillUsernameCallback implements LoginStatusAware<FillUsernameResult> {
    public abstract void onUserHaveUsername(FillUsernameResult fillUsernameResult);
}
