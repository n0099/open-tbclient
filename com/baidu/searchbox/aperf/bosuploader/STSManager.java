package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class STSManager {
    public static final String STS_FILE = ".sts";
    public static final String STS_FILE_PATH = "stsfile";
    public static final String TAG = "STSManager";
    public static final HashMap<String, STSInfo> infoMap = new HashMap<>();
    public static HashMap<String, Long> retryTime = new HashMap<>();
    public static final long RETRY_TIME_LIMIT_HOUR = TimeUnit.MINUTES.toMillis(20);

    public static boolean checkRetry(@NonNull String str) {
        long longValue = retryTime.containsKey(str) ? retryTime.get(str).longValue() : 0L;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - longValue) > RETRY_TIME_LIMIT_HOUR) {
            retryTime.put(str, Long.valueOf(currentTimeMillis));
            return true;
        }
        return false;
    }

    public static STSInfo getCurrentStsInfo(@NonNull String str) {
        STSInfo sTSInfo = infoMap.get(str);
        if (sTSInfo == null && (sTSInfo = loadStsFromFile(str)) != null) {
            synchronized (infoMap) {
                infoMap.put(str, sTSInfo);
            }
        }
        return ContentUtil.checkStsValid(sTSInfo) ? sTSInfo : retryGetStsInfo(str);
    }

    public static STSInfo loadStsFromFile(String str) {
        Throwable th;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
        } catch (FileNotFoundException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            Closeables.closeSafely(fileInputStream);
            throw th;
        }
        if (!file.exists()) {
            Closeables.closeSafely((Closeable) null);
            return null;
        }
        File file2 = new File(file, ".sts_" + str + ".log");
        if (!file2.exists()) {
            Closeables.closeSafely((Closeable) null);
            return null;
        } else if (!file2.isFile()) {
            Closeables.closeSafely((Closeable) null);
            return null;
        } else {
            fileInputStream = new FileInputStream(file2);
            try {
                try {
                    String readFromFileInputStream = FileUtil.readFromFileInputStream(fileInputStream);
                    if (!TextUtils.isEmpty(readFromFileInputStream)) {
                        STSInfo createSTSInfo = ContentUtil.createSTSInfo(readFromFileInputStream);
                        Closeables.closeSafely(fileInputStream);
                        return createSTSInfo;
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    Log.e(TAG, e.getMessage(), e);
                    Closeables.closeSafely(fileInputStream);
                    return null;
                }
                Closeables.closeSafely(fileInputStream);
                return null;
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(fileInputStream);
                throw th;
            }
        }
    }

    public static STSInfo retryGetStsInfo(String str) {
        STSInfo bosStsInfo = BOSTokenRequest.getBosStsInfo(str);
        if (bosStsInfo != null) {
            synchronized (infoMap) {
                infoMap.put(str, bosStsInfo);
            }
            writeStsInfoToFile(str, bosStsInfo.getOrigin());
            return bosStsInfo;
        }
        return null;
    }

    public static void writeStsInfoToFile(String str, String str2) {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtil.writeDataToFile(new File(file, ".sts_" + str + ".log"), str2);
    }
}
