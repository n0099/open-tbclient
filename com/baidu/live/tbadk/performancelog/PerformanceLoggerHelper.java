package com.baidu.live.tbadk.performancelog;

import android.os.Process;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes10.dex */
public class PerformanceLoggerHelper {
    private static volatile PerformanceLoggerHelper mInstance;

    public static PerformanceLoggerHelper getInstance() {
        if (mInstance == null) {
            synchronized (PerformanceLoggerHelper.class) {
                if (mInstance == null) {
                    mInstance = new PerformanceLoggerHelper();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r5 = r3[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Exception e;
        BufferedReader bufferedReader2;
        String str;
        String str2;
        String str3;
        String[] split;
        int myPid = Process.myPid();
        try {
            try {
                process = Runtime.getRuntime().exec("top -n 1");
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader2 = null;
            process = null;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            process = null;
        }
        try {
            bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String str4 = null;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        str3 = str4;
                        break;
                    } else if (readLine.trim().startsWith(String.valueOf(myPid)) && (split = readLine.split("\\s+")) != null) {
                        if (split.length > 2 && split[2] != null && split[2].contains("%")) {
                            break;
                        }
                        int i = 0;
                        while (true) {
                            if (i < split.length) {
                                if (split[i] == null || !split[i].contains("%")) {
                                    i++;
                                } else {
                                    str4 = split[i].trim();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = str4;
                    e.printStackTrace();
                    if (process != null) {
                        try {
                            process.destroy();
                        } catch (Exception e4) {
                            str2 = str;
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    str2 = str;
                    if (str2 != null) {
                    }
                    return JavaTypesHelper.toInt(str2, -1);
                }
            }
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e5) {
                    str2 = str3;
                }
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            str2 = str3;
        } catch (Exception e6) {
            e = e6;
            bufferedReader2 = null;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (process != null) {
                try {
                    process.destroy();
                } catch (Exception e7) {
                    throw th;
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        if (str2 != null) {
            String[] split2 = str2.split("%");
            if (split2.length > 0) {
                str2 = split2[0];
            }
        }
        return JavaTypesHelper.toInt(str2, -1);
    }
}
