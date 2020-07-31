package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void pP();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d XC;
        private boolean XD;
        private final HttpMessageListener XE = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.XC.a(eVar);
                    if (eVar.Xz && eVar.XB != null) {
                        com.baidu.tieba.recapp.report.d.dcY().a(com.baidu.tieba.recapp.report.g.a(a.this.XC, eVar.XB));
                    }
                }
            }
        };

        public a(d dVar) {
            this.XC = dVar;
            this.XE.setSelfListener(true);
            this.XE.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.XE);
        }

        @Override // com.baidu.afd.i
        public void pP() {
            if (!this.XD) {
                this.XD = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.XC.Xv);
                afdSyncRequestMessage.setTag(this.XC.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
