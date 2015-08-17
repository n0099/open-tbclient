package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes.dex */
public interface IncompleteUserAware<R extends SapiResult> extends LoginStatusAware<R> {
    void onIncompleteUser(R r);
}
