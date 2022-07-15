package com.baidu.tbadk.core.liveremind;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.LiveRemindFloatViewData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.d9;
import com.repackage.ly4;
import com.repackage.ma5;
import com.repackage.wh8;
import com.repackage.za;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LiveRemindModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdUniqueId b;
    public za c;

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRemindModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LiveRemindModel liveRemindModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveRemindModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = liveRemindModel;
        }

        @Override // com.repackage.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            YyExtData yyExtData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage != null || TbSingleton.getInstance().getIsNeedRemindLiveRoom()) {
                    LiveRemindFloatViewData liveRemindFloatViewData = null;
                    if (responsedMessage instanceof GetLiveRemindHttpResMessage) {
                        GetLiveRemindHttpResMessage getLiveRemindHttpResMessage = (GetLiveRemindHttpResMessage) responsedMessage;
                        liveRemindFloatViewData = getLiveRemindHttpResMessage.getLiveInfo();
                        yyExtData = getLiveRemindHttpResMessage.getYyExtData();
                    } else if (responsedMessage instanceof GetLiveRemindSocketMessage) {
                        GetLiveRemindSocketMessage getLiveRemindSocketMessage = (GetLiveRemindSocketMessage) responsedMessage;
                        liveRemindFloatViewData = getLiveRemindSocketMessage.getLiveInfo();
                        yyExtData = getLiveRemindSocketMessage.getYyExtData();
                    } else {
                        yyExtData = null;
                    }
                    if (liveRemindFloatViewData == null || ListUtils.isEmpty(liveRemindFloatViewData.getLiveInfoList())) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("view_top_params_key_image_url", liveRemindFloatViewData.getLiveInfoList().get(0).portrait);
                    hashMap.put("view_top_params_user_name", liveRemindFloatViewData.getLiveInfoList().get(0).title);
                    hashMap.put("view_top_params_key_desc", liveRemindFloatViewData.getLiveInfoList().get(0).desc);
                    hashMap.put("view_top_params_room_id", liveRemindFloatViewData.getLiveInfoList().get(0).room_id);
                    hashMap.put("view_top_params_btn_text", liveRemindFloatViewData.getLiveInfoList().get(0).btn_text);
                    hashMap.put("view_top_params_key_title", liveRemindFloatViewData.getLiveInfoList().get(0).title);
                    hashMap.put("view_top_params_key_nid", liveRemindFloatViewData.getLiveInfoList().get(0).feed_id);
                    hashMap.put("view_top_params_key_yyext", yyExtData);
                    hashMap.put("view_top_params_key_type", 2);
                    hashMap.put("view_top_params_is_breathe", Boolean.FALSE);
                    ly4.b(null, this.a.a, hashMap, 0L, 4000L);
                    ly4.a();
                    TbSingleton.getInstance().setIsNeedRemindLiveRoom(false);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRemindModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.c = new a(this, CmdConfigHttp.CMD_LIVE_REMIND_INFO, 309728);
        this.a = tbPageContext;
        setUniqueId(bdUniqueId);
        this.b = bdUniqueId;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_LIVE_REMIND_INFO, wh8.a(TbConfig.GET_LIVE_ROOM_REMIND_DATA, 309728));
        ma5 ma5Var = new ma5(309728);
        ma5Var.setResponsedClass(GetLiveRemindSocketMessage.class);
        ma5Var.g(true);
        ma5Var.h(false);
        MessageManager.getInstance().registerTask(ma5Var);
        tbHttpMessageTask.setResponsedClass(GetLiveRemindHttpResMessage.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        registerListener(this.c);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GetLiveRemindReqMessage getLiveRemindReqMessage = new GetLiveRemindReqMessage();
            getLiveRemindReqMessage.setTag(this.b);
            MessageManager.getInstance().sendMessage(getLiveRemindReqMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
