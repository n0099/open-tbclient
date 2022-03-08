package com.baidu.fsg.base.restnet.beans.business.core.utils;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class StringUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] sNum;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1883708508, "Lcom/baidu/fsg/base/restnet/beans/business/core/utils/StringUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1883708508, "Lcom/baidu/fsg/base/restnet/beans/business/core/utils/StringUtil;");
                return;
            }
        }
        sNum = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public StringUtil() {
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

    public static String arrayToString(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, null, bArr, i2, i3)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            i2 = (i2 < 0 || bArr.length < i2) ? 0 : 0;
            int i4 = i3 + i2;
            if (i4 > bArr.length) {
                i4 = bArr.length;
            }
            while (i2 < i4) {
                stringBuffer.append(memToStr(bArr[i2]));
                i2++;
            }
            return stringBuffer.toString();
        }
        return (String) invokeLII.objValue;
    }

    public static String memToStr(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65539, null, b2)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(sNum[(b2 >> 4) & 15]);
            stringBuffer.append(sNum[b2 & 15]);
            return stringBuffer.toString();
        }
        return (String) invokeB.objValue;
    }
}
