package com.baidu.crabsdk.b;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class e {
    public static String x() {
        Throwable th;
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
            try {
                bufferedReader2 = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append("\n");
                    } catch (Exception e) {
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
                fileReader.close();
                try {
                    bufferedReader2.close();
                    fileReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            bufferedReader2 = null;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileReader = null;
        }
        return sb.toString();
    }
}
