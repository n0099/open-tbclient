package com.baidu.sapi2.service.interfaces;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
/* loaded from: classes2.dex */
public interface ISAccountManager {
    SapiConfiguration getConfignation();

    String getCurrentZid(Context context);

    a getIsAccountService();

    SapiAccount getSession();

    String getVersionName();

    String getZidAndCheckSafe(Context context, String str, int i);

    boolean validate(SapiAccount sapiAccount);
}
