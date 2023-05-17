package com.baidu.searchbox.retrieve.upload;

import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;
import java.io.IOException;
/* loaded from: classes4.dex */
public class RetrieveClear {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String TAG = "RetrieveClear";
    public final String mOldZipRootPath;
    public final String mZipRootPath;

    /* loaded from: classes4.dex */
    public static class RetrieveClearSingle {
        public static final RetrieveClear INSTANCE = new RetrieveClear();
    }

    public static RetrieveClear getInstance() {
        return RetrieveClearSingle.INSTANCE;
    }

    public void autoClearCache() {
        if (DEBUG) {
            Log.v(TAG, "Retrieve Auto Clear Cache .");
        }
        deleteFolder(this.mOldZipRootPath);
        deleteFolder(this.mZipRootPath);
    }

    public long calculateCacheSize() throws IOException {
        File file = new File(this.mOldZipRootPath);
        if (!file.exists() || !file.isDirectory()) {
            return 0L;
        }
        return 0 + getDirectorySize(file);
    }

    public void manualClearCache() {
        if (DEBUG) {
            Log.v(TAG, "Retrieve Manual Clear Cache .");
        }
        deleteFolder(this.mOldZipRootPath);
    }

    public RetrieveClear() {
        this.mOldZipRootPath = AppRuntime.getAppContext().getApplicationInfo().dataDir + UploadHelper.LOG_FILE_FETCH_ZIP_PATH + File.separator;
        this.mZipRootPath = AppRuntime.getAppContext().getCacheDir().getAbsolutePath() + UploadHelper.LOG_FILE_FETCH_ZIP_PATH + File.separator;
    }

    private boolean deleteFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            if (DEBUG) {
                Log.v(TAG, "RetrieveClear delete File : " + str);
            }
            return file.delete();
        }
        return false;
    }

    private boolean deleteFolder(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return deleteFile(str);
        }
        return deleteDirectory(str);
    }

    public long getDirectorySize(File file) throws IOException {
        long length;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return file.length();
        }
        long j = 0;
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = getDirectorySize(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    private boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                z = deleteFile(file2.getAbsolutePath());
            } else {
                z = deleteDirectory(file2.getAbsolutePath());
            }
            if (!z) {
                break;
            }
        }
        if (!z) {
            return false;
        }
        if (DEBUG) {
            Log.v(TAG, "RetrieveClear delete Directory : " + str);
        }
        return file.delete();
    }
}
