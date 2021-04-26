package com.baidu.crabsdk.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static Context f4835a;

    /* renamed from: b  reason: collision with root package name */
    public static ActivityManager f4836b;

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0091: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:60:0x0091 */
    public static String a() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Exception e2;
        IOException e3;
        FileNotFoundException e4;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                } catch (Throwable th) {
                    th = th;
                    bufferedReader3 = bufferedReader2;
                }
            } catch (FileNotFoundException e5) {
                bufferedReader = null;
                e4 = e5;
                fileReader = null;
            } catch (IOException e6) {
                bufferedReader = null;
                e3 = e6;
                fileReader = null;
            } catch (Exception e7) {
                bufferedReader = null;
                e2 = e7;
                fileReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileReader = null;
            }
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int i3 = i2 + 1;
                        if (i2 >= 5) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                        i2 = i3;
                    } catch (FileNotFoundException e8) {
                        e4 = e8;
                        com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e4);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return sb.toString();
                    } catch (IOException e9) {
                        e3 = e9;
                        com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e3);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return sb.toString();
                    } catch (Exception e10) {
                        e2 = e10;
                        com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e2);
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
            } catch (FileNotFoundException e11) {
                bufferedReader = null;
                e4 = e11;
            } catch (IOException e12) {
                bufferedReader = null;
                e3 = e12;
            } catch (Exception e13) {
                bufferedReader = null;
                e2 = e13;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        throw th;
                    }
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (IOException e15) {
            e15.printStackTrace();
        }
        return sb.toString();
    }

    public static String b() {
        Debug.MemoryInfo memoryInfo;
        StringBuilder sb = new StringBuilder();
        if (f4836b == null) {
            return sb.toString();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            f4836b.getMemoryInfo(memoryInfo2);
            sb.append("isLowMem: ");
            sb.append(memoryInfo2.lowMemory ? "yes" : "no");
            sb.append("\navailMem: ");
            sb.append(com.baidu.crabsdk.c.c.f(memoryInfo2.availMem));
            sb.append("\nthreshold: ");
            sb.append(com.baidu.crabsdk.c.c.f(memoryInfo2.threshold));
            sb.append("\n");
            if (Build.VERSION.SDK_INT >= 5 && (memoryInfo = f4836b.getProcessMemoryInfo(new int[]{Process.myPid()})[0]) != null) {
                sb.append("totalPrivateDirty: ");
                sb.append(com.baidu.crabsdk.c.c.f(memoryInfo.getTotalPrivateDirty() * 1024));
                sb.append("\ntotalPss: ");
                sb.append(com.baidu.crabsdk.c.c.f(memoryInfo.getTotalPss() * 1024));
                sb.append("\ntotalSharedDirty: ");
                sb.append(com.baidu.crabsdk.c.c.f(memoryInfo.getTotalSharedDirty() * 1024));
                sb.append("\n");
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("getMemInfo error!!!", e2);
        }
        return sb.toString();
    }

    public static void c(Context context) {
        if (f4835a == null) {
            f4835a = context;
            f4836b = (ActivityManager) context.getSystemService("activity");
        }
    }
}
