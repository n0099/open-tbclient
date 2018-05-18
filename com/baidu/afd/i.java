package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void lx();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d IT;
        private boolean IU;
        private final HttpMessageListener IW = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.IT.a(eVar);
                    if (eVar.IQ && eVar.IS != null) {
                        com.baidu.tieba.recapp.report.b.bkd().a(com.baidu.tieba.recapp.report.e.a(a.this.IT, eVar.IS));
                    }
                }
            }
        };

        public a(d dVar) {
            this.IT = dVar;
            this.IW.setSelfListener(true);
            this.IW.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.IW);
        }

        @Override // com.baidu.afd.i
        public void lx() {
            if (!this.IU) {
                this.IU = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.IT.IL);
                afdSyncRequestMessage.setTag(this.IT.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
