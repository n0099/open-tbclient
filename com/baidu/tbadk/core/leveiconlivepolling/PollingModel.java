package com.baidu.tbadk.core.leveiconlivepolling;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tbadk.data.LevePopData;
import com.baidu.tbadk.data.LiveRemindData;
import com.baidu.tbadk.mutiprocess.live.LiveRemindDataEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.gx4;
import com.baidu.tieba.hx4;
import com.baidu.tieba.qb;
import com.baidu.tieba.r9;
import com.baidu.tieba.ra5;
import com.baidu.tieba.se5;
import com.baidu.tieba.ux4;
import com.baidu.tieba.zm8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
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
    public BdUniqueId b;
    public LevePopData c;
    public IconPopData d;
    public List<AlaLiveInfo> e;
    public List<AlaLiveInfo> f;
    public qb g;

    /* loaded from: classes3.dex */
    public interface b {
    }

    public void S(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
        }
    }

    public void T(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends qb {
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

        @Override // com.baidu.tieba.qb
        public void onMessage(ResponsedMessage responsedMessage) {
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
            if (!ListUtils.isEmpty(arrayList) && (responsedMessage instanceof gx4)) {
                if (arrayList.contains("live")) {
                    this.a.a = ((gx4) responsedMessage).getLiveRemindData();
                }
                if (arrayList.contains(PollingModel.LEVEL)) {
                    this.a.c = ((gx4) responsedMessage).getLevePopData();
                }
                if (arrayList.contains("icon")) {
                    this.a.d = ((gx4) responsedMessage).getIconPopData();
                }
                if (arrayList.contains(PollingModel.LIVE_FOLLOW_SECOND_FLOOR)) {
                    this.a.e.clear();
                    this.a.e.addAll(((gx4) responsedMessage).getLiveFollowSecondFloor());
                }
                if (arrayList.contains(PollingModel.LIVE_INDEX_SECOND_FLOOR)) {
                    this.a.f.clear();
                    this.a.f.addAll(((gx4) responsedMessage).getLiveIndexSecondFloor());
                }
            }
            if (this.a.c != null) {
                PollingModel pollingModel = this.a;
                if (pollingModel.L(pollingModel.c, PollingModel.O())) {
                    PollingModel.R(this.a.c, false);
                }
            }
            if (this.a.d != null) {
                PollingModel pollingModel2 = this.a;
                if (pollingModel2.J(pollingModel2.d, PollingModel.N())) {
                    PollingModel.Q(this.a.d, false);
                }
            }
            this.a.P();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921728));
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
        this.c = new LevePopData();
        this.d = new IconPopData();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new a(this, CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, 309732);
        setUniqueId(bdUniqueId);
        this.b = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_POLLING_INTERFACE, zm8.a(TbConfig.GET_POLLING_DATA, 309732));
        se5 se5Var = new se5(309732);
        tbHttpMessageTask.setResponsedClass(PollingHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        se5Var.setResponsedClass(PollingSocketResMessage.class);
        se5Var.g(true);
        se5Var.h(false);
        MessageManager.getInstance().registerTask(se5Var);
        this.g.getHttpMessageListener().setSelfListener(true);
        this.g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.g);
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && TbadkCoreApplication.isLogin()) {
            PollingReqMessage pollingReqMessage = new PollingReqMessage();
            pollingReqMessage.setDataType(str);
            pollingReqMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(pollingReqMessage);
        }
    }

    public final boolean L(LevePopData levePopData, LevePopData levePopData2) {
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

    public static boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return !N().isHadShow();
        }
        return invokeV.booleanValue;
    }

    public static IconPopData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return TbSingleton.getInstance().getIconPopData();
        }
        return (IconPopData) invokeV.objValue;
    }

    public static LevePopData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return TbSingleton.getInstance().getLevePopData();
        }
        return (LevePopData) invokeV.objValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            hx4.a().d(this.a);
            LiveRemindDataEvent liveRemindDataEvent = new LiveRemindDataEvent();
            liveRemindDataEvent.liveRemindData = this.a;
            ra5.i(liveRemindDataEvent);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }

    public static void Q(IconPopData iconPopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65549, null, iconPopData, z) == null) && iconPopData != null) {
            iconPopData.setHadShow(z);
            TbSingleton.getInstance().setIconPopData(iconPopData);
            ux4 k = ux4.k();
            k.y("key_polling_icon_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(iconPopData));
        }
    }

    public static void R(LevePopData levePopData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65550, null, levePopData, z) == null) && levePopData != null) {
            levePopData.setHadShow(z);
            TbSingleton.getInstance().setLevePopData(levePopData);
            ux4 k = ux4.k();
            k.y("key_polling_level_change" + TbadkCoreApplication.getCurrentAccountId(), DataExt.toJson(levePopData));
        }
    }

    public final boolean J(IconPopData iconPopData, IconPopData iconPopData2) {
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
}
