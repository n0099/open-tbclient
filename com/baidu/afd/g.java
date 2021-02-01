package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private final HttpMessageListener aaA = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.aay.a(eVar);
                if (eVar.aav && eVar.aax != null) {
                    com.baidu.tieba.recapp.report.e.dEm().a(com.baidu.tieba.recapp.report.h.a(g.this.aay, eVar.aax));
                }
            }
        }
    };
    private d aay;
    private boolean aaz;

    public g(d dVar) {
        this.aay = dVar;
        this.aaA.setSelfListener(true);
        this.aaA.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.aaA);
    }

    @Override // com.baidu.afd.j
    public void qV() {
        if (!this.aaz) {
            this.aaz = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.aay.aar);
            afdSyncRequestMessage.setTag(this.aay.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
