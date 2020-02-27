package com.baidu.searchbox.v8engine.util;

import com.baidu.fsg.face.base.b.c;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes11.dex */
public class DeviceInfo {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.baidu.searchbox.v8engine.util.DeviceInfo.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith(c.i)) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    };
    public static final int DEVICEINFO_UNKNOWN = -1;

    public static int getNumberOfCPUCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
        } catch (NullPointerException e) {
            return -1;
        } catch (SecurityException e2) {
            return -1;
        }
    }
}
