package com.baidu.fsg.base.restnet.beans.business.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class SecurityUtils {
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean isExecutable(String str) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        if (process != null) {
                            process.destroy();
                        }
                        return true;
                    }
                }
                if (process == null) {
                    return false;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static boolean isRoot() {
        if (new File("/system/bin/su").exists() && isExecutable("/system/bin/su")) {
            return true;
        }
        return new File("/system/xbin/su").exists() && isExecutable("/system/xbin/su");
    }
}
