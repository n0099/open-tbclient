package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yj4;
import com.squareup.wire.Wire;
import tbclient.ActiveConfig.ActiveConfigResIdl;
import tbclient.Error;
/* loaded from: classes2.dex */
public class ActiveConfigSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yj4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActiveConfigSocketResMsg() {
        super(309637);
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

    public yj4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (yj4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ActiveConfigResIdl activeConfigResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (activeConfigResIdl = (ActiveConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, ActiveConfigResIdl.class)) == null) {
            return;
        }
        Error error = activeConfigResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(activeConfigResIdl.error.usermsg);
        }
        if (activeConfigResIdl.data != null) {
            yj4 yj4Var = new yj4();
            this.mData = yj4Var;
            yj4Var.c(activeConfigResIdl.data);
        }
    }
}
