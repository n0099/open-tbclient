package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void pr();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d WR;
        private boolean WS;
        private final HttpMessageListener WT = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.WR.a(eVar);
                    if (eVar.WO && eVar.WQ != null) {
                        com.baidu.tieba.recapp.report.d.cOj().a(com.baidu.tieba.recapp.report.g.a(a.this.WR, eVar.WQ));
                    }
                }
            }
        };

        public a(d dVar) {
            this.WR = dVar;
            this.WT.setSelfListener(true);
            this.WT.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.WT);
        }

        @Override // com.baidu.afd.i
        public void pr() {
            if (!this.WS) {
                this.WS = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.WR.WK);
                afdSyncRequestMessage.setTag(this.WR.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
