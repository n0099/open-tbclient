package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void px();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Xg;
        private boolean Xh;
        private final HttpMessageListener Xi = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Xg.a(eVar);
                    if (eVar.Xc && eVar.Xf != null) {
                        com.baidu.tieba.recapp.report.d.cVA().a(com.baidu.tieba.recapp.report.g.a(a.this.Xg, eVar.Xf));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Xg = dVar;
            this.Xi.setSelfListener(true);
            this.Xi.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Xi);
        }

        @Override // com.baidu.afd.i
        public void px() {
            if (!this.Xh) {
                this.Xh = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Xg.WY);
                afdSyncRequestMessage.setTag(this.Xg.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
