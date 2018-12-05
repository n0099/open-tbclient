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
/* loaded from: classes.dex */
public class ai {
    private BdUniqueId aBS;
    private a aBT;
    private HttpMessageListener aBU = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tbadk.core.util.ai.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                long longValue = ((Long) orginalMessage.getExtra()).longValue();
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == ai.this.aBS;
                if (ai.this.aBT != null) {
                    ai.this.aBT.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), longValue, z);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, long j, boolean z);
    }

    public ai(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aBS = bdUniqueId;
        this.aBU.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.aBU);
        DI();
    }

    private static void DI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_REMOVE_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void F(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_FANS);
        httpMessage.addParam("fans_uid", j);
        httpMessage.setTag(this.aBS);
        httpMessage.setExtra(Long.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.aBT = aVar;
    }
}
