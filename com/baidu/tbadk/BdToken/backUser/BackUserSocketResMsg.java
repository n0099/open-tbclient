package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ak4;
import com.squareup.wire.Wire;
import tbclient.BackUser.BackUserResIdl;
import tbclient.Error;
/* loaded from: classes2.dex */
public class BackUserSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ak4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackUserSocketResMsg() {
        super(309689);
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

    public ak4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (ak4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class)) == null) {
            return;
        }
        Error error = backUserResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(backUserResIdl.error.usermsg);
        }
        if (backUserResIdl.data != null) {
            ak4 ak4Var = new ak4();
            this.mData = ak4Var;
            ak4Var.a(backUserResIdl.data);
        }
    }
}
