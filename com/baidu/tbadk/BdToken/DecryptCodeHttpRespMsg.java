package com.baidu.tbadk.BdToken;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.rt4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.DecryptCode.DecryptCodeResIdl;
/* loaded from: classes4.dex */
public class DecryptCodeHttpRespMsg extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rt4 decryptData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecryptCodeHttpRespMsg(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            try {
                DecryptCodeResIdl decryptCodeResIdl = (DecryptCodeResIdl) new Wire(new Class[0]).parseFrom(bArr, DecryptCodeResIdl.class);
                if (decryptCodeResIdl != null) {
                    rt4 rt4Var = new rt4();
                    this.decryptData = rt4Var;
                    rt4Var.h(decryptCodeResIdl.data);
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
    }

    public rt4 getDecryptData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.decryptData;
        }
        return (rt4) invokeV.objValue;
    }
}
