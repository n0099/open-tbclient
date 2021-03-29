package com.baidu.crabsdk.lite.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4733a;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityManager f4734b;

    public static void a(Context context) {
        if (f4733a == null) {
            f4733a = context;
            f4734b = (ActivityManager) context.getSystemService("activity");
        }
    }

    public static String b() {
        Debug.MemoryInfo memoryInfo;
        StringBuilder sb = new StringBuilder();
        if (f4734b == null) {
            return sb.toString();
        }
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        f4734b.getMemoryInfo(memoryInfo2);
        sb.append("isLowMem: ");
        sb.append(memoryInfo2.lowMemory ? "yes" : "no");
        sb.append("\navailMem: ");
        sb.append(com.baidu.crabsdk.lite.b.c.a(memoryInfo2.availMem));
        sb.append("\nthreshold: ");
        sb.append(com.baidu.crabsdk.lite.b.c.a(memoryInfo2.threshold));
        sb.append("\n");
        if (com.baidu.crabsdk.lite.b.c.g() >= 5 && (memoryInfo = f4734b.getProcessMemoryInfo(new int[]{Process.myPid()})[0]) != null) {
            sb.append("totalPrivateDirty: ");
            sb.append(com.baidu.crabsdk.lite.b.c.a(memoryInfo.getTotalPrivateDirty() * 1024));
            sb.append("\ntotalPss: ");
            sb.append(com.baidu.crabsdk.lite.b.c.a(memoryInfo.getTotalPss() * 1024));
            sb.append("\ntotalSharedDirty: ");
            sb.append(com.baidu.crabsdk.lite.b.c.a(memoryInfo.getTotalSharedDirty() * 1024));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0076: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:48:0x0076 */
    public static String c(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        IOException e2;
        FileNotFoundException e3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader2 = new BufferedReader(fileReader, 8192);
                        int i = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                int i2 = i + 1;
                                if (i >= 5) {
                                    break;
                                }
                                sb.append(readLine);
                                sb.append("\n");
                                i = i2;
                            } catch (FileNotFoundException e4) {
                                e3 = e4;
                                com.baidu.crabsdk.lite.b.a.e(str, "getSysMemInfo fail.", e3);
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                return sb.toString();
                            } catch (IOException e5) {
                                e2 = e5;
                                com.baidu.crabsdk.lite.b.a.e(str, "getSysMemInfo fail.", e2);
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                return sb.toString();
                            }
                        }
                        bufferedReader2.close();
                        fileReader.close();
                    } catch (FileNotFoundException e6) {
                        bufferedReader2 = null;
                        e3 = e6;
                    } catch (IOException e7) {
                        bufferedReader2 = null;
                        e2 = e7;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                throw th;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            } catch (FileNotFoundException e10) {
                bufferedReader2 = null;
                e3 = e10;
                fileReader = null;
            } catch (IOException e11) {
                bufferedReader2 = null;
                e2 = e11;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
            }
            return sb.toString();
        } catch (Throwable th3) {
            th = th3;
            bufferedReader3 = bufferedReader;
        }
    }
}
