package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.data.BoxAccount;
/* loaded from: classes9.dex */
public interface IGetBoxAccountListener extends NoProGuard {
    public static final int ERROR_BDUSS_EXPIRED = -1;
    public static final int ERROR_COMMON = -3;
    public static final int ERROR_NETWORK_FAILED = -2;

    void onFailed(int i);

    void onSuccess(BoxAccount boxAccount);
}
