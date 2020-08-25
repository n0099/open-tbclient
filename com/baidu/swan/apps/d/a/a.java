package com.baidu.swan.apps.d.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes8.dex */
public class a {
    public static void Q(Context context, String str) {
        if (ProcessUtils.isMainProcess()) {
            R(context, str);
        } else {
            S(context, str);
        }
    }

    public static void R(Context context, String str) {
        if (context != null) {
            CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "OPENBDUSS", str, 31449600L));
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void S(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bduss", str);
        DelegateUtils.callOnMainWithContentProvider(context, b.class, bundle);
    }
}
