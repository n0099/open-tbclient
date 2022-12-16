package com.baidu.searchbox.requestpriority;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class RequestPriorityParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int requestPriorityDelayTime;
    public boolean requestPriorityEnabled;
    public String requestPriorityWhitelist;

    public RequestPriorityParams() {
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

    public int getRequestPriorityDelayTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.requestPriorityDelayTime;
        }
        return invokeV.intValue;
    }

    public String getRequestPriorityWhitelist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.requestPriorityWhitelist;
        }
        return (String) invokeV.objValue;
    }

    public boolean isRequestPriorityEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.requestPriorityEnabled;
        }
        return invokeV.booleanValue;
    }

    public RequestPriorityParams requestPriorityDelayTime(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.requestPriorityDelayTime = i;
            return this;
        }
        return (RequestPriorityParams) invokeI.objValue;
    }

    public RequestPriorityParams requestPriorityEnabled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.requestPriorityEnabled = z;
            return this;
        }
        return (RequestPriorityParams) invokeZ.objValue;
    }

    public RequestPriorityParams requestPriorityWhitelist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            this.requestPriorityWhitelist = str;
            return this;
        }
        return (RequestPriorityParams) invokeL.objValue;
    }
}
