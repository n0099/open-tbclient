package com.baidu.searchbox.anr.collector;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.anr.impl.ANRMonitor;
import com.baidu.searchbox.anr.utils.Utils;
import com.baidu.searchbox.aperf.param.ThreadCollector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public class ANRCollector {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_TRACE_PATH = "/data/anr/traces.txt";
    public transient /* synthetic */ FieldHolder $fh;

    public ANRCollector() {
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

    public static String getAllStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!new File("/data/anr/traces.txt").canRead()) {
                return ThreadCollector.getAllThreadStacks();
            }
            return getAllTraceFromFile("/data/anr/traces.txt");
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x00a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getAllTraceFromFile(String str) {
        InterceptResult invokeL;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        String readLine;
        String readLine2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        ?? r1 = "";
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    String str2 = "Cmd line: " + Utils.getCurrentProcessName();
                    while (true) {
                        String readLine3 = bufferedReader.readLine();
                        if (readLine3 == null) {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                            return sb2;
                        } else if (readLine3.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            sb.append(readLine3);
                            sb.append(StringUtils.LF);
                            sb.append(readLine);
                            sb.append(StringUtils.LF);
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    String sb3 = sb.toString();
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused2) {
                                    }
                                    return sb3;
                                }
                                sb.append(readLine2);
                                sb.append(StringUtils.LF);
                            } while (!readLine2.contains("----- end "));
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                            return sb.toString();
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            bufferedReader = null;
            e2 = e4;
        } catch (Throwable th3) {
            r1 = 0;
            th = th3;
            if (r1 != 0) {
            }
            throw th;
        }
    }

    public static String getMainThreadStackTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            String mainTraceFromFile = new File("/data/anr/traces.txt").canRead() ? getMainTraceFromFile("/data/anr/traces.txt") : null;
            return TextUtils.isEmpty(mainTraceFromFile) ? ThreadCollector.getThreadStack(Looper.getMainLooper().getThread()) : mainTraceFromFile;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:62:0x00d5 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMainTraceFromFile(String str) {
        ?? r5;
        InterceptResult invokeL;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        String readLine;
        String readLine2;
        String readLine3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = (r5 = interceptable).invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        File file = new File(str);
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                try {
                    String str2 = "Cmd line: " + Utils.getCurrentProcessName();
                    while (true) {
                        String readLine4 = bufferedReader.readLine();
                        if (readLine4 == null) {
                            String sb2 = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                            return sb2;
                        } else if (readLine4.contains("----- pid ") && (readLine = bufferedReader.readLine()) != null && readLine.equals(str2)) {
                            String[] split = readLine4.split("----- pid | at | -----$");
                            if (split.length >= 3) {
                                ANRMonitor.sANRTimeStamp = split[2];
                            }
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains("----- end ")) {
                                }
                                String sb3 = sb.toString();
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                                return sb3;
                            } while (!readLine2.contains("\"main\" prio="));
                            sb.append(readLine2);
                            sb.append(StringUtils.LF);
                            do {
                                readLine3 = bufferedReader.readLine();
                                if (readLine3 == null) {
                                    String sb4 = sb.toString();
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException unused3) {
                                    }
                                    return sb4;
                                } else if (readLine3.startsWith("  at ")) {
                                    sb.append(readLine3.replace("  at ", ""));
                                    sb.append(StringUtils.LF);
                                }
                            } while (!readLine3.equals(""));
                        }
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused4) {
                            return sb.toString();
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                if (r5 != 0) {
                    try {
                        r5.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            bufferedReader = null;
            e2 = e4;
        } catch (Throwable th3) {
            r5 = 0;
            th = th3;
            if (r5 != 0) {
            }
            throw th;
        }
    }
}
