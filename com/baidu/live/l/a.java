package com.baidu.live.l;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class a extends BdBaseModel {
    private InterfaceC0177a beU;
    private HttpMessageListener beW = new HttpMessageListener(1021154) { // from class: com.baidu.live.l.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021154 && (httpResponsedMessage.getOrginalMessage() instanceof com.baidu.live.message.a) && a.this.beU != null) {
                com.baidu.live.message.a aVar = (com.baidu.live.message.a) httpResponsedMessage.getOrginalMessage();
                if (aVar.getTag() == a.this.beV) {
                    if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
                        a.this.beU.onFailed(httpResponsedMessage.getErrorString());
                    } else if (httpResponsedMessage.getError() == 0) {
                        a.this.beU.onSuccess(aVar.LB());
                    } else {
                        a.this.beU.onFailed(httpResponsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private BdUniqueId beV = BdUniqueId.gen();

    /* renamed from: com.baidu.live.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0177a {
        void onFailed(String str);

        void onSuccess(int i);
    }

    public a() {
        setUniqueId(this.beV);
        registerTask();
        registerListener(this.beW);
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

    public void a(InterfaceC0177a interfaceC0177a) {
        this.beU = interfaceC0177a;
    }

    public void onDestroy() {
        cancelMessage();
        if (this.beW != null) {
            MessageManager.getInstance().unRegisterListener(this.beW);
        }
    }
}
