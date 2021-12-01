package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusResIdl;
import alaim.AlaMgetLiveStatus.DataRes;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AlaMGetLiveStatusSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> mCloseIds;
    public long mInterval;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlaMGetLiveStatusSocketResponseMessage() {
        super(AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public List<Long> getClosedIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCloseIds : (List) invokeV.objValue;
    }

    public long getInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mInterval : invokeV.longValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            AlaMgetLiveStatusResIdl alaMgetLiveStatusResIdl = (AlaMgetLiveStatusResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaMgetLiveStatusResIdl.class);
            setError(alaMgetLiveStatusResIdl.error.errorno.intValue());
            setErrorString(alaMgetLiveStatusResIdl.error.usermsg);
            if (getError() != 0 || (dataRes = alaMgetLiveStatusResIdl.data) == null || dataRes.close_live == null) {
                return;
            }
            this.mInterval = dataRes.interval.longValue();
            this.mCloseIds = new ArrayList(alaMgetLiveStatusResIdl.data.close_live);
        }
    }
}
