package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.CheckMaskUser.CheckMaskUserResIdl;
/* loaded from: classes3.dex */
public class ResponseCheckUserMaskMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isMasked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseCheckUserMaskMessage() {
        super(104104);
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
        this.isMasked = false;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            CheckMaskUserResIdl checkMaskUserResIdl = (CheckMaskUserResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckMaskUserResIdl.class);
            setError(checkMaskUserResIdl.error.errorno.intValue());
            setErrorString(checkMaskUserResIdl.error.usermsg);
            if (getError() != 0) {
                return checkMaskUserResIdl;
            }
            if (checkMaskUserResIdl.data.isMask.intValue() == 1) {
                z = true;
            }
            this.isMasked = z;
            return checkMaskUserResIdl;
        }
        return invokeIL.objValue;
    }

    public boolean isMasked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isMasked;
        }
        return invokeV.booleanValue;
    }
}
