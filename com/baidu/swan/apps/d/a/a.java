package com.baidu.swan.apps.d.a;

import android.content.Context;
import android.os.Bundle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ap.ai;
import com.baidu.webkit.sdk.CookieManager;
import com.baidu.webkit.sdk.CookieSyncManager;
/* loaded from: classes3.dex */
public class a {
    public static void T(Context context, String str) {
        if (ProcessUtils.isMainProcess()) {
            U(context, str);
        } else {
            V(context, str);
        }
    }

    public static void U(Context context, String str) {
        if (context != null) {
            CookieManager.getInstance().setCookie(".baidu.com", ai.getCookieStr(".baidu.com", "OPENBDUSS", str, 31449600L));
            CookieSyncManager.createInstance(AppRuntime.getAppContext());
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void V(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("bduss", str);
        DelegateUtils.callOnMainWithContentProvider(context, b.class, bundle);
    }
}
