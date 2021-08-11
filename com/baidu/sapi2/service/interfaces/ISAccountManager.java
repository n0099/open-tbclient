package com.baidu.sapi2.service.interfaces;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
/* loaded from: classes5.dex */
public interface ISAccountManager {
    SapiConfiguration getConfignation();

    String getCurrentZid(Context context);

    ISAccountService getIsAccountService();

    SapiAccount getSession();

    String getVersionName();

    String getZidAndCheckSafe(Context context, String str, int i2);

    boolean validate(SapiAccount sapiAccount);
}
