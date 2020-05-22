package com.baidu.swan.apps.c.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes11.dex */
public class a {
    public static void M(Context context, String str) {
        if (ProcessUtils.isMainProcess()) {
            N(context, str);
        } else {
            O(context, str);
        }
    }

    public static void N(Context context, String str) {
        if (context != null) {
            CookieManager.getInstance().setCookie(".baidu.com", ah.getCookieStr(".baidu.com", "BDUSS", str, 31449600L));
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void O(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bduss", str);
        DelegateUtils.callOnMainWithContentProvider(context, b.class, bundle);
    }
}
