package com.baidu.tbadk.core.feedManager;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ma5;
import com.repackage.wh8;
import com.repackage.za;
import tbclient.Personalized.DataRes;
/* loaded from: classes3.dex */
public class FeedRecModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public int b;
    public za c;

    /* loaded from: classes3.dex */
    public class a extends za {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedRecModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FeedRecModel feedRecModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedRecModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = feedRecModel;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
        @Override // com.repackage.za
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.a == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() != null) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof FeedRecRequest) {
                    FeedRecRequest feedRecRequest = (FeedRecRequest) extra;
                    boolean z2 = feedRecRequest.getLoadType() == 1;
                    z = feedRecRequest.getNeedForumlist() == 1;
                    r1 = z2;
                    if (responsedMessage.getError() == 0) {
                        this.a.a.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                        dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    BdLog.e("FeedRecManager.getInstance().getRecFeedData() :" + dataRes);
                    this.a.a.a(dataRes, r1, z);
                    return;
                }
            }
            z = false;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i, String str);
    }

    public FeedRecModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 1;
        this.c = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(BdUniqueId.gen());
        registerHttpTask();
        B();
        registerListener(this.c);
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ma5 ma5Var = new ma5(309264);
            ma5Var.setResponsedClass(RecPersonalizeSocketResponse.class);
            ma5Var.g(true);
            ma5Var.setPriority(4);
            MessageManager.getInstance().registerTask(ma5Var);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.a = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FeedRecRequest feedRecRequest = new FeedRecRequest();
            int i = this.b;
            this.b = i + 1;
            feedRecRequest.setRequestTime(i);
            feedRecRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            feedRecRequest.setNetType(NetMessage.NetType.HTTP);
            sendMessage(feedRecRequest);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void registerHttpTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, wh8.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
