package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes2.dex */
public interface i {
    void ro();

    /* loaded from: classes2.dex */
    public static class a implements i {
        private d Yi;
        private boolean Yj;
        private final HttpMessageListener Yk = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Yi.a(eVar);
                    if (eVar.Yf && eVar.Yh != null) {
                        com.baidu.tieba.recapp.report.d.doi().a(com.baidu.tieba.recapp.report.g.a(a.this.Yi, eVar.Yh));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Yi = dVar;
            this.Yk.setSelfListener(true);
            this.Yk.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Yk);
        }

        @Override // com.baidu.afd.i
        public void ro() {
            if (!this.Yj) {
                this.Yj = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Yi.Ya);
                afdSyncRequestMessage.setTag(this.Yi.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
