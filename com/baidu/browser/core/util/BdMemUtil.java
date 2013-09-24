package com.baidu.browser.core.util;

import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class BdMemUtil {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "BdMemUtil";
    public static final String[] FIELDS_SYS_MEMINFO = {"MemTotal:", "MemFree:", "Buffers:", "Cached:", "Active:", "Inactive:", "Dirty:"};
    public static final String[] FIELDS_PROC_MEMINFO = {"VmLck:", "VmRSS:", "VmSize:", "VmExe:", "VmStk:", "VmLib", "Threads:"};

    public static Map<String, Long> getSysMemoryInfo() {
        HashMap hashMap = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method != null) {
                long[] jArr = new long[FIELDS_SYS_MEMINFO.length];
                jArr[0] = 30;
                jArr[1] = -30;
                method.invoke(null, new String("/proc/meminfo"), FIELDS_SYS_MEMINFO, jArr);
                for (int i = 0; i < jArr.length; i++) {
                    hashMap.put(FIELDS_SYS_MEMINFO[i], Long.valueOf(jArr[i]));
                }
                return hashMap;
            }
            return hashMap;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        } catch (NoSuchMethodException e4) {
            return null;
        } catch (SecurityException e5) {
            return null;
        } catch (InvocationTargetException e6) {
            return null;
        }
    }

    public Map<String, Long> getProcMemoryInfo() {
        HashMap hashMap = new HashMap();
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            if (method != null) {
                long[] jArr = new long[FIELDS_PROC_MEMINFO.length];
                jArr[0] = -1;
                method.invoke(null, new String("/proc/" + String.valueOf(Process.myPid()) + "/status"), FIELDS_PROC_MEMINFO, jArr);
                for (int i = 0; i < jArr.length; i++) {
                    hashMap.put(FIELDS_PROC_MEMINFO[i], Long.valueOf(jArr[i]));
                }
                return hashMap;
            }
            return hashMap;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (IllegalArgumentException e3) {
            return null;
        } catch (NoSuchMethodException e4) {
            return null;
        } catch (SecurityException e5) {
            return null;
        } catch (InvocationTargetException e6) {
            return null;
        }
    }
}
