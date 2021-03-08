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
/* loaded from: classes3.dex */
public class b {
    private static void uT(String str) {
        SchemeRouter.invokeSchemeForInner(AppRuntime.getAppContext(), Uri.parse(str));
    }

    private static void uU(String str) {
        a.uS(str);
    }

    public static void uV(String str) {
        if (!SwanAppInitHelper.entranceOK()) {
            Log.w("SwanAppLaunchHelper", "entrance not open");
            d.a(AppRuntime.getAppContext(), "not support for this android version").aIv();
        } else if (TextUtils.isEmpty(str)) {
            d.a(AppRuntime.getAppContext(), "url is empty").aIv();
        } else if (str.startsWith(SchemeConfig.getSchemeHead())) {
            uT(str);
        } else if (str.startsWith("bdswan")) {
            uT(str.replace("bdswan", SchemeConfig.getSchemeHead()));
        } else if (str.startsWith("https") || str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            uU(str);
        } else {
            d.a(AppRuntime.getAppContext(), "not support this uri").aIv();
        }
    }
}
