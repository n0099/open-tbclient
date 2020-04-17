package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void pr();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d WO;
        private boolean WP;
        private final HttpMessageListener WQ = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.WO.a(eVar);
                    if (eVar.WL && eVar.WN != null) {
                        com.baidu.tieba.recapp.report.d.cOl().a(com.baidu.tieba.recapp.report.g.a(a.this.WO, eVar.WN));
                    }
                }
            }
        };

        public a(d dVar) {
            this.WO = dVar;
            this.WQ.setSelfListener(true);
            this.WQ.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.WQ);
        }

        @Override // com.baidu.afd.i
        public void pr() {
            if (!this.WP) {
                this.WP = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.WO.WH);
                afdSyncRequestMessage.setTag(this.WO.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
