package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes4.dex */
public interface ISubscriptionChangeListener extends IMListener {
    void onSubscriptionResult(int i, long j, Object obj);

    void onUnSubscriptionResult(long j);
}
