package com.baidu.tbadk.browser.auth;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class AuthHttpRequestMsg extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_POLLING_TIMES = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public int currentPolling;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthHttpRequestMsg() {
        super(CmdConfigHttp.CMD_GET_ALI_AUTH_INFO);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.currentPolling = 0;
    }

    public boolean checkAllowToPolling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.currentPolling < 10) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void pollingTimesIncrease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.currentPolling++;
        }
    }
}
