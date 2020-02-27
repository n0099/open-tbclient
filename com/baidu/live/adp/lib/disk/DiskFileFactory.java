package com.baidu.live.adp.lib.disk;

import android.os.Environment;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes3.dex */
public class DiskFileFactory {
    private String mAppCachePath;
    private String mAppInternalPath;
    private final String EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    private String mAppSdCardPath = this.EXTERNAL_STORAGE_DIRECTORY + "/baidu/";

    public DiskFileFactory() {
        this.mAppInternalPath = null;
        this.mAppCachePath = null;
        try {
            this.mAppInternalPath = BdBaseApplication.getInst().getContext().getFilesDir().getAbsolutePath() + "/";
            this.mAppCachePath = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setApplicationPath(String str) {
        if (str != null) {
            this.mAppSdCardPath = this.EXTERNAL_STORAGE_DIRECTORY + "/" + str + "/";
        }
    }

    public boolean checkSD() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public String checkDir(String str, boolean z, boolean z2, boolean z3) {
        String str2;
        if (z2) {
            if (!checkSD()) {
                return null;
            }
            if (str != null) {
                str2 = this.mAppSdCardPath + str + "/";
            } else {
                str2 = this.mAppSdCardPath;
            }
        } else if (z3) {
            if (this.mAppCachePath == null) {
                return null;
            }
            if (str != null) {
                str2 = this.mAppCachePath + str + "/";
            } else {
                str2 = this.mAppCachePath;
            }
        } else if (this.mAppInternalPath == null) {
            return null;
        } else {
            if (str != null) {
                str2 = this.mAppInternalPath + str + "/";
            } else {
                str2 = this.mAppInternalPath;
            }
        }
        File file = new File(str2);
        if (!file.exists()) {
            if (z && file.mkdirs()) {
                return str2;
            }
            return null;
        }
        return str2;
    }

    public File getFile(String str, String str2, boolean z, boolean z2, boolean z3) {
        String checkDir;
        if (str2 == null || (checkDir = checkDir(str, z, z2, z3)) == null) {
            return null;
        }
        return new File(checkDir + str2);
    }

    public File getFolder(String str, boolean z, boolean z2, boolean z3) {
        String checkDir = checkDir(str, z, z2, z3);
        if (checkDir == null) {
            return null;
        }
        return new File(checkDir);
    }
}
