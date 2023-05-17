package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.ChatEntranceLoopData;
import com.baidu.tbadk.data.ChatRoomEntranceData;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.data.MemberBroadcastData;
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.a35;
import com.baidu.tieba.b65;
import com.baidu.tieba.bt5;
import com.baidu.tieba.c65;
import com.baidu.tieba.el5;
import com.baidu.tieba.fb;
import com.baidu.tieba.g9;
import com.baidu.tieba.hh5;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.ip5;
import com.baidu.tieba.lb5;
import com.baidu.tieba.o65;
import com.baidu.tieba.od5;
import com.baidu.tieba.wb;
import com.baidu.tieba.z25;
import com.baidu.tieba.z55;
import com.baidu.tieba.zq9;
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
    public LiveRemindData a;
    public TbPageContext b;
    public BdUniqueId c;
    public LevePopData d;
    public IconPopData e;
    public od5 f;
    public List<AlaLiveInfo> g;
    public List<AlaLiveInfo> h;
    public final List<AlaLiveInfo> i;
    public d j;
    public d k;
    public d l;
    public SubscribeGroupUnreadMsgData m;
    public ChatEntranceLoopData n;
    public ChatRoomEntranceData o;
    public c p;
    public MemberBroadcastData q;
    public String r;
    public final bt5 s;
    public z25 t;
    public fb u;

    /* loaded from: classes4.dex */
    public interface c {
        void a(ChatRoomEntranceData chatRoomEntranceData);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onSuccess(List<AlaLiveInfo> list);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends fb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingModel a;

        /* renamed from: com.baidu.tbadk.core.leveiconlivepolling.PollingModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0207a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0207a(a aVar) {
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
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.S0();
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

        @Override // com.baidu.tieba.fb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            MemberBroadcastData activityBroadcastData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            List arrayList = new ArrayList();
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
                String dataType = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getDataType();
                if (!TextUtils.isEmpty(dataType)) {
                    arrayList = Arrays.asList(dataType.split(","));
                }
            }
            if (!ListUtils.isEmpty(arrayList) && (responsedMessage instanceof z55)) {
                z55 z55Var = (z55) responsedMessage;
                this.a.r = z55Var.getUniqueId();
                if (arrayList.contains("live")) {
                    this.a.a = z55Var.getLiveRemindData();
                }
                if (arrayList.contains("level")) {
                    this.a.d = z55Var.getLevePopData();
                }
                if (arrayList.contains("icon")) {
                    this.a.e = z55Var.getIconPopData();
                }
                if (arrayList.contains(PollingModel.FESTIVAL)) {
                    this.a.f = z55Var.getFestivalConfigData();
                }
                if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                    this.a.g.clear();
                    this.a.g.addAll(z55Var.getLiveFollowSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                    this.a.h.clear();
                    this.a.h.addAll(z55Var.getLiveIndexSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_PIC_SECOND_FLOOR)) {
                    this.a.i.clear();
                    this.a.i.addAll(z55Var.getLivePicSecondFloor());
                }
                if (arrayList.contains(PollingModel.CHATROOM_FRS)) {
                    this.a.o = z55Var.getChatRoomEntranceData();
                    this.a.n = new ChatEntranceLoopData();
                    this.a.n.setEntranceData(this.a.o);
                    this.a.n.setUniqueId(this.a.r);
                    if (this.a.p != null) {
                        this.a.p.a(this.a.o);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921763, this.a.n));
                }
                if (arrayList.contains(PollingModel.SUBSCRIBE_GROUP_CHAT_LIST)) {
                    this.a.m = z55Var.getSubscribeChatHaveUnReadMsg();
                }
                if (arrayList.contains(PollingModel.MEMBER_BROADCAST)) {
                    this.a.q = z55Var.getMemberBroadcastData();
                    if (this.a.q != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921774, this.a.q));
                    }
                }
                if (arrayList.contains(PollingModel.ACTIVITY_BROADCAST) && (activityBroadcastData = z55Var.getActivityBroadcastData()) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921801, activityBroadcastData));
                }
            }
            if (this.a.d != null) {
                PollingModel pollingModel = this.a;
                if (pollingModel.z0(pollingModel.d, PollingModel.F0())) {
                    PollingModel.O0(this.a.d, false);
                }
            }
            if (this.a.e != null) {
                PollingModel pollingModel2 = this.a;
                if (pollingModel2.x0(pollingModel2.e, PollingModel.E0())) {
                    PollingModel.N0(this.a.e, false);
                }
            }
            if (this.a.f != null) {
                hh5.b().update(this.a.f);
            }
            this.a.I0();
            PollingModel pollingModel3 = this.a;
            pollingModel3.K0(responsedMessage, pollingModel3.m);
            PollingModel pollingModel4 = this.a;
            pollingModel4.H0(responsedMessage, pollingModel4.m);
            wb.b().a("showPollingLiveRecommend", new RunnableC0207a(this));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
            this.a.G0();
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
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (TbadkCoreApplication.isLogin()) {
                    PollingReqMessage pollingReqMessage = new PollingReqMessage();
                    pollingReqMessage.setDataType(this.a);
                    pollingReqMessage.setTag(this.b.c);
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
                super((g9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LevePopData();
        this.e = new IconPopData();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.o = new ChatRoomEntranceData();
        this.s = bt5.g();
        this.u = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.b = tbPageContext;
        setUniqueId(bdUniqueId);
        this.c = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, zq9.a(TbConfig.GET_POLLING_DATA, 309732));
        ip5 ip5Var = new ip5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        ip5Var.setResponsedClass(PollingSocketResMessage.class);
        ip5Var.g(true);
        ip5Var.h(false);
        MessageManager.getInstance().registerTask(ip5Var);
        this.u.getHttpMessageListener().setSelfListener(true);
        this.u.getSocketMessageListener().setSelfListener(true);
        registerListener(this.u);
    }

    public static IconPopData E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return TbSingleton.getInstance().getIconPopData();
        }
        return (IconPopData) invokeV.objValue;
    }

    public static LevePopData F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return TbSingleton.getInstance().getLevePopData();
        }
        return (LevePopData) invokeV.objValue;
    }

    public static boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            return !E0().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public final void G0() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.t != null && (tbPageContext = this.b) != null && tbPageContext.getPageActivity() != null) {
            a35.o(this.b.getPageActivity(), this.t);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            b65.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            el5.i(liveRemindDataEvent);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.t = null;
            this.s.h();
            MessageManager.getInstance().unRegisterListener(this.u);
        }
    }

    public static void N0(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, iconPopData, z) == null) && iconPopData != null) {
            iconPopData.setHadShow(z);
            TbSingleton.getInstance().setIconPopData(iconPopData);
            o65 m = o65.m();
            m.B("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
        }
    }

    public static void O0(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, levePopData, z) == null) && levePopData != null) {
            levePopData.setHadShow(z);
            TbSingleton.getInstance().setLevePopData(levePopData);
            o65 m = o65.m();
            m.B("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
        }
    }

    public final boolean x0(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, iconPopData, iconPopData2)) == null) {
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

    public final int B0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            o65 m = o65.m();
            String q = o65.q(SP_KEY_GROUP_CHAT_DISTURB_SETTING);
            return !m.i(q + str, true);
        }
        return invokeL.intValue;
    }

    public void C0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.s.j(new b(this, str));
        }
    }

    public void L0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.p = cVar;
        }
    }

    public void M0(z25 z25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, z25Var) == null) {
            this.t = z25Var;
        }
    }

    public void P0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void Q0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void R0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.l = dVar;
        }
    }

    public final boolean z0(LevePopData levePopData, LevePopData levePopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, levePopData, levePopData2)) == null) {
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

    public void A0(String str, String str2, long j, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Long.valueOf(j), str3, str4}) == null) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setForumName(str2);
            pollingReqMessage.setUniqueId(str3);
            pollingReqMessage.setChatroomId(j);
            pollingReqMessage.setDataRoomListMsg(str4);
            pollingReqMessage.setTag(this.c);
            if (!StringUtils.isNull(str2)) {
                pollingReqMessage.setChatroomMask(B0(str2));
            }
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public void D0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.c);
            pollingReqMessage.setDataRoomListMsg(str3);
            pollingReqMessage.setUniqueId(str2);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public final void H0(ResponsedMessage<?> responsedMessage, SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, responsedMessage, subscribeGroupUnreadMsgData) == null) && responsedMessage != null && subscribeGroupUnreadMsgData != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
            String uniqueId = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getUniqueId();
            String timeStamp = subscribeGroupUnreadMsgData.getTimeStamp();
            if (!TextUtils.isEmpty(uniqueId) && !TextUtils.isEmpty(timeStamp) && uniqueId.equals(timeStamp) && subscribeGroupUnreadMsgData.isHaveUnreadMsg()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921783));
            }
        }
    }

    public final void J0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, tbPageContext) == null) {
            int i = 0;
            LiveRemindRecommendData c2 = b65.a().c(0);
            if (c2 != null && c65.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
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
                if (lb5.f(null, tbPageContext, hashMap, 0L, 4000L) != null) {
                    c65.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                }
            }
        }
    }

    public final void K0(ResponsedMessage<?> responsedMessage, SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, responsedMessage, subscribeGroupUnreadMsgData) == null) && responsedMessage != null && subscribeGroupUnreadMsgData != null && responsedMessage.getOrginalMessage() != null) {
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

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            J0(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()));
            TbSingleton.getInstance().setLiveFollowSecondFloor(this.g);
            TbSingleton.getInstance().setLiveIndexSecondFloor(this.h);
            d dVar = this.j;
            if (dVar != null) {
                dVar.onSuccess(this.g);
            }
            d dVar2 = this.k;
            if (dVar2 != null) {
                dVar2.onSuccess(this.h);
            }
            if (this.l != null) {
                List<AlaLiveInfo> list = null;
                if (!this.i.isEmpty()) {
                    if (UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShowA()) {
                        list = this.i;
                    } else if (UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShowB()) {
                        list = this.g;
                    }
                }
                this.l.onSuccess(list);
            }
        }
    }
}
