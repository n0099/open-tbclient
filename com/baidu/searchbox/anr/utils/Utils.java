package com.baidu.searchbox.anr.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.anr.collector.ThreadCollector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes20.dex */
public class Utils {
    private static final String KEY_ANR_LOG = "Wrote stack traces to ";
    private static final int LOG_MONITOR_TIMEOUT = 5000;
    private static final int THRESHOLD_TIME = 5;

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [104=5, 105=5, 108=5, 109=5, 114=5, 115=5] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean storeIfRealANR(String str, int i) {
        Process exec;
        String[] split;
        long currentTimeMillis = System.currentTimeMillis();
        Process process = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                if (Build.VERSION.SDK_INT <= 22) {
                    Process exec2 = Runtime.getRuntime().exec("logcat -vtime -T " + i);
                    File file = new File(str);
                    if (!file.exists() && !file.createNewFile()) {
                        Log.i("ANR", "Create log file failed: " + file.getAbsolutePath());
                        if (0 != 0) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e) {
                            }
                        }
                        if (0 != 0) {
                            bufferedReader.close();
                        }
                        if (exec2 != null) {
                            exec2.destroy();
                            return false;
                        }
                        return false;
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                    exec = exec2;
                } else {
                    exec = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "logcat -vtime -T " + i + " | tee " + str});
                }
                boolean z = false;
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (System.currentTimeMillis() - currentTimeMillis < 5000) {
                        try {
                            if (bufferedReader2.ready()) {
                                if (!z) {
                                    Log.i("ANR", "Ready time: " + (System.currentTimeMillis() - currentTimeMillis));
                                    z = true;
                                }
                                String readLine = bufferedReader2.readLine();
                                if (Build.VERSION.SDK_INT <= 22 && bufferedWriter != null && readLine != null) {
                                    bufferedWriter.write(readLine + "\n");
                                }
                                if (readLine != null && readLine.contains(KEY_ANR_LOG) && (split = readLine.split(" ")) != null && split.length >= 2 && isRecentANR(split[1], 5)) {
                                    Log.i("ANR", "Detect ANR time: " + (System.currentTimeMillis() - currentTimeMillis));
                                    if (bufferedWriter != null) {
                                        try {
                                            bufferedWriter.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    if (bufferedReader2 != null) {
                                        bufferedReader2.close();
                                    }
                                    if (exec != null) {
                                        exec.destroy();
                                        return true;
                                    }
                                    return true;
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedReader = bufferedReader2;
                            process = exec;
                            e.printStackTrace();
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e4) {
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    return false;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (process != null) {
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            process = exec;
                            if (bufferedWriter != null) {
                                try {
                                    bufferedWriter.close();
                                } catch (IOException e5) {
                                    if (process != null) {
                                        process.destroy();
                                    }
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    }
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                } catch (IOException e7) {
                    e = e7;
                    process = exec;
                } catch (Throwable th2) {
                    th = th2;
                    process = exec;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (IOException e8) {
            e = e8;
        }
        return false;
    }

    private static boolean isRecentANR(String str, int i) {
        boolean z = true;
        if (TextUtils.isEmpty(str) || i < 0) {
            return false;
        }
        String format = new SimpleDateFormat("HH:mm").format(new Date());
        String[] split = str.split(":");
        String[] split2 = format.split(":");
        if (split.length < 2 || split2.length < 2) {
            return false;
        }
        Integer valueOf = Integer.valueOf(split[0]);
        Integer valueOf2 = Integer.valueOf(split[1]);
        Integer valueOf3 = Integer.valueOf(split2[0]);
        Integer valueOf4 = Integer.valueOf(split2[1]);
        if (valueOf3.intValue() - valueOf.intValue() != 0 || valueOf4.intValue() - valueOf2.intValue() >= i) {
            z = false;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=5, 175=4] */
    public static String getCurrentProcessName() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i;
        try {
            fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                bArr = new byte[256];
                i = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i >= bArr.length) {
                        break;
                    }
                    bArr[i] = (byte) read;
                    i++;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                        }
                    }
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        if (i > 0) {
            String str = new String(bArr, 0, i, "UTF-8");
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    return str;
                } catch (IOException e3) {
                    return str;
                }
            }
            return str;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [213=5, 215=4, 216=4] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void storeAllTraces2File(String str) {
        FileWriter fileWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter2 = null;
        try {
            File file = new File(str);
            if (!file.exists() && !file.createNewFile()) {
                if (0 != 0) {
                    try {
                        fileWriter2.close();
                        return;
                    } catch (IOException e) {
                        return;
                    }
                }
                return;
            }
            fileWriter = new FileWriter(file);
            try {
                Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                if (allStackTraces != null && allStackTraces.size() >= 1) {
                    Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
                    while (it.hasNext()) {
                        fileWriter.write(ThreadCollector.getThreadInfo(it.next().getKey()) + "\n");
                    }
                }
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileWriter2 = fileWriter;
                try {
                    e.printStackTrace();
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileWriter = fileWriter2;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
        }
    }
}
