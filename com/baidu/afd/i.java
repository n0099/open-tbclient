package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void kg();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d AQ;
        private boolean AR;
        private final HttpMessageListener AT = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.AQ.a(eVar);
                    if (eVar.AN && eVar.AP != null) {
                        com.baidu.tieba.recapp.report.c.cgI().a(com.baidu.tieba.recapp.report.f.a(a.this.AQ, eVar.AP));
                    }
                }
            }
        };

        public a(d dVar) {
            this.AQ = dVar;
            this.AT.setSelfListener(true);
            this.AT.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.AT);
        }

        @Override // com.baidu.afd.i
        public void kg() {
            if (!this.AR) {
                this.AR = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.AQ.AI);
                afdSyncRequestMessage.setTag(this.AQ.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
