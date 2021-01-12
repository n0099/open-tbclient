package com.baidu.searchbox.aperf.bosuploader;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class STSManager {
    private static final String STS_FILE = ".sts";
    private static final String STS_FILE_PATH = "stsfile";
    private static final String TAG = STSManager.class.getSimpleName();
    private static final HashMap<String, STSInfo> infoMap = new HashMap<>();
    private static HashMap<String, Long> retryTime = new HashMap<>();
    private static final long RETRY_TIME_LIMIT_HOUR = TimeUnit.MINUTES.toMillis(20);

    public static STSInfo getCurrentStsInfo(@NonNull String str) {
        STSInfo sTSInfo = infoMap.get(str);
        if (sTSInfo == null && (sTSInfo = loadStsFromFile(str)) != null) {
            synchronized (infoMap) {
                infoMap.put(str, sTSInfo);
            }
        }
        return ContentUtil.checkStsValid(sTSInfo) ? sTSInfo : retryGetStsInfo(str);
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

    public static boolean checkRetry(@NonNull String str) {
        long j = 0;
        if (retryTime.containsKey(str)) {
            j = retryTime.get(str).longValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - j) > RETRY_TIME_LIMIT_HOUR) {
            retryTime.put(str, Long.valueOf(currentTimeMillis));
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [133=5] */
    private static STSInfo loadStsFromFile(String str) {
        FileInputStream fileInputStream;
        STSInfo sTSInfo = null;
        try {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
            if (file.exists()) {
                File file2 = new File(file, ".sts_" + str + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX);
                if (!file2.exists()) {
                    Closeables.closeSafely((Closeable) null);
                } else if (file2.isFile()) {
                    fileInputStream = new FileInputStream(file2);
                    try {
                        try {
                            String readFromFileInputStream = FileUtil.readFromFileInputStream(fileInputStream);
                            if (TextUtils.isEmpty(readFromFileInputStream)) {
                                Closeables.closeSafely(fileInputStream);
                            } else {
                                sTSInfo = ContentUtil.createSTSInfo(readFromFileInputStream);
                                Closeables.closeSafely(fileInputStream);
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            Log.e(TAG, e.getMessage(), e);
                            Closeables.closeSafely(fileInputStream);
                            return sTSInfo;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(fileInputStream);
                        throw th;
                    }
                } else {
                    Closeables.closeSafely((Closeable) null);
                }
            } else {
                Closeables.closeSafely((Closeable) null);
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            Closeables.closeSafely(fileInputStream);
            throw th;
        }
        return sTSInfo;
    }

    private static void writeStsInfoToFile(String str, String str2) {
        File file = new File(AppRuntime.getAppContext().getFilesDir(), STS_FILE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileUtil.writeDataToFile(new File(file, ".sts_" + str + BdStatsConstant.StatsFile.LOG_FILE_SUFFIX), str2);
    }
}
