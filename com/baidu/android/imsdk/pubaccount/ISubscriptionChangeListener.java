package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes.dex */
public interface ISubscriptionChangeListener extends IMListener {
    void onSubscriptionResult(int i2, long j, Object obj);

    void onUnSubscriptionResult(long j);
}
