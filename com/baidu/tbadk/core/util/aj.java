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
public class aj {
    private BdUniqueId aqv;
    private a aqw;
    private HttpMessageListener aqx = new HttpMessageListener(CmdConfigHttp.CMD_REMOVE_FANS) { // from class: com.baidu.tbadk.core.util.aj.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                long longValue = ((Long) orginalMessage.getExtra()).longValue();
                boolean z = httpResponsedMessage.getOrginalMessage().getTag() == aj.this.aqv;
                if (aj.this.aqw != null) {
                    aj.this.aqw.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), longValue, z);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, long j, boolean z);
    }

    public aj(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mPageContext = tbPageContext;
        this.aqv = bdUniqueId;
        this.aqx.setTag(bdUniqueId);
        this.mPageContext.registerListener(this.aqx);
        zn();
    }

    private static void zn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_REMOVE_FANS, TbConfig.SERVER_ADDRESS + TbConfig.URL_REMOVE_FANS);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void s(long j) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_REMOVE_FANS);
        httpMessage.addParam("fans_uid", j);
        httpMessage.setTag(this.aqv);
        httpMessage.setExtra(Long.valueOf(j));
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void a(a aVar) {
        this.aqw = aVar;
    }
}
