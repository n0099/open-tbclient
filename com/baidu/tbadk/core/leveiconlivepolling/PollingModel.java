package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.ChatEntranceLoopData;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.gu5;
import com.baidu.tieba.i45;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.k45;
import com.baidu.tieba.l45;
import com.baidu.tieba.rh5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.v05;
import com.baidu.tieba.wva;
import com.baidu.tieba.z95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import tbclient.AlaLiveInfo;
/* loaded from: classes4.dex */
public class PollingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_BROADCAST = "activity_broadcast";
    public static final String CHATROOM_FRS = "chatroom_frs";
    public static final String FESTIVAL = "festival_info";
    public static final String ICON = "icon";
    public static final String LEVEL = "level";
    public static final String LIVE = "live";
    public static final String LIVE_FOLLOW_SECOND_FLOOR = "live_follow_second_floor";
    public static final String LIVE_INDEX_SECOND_FLOOR = "live_index_second_floor";
    public static final String LIVE_PIC_SECOND_FLOOR = "live_pic_second_floor";
    public static final String MEMBER_BROADCAST = "member_broadcast";
    public static final String POLLING_TYPE_LEVEL_ICON_LIVE = "live,level,icon,festival_info";
    public static final String POLLING_TYPE_LOOP = "live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast";
    public static final String SP_KEY_GROUP_CHAT_DISTURB_SETTING = "sp_key_group_chat_disturb_setting";
    public static final String SUBSCRIBE_GROUP_CHAT_LIST = "chatroom_message_tab";
    public transient /* synthetic */ FieldHolder $fh;
    public SubscribeGroupUnreadMsgData groupUnreadMsgData;
    public List<AlaLiveInfo> liveFollowSecondFloor;
    public d liveFollowSecondFloorCallback;
    public List<AlaLiveInfo> liveIndexSecondFloor;
    public d liveIndexSecondFloorCallback;
    public final List<AlaLiveInfo> livePicSecondFloor;
    public d livePicSecondFloorCallback;
    public ChatEntranceLoopData mChatLoopData;
    public c mChatRoomCallBack;
    public ChatRoomEntranceData mChatRoomEntranceData;
    public TbPageContext mContext;
    public v05 mDialogTime;
    public uc5 mFestivalConfigData;
    public NetMessageListener mGetPollingListener;
    public IconPopData mIconPopData;
    public LevePopData mLevePopData;
    public LiveRemindData mLiveRemindData;
    public MemberBroadcastData mMemberBroadcastData;
    public String mUniqueLoopId;
    public final gu5 retry;
    public BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface c {
        void a(ChatRoomEntranceData chatRoomEntranceData);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onFail();

        void onSuccess(List<AlaLiveInfo> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingModel a;

        /* renamed from: com.baidu.tbadk.core.leveiconlivepolling.PollingModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0213a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0213a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.showLiveRecommend();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PollingModel pollingModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pollingModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pollingModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            MemberBroadcastData activityBroadcastData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage == null) {
                    if (this.a.liveIndexSecondFloorCallback != null) {
                        this.a.liveIndexSecondFloorCallback.onFail();
                        return;
                    }
                    return;
                }
                List arrayList = new ArrayList();
                if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
                    String dataType = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getDataType();
                    if (!TextUtils.isEmpty(dataType)) {
                        arrayList = Arrays.asList(dataType.split(","));
                    }
                }
                if (!ListUtils.isEmpty(arrayList) && (responsedMessage instanceof i45)) {
                    i45 i45Var = (i45) responsedMessage;
                    this.a.mUniqueLoopId = i45Var.getUniqueId();
                    if (arrayList.contains("live")) {
                        this.a.mLiveRemindData = i45Var.getLiveRemindData();
                    }
                    if (arrayList.contains("level")) {
                        this.a.mLevePopData = i45Var.getLevePopData();
                    }
                    if (arrayList.contains("icon")) {
                        this.a.mIconPopData = i45Var.getIconPopData();
                    }
                    if (arrayList.contains(PollingModel.FESTIVAL)) {
                        this.a.mFestivalConfigData = i45Var.getFestivalConfigData();
                    }
                    if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                        this.a.liveFollowSecondFloor.clear();
                        this.a.liveFollowSecondFloor.addAll(i45Var.getLiveFollowSecondFloor());
                    }
                    if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                        this.a.liveIndexSecondFloor.clear();
                        this.a.liveIndexSecondFloor.addAll(i45Var.getLiveIndexSecondFloor());
                    }
                    if (arrayList.contains(PollingModel.LIVE_PIC_SECOND_FLOOR)) {
                        this.a.livePicSecondFloor.clear();
                        this.a.livePicSecondFloor.addAll(i45Var.getLivePicSecondFloor());
                    }
                    if (arrayList.contains(PollingModel.CHATROOM_FRS)) {
                        this.a.mChatRoomEntranceData = i45Var.getChatRoomEntranceData();
                        this.a.mChatLoopData = new ChatEntranceLoopData();
                        this.a.mChatLoopData.setEntranceData(this.a.mChatRoomEntranceData);
                        this.a.mChatLoopData.setUniqueId(this.a.mUniqueLoopId);
                        if (this.a.mChatRoomCallBack != null) {
                            this.a.mChatRoomCallBack.a(this.a.mChatRoomEntranceData);
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921763, this.a.mChatLoopData));
                    }
                    if (arrayList.contains(PollingModel.SUBSCRIBE_GROUP_CHAT_LIST)) {
                        this.a.groupUnreadMsgData = i45Var.getSubscribeChatHaveUnReadMsg();
                    }
                    if (arrayList.contains(PollingModel.MEMBER_BROADCAST)) {
                        this.a.mMemberBroadcastData = i45Var.getMemberBroadcastData();
                        if (this.a.mMemberBroadcastData != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921774, this.a.mMemberBroadcastData));
                        }
                    }
                    if (arrayList.contains(PollingModel.ACTIVITY_BROADCAST) && (activityBroadcastData = i45Var.getActivityBroadcastData()) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921801, activityBroadcastData));
                    }
                }
                if (this.a.mLevePopData != null) {
                    PollingModel pollingModel = this.a;
                    if (pollingModel.checkLevelDataIsSame(pollingModel.mLevePopData, PollingModel.getLevePopData())) {
                        PollingModel.setLevelPopData(this.a.mLevePopData, false);
                    }
                }
                if (this.a.mIconPopData != null) {
                    PollingModel pollingModel2 = this.a;
                    if (pollingModel2.checkIconPopDataIsSame(pollingModel2.mIconPopData, PollingModel.getIconPopData())) {
                        PollingModel.setIconPopData(this.a.mIconPopData, false);
                    }
                }
                if (this.a.mFestivalConfigData != null) {
                    rh5.b().c(this.a.mFestivalConfigData);
                }
                this.a.processLiveData();
                PollingModel pollingModel3 = this.a;
                pollingModel3.processTabChatSubscribeGroupRemind(responsedMessage, pollingModel3.groupUnreadMsgData);
                PollingModel pollingModel4 = this.a;
                pollingModel4.processFrsLoopUnReadNum(responsedMessage, pollingModel4.groupUnreadMsgData);
                if (!ListUtils.isEmpty(arrayList) && (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR) || arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR) || arrayList.contains(PollingModel.LIVE_PIC_SECOND_FLOOR))) {
                    IdleHandlerManager.getInstance().addOrRunTask("showPollingLiveRecommend", new RunnableC0213a(this));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
                this.a.handleYunDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Callable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ PollingModel b;

        public b(PollingModel pollingModel, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pollingModel, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pollingModel;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    PollingReqMessage pollingReqMessage = new PollingReqMessage();
                    pollingReqMessage.setDataType(this.a);
                    pollingReqMessage.setTag(this.b.uniqueId);
                    MessageManager.getInstance().sendMessage(pollingReqMessage);
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PollingModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLevePopData = new LevePopData();
        this.mIconPopData = new IconPopData();
        this.liveFollowSecondFloor = new ArrayList();
        this.liveIndexSecondFloor = new ArrayList();
        this.livePicSecondFloor = new ArrayList();
        this.mChatRoomEntranceData = new ChatRoomEntranceData();
        this.retry = gu5.g();
        this.mGetPollingListener = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.mContext = tbPageContext;
        setUniqueId(bdUniqueId);
        this.uniqueId = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, wva.a(TbConfig.GET_POLLING_DATA, 309732));
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.mGetPollingListener.getHttpMessageListener().setSelfListener(true);
        this.mGetPollingListener.getSocketMessageListener().setSelfListener(true);
        registerListener(this.mGetPollingListener);
    }

    private int getChatroomMask(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, str)) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            String sharedPrefKeyWithAccount = SharedPrefHelper.getSharedPrefKeyWithAccount(SP_KEY_GROUP_CHAT_DISTURB_SETTING);
            return !sharedPrefHelper.getBoolean(sharedPrefKeyWithAccount + str, true);
        }
        return invokeL.intValue;
    }

    public void getData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.retry.j(new b(this, str));
        }
    }

    public void setChatRoomEntranceCallback(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.mChatRoomCallBack = cVar;
        }
    }

    public void setDialogTime(v05 v05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v05Var) == null) {
            this.mDialogTime = v05Var;
        }
    }

    public void setLiveFollowSecondFloorCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.liveFollowSecondFloorCallback = dVar;
        }
    }

    public void setLiveIndexSecondFloorCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dVar) == null) {
            this.liveIndexSecondFloorCallback = dVar;
        }
    }

    public void setLivePicSecondFloorCallback(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            this.livePicSecondFloorCallback = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkLevelDataIsSame(LevePopData levePopData, LevePopData levePopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, this, levePopData, levePopData2)) == null) {
            if (levePopData == null) {
                return false;
            }
            if (levePopData2 != null && levePopData.getLevel() <= levePopData2.getLevel()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkIconPopDataIsSame(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, this, iconPopData, iconPopData2)) == null) {
            if (iconPopData != null && iconPopData.getIcon_id().longValue() != -1) {
                if (iconPopData2 == null) {
                    return true;
                }
                return !Objects.equals(iconPopData.getIcon_id(), iconPopData2.getIcon_id());
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void setIconPopData(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65579, null, iconPopData, z) == null) && iconPopData != null) {
            iconPopData.setHadShow(z);
            TbSingleton.getInstance().setIconPopData(iconPopData);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
        }
    }

    public static void setLevelPopData(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65580, null, levePopData, z) == null) && levePopData != null) {
            levePopData.setHadShow(z);
            TbSingleton.getInstance().setLevePopData(levePopData);
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
        }
    }

    public static boolean checkIconPopHadShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return !getIconPopData().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public static boolean checkLevelPopHadShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return !getLevePopData().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public static IconPopData getIconPopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            return TbSingleton.getInstance().getIconPopData();
        }
        return (IconPopData) invokeV.objValue;
    }

    public static LevePopData getLevePopData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            return TbSingleton.getInstance().getLevePopData();
        }
        return (LevePopData) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleYunDialog() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65574, this) == null) && this.mDialogTime != null && (tbPageContext = this.mContext) != null && tbPageContext.getPageActivity() != null) {
            YunDialogManager.onShow(this.mContext.getPageActivity(), this.mDialogTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLiveData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            k45.a().d(this.mLiveRemindData);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.mLiveRemindData;
            MutiProcessManager.publishEvent(liveRemindDataEvent);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mDialogTime = null;
            this.retry.h();
            MessageManager.getInstance().unRegisterListener(this.mGetPollingListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processFrsLoopUnReadNum(ResponsedMessage<?> responsedMessage, SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65575, this, responsedMessage, subscribeGroupUnreadMsgData) == null) && responsedMessage != null && subscribeGroupUnreadMsgData != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
            String uniqueId = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getUniqueId();
            String timeStamp = subscribeGroupUnreadMsgData.getTimeStamp();
            if (!TextUtils.isEmpty(uniqueId) && !TextUtils.isEmpty(timeStamp) && uniqueId.equals(timeStamp) && subscribeGroupUnreadMsgData.isHaveUnreadMsg()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921783));
            }
        }
    }

    private void processLoveRecommondData(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, tbPageContext) == null) {
            int i = 0;
            LiveRemindRecommendData c2 = k45.a().c(0);
            if (c2 != null && l45.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                HashMap hashMap = new HashMap();
                if (c2.getRemindType() == 1) {
                    i = 3;
                } else if (c2.getRemindType() == 2) {
                    i = 4;
                } else if (c2.getRemindType() == 3) {
                    i = 2;
                }
                hashMap.put("view_top_params_key_image_url", c2.getLiveIconSrc());
                hashMap.put("view_top_params_key_schema", c2.getLiveIconScheme());
                hashMap.put("view_top_params_user_name", c2.getUserName());
                hashMap.put("view_top_params_key_desc", c2.getDesc());
                hashMap.put("view_top_params_room_id", c2.getRoomId());
                hashMap.put("view_top_params_btn_text", c2.getBtnText());
                hashMap.put("view_top_params_key_title", c2.getTitle());
                hashMap.put("view_top_params_key_nid", c2.getFeedId());
                hashMap.put("view_top_params_key_yyext", c2.getYyExtData());
                hashMap.put("view_top_params_key_type", Integer.valueOf(i));
                hashMap.put("view_top_params_is_breathe", Boolean.FALSE);
                if (z95.f(null, tbPageContext, hashMap, 0L, 4000L) != null) {
                    l45.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTabChatSubscribeGroupRemind(ResponsedMessage<?> responsedMessage, SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65578, this, responsedMessage, subscribeGroupUnreadMsgData) == null) && responsedMessage != null && subscribeGroupUnreadMsgData != null && responsedMessage.getOrginalMessage() != null) {
            if ((responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage) || TbSingleton.getInstance().isChatTabPage()) {
                String uniqueId = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getUniqueId();
                String timeStamp = subscribeGroupUnreadMsgData.getTimeStamp();
                if (!TextUtils.isEmpty(uniqueId) && !TextUtils.isEmpty(timeStamp) && uniqueId.equals(timeStamp) && subscribeGroupUnreadMsgData.isHaveUnreadMsg()) {
                    ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = new ResponsedGroupChatListCompleteMessage(4);
                    responsedGroupChatListCompleteMessage.setHasUnreadMsg(true);
                    MessageManager.getInstance().dispatchResponsedMessage(responsedGroupChatListCompleteMessage);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLiveRecommend() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            processLoveRecommondData(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()));
            TbSingleton.getInstance().setLiveFollowSecondFloor(this.liveFollowSecondFloor);
            TbSingleton.getInstance().setLiveIndexSecondFloor(this.liveIndexSecondFloor);
            d dVar = this.liveFollowSecondFloorCallback;
            if (dVar != null) {
                dVar.onSuccess(this.liveFollowSecondFloor);
            }
            d dVar2 = this.liveIndexSecondFloorCallback;
            if (dVar2 != null) {
                dVar2.onSuccess(this.liveIndexSecondFloor);
            }
            if (this.livePicSecondFloorCallback != null) {
                List<AlaLiveInfo> list = null;
                if (!this.livePicSecondFloor.isEmpty()) {
                    list = this.liveFollowSecondFloor;
                }
                this.livePicSecondFloorCallback.onSuccess(list);
            }
        }
    }

    public void getChatEntranceData(String str, String str2, long j, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j), str3, str4}) == null) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setForumName(str2);
            pollingReqMessage.setUniqueId(str3);
            pollingReqMessage.setChatroomId(j);
            pollingReqMessage.setDataRoomListMsg(str4);
            pollingReqMessage.setTag(this.uniqueId);
            if (!StringUtils.isNull(str2)) {
                pollingReqMessage.setChatroomMask(getChatroomMask(str2));
            }
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public void getGroupUnReadCountData(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.uniqueId);
            pollingReqMessage.setDataRoomListMsg(str3);
            pollingReqMessage.setUniqueId(str2);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }
}
