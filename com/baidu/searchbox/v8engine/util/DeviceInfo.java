package com.baidu.searchbox.v8engine.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
/* loaded from: classes4.dex */
public class DeviceInfo {
    public static /* synthetic */ Interceptable $ic = null;
    public static final FileFilter CPU_FILTER;
    public static final int DEVICEINFO_UNKNOWN = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-581495909, "Lcom/baidu/searchbox/v8engine/util/DeviceInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-581495909, "Lcom/baidu/searchbox/v8engine/util/DeviceInfo;");
                return;
            }
        }
        CPU_FILTER = new FileFilter() { // from class: com.baidu.searchbox.v8engine.util.DeviceInfo.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                    String name = file.getName();
                    if (name.startsWith("cpu")) {
                        for (int i = 3; i < name.length(); i++) {
                            if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                                return false;
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }
        };
    }

    public DeviceInfo() {
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

    public static int getNumberOfCPUCores() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
            } catch (NullPointerException | SecurityException unused) {
                return -1;
            }
        }
        return invokeV.intValue;
    }
}
