package com.baidu.android.util.devices;

import android.app.ActivityManager;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes12.dex */
public class MemoryUtils {
    private static final int BUFFER_SIZE = 8192;
    private static final boolean DEBUG = false;
    private static final String TAG = "MemoryUtils";
    private static long sTotalMemory;

    public static long getFreeMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) AppRuntime.getAppContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [73=4] */
    public static long getTotalMemory() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String readLine;
        FileReader fileReader2 = null;
        if (sTotalMemory == 0) {
            try {
                fileReader = new FileReader("/proc/meminfo");
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                    try {
                        r0 = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                        Closeables.closeSafely(bufferedReader);
                        Closeables.closeSafely(fileReader);
                    } catch (IOException e) {
                        fileReader2 = fileReader;
                        Closeables.closeSafely(bufferedReader);
                        Closeables.closeSafely(fileReader2);
                        sTotalMemory = r0;
                        return sTotalMemory;
                    } catch (Throwable th) {
                        th = th;
                        Closeables.closeSafely(bufferedReader);
                        Closeables.closeSafely(fileReader);
                        throw th;
                    }
                } catch (IOException e2) {
                    bufferedReader = null;
                    fileReader2 = fileReader;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (IOException e3) {
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileReader = null;
            }
            sTotalMemory = r0;
        }
        return sTotalMemory;
    }
}
