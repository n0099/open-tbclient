package com.baidu.searchbox.anr.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.config.AppConfig;
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
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class Utils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECKPROCESS_SEPARATOR_TIMEOUT = 500;
    public static final int LOG_MONITOR_TIMEOUT = 500;
    public transient /* synthetic */ FieldHolder $fh;

    public Utils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean checkProcessAnrState(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, context, j)) == null) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return false;
            }
            int myPid = Process.myPid();
            long j2 = j / 500;
            for (int i = 0; i < j2; i++) {
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        if (processErrorStateInfo.pid == myPid && processErrorStateInfo.condition == 2) {
                            Log.d(BlockMonitor.TAG, "a: found!" + processErrorStateInfo.processName + "," + processErrorStateInfo.shortMsg + "," + processErrorStateInfo.longMsg + ",");
                            return true;
                        }
                    }
                }
                try {
                    Thread.sleep(500L);
                } catch (Exception unused) {
                }
            }
            if (AppConfig.isDebug()) {
                Log.d(BlockMonitor.TAG, "This process not happend ANR");
            }
            return false;
        }
        return invokeLJ.booleanValue;
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
        if (interceptable != null && (invokeV = interceptable.invokeV(65538, null)) != null) {
            return (String) invokeV.objValue;
        }
        try {
            fileInputStream = new FileInputStream(ProcessUtils.CMD_LINE_NAME);
            try {
                byte[] bArr = new byte[256];
                int i = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i >= 256) {
                        break;
                    }
                    bArr[i] = (byte) read;
                    i++;
                }
                if (i > 0) {
                    String str = new String(bArr, 0, i, "UTF-8");
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

    public static boolean isRecentANR(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (TextUtils.isEmpty(str) || i < 0) {
                return false;
            }
            String format = new SimpleDateFormat("HH:mm").format(new Date());
            String[] split = str.split(":");
            String[] split2 = format.split(":");
            if (split.length < 2 || split2.length < 2) {
                return false;
            }
            return Integer.valueOf(split2[0]).intValue() - Integer.valueOf(split[0]).intValue() == 0 && Integer.valueOf(split2[1]).intValue() - Integer.valueOf(split[1]).intValue() < i;
        }
        return invokeLI.booleanValue;
    }

    public static void storeAllTraces2File(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || TextUtils.isEmpty(str)) {
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
                    } catch (IOException e) {
                        fileWriter = fileWriter2;
                        e = e;
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
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void storeLogcat(String str, int i) {
        Process process;
        BufferedReader bufferedReader;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, str, i) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            BufferedWriter bufferedWriter = null;
            try {
                file = new File(str);
            } catch (IOException e) {
                e = e;
                process = null;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                process = null;
                bufferedReader = null;
            }
            if (!file.exists() && !file.createNewFile()) {
                Log.i("ANR", "Create log file failed: " + file.getAbsolutePath());
                return;
            }
            process = Runtime.getRuntime().exec("logcat -v time -t " + i);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    do {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            bufferedWriter2.write(readLine + "\n");
                        } catch (IOException e2) {
                            e = e2;
                            bufferedWriter = bufferedWriter2;
                            try {
                                e.printStackTrace();
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (process == null) {
                                    return;
                                }
                                process.destroy();
                            } catch (Throwable th2) {
                                th = th2;
                                if (bufferedWriter != null) {
                                    try {
                                        bufferedWriter.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                                if (process != null) {
                                    process.destroy();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedWriter = bufferedWriter2;
                            if (bufferedWriter != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (process != null) {
                            }
                            throw th;
                        }
                    } while (System.currentTimeMillis() - currentTimeMillis <= 500);
                    bufferedWriter2.flush();
                    if (AppConfig.isDebug()) {
                        Log.i("ANR", "save log file : " + str + ", time :" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                    if (process == null) {
                        return;
                    }
                } catch (IOException e9) {
                    e = e9;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                }
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            process.destroy();
        }
    }
}
