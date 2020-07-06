package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void pO();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d XK;
        private boolean XL;
        private final HttpMessageListener XM = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.XK.a(eVar);
                    if (eVar.XH && eVar.XJ != null) {
                        com.baidu.tieba.recapp.report.d.cZR().a(com.baidu.tieba.recapp.report.g.a(a.this.XK, eVar.XJ));
                    }
                }
            }
        };

        public a(d dVar) {
            this.XK = dVar;
            this.XM.setSelfListener(true);
            this.XM.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.XM);
        }

        @Override // com.baidu.afd.i
        public void pO() {
            if (!this.XL) {
                this.XL = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.XK.XD);
                afdSyncRequestMessage.setTag(this.XK.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
