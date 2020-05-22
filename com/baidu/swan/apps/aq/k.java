package com.baidu.swan.apps.aq;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class k {
    private static String ajQ;

    public static String ats() {
        if (TextUtils.isEmpty(ajQ)) {
            synchronized (k.class) {
                ajQ = att();
            }
        }
        return ajQ;
    }

    private static String att() {
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
