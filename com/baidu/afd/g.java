package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private d aaC;
    private boolean aaD;
    private final HttpMessageListener aaE = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.aaC.a(eVar);
                if (eVar.aaz && eVar.aaB != null) {
                    com.baidu.tieba.recapp.report.e.dCe().a(com.baidu.tieba.recapp.report.h.a(g.this.aaC, eVar.aaB));
                }
            }
        }
    };

    public g(d dVar) {
        this.aaC = dVar;
        this.aaE.setSelfListener(true);
        this.aaE.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.aaE);
    }

    @Override // com.baidu.afd.j
    public void qX() {
        if (!this.aaD) {
            this.aaD = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.aaC.aav);
            afdSyncRequestMessage.setTag(this.aaC.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
