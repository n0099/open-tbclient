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
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ah;
import com.baidu.tieba.cy4;
import com.baidu.tieba.dy4;
import com.baidu.tieba.ey4;
import com.baidu.tieba.fw4;
import com.baidu.tieba.hw4;
import com.baidu.tieba.k35;
import com.baidu.tieba.lj5;
import com.baidu.tieba.n9;
import com.baidu.tieba.qb;
import com.baidu.tieba.qy4;
import com.baidu.tieba.r9;
import com.baidu.tieba.ub5;
import com.baidu.tieba.uo8;
import com.baidu.tieba.wf5;
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
/* loaded from: classes3.dex */
public class PollingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ICON = "icon";
    public static final String LEVEL = "level";
    public static final String LIVE = "live";
    public static final String LIVE_FOLLOW_SECOND_FLOOR = "live_follow_second_floor";
    public static final String LIVE_INDEX_SECOND_FLOOR = "live_index_second_floor";
    public static final String LIVE_PIC_SECOND_FLOOR = "live_pic_second_floor";
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
    public final List<AlaLiveInfo> h;
    public c i;
    public c j;
    public c k;
    public final lj5 l;
    public fw4 m;
    public qb n;

    /* loaded from: classes3.dex */
    public interface c {
        void onSuccess(List<AlaLiveInfo> list);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        public class RunnableC0194a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0194a(a aVar) {
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
                this.a.a.Z(TbadkCoreApplication.getInst().getCurrentPageContext(TbadkCoreApplication.getInst().getCurrentActivity()));
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
                if (arrayList.contains("live")) {
                    this.a.a = ((cy4) responsedMessage).getLiveRemindData();
                }
                if (arrayList.contains("level")) {
                    this.a.d = ((cy4) responsedMessage).getLevePopData();
                }
                if (arrayList.contains("icon")) {
                    this.a.e = ((cy4) responsedMessage).getIconPopData();
                }
                if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                    this.a.f.clear();
                    this.a.f.addAll(((cy4) responsedMessage).getLiveFollowSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                    this.a.g.clear();
                    this.a.g.addAll(((cy4) responsedMessage).getLiveIndexSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_PIC_SECOND_FLOOR)) {
                    this.a.h.clear();
                    this.a.h.addAll(((cy4) responsedMessage).getLivePicSecondFloor());
                }
            }
            if (this.a.d != null) {
                PollingModel pollingModel = this.a;
                if (pollingModel.T(pollingModel.d, PollingModel.W())) {
                    PollingModel.c0(this.a.d, false);
                }
            }
            if (this.a.e != null) {
                PollingModel pollingModel2 = this.a;
                if (pollingModel2.R(pollingModel2.e, PollingModel.V())) {
                    PollingModel.b0(this.a.e, false);
                }
            }
            this.a.Y();
            if (n9.g().b() != null) {
                str = n9.g().b().getClass().getSimpleName();
            } else {
                str = "";
            }
            if (System.currentTimeMillis() - TbadkCoreApplication.getInst().processCreateTime < 10000 && TbadkCoreApplication.getInst().getStartType() == 2 && (TextUtils.equals("MainTabActivity", str) || TextUtils.equals("LogoActivity", str))) {
                ah.a().postDelayed(new RunnableC0194a(this), LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION);
            } else {
                PollingModel pollingModel3 = this.a;
                pollingModel3.Z(pollingModel3.b);
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
            this.a.X();
        }
    }

    /* loaded from: classes3.dex */
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
        this.l = lj5.a();
        this.n = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.b = tbPageContext;
        setUniqueId(bdUniqueId);
        this.c = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, uo8.a(TbConfig.GET_POLLING_DATA, 309732));
        wf5 wf5Var = new wf5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        wf5Var.setResponsedClass(PollingSocketResMessage.class);
        wf5Var.g(true);
        wf5Var.h(false);
        MessageManager.getInstance().registerTask(wf5Var);
        this.n.getHttpMessageListener().setSelfListener(true);
        this.n.getSocketMessageListener().setSelfListener(true);
        registerListener(this.n);
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.l.c(new b(this, str));
        }
    }

    public void a0(fw4 fw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fw4Var) == null) {
            this.m = fw4Var;
        }
    }

    public void d0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.i = cVar;
        }
    }

    public void e0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void f0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public final boolean T(LevePopData levePopData, LevePopData levePopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, levePopData, levePopData2)) == null) {
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

    public static boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return !V().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public static IconPopData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            return TbSingleton.getInstance().getIconPopData();
        }
        return (IconPopData) invokeV.objValue;
    }

    public static LevePopData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            return TbSingleton.getInstance().getLevePopData();
        }
        return (LevePopData) invokeV.objValue;
    }

    public final void X() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.m != null && (tbPageContext = this.b) != null && tbPageContext.getPageActivity() != null) {
            hw4.o(this.b.getPageActivity(), this.m);
        }
    }

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            dy4.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            ub5.i(liveRemindDataEvent);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.m = null;
            this.l.b();
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    public static void b0(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65557, null, iconPopData, z) == null) && iconPopData != null) {
            iconPopData.setHadShow(z);
            TbSingleton.getInstance().setIconPopData(iconPopData);
            qy4 k = qy4.k();
            k.y("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
        }
    }

    public static void c0(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65558, null, levePopData, z) == null) && levePopData != null) {
            levePopData.setHadShow(z);
            TbSingleton.getInstance().setLevePopData(levePopData);
            qy4 k = qy4.k();
            k.y("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
        }
    }

    public final boolean R(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iconPopData, iconPopData2)) == null) {
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

    public final void Z(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbPageContext) == null) {
            int i = 0;
            LiveRemindRecommendData c2 = dy4.a().c(0);
            if (c2 != null && ey4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
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
                if (k35.f(null, tbPageContext, hashMap, 0L, 4000L) != null) {
                    ey4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
                }
            }
        }
    }
}
