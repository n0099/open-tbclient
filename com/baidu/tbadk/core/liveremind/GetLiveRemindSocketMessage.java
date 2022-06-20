package com.baidu.tbadk.core.liveremind;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.LiveRemindFloatViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetRemindLiveRooms.DataRes;
import tbclient.GetRemindLiveRooms.GetRemindLiveRoomsResIdl;
/* loaded from: classes3.dex */
public class GetLiveRemindSocketMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindFloatViewData mLiveInfo;
    public YyExtData yyExtData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLiveRemindSocketMessage() {
        super(309728);
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
        this.mLiveInfo = new LiveRemindFloatViewData();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetRemindLiveRoomsResIdl getRemindLiveRoomsResIdl = (GetRemindLiveRoomsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRemindLiveRoomsResIdl.class);
            if (getRemindLiveRoomsResIdl != null) {
                Error error = getRemindLiveRoomsResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getRemindLiveRoomsResIdl.error.usermsg);
                    if (getError() != 0) {
                        return getRemindLiveRoomsResIdl;
                    }
                }
                DataRes dataRes = getRemindLiveRoomsResIdl.data;
                if (dataRes != null) {
                    if (dataRes.is_end != null) {
                        TbSingleton.getInstance().setIsNeedRemindLiveRoom(Integer.parseInt(getRemindLiveRoomsResIdl.data.is_end) == 0);
                    }
                    if (!ListUtils.isEmpty(getRemindLiveRoomsResIdl.data.live_list)) {
                        this.mLiveInfo.setLiveInfoList(getRemindLiveRoomsResIdl.data.live_list);
                        this.yyExtData.parseProtoBuf(getRemindLiveRoomsResIdl.data.live_list.get(0).yy_ext);
                    }
                }
            }
            return getRemindLiveRoomsResIdl;
        }
        return invokeIL.objValue;
    }

    public LiveRemindFloatViewData getLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLiveInfo : (LiveRemindFloatViewData) invokeV.objValue;
    }

    public YyExtData getYyExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.yyExtData : (YyExtData) invokeV.objValue;
    }
}
