package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
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
import com.baidu.tbadk.data.SubscribeGroupUnreadMsgData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ah;
import com.baidu.tieba.cy4;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fy4;
import com.baidu.tieba.gw4;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.iw4;
import com.baidu.tieba.l35;
import com.baidu.tieba.mc5;
import com.baidu.tieba.n9;
import com.baidu.tieba.og5;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.ry4;
import com.baidu.tieba.ur8;
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
import tbclient.AlaLiveInfo;
/* loaded from: classes3.dex */
public class PollingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CHATROOM_FRS = "chatroom_frs";
    public static final String ICON = "icon";
    public static final String LEVEL = "level";
    public static final String LIVE = "live";
    public static final String LIVE_FOLLOW_SECOND_FLOOR = "live_follow_second_floor";
    public static final String LIVE_INDEX_SECOND_FLOOR = "live_index_second_floor";
    public static final String LIVE_PIC_SECOND_FLOOR = "live_pic_second_floor";
    public static final String POLLING_TYPE_LEVEL_ICON_LIVE = "live,level,icon";
    public static final String POLLING_TYPE_LOOP = "live,level,icon,live_follow_second_floor";
    public static final String SUBSCRIBE_GROUP_CHAT_LIST = "chatroom_message_tab";
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindData a;
    public TbPageContext b;
    public BdUniqueId c;
    public LevePopData d;
    public IconPopData e;
    public List<AlaLiveInfo> f;
    public List<AlaLiveInfo> g;
    public final List<AlaLiveInfo> h;
    public b i;
    public b j;
    public b k;
    public SubscribeGroupUnreadMsgData l;
    public ChatEntranceLoopData m;
    public ChatRoomEntranceData n;
    public String o;
    public final fk5 p;
    public gw4 q;
    public qb r;

    /* loaded from: classes3.dex */
    public interface b {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends qb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingModel a;

        /* renamed from: com.baidu.tbadk.core.leveiconlivepolling.PollingModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0206a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0206a(a aVar) {
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
                this.a.a.q0(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()));
                TbSingleton.getInstance().setLiveFollowSecondFloor(this.a.a.f);
                TbSingleton.getInstance().setLiveIndexSecondFloor(this.a.a.g);
                if (this.a.a.i != null) {
                    this.a.a.i.onSuccess(this.a.a.f);
                }
                if (this.a.a.j != null) {
                    this.a.a.j.onSuccess(this.a.a.g);
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
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
            if (!ListUtils.isEmpty(arrayList) && (responsedMessage instanceof cy4)) {
                cy4 cy4Var = (cy4) responsedMessage;
                this.a.o = cy4Var.getUniqueId();
                if (arrayList.contains("live")) {
                    this.a.a = cy4Var.getLiveRemindData();
                }
                if (arrayList.contains("level")) {
                    this.a.d = cy4Var.getLevePopData();
                }
                if (arrayList.contains("icon")) {
                    this.a.e = cy4Var.getIconPopData();
                }
                if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                    this.a.f.clear();
                    this.a.f.addAll(cy4Var.getLiveFollowSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                    this.a.g.clear();
                    this.a.g.addAll(cy4Var.getLiveIndexSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_PIC_SECOND_FLOOR)) {
                    this.a.h.clear();
                    this.a.h.addAll(cy4Var.getLivePicSecondFloor());
                }
                if (arrayList.contains(PollingModel.CHATROOM_FRS)) {
                    this.a.n = cy4Var.getChatRoomEntranceData();
                    this.a.m = new ChatEntranceLoopData();
                    this.a.m.setEntranceData(this.a.n);
                    this.a.m.setUniqueId(this.a.o);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921763, this.a.m));
                }
                if (arrayList.contains(PollingModel.SUBSCRIBE_GROUP_CHAT_LIST)) {
                    this.a.l = cy4Var.getSubscribeChatHaveUnReadMsg();
                }
            }
            if (this.a.d != null) {
                PollingModel pollingModel = this.a;
                if (pollingModel.i0(pollingModel.d, PollingModel.n0())) {
                    PollingModel.u0(this.a.d, false);
                }
            }
            if (this.a.e != null) {
                PollingModel pollingModel2 = this.a;
                if (pollingModel2.g0(pollingModel2.e, PollingModel.m0())) {
                    PollingModel.t0(this.a.e, false);
                }
            }
            this.a.p0();
            PollingModel pollingModel3 = this.a;
            pollingModel3.r0(responsedMessage, pollingModel3.l);
            if (n9.g().b() != null) {
                str = n9.g().b().getClass().getSimpleName();
            } else {
                str = "";
            }
            if (System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime < 10000 && TbadkCoreApplication.getInst().getStartType() == 2 && (TextUtils.equals("MainTabActivity", str) || TextUtils.equals("LogoActivity", str))) {
                ah.a().postDelayed(new RunnableC0206a(this), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            } else {
                PollingModel pollingModel4 = this.a;
                pollingModel4.q0(pollingModel4.b);
                TbSingleton.getInstance().setLiveFollowSecondFloor(this.a.f);
                TbSingleton.getInstance().setLiveIndexSecondFloor(this.a.g);
                if (this.a.i != null) {
                    this.a.i.onSuccess(this.a.f);
                }
                if (this.a.j != null) {
                    this.a.j.onSuccess(this.a.g);
                }
                if (this.a.k != null) {
                    List<AlaLiveInfo> list = null;
                    if (!this.a.h.isEmpty()) {
                        if (UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShowA()) {
                            list = this.a.h;
                        } else if (UbsABTestHelper.isBigPicPageRecommendLiveSecondFloorShowB()) {
                            list = this.a.f;
                        }
                    }
                    this.a.k.onSuccess(list);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
            this.a.o0();
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
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LevePopData();
        this.e = new IconPopData();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.n = new ChatRoomEntranceData();
        this.p = fk5.f();
        this.r = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.b = tbPageContext;
        setUniqueId(bdUniqueId);
        this.c = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, ur8.a(TbConfig.GET_POLLING_DATA, 309732));
        og5 og5Var = new og5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        og5Var.setResponsedClass(PollingSocketResMessage.class);
        og5Var.g(true);
        og5Var.h(false);
        MessageManager.getInstance().registerTask(og5Var);
        this.r.getHttpMessageListener().setSelfListener(true);
        this.r.getSocketMessageListener().setSelfListener(true);
        registerListener(this.r);
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public void s0(gw4 gw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gw4Var) == null) {
            this.q = gw4Var;
        }
    }

    public void v0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void w0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void x0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public final boolean i0(LevePopData levePopData, LevePopData levePopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, levePopData, levePopData2)) == null) {
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

    public static boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return !m0().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public static IconPopData m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            return TbSingleton.getInstance().getIconPopData();
        }
        return (IconPopData) invokeV.objValue;
    }

    public static LevePopData n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            return TbSingleton.getInstance().getLevePopData();
        }
        return (LevePopData) invokeV.objValue;
    }

    public final void o0() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.q != null && (tbPageContext = this.b) != null && tbPageContext.getPageActivity() != null) {
            iw4.p(this.b.getPageActivity(), this.q);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.q = null;
            this.p.g();
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ey4.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            mc5.i(liveRemindDataEvent);
        }
    }

    public static void t0(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65566, null, iconPopData, z) == null) && iconPopData != null) {
            iconPopData.setHadShow(z);
            TbSingleton.getInstance().setIconPopData(iconPopData);
            ry4 l = ry4.l();
            l.z("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
        }
    }

    public static void u0(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65567, null, levePopData, z) == null) && levePopData != null) {
            levePopData.setHadShow(z);
            TbSingleton.getInstance().setLevePopData(levePopData);
            ry4 l = ry4.l();
            l.z("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
        }
    }

    public final boolean g0(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconPopData, iconPopData2)) == null) {
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

    public void j0(String str, String str2, long j, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, Long.valueOf(j), str3}) == null) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setForumName(str2);
            pollingReqMessage.setUniqueId(str3);
            pollingReqMessage.setChatroomId(j);
            pollingReqMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public void l0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.c);
            pollingReqMessage.setDataRoomListMsg(str3);
            pollingReqMessage.setUniqueId(str2);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public final void q0(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            int i = 0;
            LiveRemindRecommendData c = ey4.a().c(0);
            if (c != null && fy4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                HashMap hashMap = new HashMap();
                if (c.getRemindType() == 1) {
                    i = 3;
                } else if (c.getRemindType() == 2) {
                    i = 4;
                } else if (c.getRemindType() == 3) {
                    i = 2;
                }
                hashMap.put("view_top_params_key_image_url", c.getLiveIconSrc());
                hashMap.put("view_top_params_key_schema", c.getLiveIconScheme());
                hashMap.put("view_top_params_user_name", c.getUserName());
                hashMap.put("view_top_params_key_desc", c.getDesc());
                hashMap.put("view_top_params_room_id", c.getRoomId());
                hashMap.put("view_top_params_btn_text", c.getBtnText());
                hashMap.put("view_top_params_key_title", c.getTitle());
                hashMap.put("view_top_params_key_nid", c.getFeedId());
                hashMap.put("view_top_params_key_yyext", c.getYyExtData());
                hashMap.put("view_top_params_key_type", Integer.valueOf(i));
                hashMap.put("view_top_params_is_breathe", Boolean.FALSE);
                if (l35.f(null, tbPageContext, hashMap, 0L, 4000L) != null) {
                    fy4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                }
            }
        }
    }

    public final void r0(ResponsedMessage<?> responsedMessage, SubscribeGroupUnreadMsgData subscribeGroupUnreadMsgData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, responsedMessage, subscribeGroupUnreadMsgData) == null) && responsedMessage != null && subscribeGroupUnreadMsgData != null && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
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
