package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.sapi2.SapiOptions;
/* loaded from: classes.dex */
public final class a {
    public static String a(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", "default");
    }

    public static short a() {
        return (short) 119;
    }

    public static void a(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
        String str = z ? SapiOptions.t : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    public static boolean a(String str) {
        return "com.baidu.searchbox".equals(str) || "com.baidu.BaiduMap".equals(str) || BdSailorPlatform.LITE_PACKAGE_NAME.equals(str) || "com.baidu.haokan".equals(str) || "com.baidu.minivideo".equals(str) || "com.baidu.push.qa".equals(str) || "com.baidu.push.salon".equals(str);
    }
}
