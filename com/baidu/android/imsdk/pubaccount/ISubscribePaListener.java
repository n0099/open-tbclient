package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMListener;
/* loaded from: classes4.dex */
public interface ISubscribePaListener extends IMListener {
    void onSubsribePaResult(int i, String str, long j);

    void onUnsubsribePaResult(int i, String str, long j);
}
