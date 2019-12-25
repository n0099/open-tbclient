package com.baidu.fsg.base.restnet.beans.business.core.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class SecurityUtils {
    public static boolean isRoot() {
        if (new File("/system/bin/su").exists() && isExecutable("/system/bin/su")) {
            return true;
        }
        return new File("/system/xbin/su").exists() && isExecutable("/system/xbin/su");
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [41=4, 42=4] */
    private static boolean isExecutable(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (process != null) {
                    process.destroy();
                }
            }
            return false;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}
