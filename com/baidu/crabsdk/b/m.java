package com.baidu.crabsdk.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class m {
    private static ActivityManager apa;
    private static Context mContext;

    public static String D() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            bufferedReader2 = null;
            fileReader = null;
        } catch (IOException e2) {
            e = e2;
            bufferedReader2 = null;
            fileReader = null;
        } catch (Exception e3) {
            e = e3;
            bufferedReader2 = null;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
            fileReader = null;
        }
        try {
            bufferedReader2 = new BufferedReader(fileReader, 8192);
            int i = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        int i2 = i + 1;
                        if (i < 5) {
                            sb.append(readLine).append("\n");
                            i = i2;
                        }
                    }
                    try {
                        bufferedReader2.close();
                        fileReader.close();
                        break;
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                } catch (FileNotFoundException e5) {
                    e = e5;
                    com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return sb.toString();
                } catch (IOException e7) {
                    e = e7;
                    com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return sb.toString();
                } catch (Exception e9) {
                    e = e9;
                    com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e);
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return sb.toString();
                }
            }
        } catch (FileNotFoundException e11) {
            e = e11;
            bufferedReader2 = null;
        } catch (IOException e12) {
            e = e12;
            bufferedReader2 = null;
        } catch (Exception e13) {
            e = e13;
            bufferedReader2 = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
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
        return sb.toString();
    }

    public static String E() {
        Debug.MemoryInfo memoryInfo;
        StringBuilder sb = new StringBuilder();
        if (apa == null) {
            return sb.toString();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            apa.getMemoryInfo(memoryInfo2);
            sb.append("isLowMem: ").append(memoryInfo2.lowMemory ? "yes" : "no").append("\navailMem: ").append(com.baidu.crabsdk.c.c.b(memoryInfo2.availMem)).append("\nthreshold: ").append(com.baidu.crabsdk.c.c.b(memoryInfo2.threshold)).append("\n");
            if (Build.VERSION.SDK_INT >= 5 && (memoryInfo = apa.getProcessMemoryInfo(new int[]{Process.myPid()})[0]) != null) {
                sb.append("totalPrivateDirty: ").append(com.baidu.crabsdk.c.c.b(memoryInfo.getTotalPrivateDirty() * 1024)).append("\ntotalPss: ").append(com.baidu.crabsdk.c.c.b(memoryInfo.getTotalPss() * 1024)).append("\ntotalSharedDirty: ").append(com.baidu.crabsdk.c.c.b(memoryInfo.getTotalSharedDirty() * 1024)).append("\n");
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.a("getMemInfo error!!!", e);
        }
        return sb.toString();
    }

    public static void e(Context context) {
        if (mContext == null) {
            mContext = context;
            apa = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }
}
