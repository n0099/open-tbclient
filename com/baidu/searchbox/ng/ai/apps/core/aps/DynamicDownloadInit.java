package com.baidu.searchbox.ng.ai.apps.core.aps;

import android.content.Context;
import com.baidu.b.a.e.a;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.swancore.remote.SwanCoreDynamicCallback;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class DynamicDownloadInit {
    public static void start() {
        Context appContext = AppRuntime.getAppContext();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SwanCoreDynamicCallback(false));
        a.a(appContext, AiAppsRuntime.getConfigRuntime().getCookieManager(false, false));
        a.c(arrayList, true);
    }
}
