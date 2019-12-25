package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void kx();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d CV;
        private boolean CW;
        private final HttpMessageListener CX = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.CV.a(eVar);
                    if (eVar.CQ && eVar.CU != null) {
                        com.baidu.tieba.recapp.report.c.cAJ().a(com.baidu.tieba.recapp.report.f.a(a.this.CV, eVar.CU));
                    }
                }
            }
        };

        public a(d dVar) {
            this.CV = dVar;
            this.CX.setSelfListener(true);
            this.CX.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.CX);
        }

        @Override // com.baidu.afd.i
        public void kx() {
            if (!this.CW) {
                this.CW = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.CV.CM);
                afdSyncRequestMessage.setTag(this.CV.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
