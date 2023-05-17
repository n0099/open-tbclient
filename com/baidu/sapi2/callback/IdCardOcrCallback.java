package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.IdCardOcrResult;
/* loaded from: classes3.dex */
public abstract class IdCardOcrCallback {
    public abstract void onFailure(IdCardOcrResult idCardOcrResult);

    public abstract void onSuccess(IdCardOcrResult idCardOcrResult);
}
