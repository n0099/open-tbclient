package com.baidu.crabsdk.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
public final class p {
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private static boolean c(String str) {
        Process process = null;
        try {
            try {
                process = Runtime.getRuntime().exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                com.baidu.crabsdk.c.a.cG("isExecutable" + readLine);
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        return true;
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

    public static int rp() {
        if (new File("/system/bin/su").exists() && c("/system/bin/su")) {
            return 1;
        }
        return (new File("/system/xbin/su").exists() && c("/system/xbin/su")) ? 1 : 0;
    }
}
