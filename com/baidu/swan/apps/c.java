package com.baidu.swan.apps;

import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.swan.apps.an.ac;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public final class c {
    public static String getVersion() {
        return "2.3.0";
    }

    public static String AV() {
        StringBuilder sb = new StringBuilder();
        String hostName = com.baidu.swan.apps.u.a.Jv().getHostName();
        sb.append("swan").append("/").append("2.3.0").append(HanziToPinyin.Token.SEPARATOR).append("swan").append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(hostName).append("/").append(ac.getVersionName()).append(HanziToPinyin.Token.SEPARATOR).append(AW());
        return dN(sb.toString());
    }

    private static String AW() {
        return String.format("(%s; P1 %s)", "Baidu", com.baidu.swan.apps.al.b.getOSVersion());
    }

    private static String dN(String str) {
        if (TextUtils.equals(com.baidu.swan.apps.u.a.Jv().getHostName(), SchemeConfig.DEFAULT_SCHEME_HEAD)) {
            return str + HanziToPinyin.Token.SEPARATOR + String.format("%s/%s", SchemeConfig.DEFAULT_SCHEME_HEAD, com.baidu.swan.apps.al.b.getVersionName());
        }
        return str;
    }
}
