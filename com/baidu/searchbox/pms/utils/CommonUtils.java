package com.baidu.searchbox.pms.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CommonUtils {
    public static final String TAG = "pmsCommonUtils";

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String createErrorJson(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                if (strArr.length > 0 && strArr.length % 2 == 0) {
                    for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                        String str = strArr[i2];
                        String str2 = strArr[i2 + 1];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put(str, str2);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return ",errmsg:" + jSONObject.toString();
    }

    public static String getCpuAbi() {
        return Build.CPU_ABI;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static String mergePath(String str, String str2) {
        return pathCombine(str, str2, File.separator);
    }

    public static String pathCombine(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str.endsWith(str3)) {
            if (str2.startsWith(str3)) {
                return str.concat(str2.substring(str3.length()));
            }
            return str.concat(str2);
        } else if (str2.startsWith(str3)) {
            return str.concat(str2);
        } else {
            return str.concat(str3).concat(str2);
        }
    }

    public static void postThread(Runnable runnable, String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 3);
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }
}
