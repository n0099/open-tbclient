package com.baidu.ar.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes11.dex */
public class c {
    private static String xf = "pro";
    private static String xg = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;

    public static int getVersionCode() {
        return 490;
    }

    public static String getVersionName() {
        return "4.9.0";
    }

    public static String gx() {
        return xf;
    }

    public static String gy() {
        return xg;
    }

    public static String r(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        sb.append(str2);
                        b.aN("appId = " + sb.toString());
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            str = sb.toString();
            return str;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
