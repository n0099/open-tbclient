package com.baidu.searchbox.process.ipc.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.process.ipc.IPCLibConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public final class ProcessUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AI_APPS_PROCESS_SUFFIX = ":swan";
    public static final String CMD_LINE_NAME = "/proc/self/cmdline";
    public static final boolean DEBUG = false;
    public static final int PROCESS_NAME_LENGTH = 500;
    public static final String TAG = "ProcessUtils";
    public static boolean sIsMainProcess;
    public static String sMainProcessName;
    public static String sProcessName;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1025500025, "Lcom/baidu/searchbox/process/ipc/util/ProcessUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1025500025, "Lcom/baidu/searchbox/process/ipc/util/ProcessUtils;");
                return;
            }
        }
        Context context = IPCLibConfig.sAppContext;
        sMainProcessName = context.getApplicationInfo().processName;
        String processNameFromFile = getProcessNameFromFile();
        sProcessName = processNameFromFile;
        if (TextUtils.isEmpty(processNameFromFile)) {
            sProcessName = getProcessNameFromAm(context);
        }
        sIsMainProcess = checkIsMainProcess(sProcessName);
    }

    public ProcessUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean checkIsMainProcess(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.equals(str, sMainProcessName)) {
                return true;
            }
            return str.startsWith(sMainProcessName) && !str.contains(":");
        }
        return invokeL.booleanValue;
    }

    public static String getCurProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sProcessName : (String) invokeV.objValue;
    }

    public static String getMainProcessName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sMainProcessName : (String) invokeV.objValue;
    }

    public static String getProcessNameFromAm(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getProcessNameFromFile() {
        InterceptResult invokeV;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String str = null;
            str = null;
            str = null;
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(new File(CMD_LINE_NAME));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    byte[] bArr = new byte[500];
                    str = new String(bArr, 0, fileInputStream.read(bArr)).trim();
                    fileInputStream.close();
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static boolean is64Bit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                return Process.is64Bit();
            }
            if (i >= 21) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr.length > 0) {
                    return Build.CPU_ABI.equals(strArr[0]);
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMainProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sIsMainProcess : invokeV.booleanValue;
    }

    public static boolean isSwanProcess() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? !TextUtils.isEmpty(sProcessName) && sProcessName.contains(":swan") : invokeV.booleanValue;
    }
}
