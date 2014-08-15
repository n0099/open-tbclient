package com.baidu.tbadk.core.account;

import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public interface g {
    void onBeforeLogin(String str);

    void onFailure(String str, int i, String str2);

    void onSuccess(AccountData accountData);
}
