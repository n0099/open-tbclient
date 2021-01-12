package com.baidu.live.p;

import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.message.DailyTaskFinishResponseMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes10.dex */
public class d extends BdBaseModel {
    int brW = -1;
    private HttpMessageListener messageListener;

    /* loaded from: classes10.dex */
    public interface a {
        void KJ();

        void u(int i, String str);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void dE(int i) {
        HttpMessage httpMessage = new HttpMessage(1021067);
        httpMessage.addParam("task_id", i);
        sendMessage(httpMessage);
    }

    public void Nf() {
        Ng();
        b(new a() { // from class: com.baidu.live.p.d.1
            @Override // com.baidu.live.p.d.a
            public void KJ() {
            }

            @Override // com.baidu.live.p.d.a
            public void u(int i, String str) {
            }
        });
    }

    public void a(a aVar) {
        b(aVar);
    }

    public void setTaskId(int i) {
        this.brW = i;
    }

    private void b(final a aVar) {
        this.messageListener = new HttpMessageListener(1021067) { // from class: com.baidu.live.p.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021067 && (httpResponsedMessage instanceof DailyTaskFinishResponseMessage)) {
                    DailyTaskFinishResponseMessage dailyTaskFinishResponseMessage = (DailyTaskFinishResponseMessage) httpResponsedMessage;
                    if (dailyTaskFinishResponseMessage.getError() != 0 || !dailyTaskFinishResponseMessage.isSuccess()) {
                        aVar.u(dailyTaskFinishResponseMessage.getError(), dailyTaskFinishResponseMessage.getErrorString());
                    } else if (d.this.brW == 8) {
                        aVar.KJ();
                    }
                }
            }
        };
        registerListener(this.messageListener);
    }

    private void Ng() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021067, com.baidu.live.b.awh);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(DailyTaskFinishResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void Nh() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
        MessageManager.getInstance().unRegisterTask(1021067);
    }

    public void Ni() {
        MessageManager.getInstance().unRegisterListener(this.messageListener);
    }
}
