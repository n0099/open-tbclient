package com.baidu.android.ddmlib.tools.perflib.vmtrace.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Strings {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Strings() {
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

    public static String repeat(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i)) == null) {
            if (i <= 1) {
                if (i == 0) {
                    return "";
                }
                return str;
            }
            int length = str.length();
            long j = length * i;
            int i2 = (int) j;
            if (i2 == j) {
                char[] cArr = new char[i2];
                str.getChars(0, length, cArr, 0);
                while (true) {
                    int i3 = i2 - length;
                    if (length < i3) {
                        System.arraycopy(cArr, 0, cArr, length, length);
                        length <<= 1;
                    } else {
                        System.arraycopy(cArr, 0, cArr, length, i3);
                        return new String(cArr);
                    }
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Required array size too large: " + j);
            }
        } else {
            return (String) invokeLI.objValue;
        }
    }
}
