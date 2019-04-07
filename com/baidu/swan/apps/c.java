package com.baidu.swan.apps;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.an.aa;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public final class c {
    public static String getVersion() {
        return "2.1.0";
    }

    public static String uL() {
        StringBuilder sb = new StringBuilder();
        String hostName = com.baidu.swan.apps.u.a.CI().getHostName();
        sb.append("swan").append("/").append("2.1.0").append(" ").append("swan").append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(hostName).append("/").append(aa.getVersionName()).append(" ").append(uM());
        return dk(sb.toString());
    }

    private static String uM() {
        return String.format("(%s; P1 %s)", "Baidu", com.baidu.swan.apps.al.b.getOSVersion());
    }

    private static String dk(String str) {
        if (TextUtils.equals(com.baidu.swan.apps.u.a.CI().getHostName(), SchemeConfig.DEFAULT_SCHEME_HEAD)) {
            return str + " " + String.format("%s/%s", SchemeConfig.DEFAULT_SCHEME_HEAD, com.baidu.swan.apps.al.b.getVersionName());
        }
        return str;
    }
}
