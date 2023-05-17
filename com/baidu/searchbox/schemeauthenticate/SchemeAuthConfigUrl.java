package com.baidu.searchbox.schemeauthenticate;

import com.baidu.searchbox.config.HostConfig;
/* loaded from: classes4.dex */
public class SchemeAuthConfigUrl {
    public static String getAuthenticateUrl() {
        return String.format("%s/searchbox?action=proxy&type=authright", HostConfig.getSearchboxHostForHttps());
    }
}
