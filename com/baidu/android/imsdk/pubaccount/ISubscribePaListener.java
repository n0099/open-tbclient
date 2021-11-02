package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes6.dex */
public interface ISubscribePaListener extends IMListener {
    void onSubsribePaResult(int i2, String str, long j);

    void onUnsubsribePaResult(int i2, String str, long j);
}
