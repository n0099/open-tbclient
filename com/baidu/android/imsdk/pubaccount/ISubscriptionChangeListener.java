package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes10.dex */
public interface ISubscriptionChangeListener extends IMListener {
    void onSubscriptionResult(int i2, long j2, Object obj);

    void onUnSubscriptionResult(long j2);
}
