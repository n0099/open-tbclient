package com.baidu.minivideo.arface.c;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
/* loaded from: classes8.dex */
public class b {
    private static volatile b ceO = null;
    private Long ceP;
    private Long ceQ;
    private RandomAccessFile ceR;
    private RandomAccessFile ceS;
    private String mPackageName;

    private b() {
    }

    public static b acD() {
        if (ceO == null) {
            synchronized (b.class) {
                if (ceO == null) {
                    ceO = new b();
                }
            }
        }
        return ceO;
    }

    public ActivityManager.MemoryInfo acE() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) com.baidu.minivideo.arface.b.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public double acF() {
        double acH = acH();
        if (acH <= 0.0d) {
            acH = acG();
        }
        if (acH <= 0.0d) {
            return getCpuUsageStatistic();
        }
        return acH;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double acG() {
        double doubleValue;
        if (Build.VERSION.SDK_INT >= 26) {
            String jR = jR(this.mPackageName);
            if (!TextUtils.isEmpty(jR)) {
                try {
                    doubleValue = Double.valueOf(jR).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (doubleValue <= 0.0d) {
                    return doubleValue;
                }
                return 0.0d;
            }
            doubleValue = 0.0d;
            if (doubleValue <= 0.0d) {
            }
        } else {
            return acH();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0061, code lost:
        r0.waitFor();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String jR(String str) {
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{IXAdRequestInfo.SCREEN_HEIGHT, "-c", "top -n 1"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.trim().split(" ");
                    if (str != null && str.startsWith(split[split.length - 1].substring(0, split[split.length - 1].length() - 1))) {
                        return split[16];
                    }
                } else {
                    try {
                        break;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return "";
    }

    public double acH() {
        double d = 0.0d;
        try {
            if (this.ceR == null || this.ceS == null) {
                this.ceR = new RandomAccessFile("/proc/stat", "r");
                this.ceS = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.ceR.seek(0L);
                this.ceS.seek(0L);
            }
            String readLine = this.ceR.readLine();
            String readLine2 = this.ceS.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.ceP == null && this.ceQ == null) {
                this.ceP = Long.valueOf(parseLong);
                this.ceQ = Long.valueOf(parseLong2);
            } else {
                if (this.ceP != null && this.ceQ != null) {
                    d = ((parseLong2 - this.ceQ.longValue()) / (parseLong - this.ceP.longValue())) * 100.0d;
                }
                this.ceP = Long.valueOf(parseLong);
                this.ceQ = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3 A[Catch: Exception -> 0x00ba, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ba, blocks: (B:53:0x00ae, B:55:0x00b3), top: B:77:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Process process2;
        String str;
        String str2;
        String[] split;
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
                        if (readLine == null) {
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
                                        str2 = split[i].trim();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
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
                            return Integer.parseInt(str2);
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
        try {
            return Integer.parseInt(str2);
        } catch (Exception e7) {
            return -1;
        }
    }
}
