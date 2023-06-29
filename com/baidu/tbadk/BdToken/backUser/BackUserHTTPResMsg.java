package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.jv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.BackUser.BackUserResIdl;
import tbclient.Error;
/* loaded from: classes4.dex */
public class BackUserHTTPResMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jv4 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackUserHTTPResMsg() {
        super(CmdConfigHttp.CMD_BACK_USER);
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

    public jv4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mData;
        }
        return (jv4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        BackUserResIdl backUserResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class)) != null) {
            Error error = backUserResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(backUserResIdl.error.usermsg);
            }
            if (backUserResIdl.data != null) {
                jv4 jv4Var = new jv4();
                this.mData = jv4Var;
                jv4Var.a(backUserResIdl.data);
            }
        }
    }
}
