package com.baidu.tbadk.BdToken.activeConfig;

import b.a.q0.a.b0.b;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.ActiveConfig.ActiveConfigResIdl;
import tbclient.Error;
/* loaded from: classes8.dex */
public class ActiveConfigHTTPResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveConfigHTTPResMsg() {
        super(CmdConfigHttp.CMD_ACTIVE_CONFIG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ActiveConfigResIdl activeConfigResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (activeConfigResIdl = (ActiveConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, ActiveConfigResIdl.class)) == null) {
            return;
        }
        Error error = activeConfigResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(activeConfigResIdl.error.usermsg);
        }
        if (activeConfigResIdl.data != null) {
            b bVar = new b();
            this.mData = bVar;
            bVar.c(activeConfigResIdl.data);
        }
    }
}
