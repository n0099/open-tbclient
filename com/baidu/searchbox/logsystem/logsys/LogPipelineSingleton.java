package com.baidu.searchbox.logsystem.logsys;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.logsys.CrashUtil;
import java.io.File;
/* loaded from: classes2.dex */
public class LogPipelineSingleton {
    public static final String CRASH_PAD_DIR = "crashpad";
    public static final String TAG = "LogPipelineSingleton";
    public static volatile LogPipelineSingleton sInstance;
    @NonNull
    public LogSystemConfig mLogSystemConfig;

    public LogPipelineSingleton(@NonNull LogSystemConfig logSystemConfig) {
        this.mLogSystemConfig = logSystemConfig;
    }

    public static synchronized void initialize(@NonNull LogSystemConfig logSystemConfig) {
        synchronized (LogPipelineSingleton.class) {
            sInstance = new LogPipelineSingleton(logSystemConfig);
        }
    }

    public static File obtainFileDirWithProcessName(@NonNull String str) {
        File file = getInstance().getLogStoreDirSupplier().get();
        if (TextUtils.isEmpty(str)) {
            return file;
        }
        return new File(file, str.replace(":", "_"));
    }

    @Nullable
    public File getProcessCrashpadDir(@NonNull CrashUtil.CrashTAG crashTAG) {
        String crashTAG2 = CrashUtil.CrashTAG.getCrashTAG(crashTAG);
        if (!TextUtils.isEmpty(crashTAG2)) {
            return new File(getCrashRootDir(), crashTAG2);
        }
        return null;
    }

    @NonNull
    public static LogPipelineSingleton getInstance() {
        if (sInstance == null) {
            synchronized (LogPipelineSingleton.class) {
                if (sInstance == null) {
                    initialize();
                }
            }
        }
        return sInstance;
    }

    public static void init() {
        LogSystemConfig.init();
    }

    public static synchronized void initialize() {
        synchronized (LogPipelineSingleton.class) {
            initialize(LogSystemConfig.newBuilder(AppRuntime.getAppContext()).build());
        }
    }

    public File getCrashRootDir() {
        return new File(getLogStoreDirSupplier().get(), CRASH_PAD_DIR);
    }

    @NonNull
    public Supplier<File> getLogStoreDirSupplier() {
        return this.mLogSystemConfig.getLogDiskStoreConfig().getLogStoreRootDirSupplier();
    }

    @NonNull
    public File getProcessCrashpadDir() {
        return new File(getCrashRootDir(), CrashUtil.getCrashTAG());
    }

    @Nullable
    public File getProcessCrashpadDir(@NonNull String str) {
        CrashUtil.CrashTAG crashTAG = CrashUtil.CrashTAG.getCrashTAG(str);
        if (crashTAG != null) {
            return getProcessCrashpadDir(crashTAG);
        }
        return null;
    }
}
