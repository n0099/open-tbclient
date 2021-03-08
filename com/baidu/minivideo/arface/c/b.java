package com.baidu.minivideo.arface.c;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
/* loaded from: classes5.dex */
public class b {
    private static volatile b cmL = null;
    private Long cmM;
    private Long cmN;
    private RandomAccessFile cmO;
    private RandomAccessFile cmP;
    private String mPackageName;

    private b() {
    }

    public static b acv() {
        if (cmL == null) {
            synchronized (b.class) {
                if (cmL == null) {
                    cmL = new b();
                }
            }
        }
        return cmL;
    }

    public ActivityManager.MemoryInfo acw() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) com.baidu.minivideo.arface.b.getContext().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public double acx() {
        double acz = acz();
        if (acz <= 0.0d) {
            acz = acy();
        }
        if (acz <= 0.0d) {
            return getCpuUsageStatistic();
        }
        return acz;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double acy() {
        double doubleValue;
        if (Build.VERSION.SDK_INT >= 26) {
            String jo = jo(this.mPackageName);
            if (!TextUtils.isEmpty(jo)) {
                try {
                    doubleValue = Double.valueOf(jo).doubleValue();
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
            return acz();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0061, code lost:
        r0.waitFor();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String jo(String str) {
        try {
            Process exec = Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1"});
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

    public double acz() {
        double d = 0.0d;
        try {
            if (this.cmO == null || this.cmP == null) {
                this.cmO = new RandomAccessFile("/proc/stat", "r");
                this.cmP = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.cmO.seek(0L);
                this.cmP.seek(0L);
            }
            String readLine = this.cmO.readLine();
            String readLine2 = this.cmP.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.cmM == null && this.cmN == null) {
                this.cmM = Long.valueOf(parseLong);
                this.cmN = Long.valueOf(parseLong2);
            } else {
                if (this.cmM != null && this.cmN != null) {
                    d = ((parseLong2 - this.cmN.longValue()) / (parseLong - this.cmM.longValue())) * 100.0d;
                }
                this.cmM = Long.valueOf(parseLong);
                this.cmN = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r5 = r3[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9 A[Catch: Exception -> 0x00c0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c0, blocks: (B:56:0x00b4, B:58:0x00b9), top: B:73:0x00b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Exception e;
        String str;
        String str2;
        String str3;
        String[] split;
        int myPid = Process.myPid();
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String str4 = null;
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
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
                        } catch (Exception e2) {
                            e = e2;
                            str = str4;
                            e.printStackTrace();
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e3) {
                                    str2 = str;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            str2 = str;
                            if (str2 != null) {
                            }
                            return Integer.parseInt(str2);
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (process != null) {
                            try {
                                process.destroy();
                            } catch (Exception e4) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e5) {
                        str2 = str3;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                str2 = str3;
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                str = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (process != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader = null;
            process = null;
            str = null;
        } catch (Throwable th3) {
            th = th3;
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
        } catch (Exception e8) {
            return -1;
        }
    }
}
