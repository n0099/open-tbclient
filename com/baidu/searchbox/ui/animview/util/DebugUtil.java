package com.baidu.searchbox.ui.animview.util;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes14.dex */
public class DebugUtil {
    public static boolean isApkInDebug() {
        try {
            return (AppRuntime.getAppContext().getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
