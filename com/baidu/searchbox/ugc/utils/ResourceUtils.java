package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes13.dex */
public class ResourceUtils {
    private static Context sContext = AppRuntime.getAppContext();
    private static Resources sResources = sContext.getResources();

    public static int getResIdByName(String str) {
        if (sResources == null) {
            return -1;
        }
        return sResources.getIdentifier(str, "id", sContext.getPackageName());
    }
}
