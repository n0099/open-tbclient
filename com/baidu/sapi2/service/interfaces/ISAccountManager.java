package com.baidu.sapi2.service.interfaces;

import android.content.Context;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
/* loaded from: classes3.dex */
public interface ISAccountManager {
    SapiConfiguration getConfignation();

    String getCurrentZid(Context context);

    ISAccountService getIsAccountService();

    SapiAccount getSession();

    UbcUploadImplCallback getUbcUploadImplCallback();

    String getVersionName();

    String getZidAndCheckSafe(Context context, String str, int i);

    boolean validate(SapiAccount sapiAccount);
}
