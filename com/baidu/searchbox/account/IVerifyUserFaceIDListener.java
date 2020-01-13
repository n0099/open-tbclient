package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.data.SearchBoxRealNameResult;
/* loaded from: classes10.dex */
public interface IVerifyUserFaceIDListener extends NoProGuard {
    void onFailure(String str);

    void onSuccess(SearchBoxRealNameResult searchBoxRealNameResult);
}
