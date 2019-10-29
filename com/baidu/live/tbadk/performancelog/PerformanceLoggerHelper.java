package com.baidu.live.tbadk.performancelog;

import android.os.Process;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes6.dex */
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
        r0 = r6[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b7, blocks: (B:52:0x00ae, B:54:0x00b3), top: B:72:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Process process2;
        String str;
        String str2;
        BufferedReader bufferedReader2 = null;
        int myPid = Process.myPid();
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                str2 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            if (readLine.trim().startsWith(String.valueOf(myPid))) {
                                String[] split = readLine.split("\\s+");
                                if (split != null && split.length > 2 && split[2] != null && split[2].contains("%")) {
                                    break;
                                }
                                int i = 0;
                                while (true) {
                                    if (i < split.length) {
                                        if (split[i] == null || !split[i].contains("%")) {
                                            i++;
                                        } else {
                                            str2 = split[i].trim();
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        bufferedReader2 = bufferedReader;
                        process2 = process;
                        str = str2;
                        e = e;
                        try {
                            e.printStackTrace();
                            if (process2 != null) {
                                try {
                                    process2.destroy();
                                } catch (Exception e2) {
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
                        } catch (Throwable th) {
                            th = th;
                            process = process2;
                            bufferedReader = bufferedReader2;
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e3) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (process != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e4) {
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e5) {
                e = e5;
                process2 = process;
                str = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            e = e6;
            process2 = null;
            str = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            process = null;
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
