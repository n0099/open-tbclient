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
/* loaded from: classes8.dex */
public final class m {
    private static ActivityManager apD;
    private static Context mContext;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x007a */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008e A[Catch: IOException -> 0x0092, TRY_LEAVE, TryCatch #4 {IOException -> 0x0092, blocks: (B:50:0x0089, B:52:0x008e), top: B:76:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String D() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        int i = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        FileReader fileReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
                try {
                    bufferedReader = new BufferedReader(fileReader, 8192);
                    int i2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            bufferedReader2 = i;
                            if (readLine != null) {
                                int i3 = i2 + 1;
                                bufferedReader2 = i3;
                                if (i2 < 5) {
                                    sb.append(readLine).append("\n");
                                    i2 = i3;
                                    i = i3;
                                }
                            }
                            try {
                                bufferedReader.close();
                                fileReader.close();
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileReader2 = fileReader;
                            try {
                                com.baidu.crabsdk.c.a.a("getSysMemInfo fail.", e);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileReader2 != null) {
                                    fileReader2.close();
                                }
                                return sb.toString();
                            } catch (Throwable th) {
                                th = th;
                                fileReader = fileReader2;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                throw th;
                            }
                        } catch (IOException e5) {
                            e = e5;
                            bufferedReader2 = bufferedReader;
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
                        } catch (Exception e7) {
                            e = e7;
                            bufferedReader2 = bufferedReader;
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
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                            }
                            if (fileReader != null) {
                            }
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e9) {
                    e = e9;
                    bufferedReader = null;
                    fileReader2 = fileReader;
                } catch (IOException e10) {
                    e = e10;
                } catch (Exception e11) {
                    e = e11;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e12) {
            e = e12;
            bufferedReader = null;
        } catch (IOException e13) {
            e = e13;
            fileReader = null;
        } catch (Exception e14) {
            e = e14;
            fileReader = null;
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
        return sb.toString();
    }

    public static String E() {
        Debug.MemoryInfo memoryInfo;
        StringBuilder sb = new StringBuilder();
        if (apD == null) {
            return sb.toString();
        }
        try {
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            apD.getMemoryInfo(memoryInfo2);
            sb.append("isLowMem: ").append(memoryInfo2.lowMemory ? "yes" : "no").append("\navailMem: ").append(com.baidu.crabsdk.c.c.b(memoryInfo2.availMem)).append("\nthreshold: ").append(com.baidu.crabsdk.c.c.b(memoryInfo2.threshold)).append("\n");
            if (Build.VERSION.SDK_INT >= 5 && (memoryInfo = apD.getProcessMemoryInfo(new int[]{Process.myPid()})[0]) != null) {
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
            apD = (ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        }
    }
}
