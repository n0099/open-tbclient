package com.baidu.sapi2.passhost.pluginsdk.service;
/* loaded from: classes.dex */
public interface ISapiAccount {
    public static final String SAPI_ACCOUNT_APP = "app";
    public static final String SAPI_ACCOUNT_BDUSS = "bduss";
    public static final String SAPI_ACCOUNT_DISPLAYNAME = "displayname";
    public static final String SAPI_ACCOUNT_EMAIL = "email";
    public static final String SAPI_ACCOUNT_EXTRA = "extra";
    public static final String SAPI_ACCOUNT_PHONE = "phone";
    public static final String SAPI_ACCOUNT_PTOKEN = "ptoken";
    public static final String SAPI_ACCOUNT_STOKEN = "stoken";
    public static final String SAPI_ACCOUNT_UID = "uid";
    public static final String SAPI_ACCOUNT_USERNAME = "username";

    String getSapiAccountInfo(String str);
}
