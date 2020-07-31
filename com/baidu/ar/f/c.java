package com.baidu.ar.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes11.dex */
public class c {
    private static String wH = "pro";
    private static String wI = TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY;

    public static String fj() {
        return wH;
    }

    public static String fk() {
        return wI;
    }

    public static int getVersionCode() {
        return 460;
    }

    public static String getVersionName() {
        return "4.6.0";
    }

    public static String q(Context context) {
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
                        b.aJ("appId = " + sb.toString());
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
