package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void rt();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d YC;
        private boolean YD;
        private final HttpMessageListener YE = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.YC.a(eVar);
                    if (eVar.Yz && eVar.YB != null) {
                        com.baidu.tieba.recapp.report.d.drV().a(com.baidu.tieba.recapp.report.g.a(a.this.YC, eVar.YB));
                    }
                }
            }
        };

        public a(d dVar) {
            this.YC = dVar;
            this.YE.setSelfListener(true);
            this.YE.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.YE);
        }

        @Override // com.baidu.afd.i
        public void rt() {
            if (!this.YD) {
                this.YD = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.YC.Yv);
                afdSyncRequestMessage.setTag(this.YC.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
