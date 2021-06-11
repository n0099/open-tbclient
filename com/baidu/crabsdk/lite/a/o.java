package com.baidu.crabsdk.lite.a;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public final class o {
    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean a(String str, String str2) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str2);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                com.baidu.crabsdk.lite.b.a.f(str, "isExecutable" + readLine);
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

    public static int b(String str) {
        if (new File("/system/bin/su").exists() && a(str, "/system/bin/su")) {
            return 1;
        }
        return (new File("/system/xbin/su").exists() && a(str, "/system/xbin/su")) ? 1 : 0;
    }
}
