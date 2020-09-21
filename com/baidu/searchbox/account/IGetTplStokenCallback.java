package com.baidu.searchbox.account;

import com.baidu.searchbox.account.data.OnGetTplStokenResult;
/* loaded from: classes23.dex */
public interface IGetTplStokenCallback {
    void onFailure(OnGetTplStokenResult onGetTplStokenResult);

    void onFinish();

    void onStart();

    void onSuccess(OnGetTplStokenResult onGetTplStokenResult);
}
