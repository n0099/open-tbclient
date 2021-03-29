package com.baidu.crabsdk.b;

import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class e {
    public static String a() {
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                fileReader = new FileReader("/proc/" + Process.myPid() + "/stat");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append("\n");
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            return sb.toString();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
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
                    bufferedReader2.close();
                    fileReader.close();
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Exception unused3) {
            fileReader = null;
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
        }
        return sb.toString();
    }
}
