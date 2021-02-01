package com.baidu.pyramid.runtime.multiprocess;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
/* loaded from: classes15.dex */
public class a {
    private static volatile int csE = 0;
    private static volatile String sProcessName;

    public static int adZ() {
        int i = csE;
        if (i == 0) {
            String processName = getProcessName();
            String packageName = e.getAppContext().getPackageName();
            if (TextUtils.equals(processName, packageName) || (processName.startsWith(packageName) && !processName.contains(":"))) {
                i = i | 1 | 2;
            } else {
                i |= 4;
            }
            csE = i;
        }
        return i;
    }

    public static boolean aea() {
        return (adZ() & 1) != 0;
    }

    public static boolean aeb() {
        return (adZ() & 2) != 0;
    }

    public static String getProcessName() {
        String str = sProcessName;
        if (str == null) {
            synchronized (a.class) {
                str = sProcessName;
                if (str == null) {
                    Context appContext = e.getAppContext();
                    str = aed();
                    if (str == null && (str = getProcessNameFromAm(appContext)) == null) {
                        str = appContext.getPackageName();
                    }
                    sProcessName = str;
                }
            }
        }
        return str;
    }

    public static int aec() {
        Context appContext = e.getAppContext();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) appContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return -1;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.importance;
            }
        }
        return 0;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [195=4] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String aed() {
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/self/cmdline"))));
            try {
                try {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        try {
                            str = str.trim();
                        } catch (Exception e) {
                            e = e;
                            c("MultiProcess", e);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            return str;
                        }
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    str = null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            str = null;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return str;
    }

    private static void c(String str, Exception exc) {
    }
}
