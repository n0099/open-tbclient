package com.baidu.mapapi.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
/* loaded from: classes6.dex */
public class OpenClientUtil {
    public static int getBaiduMapVersion(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            String str = context.getPackageManager().getPackageInfo("com.baidu.BaiduMap", 0).versionName;
            if (str == null || str.length() <= 0) {
                return 0;
            }
            return Integer.valueOf(str.trim().replace(".", "").trim()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    public static void getLatestBaiduMapApp(Context context) {
        if (context == null) {
            return;
        }
        String b = b.b(context);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("http://map.baidu.com/zt/client/index/?fr=sdk_[" + b + "]"));
        context.startActivity(intent);
    }
}
