package com.baidu.crabsdk.b;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes6.dex */
public final class e {
    public static String x() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        bufferedReader2 = null;
        FileReader fileReader2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine).append("\n");
                    } catch (Exception e) {
                        fileReader2 = fileReader;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (fileReader2 != null) {
                            fileReader2.close();
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        bufferedReader2 = bufferedReader;
                        th = th;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
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
                bufferedReader.close();
                fileReader.close();
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                bufferedReader = null;
                fileReader2 = fileReader;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        return sb.toString();
    }
}
