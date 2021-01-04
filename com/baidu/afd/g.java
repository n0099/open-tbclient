package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private d aaE;
    private boolean aaF;
    private final HttpMessageListener aaG = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.aaE.a(eVar);
                if (eVar.aaB && eVar.aaD != null) {
                    com.baidu.tieba.recapp.report.e.dFV().a(com.baidu.tieba.recapp.report.h.a(g.this.aaE, eVar.aaD));
                }
            }
        }
    };

    public g(d dVar) {
        this.aaE = dVar;
        this.aaG.setSelfListener(true);
        this.aaG.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.aaG);
    }

    @Override // com.baidu.afd.j
    public void qX() {
        if (!this.aaF) {
            this.aaF = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.aaE.aax);
            afdSyncRequestMessage.setTag(this.aaE.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
