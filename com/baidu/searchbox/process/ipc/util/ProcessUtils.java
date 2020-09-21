package com.baidu.searchbox.process.ipc.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.searchbox.process.ipc.IPCLibConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes16.dex */
public final class ProcessUtils {
    private static final String AI_APPS_PROCESS_SUFFIX = ":swan";
    private static final String CMD_LINE_NAME = "/proc/self/cmdline";
    private static final boolean DEBUG = false;
    private static final int PROCESS_NAME_LENGTH = 500;
    private static final String TAG = "ProcessUtils";
    private static boolean sIsMainProcess;
    private static String sMainProcessName;
    private static String sProcessName;

    static {
        Context context = IPCLibConfig.sAppContext;
        sMainProcessName = context.getApplicationInfo().processName;
        sProcessName = getProcessNameFromFile();
        if (TextUtils.isEmpty(sProcessName)) {
            sProcessName = getProcessNameFromAm(context);
        }
        sIsMainProcess = checkIsMainProcess(sProcessName);
    }

    public static boolean isMainProcess() {
        return sIsMainProcess;
    }

    public static boolean isSwanProcess() {
        return !TextUtils.isEmpty(sProcessName) && sProcessName.contains(AI_APPS_PROCESS_SUFFIX);
    }

    public static String getMainProcessName() {
        return sMainProcessName;
    }

    public static String getCurProcessName() {
        return sProcessName;
    }

    private static String getProcessNameFromAm(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [138=4] */
    private static String getProcessNameFromFile() {
        FileInputStream fileInputStream;
        Throwable th;
        String str = null;
        try {
            fileInputStream = new FileInputStream(new File(CMD_LINE_NAME));
        } catch (Exception e) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            byte[] bArr = new byte[500];
            str = new String(bArr, 0, fileInputStream.read(bArr)).trim();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
        return str;
    }

    public static boolean checkIsMainProcess(String str) {
        if (TextUtils.equals(str, sMainProcessName)) {
            return true;
        }
        return str.startsWith(sMainProcessName) && !str.contains(":");
    }

    public static boolean is64Bit() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
            if (strArr.length > 0) {
                return Build.CPU_ABI.equals(strArr[0]);
            }
            return false;
        }
        return false;
    }
}
