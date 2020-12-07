package com.baidu.live.yuyinnoble.d;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.yuyinnoble.http.AlaNobleUserListResponseMessage;
/* loaded from: classes4.dex */
public class e extends BdBaseModel {
    private a bXU;
    private HttpMessageListener bsW = new HttpMessageListener(1031032) { // from class: com.baidu.live.yuyinnoble.d.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && e.this.bXU != null) {
                com.baidu.live.yuyinnoble.c.a ZX = ((AlaNobleUserListResponseMessage) httpResponsedMessage).ZX();
                if (ZX != null) {
                    e.this.bXU.a(ZX);
                } else {
                    e.this.bXU.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.live.yuyinnoble.c.a aVar);

        void onFail(int i, String str);
    }

    public e(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.bXU = aVar;
        Qp();
        MessageManager.getInstance().registerListener(this.bsW);
    }

    private void Qp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031032, TbConfig.SERVER_ADDRESS + "ala/audio/live/ulist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaNobleUserListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void jA(String str) {
        if (!StringUtils.isNull(str)) {
            HttpMessage httpMessage = new HttpMessage(1031032);
            httpMessage.addParam("live_id", str);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterTask(1031032);
        MessageManager.getInstance().unRegisterListener(this.bsW);
    }
}
