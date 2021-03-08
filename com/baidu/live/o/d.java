package com.baidu.live.o;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.message.AlaBarrageCardSendHttpResponseMessage;
import com.baidu.live.message.DailyTaskFinishResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class d extends BdBaseModel {
    private a bwY;
    int bwZ = -1;
    private HttpMessageListener bxa = new HttpMessageListener(1021235) { // from class: com.baidu.live.o.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaBarrageCardSendHttpResponseMessage) && httpResponsedMessage.getCmd() == 1021235) {
                AlaBarrageCardSendHttpResponseMessage alaBarrageCardSendHttpResponseMessage = (AlaBarrageCardSendHttpResponseMessage) httpResponsedMessage;
                if (alaBarrageCardSendHttpResponseMessage.getError() == 0) {
                    if (d.this.bwY != null) {
                        d.this.bwY.hw(alaBarrageCardSendHttpResponseMessage.getErrorString());
                    }
                } else if (d.this.bwY != null) {
                    d.this.bwY.y(alaBarrageCardSendHttpResponseMessage.getError(), alaBarrageCardSendHttpResponseMessage.getErrorString());
                }
            }
        }
    };
    private HttpMessageListener messageListener;

    /* loaded from: classes10.dex */
    public interface a {
        void hw(String str);

        void y(int i, String str);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void Mk();

        void x(int i, String str);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dL(int i) {
        HttpMessage httpMessage = new HttpMessage(1021067);
        httpMessage.addParam("task_id", i);
        sendMessage(httpMessage);
    }

    public void h(long j, String str) {
        HttpMessage httpMessage = new HttpMessage(1021235);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("user_id", str);
        sendMessage(httpMessage);
    }

    public void OG() {
        OH();
        OI();
        b(new b() { // from class: com.baidu.live.o.d.1
            @Override // com.baidu.live.o.d.b
            public void Mk() {
            }

            @Override // com.baidu.live.o.d.b
            public void x(int i, String str) {
            }
        });
    }

    public void a(b bVar) {
        b(bVar);
    }

    public void a(a aVar) {
        this.bwY = aVar;
    }

    public void setTaskId(int i) {
        this.bwZ = i;
    }

    private void b(final b bVar) {
        this.messageListener = new HttpMessageListener(1021067) { // from class: com.baidu.live.o.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof DailyTaskFinishResponseMessage)) {
                    DailyTaskFinishResponseMessage dailyTaskFinishResponseMessage = (DailyTaskFinishResponseMessage) httpResponsedMessage;
                    if (dailyTaskFinishResponseMessage.getError() != 0 || !dailyTaskFinishResponseMessage.isSuccess()) {
                        bVar.x(dailyTaskFinishResponseMessage.getError(), dailyTaskFinishResponseMessage.getErrorString());
                    } else if (d.this.bwZ == 8) {
                        bVar.Mk();
                    }
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void OH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.axw);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DailyTaskFinishResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private void OI() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021235, TbConfig.SERVER_ADDRESS + "ala/live/finishWatchTask");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaBarrageCardSendHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.bxa);
    }

    public void OJ() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterListener(this.bxa);
        MessageManager.getInstance().unRegisterTask(1021067);
        MessageManager.getInstance().unRegisterTask(1021235);
    }

    public void OK() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterListener(this.bxa);
    }
}
