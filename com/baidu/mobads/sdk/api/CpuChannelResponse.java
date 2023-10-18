package com.baidu.mobads.sdk.api;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.k;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class CpuChannelResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k mCpuChannelInfo;

    public CpuChannelResponse(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCpuChannelInfo = kVar;
    }

    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            k kVar = this.mCpuChannelInfo;
            if (kVar != null) {
                return kVar.a();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String getChannelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            k kVar = this.mCpuChannelInfo;
            if (kVar != null) {
                return kVar.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}
