package com.baidu.android.util.media;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class LogUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Media@MediaQuery";
    public static final boolean isDebug = false;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, objArr) == null) {
        }
    }

    public static void e(Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, objArr) == null) {
        }
    }

    public LogUtils() {
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

    public static String appendStr(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) {
            if (objArr != null) {
                if (objArr.length >= 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(objArr[0]);
                    for (int i = 1; i < objArr.length; i++) {
                        stringBuffer.append(" = ");
                        stringBuffer.append(objArr[i]);
                    }
                    return stringBuffer.toString();
                }
                return "LogUtil empty log";
            }
            return "LogUtil empty log";
        }
        return (String) invokeL.objValue;
    }
}
