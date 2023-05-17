package com.baidu.searchbox.pms.utils;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.pms.PmsRuntime;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CommonUtils {
    public static final int CLEAR_INTERVAL_MIN_LIMIT = 604800000;
    public static final int DEFAULT_DELAY_TIME = 10000;
    public static final String PMS_DIR = "pms";
    public static final String TAG = "pmsCommonUtils";

    public static String getCpuAbi() {
        return Build.CPU_ABI;
    }

    public static boolean checkFileAbsolutePathNeedClear(String str) {
        if (!TextUtils.isEmpty(str) && PmsRuntime.getPmsContext().getAutoClearChannelIdList() != null) {
            Iterator<String> it = PmsRuntime.getPmsContext().getAutoClearChannelIdList().iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next() + "_")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static String createErrorJson(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        if (strArr != null) {
            try {
                if (strArr.length > 0 && strArr.length % 2 == 0) {
                    for (int i = 0; i < strArr.length; i += 2) {
                        String str = strArr[i];
                        String str2 = strArr[i + 1];
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put(str, str2);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ",errmsg:" + jSONObject.toString();
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                if (AppConfig.isDebug()) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isEmpty(Collection collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static List<String> getAllRedundantFiles() {
        ArrayList arrayList = new ArrayList();
        File file = new File(AppRuntime.getAppContext().getFilesDir(), "pms");
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile() && System.currentTimeMillis() - listFiles[i].lastModified() > 604800000 && checkFileAbsolutePathNeedClear(listFiles[i].getAbsolutePath())) {
                    arrayList.add(listFiles[i].getAbsolutePath());
                }
            }
        }
        return arrayList;
    }

    public static boolean isEmpty(Map map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }

    public static String mergePath(String str, String str2) {
        return pathCombine(str, str2, File.separator);
    }

    public static void postThread(Runnable runnable, String str) {
        ExecutorUtilsExt.postOnElastic(runnable, str, 3);
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
}
