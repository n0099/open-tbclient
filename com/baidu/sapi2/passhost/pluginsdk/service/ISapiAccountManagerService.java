package com.baidu.sapi2.passhost.pluginsdk.service;

import com.baidu.sapi2.passhost.pluginsdk.callback.IGetUserInfoCallback;
import java.util.List;
/* loaded from: classes.dex */
public interface ISapiAccountManagerService {
    List<String> buildShareUidList();

    List<String> getPackageList();

    ISapiConfiguration getSapiConfiguration();

    ISapiAccount getSession();

    int getShareAccountsSize();

    void getUserInfo(IGetUserInfoCallback iGetUserInfoCallback);

    int getVersionCode();

    String getVersionName();

    boolean isAppProcess();

    boolean isLogin();
}
