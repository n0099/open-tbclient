package com.baidu.live.m;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class a extends BdBaseModel {
    private InterfaceC0190a bot;
    private HttpMessageListener bov = new HttpMessageListener(1021154) { // from class: com.baidu.live.m.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021154 && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.message.a) && a.this.bot != null) {
                com.baidu.live.message.a aVar = (com.baidu.live.message.a) httpResponsedMessage.getOrginalMessage();
                if (aVar.getTag() == a.this.bou) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        a.this.bot.onFailed(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        a.this.bot.onSuccess(aVar.Oc());
                    } else {
                        a.this.bot.onFailed(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private BdUniqueId bou = BdUniqueId.gen();

    /* renamed from: com.baidu.live.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0190a {
        void onFailed(String str);

        void onSuccess(int i);
    }

    public a() {
        setUniqueId(this.bou);
        registerTask();
        registerListener(this.bov);
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021154, TbConfig.SERVER_ADDRESS + "ala/sdk/notice/updateAutomaticStatus");
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void i(String str, int i, int i2) {
        sendMessage(new com.baidu.live.message.a(str, i, i2));
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void a(InterfaceC0190a interfaceC0190a) {
        this.bot = interfaceC0190a;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.bov != null) {
            MessageManager.getInstance().unRegisterListener(this.bov);
        }
    }
}
