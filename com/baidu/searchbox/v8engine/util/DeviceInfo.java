package com.baidu.searchbox.v8engine.util;

import java.io.File;
import java.io.FileFilter;
/* loaded from: classes4.dex */
public class DeviceInfo {
    public static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.searchbox.v8engine.util.DeviceInfo.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    public static int getNumberOfCPUCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }
}
