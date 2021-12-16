package com.alipay.android.app.helper;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class TidHelper extends com.alipay.sdk.tid.TidHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TidHelper() {
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

    public static void clearTID(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            com.alipay.sdk.tid.TidHelper.clearTID(context);
        }
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? com.alipay.sdk.tid.TidHelper.getIMEI(context) : (String) invokeL.objValue;
    }

    public static String getIMSI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? com.alipay.sdk.tid.TidHelper.getIMSI(context) : (String) invokeL.objValue;
    }

    public static synchronized String getTIDValue(Context context) {
        InterceptResult invokeL;
        String tIDValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (TidHelper.class) {
                tIDValue = com.alipay.sdk.tid.TidHelper.getTIDValue(context);
            }
            return tIDValue;
        }
        return (String) invokeL.objValue;
    }

    public static String getVirtualImei(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? com.alipay.sdk.tid.TidHelper.getVirtualImei(context) : (String) invokeL.objValue;
    }

    public static String getVirtualImsi(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? com.alipay.sdk.tid.TidHelper.getVirtualImsi(context) : (String) invokeL.objValue;
    }

    public static Tid loadLocalTid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadLocalTid(context)) : (Tid) invokeL.objValue;
    }

    public static synchronized Tid loadOrCreateTID(Context context) {
        InterceptResult invokeL;
        Tid fromRealTidModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            synchronized (TidHelper.class) {
                fromRealTidModel = Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadOrCreateTID(context));
            }
            return fromRealTidModel;
        }
        return (Tid) invokeL.objValue;
    }

    public static Tid loadTID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadTID(context)) : (Tid) invokeL.objValue;
    }

    public static boolean resetTID(Context context) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? com.alipay.sdk.tid.TidHelper.resetTID(context) : invokeL.booleanValue;
    }
}
