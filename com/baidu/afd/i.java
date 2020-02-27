package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void kN();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Dt;
        private boolean Du;
        private final HttpMessageListener Dv = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Dt.a(eVar);
                    if (eVar.Dq && eVar.Ds != null) {
                        com.baidu.tieba.recapp.report.c.cDn().a(com.baidu.tieba.recapp.report.f.a(a.this.Dt, eVar.Ds));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Dt = dVar;
            this.Dv.setSelfListener(true);
            this.Dv.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Dv);
        }

        @Override // com.baidu.afd.i
        public void kN() {
            if (!this.Du) {
                this.Du = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Dt.Dm);
                afdSyncRequestMessage.setTag(this.Dt.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
