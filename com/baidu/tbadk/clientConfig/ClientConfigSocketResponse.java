package com.baidu.tbadk.clientConfig;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetClientConfig.DataRes;
import tbclient.GetClientConfig.GetClientConfigResIdl;
/* loaded from: classes3.dex */
public class ClientConfigSocketResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientConfigSocketResponse() {
        super(303039);
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
            GetClientConfigResIdl getClientConfigResIdl = (GetClientConfigResIdl) new Wire(new Class[0]).parseFrom(bArr, GetClientConfigResIdl.class);
            if (getClientConfigResIdl == null) {
                return null;
            }
            Error error = getClientConfigResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getClientConfigResIdl.error.errmsg);
            }
            DataRes dataRes = getClientConfigResIdl.data;
            if (dataRes == null) {
                return getClientConfigResIdl;
            }
            this.mData = dataRes;
            return getClientConfigResIdl;
        }
        return invokeIL.objValue;
    }

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (DataRes) invokeV.objValue;
    }
}
