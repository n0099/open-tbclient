package com.baidu.android.util.devices;

import android.app.ActivityManager;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class MemoryUtils {
    public static final int BUFFER_SIZE = 8192;
    public static final boolean DEBUG = false;
    public static final String TAG = "MemoryUtils";
    public static long sTotalMemory;

    public static long getFreeMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static long getTotalMemory() {
        FileReader fileReader;
        String readLine;
        if (sTotalMemory == 0) {
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader("/proc/meminfo");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                    try {
                        r1 = bufferedReader2.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                        Closeables.closeSafely(bufferedReader2);
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely(bufferedReader);
                        Closeables.closeSafely(fileReader);
                        sTotalMemory = r1;
                        return sTotalMemory;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Closeables.closeSafely(bufferedReader);
                        Closeables.closeSafely(fileReader);
                        throw th;
                    }
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused3) {
                fileReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileReader = null;
            }
            Closeables.closeSafely(fileReader);
            sTotalMemory = r1;
        }
        return sTotalMemory;
    }
}
