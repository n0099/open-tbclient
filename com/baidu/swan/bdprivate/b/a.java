package com.baidu.swan.bdprivate.b;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.setting.oauth.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a extends g {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CookieManager bKE;

    public a() {
        this.bKE = null;
        this.bKE = new b();
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.bKE.shouldAcceptCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, c(str, str2, 1));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.bKE.shouldSendCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, c(str, str2, 2));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (ProcessUtils.isMainProcess()) {
            this.bKE.storeCookie(str, list);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("param1", str);
        bundle.putStringArrayList("param2", (ArrayList) list);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, bundle);
        if (DEBUG) {
            Log.d("DelegationCookieManager", "set cookies for " + str);
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.g, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (ProcessUtils.isMainProcess()) {
            return this.bKE.getCookie(str);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), c.class, c(str, "", 4));
        if (!callOnMainWithContentProvider.isOk()) {
            return "";
        }
        String string = callOnMainWithContentProvider.mResult.getString("result");
        if (DEBUG) {
            Log.d("DelegationCookieManager", "getCookie cookie : " + string);
            return string;
        }
        return string;
    }

    private Bundle c(String str, String str2, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("param1", str);
        bundle.putString("param2", str2);
        return bundle;
    }
}
