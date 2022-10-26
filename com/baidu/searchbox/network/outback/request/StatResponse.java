package com.baidu.searchbox.network.outback.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.core.ResponseBody;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class StatResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Response realResponse;
    public NetworkStatRecord statRecord;

    public StatResponse(Response response, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {response, networkStatRecord};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.realResponse = response;
        this.statRecord = networkStatRecord;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatResponse(NetworkStatRecord networkStatRecord) {
        this(null, networkStatRecord);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {networkStatRecord};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Response) objArr2[0], (NetworkStatRecord) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public ResponseBody body() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Response response = this.realResponse;
            if (response != null) {
                return response.body();
            }
            return null;
        }
        return (ResponseBody) invokeV.objValue;
    }

    public Response getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.realResponse;
        }
        return (Response) invokeV.objValue;
    }

    public NetworkStatRecord getStatRecord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.statRecord;
        }
        return (NetworkStatRecord) invokeV.objValue;
    }
}
