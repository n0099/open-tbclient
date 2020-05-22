package com.baidu.live.noble.c;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.noble.http.AlaNobleUserListResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class e extends BdBaseModel {
    private a aXY;
    private HttpMessageListener aXZ = new HttpMessageListener(1021190) { // from class: com.baidu.live.noble.c.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaNobleUserListResponseMessage) && e.this.aXY != null) {
                com.baidu.live.noble.data.b FD = ((AlaNobleUserListResponseMessage) httpResponsedMessage).FD();
                if (FD != null) {
                    e.this.aXY.a(FD);
                } else {
                    e.this.aXY.onFail(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.live.noble.data.b bVar);

        void onFail(int i, String str);
    }

    public e(TbPageContext tbPageContext, a aVar) {
        this.mPageContext = tbPageContext;
        this.aXY = aVar;
        FJ();
        MessageManager.getInstance().registerListener(this.aXZ);
    }

    private void FJ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021190, TbConfig.SERVER_HOST + "liveserver/noble/ulist");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaNobleUserListResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void at(String str, String str2) {
        if (!StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
            HttpMessage httpMessage = new HttpMessage(1021190);
            httpMessage.addParam("scene_from", q.yu());
            httpMessage.addParam("anchor_id", str);
            httpMessage.addParam("live_id", str2);
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
        MessageManager.getInstance().unRegisterTask(1021190);
        MessageManager.getInstance().unRegisterListener(this.aXZ);
    }
}
