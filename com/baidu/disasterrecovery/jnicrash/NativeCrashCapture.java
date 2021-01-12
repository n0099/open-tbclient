package com.baidu.disasterrecovery.jnicrash;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
/* loaded from: classes5.dex */
public class NativeCrashCapture implements NoProGuard {
    private static final String SO_INIT_FLAG_FILE = "jnicrash_so_init_fail_flag";
    private static final String SO_LOAD_FLAG_FILE = "jnicrash_so_load_fail_flag";
    private static final String STATISTIC_UBC_INIT_FAILED_TAG = "SO_INIT_FAILED";
    private static final String STATISTIC_UBC_LOAD_CRASH_TAG = "SO_LOAD_CRASH";
    private static final String STATISTIC_UBC_LOAD_EXP_TAG = "SO_LOAD_EXCEPTION";
    private static final String TAG = "NativeCrashCapture";
    private static final boolean DEBUG = LLog.sDebug;
    private static boolean sInit = false;
    private static Context sContext = null;
    private static com.baidu.disasterrecovery.jnicrash.b sNativeCrashHandler = null;

    private static native int nativeCrash();

    private static native int nativeInit(int i);

    public static void init(@NonNull Context context, @NonNull com.baidu.disasterrecovery.jnicrash.b bVar, boolean z) {
        if (!sInit && bVar != null && context != null) {
            sContext = context;
            sNativeCrashHandler = bVar;
            loadNativeCrashLib();
            if (sInit) {
                File file = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                nativeInit(Build.VERSION.SDK_INT);
                if (z) {
                    com.baidu.disasterrecovery.jnicrash.a.uz();
                }
                file.delete();
                if (DEBUG) {
                    Log.d(TAG, "nativeInit success");
                }
            }
        }
    }

    private static void loadNativeCrashLib() {
        File file = new File(sContext.getFilesDir() + "/" + SO_LOAD_FLAG_FILE);
        File file2 = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
        if (file.exists()) {
            sNativeCrashHandler.onEvent(STATISTIC_UBC_LOAD_CRASH_TAG, "Native load crash");
        }
        if (file2.exists()) {
            sNativeCrashHandler.onEvent(STATISTIC_UBC_INIT_FAILED_TAG, "Native init failed");
        }
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            SoLoader.load(sContext, "native-crash");
            if (SoLoader.isSoLoadedSucc("native-crash")) {
                sInit = true;
                file.delete();
                if (DEBUG) {
                    Log.d(TAG, "load native-crash.so success, arch is: " + System.getProperty("os.arch").toLowerCase());
                }
            }
        } catch (Throwable th) {
            sInit = false;
            th.printStackTrace();
            sNativeCrashHandler.onEvent(STATISTIC_UBC_LOAD_EXP_TAG, Log.getStackTraceString(th));
        }
    }

    public static void uncaughtNativeCrash(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT > 19) {
            if (sNativeCrashHandler != null) {
                sNativeCrashHandler.uncaughtNativeCrash(str, i, i2);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "uncaughtNativeCrash");
        }
        if (sNativeCrashHandler != null) {
            sNativeCrashHandler.uncaughtNativeCrash(str, i, i2);
        }
    }

    public static void beginNativeCrash() {
        if (Build.VERSION.SDK_INT > 19) {
            if (sNativeCrashHandler != null) {
                sNativeCrashHandler.uC();
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "beginNativeCrash");
        }
        if (sNativeCrashHandler != null) {
            sNativeCrashHandler.uC();
        }
    }

    public static void makeCrash() {
        if (sInit) {
            nativeCrash();
        } else {
            Log.e(TAG, "so hasn't been loaded.");
        }
    }

    private static void preloadKIKKAT() {
        if (Build.VERSION.SDK_INT <= 19) {
            a.init();
            b.init();
        }
    }

    /* loaded from: classes5.dex */
    private static class a extends Thread {
        public static void init() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NativeCrashCapture.sNativeCrashHandler.uC();
        }
    }

    /* loaded from: classes5.dex */
    private static class b extends Thread {
        String arf;
        int pid;
        int tid;

        public static void init() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (NativeCrashCapture.sNativeCrashHandler != null) {
                NativeCrashCapture.sNativeCrashHandler.uncaughtNativeCrash(this.arf, this.pid, this.tid);
            }
        }
    }
}
