package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void rt();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d YT;
        private boolean YU;
        private final HttpMessageListener YV = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.YT.a(eVar);
                    if (eVar.YQ && eVar.YS != null) {
                        com.baidu.tieba.recapp.report.d.dyN().a(com.baidu.tieba.recapp.report.g.a(a.this.YT, eVar.YS));
                    }
                }
            }
        };

        public a(d dVar) {
            this.YT = dVar;
            this.YV.setSelfListener(true);
            this.YV.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.YV);
        }

        @Override // com.baidu.afd.i
        public void rt() {
            if (!this.YU) {
                this.YU = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.YT.YM);
                afdSyncRequestMessage.setTag(this.YT.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
