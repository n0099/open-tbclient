package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.data.BoxAccount;
/* loaded from: classes4.dex */
public interface IAccountRequestListener extends NoProGuard {
    void onFailed(BoxAccount.ErrorBean errorBean);

    void onSuccess(BoxAccount boxAccount);
}
