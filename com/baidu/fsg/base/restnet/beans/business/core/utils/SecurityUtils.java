package com.baidu.fsg.base.restnet.beans.business.core.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
public class SecurityUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SecurityUtils() {
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static boolean isExecutable(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Process process = null;
            try {
                try {
                    Runtime runtime = Runtime.getRuntime();
                    process = runtime.exec("ls -l " + str);
                    String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                    if (readLine != null && readLine.length() >= 4) {
                        char charAt = readLine.charAt(3);
                        if (charAt == 's' || charAt == 'x') {
                            if (process != null) {
                                process.destroy();
                            }
                            return true;
                        }
                    }
                    if (process == null) {
                        return false;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    if (process == null) {
                        return false;
                    }
                }
                process.destroy();
                return false;
            } catch (Throwable th) {
                if (process != null) {
                    process.destroy();
                }
                throw th;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (new File("/system/bin/su").exists() && isExecutable("/system/bin/su")) {
                return true;
            }
            return new File("/system/xbin/su").exists() && isExecutable("/system/xbin/su");
        }
        return invokeV.booleanValue;
    }
}
