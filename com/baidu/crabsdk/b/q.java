package com.baidu.crabsdk.b;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public final class q {
    public static int a() {
        if (new File("/system/bin/su").exists() && b("/system/bin/su")) {
            return 1;
        }
        return (new File("/system/xbin/su").exists() && b("/system/xbin/su")) ? 1 : 0;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean b(String str) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                com.baidu.crabsdk.c.a.b("isExecutable" + readLine);
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        if (process != null) {
                            process.destroy();
                            return true;
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
}
