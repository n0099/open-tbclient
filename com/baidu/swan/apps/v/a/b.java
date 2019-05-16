package com.baidu.swan.apps.v.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static boolean a(@Nullable c cVar) {
        if (!com.baidu.swan.apps.u.a.DE().vW()) {
            if (DEBUG) {
                Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade false => 新年小程序错误兜底h5降级ab开关为关闭 swan_new_year_h5_downgrade false");
            }
            return false;
        } else if (cVar == null || TextUtils.isEmpty(cVar.mAppId)) {
            if (DEBUG) {
                Log.d("LaunchError", "isExecuteSwanNewYearH5Downgrade false => illegal launchErrorInfo");
            }
            return false;
        } else {
            List<String> EH = EH();
            if (EH == null) {
                if (DEBUG) {
                    Log.w("LaunchError", "isExecuteSwanNewYearH5Downgrade false =》 illegal newYearAppIds");
                }
                return false;
            }
            String str = cVar.mAppId;
            for (String str2 : EH) {
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
    public static String EG() {
        String vX = vX();
        if (DEBUG) {
            Log.d("LaunchError", "getSwanNewYearH5DowngradeScheme => originUrl: " + vX);
        }
        String str = null;
        try {
            str = URLEncoder.encode(vX, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            if (DEBUG) {
                throw new RuntimeException(e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = vX;
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
    private static String vX() {
        String vX = com.baidu.swan.apps.u.a.DE().vX();
        if (TextUtils.isEmpty(vX)) {
            return "https://2019.baidu.com/activity/shake2019/index.html?idfrom=aiappfb";
        }
        return vX;
    }

    private static List<String> EH() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("i2UoL6iWVUjaSpHLA4ftCxO2SNCdkTf0");
        arrayList.add("uSTqbBp5u8egzErCpTiPrAOumDjAXWMU");
        return arrayList;
    }
}
