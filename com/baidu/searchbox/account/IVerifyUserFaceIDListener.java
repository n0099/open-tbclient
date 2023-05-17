package com.baidu.searchbox.account;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.account.data.SearchBoxRealNameResult;
/* loaded from: classes3.dex */
public interface IVerifyUserFaceIDListener extends NoProGuard {
    public static final int NO_LOGIN_RESULT_CODE = -1;

    void onFailure(int i, String str);

    void onSuccess(SearchBoxRealNameResult searchBoxRealNameResult);
}
