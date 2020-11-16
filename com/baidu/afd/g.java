package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class g implements j {
    private d YY;
    private boolean YZ;
    private final HttpMessageListener Za = new HttpMessageListener(1003397) { // from class: com.baidu.afd.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                g.this.YY.a(eVar);
                if (eVar.YV && eVar.YX != null) {
                    com.baidu.tieba.recapp.report.d.dAT().a(com.baidu.tieba.recapp.report.g.a(g.this.YY, eVar.YX));
                }
            }
        }
    };

    public g(d dVar) {
        this.YY = dVar;
        this.Za.setSelfListener(true);
        this.Za.setTag(dVar.getTag());
        MessageManager.getInstance().registerListener(this.Za);
    }

    @Override // com.baidu.afd.j
    public void rt() {
        if (!this.YZ) {
            this.YZ = true;
            AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.YY.YR);
            afdSyncRequestMessage.setTag(this.YY.getTag());
            MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
        }
    }
}
