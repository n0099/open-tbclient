package com.baidu.searchbox.logsystem.logsys;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
/* loaded from: classes9.dex */
public class LogObject extends LogBaseObject {
    private String mCrashTAG;
    @Nullable
    private String mLogBasicData;
    @Nullable
    private File mLogBasicDataFile;
    private boolean mLogBasicDataOverflow = false;
    @Nullable
    private LogExtra mLogExtra;
    @Nullable
    private File mLogExtraPathNameKeeper;
    @NonNull
    private String mProcessName;

    public LogObject(@NonNull LogType logType, @NonNull String str, @Nullable String str2, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra, @NonNull String str3) {
        this.mProcessName = null;
        this.mLogBasicData = null;
        this.mLogBasicDataFile = null;
        this.mLogExtraPathNameKeeper = null;
        this.mCrashTAG = null;
        if (LogType.NONE == logType && LLog.sDebug) {
            throw new RuntimeException("logType should not be LogType.NONE in LogObject instance.");
        }
        this.mLogType = logType;
        this.mProcessName = str;
        this.mLogBasicData = str2;
        if (file != null && file.exists() && file.isFile()) {
            this.mLogBasicDataFile = file;
        }
        if (file2 != null && file2.exists() && file2.isFile()) {
            this.mLogExtraPathNameKeeper = file2;
        }
        this.mLogExtra = logExtra;
        this.mCrashTAG = str3;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getLogBasicData() {
        return this.mLogBasicData;
    }

    public void setLogBasicData(@NonNull String str) {
        this.mLogBasicData = str;
    }

    public File getLogBasicDataFile() {
        return this.mLogBasicDataFile;
    }

    public void setLogBasicDataFile(@NonNull File file) {
        this.mLogBasicDataFile = file;
    }

    public File getLogExtraPathNameKeeper() {
        return this.mLogExtraPathNameKeeper;
    }

    public boolean getLogBasicDataOverflow() {
        return this.mLogBasicDataOverflow;
    }

    public void setLogBasicDataOverflow(boolean z) {
        this.mLogBasicDataOverflow = z;
    }

    public LogExtra getLogExtra() {
        return this.mLogExtra;
    }

    public String getCrashTAG() {
        return this.mCrashTAG;
    }
}
