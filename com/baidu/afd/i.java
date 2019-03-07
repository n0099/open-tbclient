package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pU();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Tp;
        private boolean Tq;
        private final HttpMessageListener Tr = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Tp.a(eVar);
                    if (eVar.Tm && eVar.To != null) {
                        com.baidu.tieba.recapp.report.c.bXB().a(com.baidu.tieba.recapp.report.f.a(a.this.Tp, eVar.To));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Tp = dVar;
            this.Tr.setSelfListener(true);
            this.Tr.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Tr);
        }

        @Override // com.baidu.afd.i
        public void pU() {
            if (!this.Tq) {
                this.Tq = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Tp.Ti);
                afdSyncRequestMessage.setTag(this.Tp.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
