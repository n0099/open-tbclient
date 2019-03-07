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

    String getDeviceAuthToken(Context context, String str, int i);

    ISAccountService getIsAccountService();

    SapiAccount getSession();

    List<SapiAccount> getShareAccounts();

    String getVersionName();

    String getZidAndCheckSafe(Context context, String str, int i);

    void invalidate(SapiAccount sapiAccount);

    boolean validate(ISapiAccount iSapiAccount);
}
