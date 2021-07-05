package com.baidu.android.lbspay.channelpay.fast;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.lbspay.channelpay.ChannelBaseWapPay;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.android.lbspay.network.GetPayContent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ChannelFastPay extends ChannelBaseWapPay {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ChannelFastPay() {
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

    @Override // com.baidu.android.lbspay.channelpay.IChannelPay
    public int getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 107;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.lbspay.channelpay.ChannelBaseWapPay
    public String getUrl(GetPayContent getPayContent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getPayContent)) == null) {
            PayDataBean payData = getPayData(getPayContent);
            return payData != null ? payData.payurl : "";
        }
        return (String) invokeL.objValue;
    }
}
