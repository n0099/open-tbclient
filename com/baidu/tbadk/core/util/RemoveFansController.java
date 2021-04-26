package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class RemoveFansController {
    public IResultCallBack mCallBack;
    public HttpMessageListener mListener;
    public TbPageContext mPageContext;
    public BdUniqueId mUniqueId;

    /* loaded from: classes3.dex */
    public interface IResultCallBack {
        void onResultCallBack(int i2, String str, long j, boolean z);
    }

    public RemoveFansController(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        HttpMessageListener httpMessageListener = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tbadk.core.util.RemoveFansController.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Message<?> orginalMessage;
                if (httpResponsedMessage == null || (orginalMessage = httpResponsedMessage.getOrginalMessage()) == null || !(orginalMessage.getExtra() instanceof Long)) {
                    return;
                }
                long longValue = ((Long) orginalMessage.getExtra()).longValue();
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == RemoveFansController.this.mUniqueId;
                if (RemoveFansController.this.mCallBack != null) {
                    RemoveFansController.this.mCallBack.onResultCallBack(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), longValue, z);
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
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_REMOVE_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void removeFans(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_FANS);
        httpMessage.addParam("fans_uid", j);
        httpMessage.setTag(this.mUniqueId);
        httpMessage.setExtra(Long.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void setResultCallBack(IResultCallBack iResultCallBack) {
        this.mCallBack = iResultCallBack;
    }
}
