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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ax4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.cx4;
import com.baidu.tieba.g25;
import com.baidu.tieba.gh;
import com.baidu.tieba.me5;
import com.baidu.tieba.n9;
import com.baidu.tieba.na5;
import com.baidu.tieba.ox4;
import com.baidu.tieba.pb;
import com.baidu.tieba.r9;
import com.baidu.tieba.sm8;
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
    public static final String ICON = "icon";
    public static final String LEVEL = "level";
    public static final String LIVE = "live";
    public static final String LIVE_FOLLOW_SECOND_FLOOR = "live_follow_second_floor";
    public static final String LIVE_INDEX_SECOND_FLOOR = "live_index_second_floor";
    public static final String POLLING_TYPE_LEVEL_ICON_LIVE = "live,level,icon";
    public static final String POLLING_TYPE_LOOP = "live,level,icon,live_follow_second_floor";
    public static final long POLL_LOOP_REQUEST_TIME = 300000;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindData a;
    public TbPageContext b;
    public BdUniqueId c;
    public LevePopData d;
    public IconPopData e;
    public List<AlaLiveInfo> f;
    public List<AlaLiveInfo> g;
    public b h;
    public b i;
    public pb j;

    /* loaded from: classes3.dex */
    public class a extends pb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingModel a;

        /* renamed from: com.baidu.tbadk.core.leveiconlivepolling.PollingModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0185a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0185a(a aVar) {
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
                    this.a.a.U(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()));
                    TbSingleton.getInstance().setLiveFollowSecondFloor(this.a.a.f);
                    TbSingleton.getInstance().setLiveIndexSecondFloor(this.a.a.g);
                    if (this.a.a.h != null) {
                        this.a.a.h.onSuccess(this.a.a.f);
                    }
                    if (this.a.a.i != null) {
                        this.a.a.i.onSuccess(this.a.a.g);
                    }
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

        @Override // com.baidu.tieba.pb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            List arrayList = new ArrayList();
            if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof PollingReqMessage)) {
                String dataType = ((PollingReqMessage) responsedMessage.getOrginalMessage().getExtra()).getDataType();
                if (!TextUtils.isEmpty(dataType)) {
                    arrayList = Arrays.asList(dataType.split(","));
                }
            }
            if (!ListUtils.isEmpty(arrayList) && (responsedMessage instanceof ax4)) {
                if (arrayList.contains("live")) {
                    this.a.a = ((ax4) responsedMessage).getLiveRemindData();
                }
                if (arrayList.contains(PollingModel.LEVEL)) {
                    this.a.d = ((ax4) responsedMessage).getLevePopData();
                }
                if (arrayList.contains("icon")) {
                    this.a.e = ((ax4) responsedMessage).getIconPopData();
                }
                if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                    this.a.f.clear();
                    this.a.f.addAll(((ax4) responsedMessage).getLiveFollowSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                    this.a.g.clear();
                    this.a.g.addAll(((ax4) responsedMessage).getLiveIndexSecondFloor());
                }
            }
            if (this.a.d != null) {
                PollingModel pollingModel = this.a;
                if (pollingModel.P(pollingModel.d, PollingModel.S())) {
                    PollingModel.W(this.a.d, false);
                }
            }
            if (this.a.e != null) {
                PollingModel pollingModel2 = this.a;
                if (pollingModel2.N(pollingModel2.e, PollingModel.R())) {
                    PollingModel.V(this.a.e, false);
                }
            }
            this.a.T();
            String simpleName = n9.g().b() != null ? n9.g().b().getClass().getSimpleName() : "";
            if (System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime < 10000 && TbadkCoreApplication.getInst().getStartType() == 2 && (TextUtils.equals("MainTabActivity", simpleName) || TextUtils.equals("LogoActivity", simpleName))) {
                gh.a().postDelayed(new RunnableC0185a(this), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            } else {
                PollingModel pollingModel3 = this.a;
                pollingModel3.U(pollingModel3.b);
                TbSingleton.getInstance().setLiveFollowSecondFloor(this.a.f);
                TbSingleton.getInstance().setLiveIndexSecondFloor(this.a.g);
                if (this.a.h != null) {
                    this.a.h.onSuccess(this.a.f);
                }
                if (this.a.i != null) {
                    this.a.i.onSuccess(this.a.g);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onSuccess(List<AlaLiveInfo> list);
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
        this.j = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.b = tbPageContext;
        setUniqueId(bdUniqueId);
        this.c = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, sm8.a(TbConfig.GET_POLLING_DATA, 309732));
        me5 me5Var = new me5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        me5Var.setResponsedClass(PollingSocketResMessage.class);
        me5Var.g(true);
        me5Var.h(false);
        MessageManager.getInstance().registerTask(me5Var);
        registerListener(this.j);
    }

    public static boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? !R().isHadShow() : invokeV.booleanValue;
    }

    public static IconPopData R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? TbSingleton.getInstance().getIconPopData() : (IconPopData) invokeV.objValue;
    }

    public static LevePopData S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) ? TbSingleton.getInstance().getLevePopData() : (LevePopData) invokeV.objValue;
    }

    public static void V(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65553, null, iconPopData, z) == null) || iconPopData == null) {
            return;
        }
        iconPopData.setHadShow(z);
        TbSingleton.getInstance().setIconPopData(iconPopData);
        ox4 k = ox4.k();
        k.y("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
    }

    public static void W(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65554, null, levePopData, z) == null) || levePopData == null) {
            return;
        }
        levePopData.setHadShow(z);
        TbSingleton.getInstance().setLevePopData(levePopData);
        ox4 k = ox4.k();
        k.y("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
    }

    public final boolean N(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iconPopData, iconPopData2)) == null) {
            if (iconPopData == null || iconPopData.getIcon_id().longValue() == -1) {
                return false;
            }
            if (iconPopData2 != null) {
                return !Objects.equals(iconPopData.getIcon_id(), iconPopData2.getIcon_id());
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean P(LevePopData levePopData, LevePopData levePopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, levePopData, levePopData2)) == null) {
            if (levePopData != null) {
                return levePopData2 == null || levePopData.getLevel() > levePopData2.getLevel();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bx4.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            na5.i(liveRemindDataEvent);
        }
    }

    public final void U(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tbPageContext) == null) {
            int i = 0;
            LiveRemindRecommendData c = bx4.a().c(0);
            if (c == null || !cx4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
                return;
            }
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
            if (g25.e(null, tbPageContext, hashMap, 0L, 4000L) != null) {
                cx4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
            }
        }
    }

    public void X(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.h = bVar;
        }
    }

    public void Y(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.i = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }
}
