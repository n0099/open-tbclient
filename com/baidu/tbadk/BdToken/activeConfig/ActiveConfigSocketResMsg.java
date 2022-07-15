package com.baidu.tbadk.BdToken.activeConfig;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kj4;
import com.squareup.wire.Wire;
import tbclient.ActiveConfig.ActiveConfigResIdl;
import tbclient.Error;
/* loaded from: classes2.dex */
public class ActiveConfigSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kj4 mData;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            ActiveConfigResIdl activeConfigResIdl = (ActiveConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, ActiveConfigResIdl.class);
            if (activeConfigResIdl != null) {
                Error error = activeConfigResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(activeConfigResIdl.error.usermsg);
                }
                if (activeConfigResIdl.data != null) {
                    kj4 kj4Var = new kj4();
                    this.mData = kj4Var;
                    kj4Var.c(activeConfigResIdl.data);
                }
            }
            return activeConfigResIdl;
        }
        return invokeIL.objValue;
    }

    public kj4 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (kj4) invokeV.objValue;
    }
}
