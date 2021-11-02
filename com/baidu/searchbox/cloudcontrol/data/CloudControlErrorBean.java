package com.baidu.searchbox.cloudcontrol.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class CloudControlErrorBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NET_WORK_ERROR = 1;
    public static final int NO_ERROR = 0;
    public static final int PARSE_ERROR = 3;
    public static final int SERVER_ERROR = 2;
    public static final int SUB_PARSE_DATA_FORMAT_ERROR = 30;
    public static final int SUB_PARSE_DATA_NO_NODE = 31;
    public transient /* synthetic */ FieldHolder $fh;
    public int errorCode;
    public int subErrorCode;

    public CloudControlErrorBean() {
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

    public int getErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.errorCode : invokeV.intValue;
    }

    public int getSubErrorCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.subErrorCode : invokeV.intValue;
    }

    public void setErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.errorCode = i2;
        }
    }

    public void setSubErrorCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.subErrorCode = i2;
        }
    }
}
