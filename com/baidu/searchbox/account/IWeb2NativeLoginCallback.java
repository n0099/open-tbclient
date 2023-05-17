package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
/* loaded from: classes3.dex */
public interface IWeb2NativeLoginCallback extends NoProGuard {
    void onBdussEmpty();

    void onBdussExpired();

    void onFailure();

    void onFinish();

    void onStart();

    void onSuccess();
}
