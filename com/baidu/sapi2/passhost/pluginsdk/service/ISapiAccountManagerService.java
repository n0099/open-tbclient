package com.baidu.sapi2.passhost.pluginsdk.service;

import java.util.List;
/* loaded from: classes.dex */
public interface ISapiAccountManagerService {
    List<String> buildShareUidList();

    List<String> getPackageList();

    ISapiConfiguration getSapiConfiguration();

    ISapiAccount getSession();

    int getShareAccountsSize();

    int getVersionCode();

    String getVersionName();

    boolean isAppProcess();

    boolean isLogin();

    boolean isOutsideCompany();
}
