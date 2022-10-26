package com.baidu.tbadk.core.leveiconlivepolling;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tieba.gx4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Loop.DataRes;
import tbclient.Loop.IconRes;
import tbclient.Loop.LevelRes;
import tbclient.Loop.LiveRes;
import tbclient.Loop.LoopResIdl;
/* loaded from: classes3.dex */
public class PollingSocketResMessage extends SocketResponsedMessage implements gx4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List liveFollowSecondFloor;
    public List liveIndexSecondFloor;
    public IconPopData mIconPopData;
    public LevePopData mLevePopData;
    public LiveRemindData mLiveRemindData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollingSocketResMessage(int i) {
        super(309732);
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
        this.mLevePopData = new LevePopData();
        this.mIconPopData = new IconPopData();
        this.mLiveRemindData = new LiveRemindData();
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            LoopResIdl loopResIdl = (LoopResIdl) new Wire(new Class[0]).parseFrom(bArr, LoopResIdl.class);
            if (loopResIdl != null) {
                Error error = loopResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(loopResIdl.error.usermsg);
                    if (getError() != 0) {
                        return loopResIdl;
                    }
                }
                DataRes dataRes = loopResIdl.data;
                if (dataRes != null) {
                    LiveRes liveRes = dataRes.live;
                    if (liveRes != null) {
                        this.mLiveRemindData.parserProtobuf(liveRes);
                    }
                    LevelRes levelRes = loopResIdl.data.level;
                    if (levelRes != null) {
                        this.mLevePopData.parserProtobuf(levelRes.pop);
                    }
                    IconRes iconRes = loopResIdl.data.icon;
                    if (iconRes != null) {
                        this.mIconPopData.parserProtobuf(iconRes.pop);
                    }
                    if (loopResIdl.data.live_follow_second_floor != null) {
                        this.liveFollowSecondFloor.clear();
                        this.liveFollowSecondFloor.addAll(loopResIdl.data.live_follow_second_floor);
                    }
                    if (loopResIdl.data.live_follow_second_floor != null) {
                        this.liveIndexSecondFloor.clear();
                        this.liveIndexSecondFloor.addAll(loopResIdl.data.live_follow_second_floor);
                    }
                }
            }
            return loopResIdl;
        }
        return invokeIL.objValue;
    }

    @Override // com.baidu.tieba.gx4
    public IconPopData getIconPopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mIconPopData;
        }
        return (IconPopData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx4
    public LevePopData getLevePopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mLevePopData;
        }
        return (LevePopData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx4
    public List getLiveFollowSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.liveFollowSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx4
    public List getLiveIndexSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.liveIndexSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gx4
    public LiveRemindData getLiveRemindData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mLiveRemindData;
        }
        return (LiveRemindData) invokeV.objValue;
    }
}
