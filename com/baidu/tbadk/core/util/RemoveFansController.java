package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RemoveFansController {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IResultCallBack mCallBack;
    public HttpMessageListener mListener;
    public TbPageContext mPageContext;
    public BdUniqueId mUniqueId;

    /* loaded from: classes5.dex */
    public interface IResultCallBack {
        void onResultCallBack(int i2, String str, long j2, boolean z);
    }

    public RemoveFansController(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        HttpMessageListener httpMessageListener = new HttpMessageListener(this, CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tbadk.core.util.RemoveFansController.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RemoveFansController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Message<?> orginalMessage;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) || httpResponsedMessage == null || (orginalMessage = httpResponsedMessage.getOrginalMessage()) == null || !(orginalMessage.getExtra() instanceof Long)) {
                    return;
                }
                long longValue = ((Long) orginalMessage.getExtra()).longValue();
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == this.this$0.mUniqueId;
                if (this.this$0.mCallBack != null) {
                    this.this$0.mCallBack.onResultCallBack(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), longValue, z);
                }
            }
        };
        this.mListener = httpMessageListener;
        this.mPageContext = tbPageContext;
        this.mUniqueId = bdUniqueId;
        httpMessageListener.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.mListener);
        registerRemoveFansTask();
    }

    public static void registerRemoveFansTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_REMOVE_FANS);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void removeFans(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_FANS);
            httpMessage.addParam("fans_uid", j2);
            httpMessage.setTag(this.mUniqueId);
            httpMessage.setExtra(Long.valueOf(j2));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void setResultCallBack(IResultCallBack iResultCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iResultCallBack) == null) {
            this.mCallBack = iResultCallBack;
        }
    }
}
