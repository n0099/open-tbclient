package com.baidu.searchbox.pms.utils;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ABIUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ABI_32 = "1";
    public static final String ABI_32_64 = "3";
    public static final String ABI_64 = "2";
    public transient /* synthetic */ FieldHolder $fh;

    public ABIUtils() {
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

    public static boolean checkABIIsValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (checkCpuAbiIs64() && "1".equals(str)) {
                return false;
            }
            return checkCpuAbiIs64() || !"2".equals(str);
        }
        return invokeL.booleanValue;
    }

    public static boolean checkCpuAbiIs64() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                return Process.is64Bit();
            }
            if (i2 >= 21) {
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

    public static boolean checkLocalABIIsValid(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (!"".equals(str2) && !"3".equals(str2)) {
                if (TextUtils.isEmpty(str) && !"3".equals(str2)) {
                    return false;
                }
                if ("1".equals(str) && "2".equals(str2)) {
                    return false;
                }
                if ("2".equals(str) && "1".equals(str2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
