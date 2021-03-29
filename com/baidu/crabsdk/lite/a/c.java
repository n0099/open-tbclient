package com.baidu.crabsdk.lite.a;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class c {
    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: java.lang.StringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    public static String a(String str) {
        ?? myPid;
        FileReader fileReader;
        Exception e2;
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/" + ((int) myPid) + "/stat");
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = Process.myPid();
                }
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (Exception e3) {
                            e2 = e3;
                            com.baidu.crabsdk.lite.b.a.e(str, "getMyAppCPUStat fail.", e2);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return sb.toString();
                        }
                    }
                    bufferedReader.close();
                    fileReader.close();
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e4) {
                    e2 = e4;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                fileReader = null;
                e2 = e6;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileReader = null;
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        return sb.toString();
    }
}
