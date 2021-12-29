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
import tbclient.Personalized.DataRes;
/* loaded from: classes11.dex */
public class FeedRecModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f41646e;

    /* renamed from: f  reason: collision with root package name */
    public int f41647f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f41648g;

    /* loaded from: classes11.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FeedRecModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FeedRecModel feedRecModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {feedRecModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
        @Override // c.a.d.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || this.a.f41646e == null) {
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
                        this.a.f41646e.onLoadError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeSocketResponse) {
                        dataRes = ((RecPersonalizeSocketResponse) responsedMessage).getResultData();
                    } else if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    BdLog.e("FeedRecManager.getInstance().getRecFeedData() :" + dataRes);
                    this.a.f41646e.a(dataRes, r1, z);
                    return;
                }
            }
            z = false;
            if (responsedMessage.getError() == 0) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(DataRes dataRes, boolean z, boolean z2);

        void onLoadError(int i2, String str);
    }

    public FeedRecModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41647f = 1;
        this.f41648g = new a(this, CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
        setUniqueId(BdUniqueId.gen());
        x();
        y();
        registerListener(this.f41648g);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            FeedRecRequest feedRecRequest = new FeedRecRequest();
            int i2 = this.f41647f;
            this.f41647f = i2 + 1;
            feedRecRequest.setRequestTime(i2);
            feedRecRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            feedRecRequest.setNetType(NetMessage.NetType.HTTP);
            sendMessage(feedRecRequest);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, c.a.t0.w3.f0.a.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.a1.b bVar = new c.a.s0.a1.b(309264);
            bVar.setResponsedClass(RecPersonalizeSocketResponse.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.f41646e = bVar;
        }
    }
}
