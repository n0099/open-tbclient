package com.baidu.platform.comapi.walknavi.d.a.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
/* loaded from: classes26.dex */
public class b {
    public static int a() {
        return Opcodes.PUTFIELD;
    }

    public static String b() {
        return "5.5.0";
    }

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            StringBuilder sb = new StringBuilder(context.getApplicationContext().getPackageName());
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (!TextUtils.isEmpty(str)) {
                        sb.append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
                        sb.append(str);
                        a.a("appId = " + sb.toString());
                    }
                }
            } catch (Exception e) {
            }
            return sb.toString();
        } catch (NullPointerException e2) {
            return null;
        }
    }
}
