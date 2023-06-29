package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.fv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetToken.GetTokenResIdl;
/* loaded from: classes4.dex */
public class GetTokenHttpResponsedMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_GET_TOKEN);
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
    }

    public fv4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData;
        }
        return (fv4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTokenResIdl getTokenResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getTokenResIdl = (GetTokenResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTokenResIdl.class)) == null) {
            return;
        }
        Error error = getTokenResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getTokenResIdl.error.usermsg);
        }
        if (getTokenResIdl.data != null) {
            fv4 fv4Var = new fv4();
            this.mData = fv4Var;
            fv4Var.e(getTokenResIdl.data);
        }
    }
}
