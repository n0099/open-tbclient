package com.baidu.swan.apps.x.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean hR(@Nullable String str) {
        if (!com.baidu.swan.apps.w.a.Rn().EC()) {
            if (DEBUG) {
                Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade false => 新年小程序错误兜底h5降级ab开关为关闭 swan_new_year_h5_downgrade false");
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (DEBUG) {
                Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade false => illegal launchErrorInfo");
            }
            return false;
        } else {
            List<String> SE = SE();
            if (SE == null) {
                if (DEBUG) {
                    Log.w("LaunchError", "isExecuteSwanNewYearH5Downgrade false =》 illegal newYearAppIds");
                }
                return false;
            }
            for (String str2 : SE) {
                if (TextUtils.isEmpty(str2)) {
                    if (DEBUG) {
                        Log.w("LaunchError", "isExecuteSwanNewYearH5Downgrade =》 illegal newYearAppId");
                    }
                } else if (str.startsWith(str2)) {
                    if (DEBUG) {
                        Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade true =》 launchAppId: " + str + " newYearAppId: " + str2);
                    }
                    return true;
                } else if (DEBUG) {
                    Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade continue =》 launchAppId: " + str + " newYearAppId: " + str2);
                }
            }
            if (DEBUG) {
                Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade false");
            }
            return false;
        }
    }

    @NonNull
    public static String SD() {
        String ED = ED();
        if (DEBUG) {
            Log.d("LaunchError", "getSwanNewYearH5DowngradeScheme => originUrl: " + ED);
        }
        String str = null;
        try {
            str = URLEncoder.encode(ED, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = ED;
        }
        if (DEBUG) {
            Log.d("LaunchError", "getSwanNewYearH5DowngradeScheme => encodedUrl: " + str);
        }
        String str2 = "baiduboxapp://v1/easybrowse/open?url=" + str + "&newbrowser=1&forbidautorotate=1";
        if (DEBUG) {
            Log.d("LaunchError", "getSwanNewYearH5DowngradeScheme => scheme: " + str2);
        }
        return str2;
    }

    @NonNull
    private static String ED() {
        String ED = com.baidu.swan.apps.w.a.Rn().ED();
        if (TextUtils.isEmpty(ED)) {
            return "https://2019.baidu.com/activity/shake2019/index.html?idfrom=aiappfb";
        }
        return ED;
    }

    private static List<String> SE() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("i2UoL6iWVUjaSpHLA4ftCxO2SNCdkTf0");
        arrayList.add("uSTqbBp5u8egzErCpTiPrAOumDjAXWMU");
        return arrayList;
    }
}
