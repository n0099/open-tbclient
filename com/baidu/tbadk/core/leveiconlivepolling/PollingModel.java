package com.baidu.tbadk.core.leveiconlivepolling;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.data.LiveRemindRecommendData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab;
import com.repackage.d9;
import com.repackage.eu4;
import com.repackage.fu4;
import com.repackage.hz4;
import com.repackage.jk8;
import com.repackage.lb5;
import com.repackage.o75;
import com.repackage.ru4;
import java.util.HashMap;
import java.util.Objects;
/* loaded from: classes3.dex */
public class PollingModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ICON = "icon";
    public static final String LEVEL = "level";
    public static final String LIVE = "live";
    public static final String POLLING_TYPE_ICON = "icon";
    public static final String POLLING_TYPE_LEVEL_ICON_LIVE = "live,level,icon";
    public static final long POLL_LOOP_REQUEST_TIME = 300000;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveRemindData a;
    public TbPageContext b;
    public BdUniqueId c;
    public LevePopData d;
    public IconPopData e;
    public ab f;

    /* loaded from: classes3.dex */
    public class a extends ab {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PollingModel a;

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

        @Override // com.repackage.ab
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                if (responsedMessage instanceof PollingHttpResMessage) {
                    PollingHttpResMessage pollingHttpResMessage = (PollingHttpResMessage) responsedMessage;
                    this.a.a = pollingHttpResMessage.getLiveRemindData();
                    this.a.d = pollingHttpResMessage.getLevePopData();
                    this.a.e = pollingHttpResMessage.getIconPopData();
                } else if (responsedMessage instanceof PollingSocketResMessage) {
                    PollingSocketResMessage pollingSocketResMessage = (PollingSocketResMessage) responsedMessage;
                    this.a.a = pollingSocketResMessage.getLiveRemindData();
                    this.a.d = pollingSocketResMessage.getLevePopData();
                    this.a.e = pollingSocketResMessage.getIconPopData();
                }
                if (this.a.d != null) {
                    PollingModel pollingModel = this.a;
                    if (pollingModel.K(pollingModel.d, PollingModel.N())) {
                        PollingModel.R(this.a.d, false);
                    }
                }
                if (this.a.e != null) {
                    PollingModel pollingModel2 = this.a;
                    if (pollingModel2.I(pollingModel2.e, PollingModel.M())) {
                        PollingModel.Q(this.a.e, false);
                    }
                }
                this.a.O();
                this.a.P();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
            }
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LevePopData();
        this.e = new IconPopData();
        this.f = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        this.b = tbPageContext;
        setUniqueId(bdUniqueId);
        this.c = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, jk8.a(TbConfig.GET_POLLING_DATA, 309732));
        lb5 lb5Var = new lb5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        lb5Var.setResponsedClass(PollingSocketResMessage.class);
        lb5Var.g(true);
        lb5Var.h(false);
        MessageManager.getInstance().registerTask(lb5Var);
        registerListener(this.f);
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? !M().isHadShow() : invokeV.booleanValue;
    }

    public static IconPopData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? TbSingleton.getInstance().getIconPopData() : (IconPopData) invokeV.objValue;
    }

    public static LevePopData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? TbSingleton.getInstance().getLevePopData() : (LevePopData) invokeV.objValue;
    }

    public static void Q(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65548, null, iconPopData, z) == null) || iconPopData == null) {
            return;
        }
        iconPopData.setHadShow(z);
        TbSingleton.getInstance().setIconPopData(iconPopData);
        ru4 k = ru4.k();
        k.y("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
    }

    public static void R(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65549, null, levePopData, z) == null) || levePopData == null) {
            return;
        }
        levePopData.setHadShow(z);
        TbSingleton.getInstance().setLevePopData(levePopData);
        ru4 k = ru4.k();
        k.y("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
    }

    public final boolean I(IconPopData iconPopData, IconPopData iconPopData2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, iconPopData, iconPopData2)) == null) {
            if (iconPopData != null) {
                if (iconPopData2 != null) {
                    return !Objects.equals(iconPopData.getIcon_id(), iconPopData2.getIcon_id());
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean K(LevePopData levePopData, LevePopData levePopData2) {
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

    public void L(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.c);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            eu4.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            o75.i(liveRemindDataEvent);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = 0;
            LiveRemindRecommendData c = eu4.a().c(0);
            if (c == null || !fu4.b().j(LiveRemindConfig.Scene.LIVE_FLOAT)) {
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
            if (hz4.b(null, this.b, hashMap, 0L, 4000L) != null) {
                fu4.b().f(LiveRemindConfig.Scene.LIVE_FLOAT);
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
}
