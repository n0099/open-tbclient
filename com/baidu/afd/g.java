package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private d ZV;
    private boolean ZW;
    private final HttpMessageListener ZX = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.ZV.a(eVar);
                if (eVar.ZS && eVar.ZU != null) {
                    com.baidu.tieba.recapp.report.d.dGf().a(com.baidu.tieba.recapp.report.g.a(g.this.ZV, eVar.ZU));
                }
            }
        }
    };

    public g(d dVar) {
        this.ZV = dVar;
        this.ZX.setSelfListener(true);
        this.ZX.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.ZX);
    }

    @Override // com.baidu.afd.j
    public void rv() {
        if (!this.ZW) {
            this.ZW = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.ZV.ZO);
            afdSyncRequestMessage.setTag(this.ZV.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
