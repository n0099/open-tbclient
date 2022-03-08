package com.baidu.searchbox.logsystem.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AppExtraUtil {
    public static /* synthetic */ Interceptable $ic;
    public static volatile AppExtraCall sAppExtraCall;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface AppExtraCall {
        JSONObject getAppExtraInfo();
    }

    public AppExtraUtil() {
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

    public static String getAppExtra() {
        InterceptResult invokeV;
        JSONObject appExtraInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sAppExtraCall == null || (appExtraInfo = sAppExtraCall.getAppExtraInfo()) == null) {
                return null;
            }
            return appExtraInfo.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void setAppExtraCall(AppExtraCall appExtraCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, appExtraCall) == null) {
            sAppExtraCall = appExtraCall;
        }
    }
}
