package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
/* loaded from: classes3.dex */
public interface GetUserAttrInfoCallback extends NoProguard {
    void onFailure(GetUserAttrInfoResult getUserAttrInfoResult);

    void onSuccess(GetUserAttrInfoResult getUserAttrInfoResult);
}
