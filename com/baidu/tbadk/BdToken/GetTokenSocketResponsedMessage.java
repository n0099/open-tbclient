package com.baidu.tbadk.BdToken;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
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
public class GetTokenSocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fv4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenSocketResponsedMessage() {
        super(309608);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (fv4) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetTokenResIdl getTokenResIdl = (GetTokenResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTokenResIdl.class);
            if (getTokenResIdl == null) {
                return null;
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
            return null;
        }
        return invokeIL.objValue;
    }
}
