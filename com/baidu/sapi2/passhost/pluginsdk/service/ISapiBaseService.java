package com.baidu.sapi2.passhost.pluginsdk.service;
/* loaded from: classes.dex */
public interface ISapiBaseService {
    boolean checkRequestPermission(String str);

    String getAppPackageSign();

    String getAppVersionName();

    String getAppZid();

    String getClientId();

    String getDeviceInfo(String str);

    String getGPSInfo();

    String getLocation();

    String getPiranhaVersion();

    String getWifiInfo();

    boolean isRoot();
}
