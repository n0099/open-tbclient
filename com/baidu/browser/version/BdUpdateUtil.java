package com.baidu.browser.version;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.baidu.android.common.util.HanziToPinyin;
import com.baidu.browser.bbm.BdBBM;
/* loaded from: classes.dex */
public class BdUpdateUtil {
    public static final String OUTER_VERSION = "1.0.5.0";
    public static final String SERVER_URL = "http://shahe.baidu.com/";
    private static String mZeusCode = "j2";

    public static String ccSeid(String str) {
        return String.valueOf(str) + "&seid=tieba";
    }

    public static String processUrl(Context context, String str) {
        return ccTn(ccUA(context, ccImei(str)));
    }

    public static String ccUA(Context context, String str) {
        String replace;
        String str2 = String.valueOf(Build.MANUFACTURER) + "-" + Build.MODEL + "-" + Build.VERSION.RELEASE;
        if (str2.equals("--")) {
            replace = "bd-android";
        } else {
            replace = str2.replace(HanziToPinyin.Token.SEPARATOR, "").replace("_", "").replace("&", "-");
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        String replace2 = ("bd_" + Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) + "_" + Math.min(displayMetrics.heightPixels, displayMetrics.heightPixels) + "_" + replace + "_" + OUTER_VERSION + "_" + mZeusCode).replace('.', '-');
        if (str.indexOf("?") < 0) {
            return String.valueOf(str) + "?ua=" + replace2;
        }
        if (str.endsWith("?") || str.endsWith("&")) {
            return String.valueOf(str) + "ua=" + replace2;
        }
        return String.valueOf(str) + "&ua=" + replace2;
    }

    public static final String ccImei(String str) {
        String str2;
        if (!BdBBM.appendIMEIBBMInfo().equals("")) {
            if (str.indexOf("?") < 0) {
                str2 = String.valueOf(str) + "?uid=bd_" + BdBBM.appendIMEIBBMInfo();
            } else {
                str2 = String.valueOf(str) + "&uid=bd_" + BdBBM.appendIMEIBBMInfo();
            }
            return str2;
        }
        return str;
    }

    public static final String ccTn(String str) {
        String str2;
        if (BdBBM.getTNNumber() != null) {
            if (str.indexOf("?") < 0) {
                str2 = String.valueOf(str) + "?from=" + BdBBM.getTNNumber();
            } else if (str.endsWith("?") || str.endsWith("&")) {
                str2 = String.valueOf(str) + "from=" + BdBBM.getTNNumber();
            } else {
                str2 = String.valueOf(str) + "&from=" + BdBBM.getTNNumber();
            }
            return str2;
        }
        return str;
    }
}
