package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import com.baidu.tieba.a45;
import com.baidu.tieba.nb5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.Error;
import tbclient.Loop.DataRes;
import tbclient.Loop.FestivalInfo;
import tbclient.Loop.IconRes;
import tbclient.Loop.LevelRes;
import tbclient.Loop.LiveRes;
import tbclient.Loop.LoopResIdl;
/* loaded from: classes3.dex */
public class PollingSocketResMessage extends SocketResponsedMessage implements a45 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatRoomEntranceData chatEntranceData;
    public SubscribeGroupUnreadMsgData groupUnreadMsgData;
    public List<AlaLiveInfo> liveFollowSecondFloor;
    public List<AlaLiveInfo> liveIndexSecondFloor;
    public final List<AlaLiveInfo> livePicSecondFloor;
    public MemberBroadcastData mActivityBroadcastData;
    public nb5 mFestivalConfigData;
    public IconPopData mIconPopData;
    public LevePopData mLevePopData;
    public LiveRemindData mLiveRemindData;
    public MemberBroadcastData mMemberBroadcastData;
    public String uniqueId;

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
        this.mFestivalConfigData = new nb5();
        this.mLiveRemindData = new LiveRemindData();
        this.groupUnreadMsgData = new SubscribeGroupUnreadMsgData();
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
        this.livePicSecondFloor = new ArrayList();
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
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
                    FestivalInfo festivalInfo = loopResIdl.data.festival_info;
                    if (festivalInfo != null) {
                        this.mFestivalConfigData.a(festivalInfo);
                    }
                    if (loopResIdl.data.live_follow_second_floor != null) {
                        this.liveFollowSecondFloor.clear();
                        this.liveFollowSecondFloor.addAll(loopResIdl.data.live_follow_second_floor);
                    }
                    if (loopResIdl.data.live_follow_second_floor != null) {
                        this.liveIndexSecondFloor.clear();
                        this.liveIndexSecondFloor.addAll(loopResIdl.data.live_follow_second_floor);
                    }
                    if (loopResIdl.data.live_pic_second_floor != null) {
                        this.livePicSecondFloor.clear();
                        this.livePicSecondFloor.addAll(loopResIdl.data.live_pic_second_floor);
                    }
                    if (loopResIdl.data.chatroom_frs != null) {
                        ChatRoomEntranceData chatRoomEntranceData = new ChatRoomEntranceData();
                        this.chatEntranceData = chatRoomEntranceData;
                        chatRoomEntranceData.parserProtobuf(loopResIdl.data.chatroom_frs);
                    }
                    DataRes dataRes2 = loopResIdl.data;
                    if (dataRes2.chatroom_message_tab != null && !TextUtils.isEmpty(dataRes2.uniq_id)) {
                        SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData = new SubscribeGroupUnreadMsgData();
                        this.groupUnreadMsgData = subscribeGroupUnreadMsgData;
                        DataRes dataRes3 = loopResIdl.data;
                        subscribeGroupUnreadMsgData.parse(dataRes3.chatroom_message_tab, dataRes3.uniq_id);
                    }
                    if (loopResIdl.data.member_broadcast != null) {
                        MemberBroadcastData memberBroadcastData = new MemberBroadcastData();
                        this.mMemberBroadcastData = memberBroadcastData;
                        memberBroadcastData.parseProtobuf(loopResIdl.data.member_broadcast);
                    }
                    if (loopResIdl.data.activity_broadcast != null) {
                        MemberBroadcastData memberBroadcastData2 = new MemberBroadcastData();
                        this.mActivityBroadcastData = memberBroadcastData2;
                        memberBroadcastData2.parseProtobuf(loopResIdl.data.activity_broadcast);
                    }
                    this.uniqueId = loopResIdl.data.uniq_id;
                }
            }
            return loopResIdl;
        }
        return invokeIL.objValue;
    }

    @Override // com.baidu.tieba.a45
    public MemberBroadcastData getActivityBroadcastData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mActivityBroadcastData;
        }
        return (MemberBroadcastData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public ChatRoomEntranceData getChatRoomEntranceData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.chatEntranceData;
        }
        return (ChatRoomEntranceData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public nb5 getFestivalConfigData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFestivalConfigData;
        }
        return (nb5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public IconPopData getIconPopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mIconPopData;
        }
        return (IconPopData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public LevePopData getLevePopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mLevePopData;
        }
        return (LevePopData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public List<AlaLiveInfo> getLiveFollowSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.liveFollowSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public List<AlaLiveInfo> getLiveIndexSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.liveIndexSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public List<AlaLiveInfo> getLivePicSecondFloor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.livePicSecondFloor;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public LiveRemindData getLiveRemindData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mLiveRemindData;
        }
        return (LiveRemindData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public MemberBroadcastData getMemberBroadcastData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mMemberBroadcastData;
        }
        return (MemberBroadcastData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public SubscribeGroupUnreadMsgData getSubscribeChatHaveUnReadMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.groupUnreadMsgData;
        }
        return (SubscribeGroupUnreadMsgData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.a45
    public String getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.uniqueId;
        }
        return (String) invokeV.objValue;
    }
}
