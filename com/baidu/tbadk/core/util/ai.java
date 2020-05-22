package com.baidu.tbadk.core.util;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class ai {
    private BdUniqueId afZ;
    private a dND;
    private HttpMessageListener dNE = new HttpMessageListener(1003396) { // from class: com.baidu.tbadk.core.util.ai.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                long longValue = ((Long) orginalMessage.getExtra()).longValue();
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == ai.this.afZ;
                if (ai.this.dND != null) {
                    ai.this.dND.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), longValue, z);
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
        this.afZ = bdUniqueId;
        this.dNE.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.dNE);
        aUL();
    }

    private static void aUL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003396, TbConfig.SERVER_ADDRESS + TbConfig.URL_REMOVE_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void ce(long j) {
        HttpMessage httpMessage = new HttpMessage(1003396);
        httpMessage.addParam("fans_uid", j);
        httpMessage.setTag(this.afZ);
        httpMessage.setExtra(Long.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.dND = aVar;
    }
}
