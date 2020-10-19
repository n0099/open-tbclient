package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void rt();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d YS;
        private boolean YT;
        private final HttpMessageListener YU = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.YS.a(eVar);
                    if (eVar.YP && eVar.YR != null) {
                        com.baidu.tieba.recapp.report.d.dvG().a(com.baidu.tieba.recapp.report.g.a(a.this.YS, eVar.YR));
                    }
                }
            }
        };

        public a(d dVar) {
            this.YS = dVar;
            this.YU.setSelfListener(true);
            this.YU.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.YU);
        }

        @Override // com.baidu.afd.i
        public void rt() {
            if (!this.YT) {
                this.YT = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.YS.YL);
                afdSyncRequestMessage.setTag(this.YS.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
