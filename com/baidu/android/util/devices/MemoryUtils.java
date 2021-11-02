package com.baidu.android.util.devices;

import android.app.ActivityManager;
import android.os.Debug;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
/* loaded from: classes6.dex */
public class MemoryUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 8192;
    public static final boolean DEBUG = false;
    public static final String FDSIZE = "FDSize";
    public static final String TAG = "MemoryUtils";
    public static final String THREADS = "Threads";
    public static final String VMPEAK = "VmPeak";
    public static final String VMSIZE = "VmSize";
    public static HashSet<String> mVssKeys;
    public static long sJavaMaxMemory;
    public static long sTotalMemory;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1000571620, "Lcom/baidu/android/util/devices/MemoryUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1000571620, "Lcom/baidu/android/util/devices/MemoryUtils;");
                return;
            }
        }
        mVssKeys = new HashSet<String>() { // from class: com.baidu.android.util.devices.MemoryUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("VmPeak");
                add("VmSize");
                add(MemoryUtils.THREADS);
                add(MemoryUtils.FDSIZE);
            }
        };
    }

    public MemoryUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ActivityManager.MemoryInfo getAMSMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) AppRuntime.getAppContext().getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo;
        }
        return (ActivityManager.MemoryInfo) invokeV.objValue;
    }

    public static Debug.MemoryInfo getDebugMemoryInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            return memoryInfo;
        }
        return (Debug.MemoryInfo) invokeV.objValue;
    }

    public static long getFreeMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? getAMSMemoryInfo().availMem / 1024 : invokeV.longValue;
    }

    public static long getJavaFreeMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? Runtime.getRuntime().freeMemory() / 1024 : invokeV.longValue;
    }

    public static long getJavaMaxMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            if (sJavaMaxMemory == 0) {
                sJavaMaxMemory = Runtime.getRuntime().maxMemory() / 1024;
            }
            return sJavaMaxMemory;
        }
        return invokeV.longValue;
    }

    public static long getJavaTotalMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? Runtime.getRuntime().totalMemory() / 1024 : invokeV.longValue;
    }

    public static long getJavaUsedMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? getJavaTotalMemory() - getJavaFreeMemory() : invokeV.longValue;
    }

    public static long getNativeFreeMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Debug.getNativeHeapFreeSize() / 1024 : invokeV.longValue;
    }

    public static long getNativeTotalMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? Debug.getNativeHeapSize() / 1024 : invokeV.longValue;
    }

    public static long getNativeUsedMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? Debug.getNativeHeapAllocatedSize() / 1024 : invokeV.longValue;
    }

    public static long getTotalMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (sTotalMemory == 0) {
                sTotalMemory = getAMSMemoryInfo().totalMem / 1024;
            }
            return sTotalMemory;
        }
        return invokeV.longValue;
    }

    public static Map<String, String> parseProcStatus() {
        InterceptResult invokeV;
        FileReader fileReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            HashMap hashMap = new HashMap();
            BufferedReader bufferedReader = null;
            try {
                fileReader = new FileReader("/proc/self/status");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(fileReader, 8192);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null || hashMap.size() >= mVssKeys.size()) {
                                break;
                            }
                            String[] split = readLine.split("\\s+");
                            if (split != null && split.length > 1 && split[0] != null && split[1] != null) {
                                String replace = split[0].replace(":", "");
                                if (mVssKeys.contains(replace)) {
                                    hashMap.put(replace, split[1]);
                                }
                            }
                        } catch (IOException unused) {
                            bufferedReader = bufferedReader2;
                            Closeables.closeSafely(bufferedReader);
                            Closeables.closeSafely(fileReader);
                            return hashMap;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            Closeables.closeSafely(bufferedReader);
                            Closeables.closeSafely(fileReader);
                            throw th;
                        }
                    }
                    Closeables.closeSafely(bufferedReader2);
                } catch (IOException unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused3) {
                fileReader = null;
            } catch (Throwable th3) {
                th = th3;
                fileReader = null;
            }
            Closeables.closeSafely(fileReader);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }
}
