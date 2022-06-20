package com.baidu.tbadk.core.liveremind;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
public class GetLiveRemindHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindFloatViewData mLiveInfo;
    public YyExtData yyExtData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetLiveRemindHttpResMessage() {
        super(CmdConfigHttp.CMD_LIVE_REMIND_INFO);
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
        this.yyExtData = new YyExtData();
    }

    public LiveRemindFloatViewData getLiveInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLiveInfo : (LiveRemindFloatViewData) invokeV.objValue;
    }

    public YyExtData getYyExtData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.yyExtData : (YyExtData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRemindLiveRoomsResIdl getRemindLiveRoomsResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getRemindLiveRoomsResIdl = (GetRemindLiveRoomsResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRemindLiveRoomsResIdl.class)) == null) {
            return;
        }
        Error error = getRemindLiveRoomsResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getRemindLiveRoomsResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
        }
        DataRes dataRes = getRemindLiveRoomsResIdl.data;
        if (dataRes != null) {
            if (dataRes.is_end != null) {
                TbSingleton.getInstance().setIsNeedRemindLiveRoom(Integer.parseInt(getRemindLiveRoomsResIdl.data.is_end) == 0);
            }
            if (ListUtils.isEmpty(getRemindLiveRoomsResIdl.data.live_list)) {
                return;
            }
            this.mLiveInfo.setLiveInfoList(getRemindLiveRoomsResIdl.data.live_list);
            this.yyExtData.parseProtoBuf(getRemindLiveRoomsResIdl.data.live_list.get(0).yy_ext);
        }
    }
}
