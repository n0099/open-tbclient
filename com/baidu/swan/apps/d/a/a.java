package com.baidu.swan.apps.d.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes25.dex */
public class a {
    public static void X(Context context, String str) {
        if (ProcessUtils.isMainProcess()) {
            Y(context, str);
        } else {
            Z(context, str);
        }
    }

    public static void Y(Context context, String str) {
        if (context != null) {
            CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "OPENBDUSS", str, 31449600L));
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void Z(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bduss", str);
        DelegateUtils.callOnMainWithContentProvider(context, b.class, bundle);
    }
}
