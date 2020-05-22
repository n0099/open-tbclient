package com.baidu.swan.facade.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import org.apache.http.HttpHost;
/* loaded from: classes11.dex */
public class b {
    private static void qh(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    private static void qi(String str) {
        a.qg(str);
    }

    public static void qj(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").showToast();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").showToast();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            qh(str);
        } else if (str.startsWith("bdswan")) {
            qh(str.replace("bdswan", SchemeConfig.getSchemeHead()));
        } else if (str.startsWith("https") || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            qi(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").showToast();
        }
    }
}
