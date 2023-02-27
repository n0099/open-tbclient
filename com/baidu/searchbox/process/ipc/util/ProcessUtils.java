package com.baidu.searchbox.process.ipc.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.IPCLibConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public final class ProcessUtils {
    public static final String AI_APPS_PROCESS_SUFFIX = ":swan";
    public static final String CMD_LINE_NAME = "/proc/self/cmdline";
    public static final boolean DEBUG = false;
    public static final int PROCESS_NAME_LENGTH = 500;
    public static final String TAG = "ProcessUtils";
    public static boolean sIsMainProcess;
    public static String sMainProcessName;
    public static String sProcessName;

    static {
        Context context = IPCLibConfig.sAppContext;
        sMainProcessName = context.getApplicationInfo().processName;
        String processNameFromFile = getProcessNameFromFile();
        sProcessName = processNameFromFile;
        if (TextUtils.isEmpty(processNameFromFile)) {
            sProcessName = getProcessNameFromAm(context);
        }
        sIsMainProcess = checkIsMainProcess(sProcessName);
    }

    public static String getCurProcessName() {
        return sProcessName;
    }

    public static String getMainProcessName() {
        return sMainProcessName;
    }

    public static boolean is64Bit() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return Process.is64Bit();
        }
        if (i < 21) {
            return false;
        }
        String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
        if (strArr.length <= 0) {
            return false;
        }
        return Build.CPU_ABI.equals(strArr[0]);
    }

    public static boolean isMainProcess() {
        return sIsMainProcess;
    }

    public static boolean isSwanProcess() {
        if (!TextUtils.isEmpty(sProcessName) && sProcessName.contains(":swan")) {
            return true;
        }
        return false;
    }

    public static boolean checkIsMainProcess(String str) {
        if (TextUtils.equals(str, sMainProcessName)) {
            return true;
        }
        if (str.startsWith(sMainProcessName) && !str.contains(":")) {
            return true;
        }
        return false;
    }

    public static String getProcessNameFromAm(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String getProcessNameFromFile() {
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(new File(CMD_LINE_NAME));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                byte[] bArr = new byte[500];
                str = new String(bArr, 0, fileInputStream.read(bArr)).trim();
                fileInputStream.close();
            } catch (Exception unused) {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return str;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }
}
