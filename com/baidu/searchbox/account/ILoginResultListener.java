package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
/* loaded from: classes14.dex */
public interface ILoginResultListener extends NoProGuard {
    public static final int CANCELD = -2;
    public static final int FAILED = -1;
    public static final int SUCCESS = 0;

    void onResult(int i);
}
