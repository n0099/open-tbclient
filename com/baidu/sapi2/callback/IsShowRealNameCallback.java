package com.baidu.sapi2.callback;

import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.result.IsShowRealNameGuideResult;
/* loaded from: classes2.dex */
public interface IsShowRealNameCallback extends NoProguard {
    void onFailure(IsShowRealNameGuideResult isShowRealNameGuideResult);

    void onSuccess(IsShowRealNameGuideResult isShowRealNameGuideResult);
}
