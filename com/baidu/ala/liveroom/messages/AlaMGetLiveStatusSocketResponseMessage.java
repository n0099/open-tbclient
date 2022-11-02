package com.baidu.ala.liveroom.messages;

import alaim.AlaMgetLiveStatus.AlaMgetLiveStatusResIdl;
import alaim.AlaMgetLiveStatus.DataRes;
import androidx.annotation.Nullable;
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
/* loaded from: classes.dex */
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

    public List<Long> getClosedIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCloseIds;
        }
        return (List) invokeV.objValue;
    }

    public long getInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mInterval;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AlaMgetLiveStatusResIdl alaMgetLiveStatusResIdl = (AlaMgetLiveStatusResIdl) new Wire(new Class[0]).parseFrom(bArr, AlaMgetLiveStatusResIdl.class);
            setError(alaMgetLiveStatusResIdl.error.errorno.intValue());
            setErrorString(alaMgetLiveStatusResIdl.error.usermsg);
            if (getError() != 0) {
                return alaMgetLiveStatusResIdl;
            }
            DataRes dataRes = alaMgetLiveStatusResIdl.data;
            if (dataRes != null && dataRes.close_live != null) {
                this.mInterval = dataRes.interval.longValue();
                this.mCloseIds = new ArrayList(alaMgetLiveStatusResIdl.data.close_live);
            }
            return alaMgetLiveStatusResIdl;
        }
        return invokeIL.objValue;
    }
}
