package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.result.AccountOpenBdussResult;
/* loaded from: classes3.dex */
public interface IGetOpenBdussCallback extends NoProGuard {
    void onFailure(AccountOpenBdussResult accountOpenBdussResult);

    void onFinish();

    void onStart();

    void onSuccess(AccountOpenBdussResult accountOpenBdussResult);
}
