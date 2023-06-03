package com.baidu.searchbox.permission;

import android.os.Build;
/* loaded from: classes4.dex */
public class ApiUtils {
    public static final int MARSHMALLOW = 23;
    public static final int Q_VERSION = 29;

    public static boolean hasMarshMallow() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static boolean hasQVersion() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }
}
