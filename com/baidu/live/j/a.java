package com.baidu.live.j;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class a extends BdBaseModel {
    private InterfaceC0082a asE;
    private HttpMessageListener asF = new HttpMessageListener(1021154) { // from class: com.baidu.live.j.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021154 && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.message.a) && a.this.asE != null) {
                com.baidu.live.message.a aVar = (com.baidu.live.message.a) httpResponsedMessage.getOrginalMessage();
                if (aVar.getTag() == a.this.aoz) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        a.this.asE.onFailed(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        a.this.asE.onSuccess(aVar.wv());
                    } else {
                        a.this.asE.onFailed(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private BdUniqueId aoz = BdUniqueId.gen();

    /* renamed from: com.baidu.live.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0082a {
        void onFailed(String str);

        void onSuccess(int i);
    }

    public a() {
        setUniqueId(this.aoz);
        rT();
        registerListener(this.asF);
    }

    private void rT() {
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

    public void a(InterfaceC0082a interfaceC0082a) {
        this.asE = interfaceC0082a;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.asF != null) {
            MessageManager.getInstance().unRegisterListener(this.asF);
        }
    }
}
