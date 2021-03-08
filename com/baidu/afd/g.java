package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private d abS;
    private boolean abT;
    private final HttpMessageListener abU = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.abS.a(eVar);
                if (eVar.abP && eVar.abR != null) {
                    com.baidu.tieba.recapp.report.e.dEC().a(com.baidu.tieba.recapp.report.h.a(g.this.abS, eVar.abR));
                }
            }
        }
    };

    public g(d dVar) {
        this.abS = dVar;
        this.abU.setSelfListener(true);
        this.abU.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.abU);
    }

    @Override // com.baidu.afd.j
    public void qV() {
        if (!this.abT) {
            this.abT = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.abS.abL);
            afdSyncRequestMessage.setTag(this.abS.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
