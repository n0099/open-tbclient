package com.baidu.swan.apps.q.a.b;

import android.os.Bundle;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.setting.oauth.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends f {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private CookieManager awm;

    public a() {
        this.awm = null;
        this.awm = com.baidu.tieba.aiapps.apps.a.a.Dp();
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldAcceptCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.awm.shouldAcceptCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), b.class, c(str, str2, 1));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public boolean shouldSendCookie(String str, String str2) {
        if (ProcessUtils.isMainProcess()) {
            return this.awm.shouldSendCookie(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), b.class, c(str, str2, 2));
        if (!callOnMainWithContentProvider.isOk()) {
            return false;
        }
        return callOnMainWithContentProvider.mResult.getBoolean("result");
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public void storeCookie(String str, List<String> list) {
        if (ProcessUtils.isMainProcess()) {
            this.awm.storeCookie(str, list);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("param1", str);
        bundle.putStringArrayList("param2", (ArrayList) list);
        DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), b.class, bundle);
        if (DEBUG) {
            Log.d("SearchBoxSwanAppCookieManager", "set cookies for " + str);
        }
    }

    @Override // com.baidu.swan.apps.setting.oauth.f, com.baidu.searchbox.http.cookie.CookieManager
    public String getCookie(String str) {
        if (ProcessUtils.isMainProcess()) {
            return this.awm.getCookie(str);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), b.class, c(str, "", 4));
        if (!callOnMainWithContentProvider.isOk()) {
            return "";
        }
        String string = callOnMainWithContentProvider.mResult.getString("result");
        if (DEBUG) {
            Log.d("SearchBoxSwanAppCookieManager", "getCookie cookie : " + string);
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
