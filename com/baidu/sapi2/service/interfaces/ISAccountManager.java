package com.baidu.sapi2.service.interfaces;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import java.util.List;
/* loaded from: classes6.dex */
public interface ISAccountManager {
    SapiConfiguration getConfignation();

    String getCurrentZid(Context context);

    String getDeviceAuthToken(Context context, String str, int i);

    a getIsAccountService();

    SapiAccount getSession();

    List<SapiAccount> getShareAccounts();

    String getVersionName();

    String getZidAndCheckSafe(Context context, String str, int i);

    void invalidate(SapiAccount sapiAccount);

    boolean validate(SapiAccount sapiAccount);
}
