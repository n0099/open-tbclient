package com.baidu.android.util.time;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes.dex */
public class TimeUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String MD = "MM-dd";
    public static long MSEC_OF_ONE_DAY = 86400000;
    public static long MSEC_OF_ONE_HOUR = 3600000;
    public static long MSEC_OF_ONE_MINUTE = 60000;
    public static long MSEC_OF_ONE_SEC = 1000;
    public static final String Y4MD = "yyyy-MM-dd";
    public static final String Y4MD_HM = "yyyy-MM-dd HH:mm";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1290121498, "Lcom/baidu/android/util/time/TimeUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1290121498, "Lcom/baidu/android/util/time/TimeUtils;");
        }
    }

    public TimeUtils() {
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

    public static String getFormatTeletextTime(Context context, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, context, j)) == null) {
            return getFormatTeletextTime(context, j, true);
        }
        return (String) invokeLJ.objValue;
    }

    public static String getFormatTeletextTime(Context context, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return DateTimeUtil.getFormatTeletextTime(context, j, z);
        }
        return (String) invokeCommon.objValue;
    }
}
