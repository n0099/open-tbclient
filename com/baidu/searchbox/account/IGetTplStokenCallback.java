package com.baidu.searchbox.account;

import com.baidu.searchbox.account.data.OnGetTplStokenResult;
/* loaded from: classes2.dex */
public interface IGetTplStokenCallback {
    void onFailure(OnGetTplStokenResult onGetTplStokenResult);

    void onFinish();

    void onStart();

    void onSuccess(OnGetTplStokenResult onGetTplStokenResult);
}
