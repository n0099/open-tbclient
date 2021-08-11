package com.baidu.android.util.devices;

import android.app.ActivityManager;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes4.dex */
public class MemoryUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 8192;
    public static final boolean DEBUG = false;
    public static final String TAG = "MemoryUtils";
    public static long sTotalMemory;
    public transient /* synthetic */ FieldHolder $fh;

    public MemoryUtils() {
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

    public static long getFreeMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.availMem / 1024;
        }
        return invokeV.longValue;
    }

    public static long getTotalMemory() {
        InterceptResult invokeV;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sTotalMemory == 0) {
                BufferedReader bufferedReader2 = null;
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException unused2) {
                    fileReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileReader = null;
                }
                try {
                    r1 = bufferedReader.readLine() != null ? Integer.valueOf(readLine.split("\\s+")[1]).intValue() : -1L;
                    Closeables.closeSafely(bufferedReader);
                } catch (IOException unused3) {
                    bufferedReader2 = bufferedReader;
                    Closeables.closeSafely(bufferedReader2);
                    Closeables.closeSafely(fileReader);
                    sTotalMemory = r1;
                    return sTotalMemory;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = bufferedReader;
                    Closeables.closeSafely(bufferedReader2);
                    Closeables.closeSafely(fileReader);
                    throw th;
                }
                Closeables.closeSafely(fileReader);
                sTotalMemory = r1;
            }
            return sTotalMemory;
        }
        return invokeV.longValue;
    }
}
