package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.pushservice.i.m;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.internal.GlobalConstants;
/* loaded from: classes9.dex */
public final class a {
    public static String a(Context context) {
        return context.getSharedPreferences("pst", 4).getString("s_e", "default");
    }

    public static short a() {
        return (short) 96;
    }

    public static void a(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
        String str = z ? "enabled" : "disabled";
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("s_e", str);
        edit.commit();
    }

    public static boolean a(String str) {
        return GlobalConstants.SEARCHBOX_PACKAGE_NAME.equals(str) || "com.baidu.BaiduMap".equals(str) || BdSailorPlatform.LITE_PACKAGE_NAME.equals(str) || "com.baidu.haokan".equals(str) || "com.baidu.minivideo".equals(str) || "com.baidu.push.qa".equals(str) || "com.baidu.push.salon".equals(str);
    }

    public static boolean b(Context context) {
        String packageName = context.getPackageName();
        char c = 65535;
        switch (packageName.hashCode()) {
            case -1747343356:
                if (packageName.equals("com.baidu.minivideo")) {
                    c = 5;
                    break;
                }
                break;
            case -796004189:
                if (packageName.equals(GlobalConstants.SEARCHBOX_PACKAGE_NAME)) {
                    c = 0;
                    break;
                }
                break;
            case 342704719:
                if (packageName.equals("com.baidu.tieba")) {
                    c = 6;
                    break;
                }
                break;
            case 596174617:
                if (packageName.equals(BdSailorPlatform.LITE_PACKAGE_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case 744792033:
                if (packageName.equals("com.baidu.BaiduMap")) {
                    c = 3;
                    break;
                }
                break;
            case 1683280386:
                if (packageName.equals("com.baidu.haokan")) {
                    c = 4;
                    break;
                }
                break;
            case 1835347777:
                if (packageName.equals("com.baidu.searchbox.mission")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                if (m.n()) {
                    return true;
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (m.e() || m.h() || m.f() || m.g()) {
                    return true;
                }
                break;
        }
        return false;
    }
}
