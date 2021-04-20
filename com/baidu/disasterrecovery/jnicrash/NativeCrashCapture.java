package com.baidu.disasterrecovery.jnicrash;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.logsystem.util.LLog;
import java.io.File;
/* loaded from: classes.dex */
public class NativeCrashCapture implements NoProGuard {
    public static final String SO_INIT_FLAG_FILE = "jnicrash_so_init_fail_flag";
    public static final String SO_LOAD_FLAG_FILE = "jnicrash_so_load_fail_flag";
    public static final String STATISTIC_UBC_INIT_FAILED_TAG = "SO_INIT_FAILED";
    public static final String STATISTIC_UBC_LOAD_CRASH_TAG = "SO_LOAD_CRASH";
    public static final String STATISTIC_UBC_LOAD_EXP_TAG = "SO_LOAD_EXCEPTION";
    public static final String TAG = "NativeCrashCapture";
    public static final boolean DEBUG = LLog.sDebug;
    public static boolean sInit = false;
    public static Context sContext = null;
    public static d.b.n.a.b sNativeCrashHandler = null;

    /* loaded from: classes.dex */
    public static class a extends Thread {
        public static void a() {
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Thread {
        public static void a() {
        }
    }

    public static void beginNativeCrash() {
        if (Build.VERSION.SDK_INT > 19) {
            d.b.n.a.b bVar = sNativeCrashHandler;
            if (bVar != null) {
                bVar.d();
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "beginNativeCrash");
        }
        d.b.n.a.b bVar2 = sNativeCrashHandler;
        if (bVar2 != null) {
            bVar2.d();
        }
    }

    public static void init(@NonNull Context context, @NonNull d.b.n.a.b bVar, boolean z) {
        if (sInit || bVar == null || context == null) {
            return;
        }
        sContext = context;
        sNativeCrashHandler = bVar;
        loadNativeCrashLib();
        if (sInit) {
            File file = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            nativeInit(Build.VERSION.SDK_INT);
            if (z) {
                d.b.n.a.a.a();
            }
            file.delete();
            if (DEBUG) {
                Log.d(TAG, "nativeInit success");
            }
        }
    }

    public static void loadNativeCrashLib() {
        File file = new File(sContext.getFilesDir() + "/" + SO_LOAD_FLAG_FILE);
        File file2 = new File(sContext.getFilesDir() + "/" + SO_INIT_FLAG_FILE);
        if (file.exists()) {
            sNativeCrashHandler.f(STATISTIC_UBC_LOAD_CRASH_TAG, "Native load crash");
        }
        if (file2.exists()) {
            sNativeCrashHandler.f(STATISTIC_UBC_INIT_FAILED_TAG, "Native init failed");
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
                    String lowerCase = System.getProperty("os.arch").toLowerCase();
                    Log.d(TAG, "load native-crash.so success, arch is: " + lowerCase);
                }
            }
        } catch (Throwable th) {
            sInit = false;
            th.printStackTrace();
            sNativeCrashHandler.f(STATISTIC_UBC_LOAD_EXP_TAG, Log.getStackTraceString(th));
        }
    }

    public static void makeCrash() {
        if (sInit) {
            nativeCrash();
        } else {
            Log.e(TAG, "so hasn't been loaded.");
        }
    }

    public static native int nativeCrash();

    public static native int nativeInit(int i);

    public static void preloadKIKKAT() {
        if (Build.VERSION.SDK_INT <= 19) {
            a.a();
            b.a();
        }
    }

    public static void uncaughtNativeCrash(String str, int i, int i2) {
        if (Build.VERSION.SDK_INT > 19) {
            d.b.n.a.b bVar = sNativeCrashHandler;
            if (bVar != null) {
                bVar.i(str, i, i2);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d(TAG, "uncaughtNativeCrash");
        }
        d.b.n.a.b bVar2 = sNativeCrashHandler;
        if (bVar2 != null) {
            bVar2.i(str, i, i2);
        }
    }
}
