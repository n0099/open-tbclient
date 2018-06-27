package com.baidu.sapi2.service.interfaces;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import java.util.List;
/* loaded from: classes.dex */
public interface ISAccountManager {
    SapiConfiguration getConfignation();

    String getCurrentZid(Context context);

    ISAccountService getIsAccountService();

    SapiAccount getSession();

    List<SapiAccount> getShareAccounts();

    String getVersionName();

    void invalidate(SapiAccount sapiAccount);

    boolean validate(ISapiAccount iSapiAccount);
}
