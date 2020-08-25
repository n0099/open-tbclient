package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes12.dex */
public abstract class AuthWidgetCallback<R extends SapiResult> {
    public abstract void onFailure(R r);

    public abstract void onSuccess(String str);
}
