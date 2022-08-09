package com.baidu.tbadk.BdToken.backUser;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ek4;
import com.squareup.wire.Wire;
import tbclient.BackUser.BackUserResIdl;
import tbclient.Error;
/* loaded from: classes3.dex */
public class BackUserSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ek4 mData;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            BackUserResIdl backUserResIdl = (BackUserResIdl) new Wire(new Class[0]).parseFrom(bArr, BackUserResIdl.class);
            if (backUserResIdl != null) {
                Error error = backUserResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(backUserResIdl.error.usermsg);
                }
                if (backUserResIdl.data != null) {
                    ek4 ek4Var = new ek4();
                    this.mData = ek4Var;
                    ek4Var.a(backUserResIdl.data);
                }
            }
            return backUserResIdl;
        }
        return invokeIL.objValue;
    }

    public ek4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (ek4) invokeV.objValue;
    }
}
