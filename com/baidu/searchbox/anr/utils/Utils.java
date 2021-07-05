package com.baidu.searchbox.anr.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.anr.collector.ThreadCollector;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ANR_LOG = "Wrote stack traces to ";
    public static final int LOG_MONITOR_TIMEOUT = 5000;
    public static final int THRESHOLD_TIME = 5;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        if (r2 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCurrentProcessName() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65537, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            fileInputStream = new FileInputStream(ProcessUtils.CMD_LINE_NAME);
            try {
                byte[] bArr = new byte[256];
                int i2 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i2 >= 256) {
                        break;
                    }
                    bArr[i2] = (byte) read;
                    i2++;
                }
                if (i2 > 0) {
                    String str = new String(bArr, 0, i2, "UTF-8");
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
        try {
            fileInputStream.close();
        } catch (IOException unused3) {
            return null;
        }
    }

    public static boolean isRecentANR(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            if (TextUtils.isEmpty(str) || i2 < 0) {
                return false;
            }
            String format = new SimpleDateFormat("HH:mm").format(new Date());
            String[] split = str.split(":");
            String[] split2 = format.split(":");
            if (split.length < 2 || split2.length < 2) {
                return false;
            }
            return Integer.valueOf(split2[0]).intValue() - Integer.valueOf(split[0]).intValue() == 0 && Integer.valueOf(split2[1]).intValue() - Integer.valueOf(split[1]).intValue() < i2;
        }
        return invokeLI.booleanValue;
    }

    public static void storeAllTraces2File(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileWriter fileWriter = null;
        try {
            try {
                try {
                    File file = new File(str);
                    if (!file.exists() && !file.createNewFile()) {
                        return;
                    }
                    FileWriter fileWriter2 = new FileWriter(file);
                    try {
                        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
                        if (allStackTraces != null && allStackTraces.size() >= 1) {
                            Iterator<Map.Entry<Thread, StackTraceElement[]>> it = allStackTraces.entrySet().iterator();
                            while (it.hasNext()) {
                                fileWriter2.write(ThreadCollector.getThreadInfo(it.next().getKey()) + "\n");
                            }
                        }
                        fileWriter2.close();
                    } catch (IOException e2) {
                        fileWriter = fileWriter2;
                        e = e2;
                        e.printStackTrace();
                        if (fileWriter != null) {
                            fileWriter.close();
                        }
                    } catch (Throwable th) {
                        fileWriter = fileWriter2;
                        th = th;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x014c, code lost:
        if (r15 != null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0174, code lost:
        if (r15 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0176, code lost:
        r15.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0179, code lost:
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x017d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0171 A[Catch: IOException -> 0x016d, TRY_LEAVE, TryCatch #4 {IOException -> 0x016d, blocks: (B:79:0x0169, B:82:0x0171), top: B:101:0x0169 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0185 A[Catch: IOException -> 0x0181, TRY_LEAVE, TryCatch #9 {IOException -> 0x0181, blocks: (B:88:0x017d, B:91:0x0185), top: B:105:0x017d }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean storeIfRealANR(String str, int i2) {
        InterceptResult invokeLI;
        Process process;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLI = interceptable.invokeLI(65540, null, str, i2)) != null) {
            return invokeLI.booleanValue;
        }
        long currentTimeMillis = System.currentTimeMillis();
        BufferedWriter bufferedWriter2 = null;
        try {
            if (Build.VERSION.SDK_INT <= 22) {
                process = Runtime.getRuntime().exec("logcat -vtime -T " + i2);
                try {
                    File file = new File(str);
                    if (!file.exists() && !file.createNewFile()) {
                        Log.i("ANR", "Create log file failed: " + file.getAbsolutePath());
                        if (process != null) {
                            process.destroy();
                        }
                        return false;
                    }
                    bufferedWriter = new BufferedWriter(new FileWriter(file));
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = null;
                    try {
                        e.printStackTrace();
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException unused2) {
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
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                    if (bufferedWriter2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    if (process != null) {
                    }
                    throw th;
                }
            } else {
                process = Runtime.getRuntime().exec(new String[]{"/system/bin/sh", "-c", "logcat -vtime -T " + i2 + " | tee " + str});
                bufferedWriter = null;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                boolean z = false;
                while (System.currentTimeMillis() - currentTimeMillis < 5000) {
                    try {
                        if (bufferedReader.ready()) {
                            if (!z) {
                                Log.i("ANR", "Ready time: " + (System.currentTimeMillis() - currentTimeMillis));
                                z = true;
                            }
                            String readLine = bufferedReader.readLine();
                            if (Build.VERSION.SDK_INT <= 22 && bufferedWriter != null && readLine != null) {
                                bufferedWriter.write(readLine + "\n");
                            }
                            if (readLine != null && readLine.contains(KEY_ANR_LOG) && (split = readLine.split(" ")) != null && split.length >= 2 && isRecentANR(split[1], 5)) {
                                Log.i("ANR", "Detect ANR time: " + (System.currentTimeMillis() - currentTimeMillis));
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                bufferedReader.close();
                                if (process != null) {
                                    process.destroy();
                                }
                                return true;
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter2 = bufferedWriter;
                        e = e;
                        e.printStackTrace();
                        if (bufferedWriter2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedWriter2 = bufferedWriter;
                        th = th;
                        if (bufferedWriter2 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (process != null) {
                        }
                        throw th;
                    }
                }
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException unused4) {
                    }
                }
                bufferedReader.close();
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (IOException e5) {
            e = e5;
            process = null;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            process = null;
            bufferedReader = null;
        }
    }
}
