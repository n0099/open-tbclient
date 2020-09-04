package com.baidu.swan.apps.ap;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class l {
    private static String amk;

    public static String aEK() {
        if (TextUtils.isEmpty(amk)) {
            synchronized (l.class) {
                amk = aEL();
            }
        }
        return amk;
    }

    private static String aEL() {
        String replace;
        String replace2;
        String replace3;
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            replace = "NUL";
        } else {
            replace = str.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        String str2 = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str2)) {
            replace2 = "0.0";
        } else {
            replace2 = str2.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        int i = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str3)) {
            replace3 = "NUL";
        } else {
            replace3 = str3.replace(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS, Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        }
        return replace + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + replace2 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + i + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + replace3;
    }
}
