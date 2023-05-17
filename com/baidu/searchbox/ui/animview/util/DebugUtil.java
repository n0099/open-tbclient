package com.baidu.searchbox.ui.animview.util;

import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes4.dex */
public class DebugUtil {
    public static boolean isApkInDebug() {
        try {
            if ((AppRuntime.getAppContext().getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
