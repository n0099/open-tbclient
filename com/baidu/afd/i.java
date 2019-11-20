package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void kg();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Ap;
        private boolean Aq;
        private final HttpMessageListener Ar = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Ap.a(eVar);
                    if (eVar.Am && eVar.Ao != null) {
                        com.baidu.tieba.recapp.report.c.cgG().a(com.baidu.tieba.recapp.report.f.a(a.this.Ap, eVar.Ao));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Ap = dVar;
            this.Ar.setSelfListener(true);
            this.Ar.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ar);
        }

        @Override // com.baidu.afd.i
        public void kg() {
            if (!this.Aq) {
                this.Aq = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Ap.Ai);
                afdSyncRequestMessage.setTag(this.Ap.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
