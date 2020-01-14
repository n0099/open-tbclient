package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void ky();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Da;
        private boolean Db;
        private final HttpMessageListener Dc = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Da.a(eVar);
                    if (eVar.CX && eVar.CZ != null) {
                        com.baidu.tieba.recapp.report.c.cBR().a(com.baidu.tieba.recapp.report.f.a(a.this.Da, eVar.CZ));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Da = dVar;
            this.Dc.setSelfListener(true);
            this.Dc.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Dc);
        }

        @Override // com.baidu.afd.i
        public void ky() {
            if (!this.Db) {
                this.Db = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Da.CT);
                afdSyncRequestMessage.setTag(this.Da.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
