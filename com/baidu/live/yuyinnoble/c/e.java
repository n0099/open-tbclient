package com.baidu.live.yuyinnoble.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.message.AlaNobleUserListResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class e extends BdBaseModel {
    private HttpMessageListener bxJ = new HttpMessageListener(1031032) { // from class: com.baidu.live.yuyinnoble.c.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && e.this.ceD != null) {
                com.baidu.live.noble.data.d QN = ((AlaNobleUserListResponseMessage) httpResponsedMessage).QN();
                if (QN != null) {
                    e.this.ceD.a(QN);
                } else {
                    e.this.ceD.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private a ceD;
    private TbPageContext mPageContext;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.live.noble.data.d dVar);

        void onFail(int i, String str);
    }

    public e(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.ceD = aVar;
        Rt();
        MessageManager.getInstance().registerListener(this.bxJ);
    }

    private void Rt() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031032, com.baidu.live.a.aAH + "ala/audio/live/ulist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaNobleUserListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void jt(String str) {
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
        MessageManager.getInstance().unRegisterListener(this.bxJ);
    }
}
