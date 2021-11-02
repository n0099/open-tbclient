package com.baidu.android.util.media;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LogUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "Media@MediaQuery";
    public static final boolean isDebug = false;
    public transient /* synthetic */ FieldHolder $fh;

    public LogUtils() {
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

    public static String appendStr(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, objArr)) == null) {
            if (objArr != null) {
                if (objArr.length < 1) {
                    return "LogUtil empty log";
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(objArr[0]);
                for (int i2 = 1; i2 < objArr.length; i2++) {
                    stringBuffer.append(" = ");
                    stringBuffer.append(objArr[i2]);
                }
                return stringBuffer.toString();
            }
            return "LogUtil empty log";
        }
        return (String) invokeL.objValue;
    }

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
}
