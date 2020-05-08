package com.baidu.live.k;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class a extends BdBaseModel {
    private InterfaceC0137a aQJ;
    private HttpMessageListener aQL = new HttpMessageListener(1021154) { // from class: com.baidu.live.k.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021154 && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.message.a) && a.this.aQJ != null) {
                com.baidu.live.message.a aVar = (com.baidu.live.message.a) httpResponsedMessage.getOrginalMessage();
                if (aVar.getTag() == a.this.aQK) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        a.this.aQJ.onFailed(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        a.this.aQJ.onSuccess(aVar.DL());
                    } else {
                        a.this.aQJ.onFailed(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private BdUniqueId aQK = BdUniqueId.gen();

    /* renamed from: com.baidu.live.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0137a {
        void onFailed(String str);

        void onSuccess(int i);
    }

    public a() {
        setUniqueId(this.aQK);
        xB();
        registerListener(this.aQL);
    }

    private void xB() {
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

    public void a(InterfaceC0137a interfaceC0137a) {
        this.aQJ = interfaceC0137a;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.aQL != null) {
            MessageManager.getInstance().unRegisterListener(this.aQL);
        }
    }
}
