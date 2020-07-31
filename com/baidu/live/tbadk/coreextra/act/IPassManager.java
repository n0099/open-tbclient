package com.baidu.live.tbadk.coreextra.act;

import com.baidu.live.tbadk.core.data.AccountData;
import java.util.List;
/* loaded from: classes4.dex */
public interface IPassManager {
    List<AccountData> loadLoginAccounts();

    void removeAccount(AccountData accountData);

    void sapiLogout();

    void syncSapiAccount(AccountData accountData);
}
