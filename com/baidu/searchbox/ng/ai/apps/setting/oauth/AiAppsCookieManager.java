package com.baidu.searchbox.ng.ai.apps.setting.oauth;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class AiAppsCookieManager implements CookieManager {
    private boolean isMainProcess;

    public AiAppsCookieManager(boolean z) {
        this.isMainProcess = z;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        return false;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        return true;
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
    }

    @Override // com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host) && host.endsWith("baidu.com")) {
            return "BDUSS=" + AiAppsRuntime.getAiAppAccountRuntime().getBduss(AppRuntime.getAppContext());
        }
        return "";
    }
}
