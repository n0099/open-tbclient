package com.baidu.searchbox.ng.ai.apps.system.sysinfo.util;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
/* loaded from: classes2.dex */
public class AiAppsSysInfoUtil {
    private static final boolean DEBUG = false;
    private static final String TAG = "AiAppsSysInfoUtil";

    public static String getCUID() {
        return AiAppsRuntime.getAiAppAccountRuntime().getCuid(AppRuntime.getAppContext());
    }

    public static String getIMEI(Context context) {
        return AiAppsRuntime.getAiAppAccountRuntime().getIMEI();
    }
}
