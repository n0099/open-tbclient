package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pA();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d RX;
        private boolean RY;
        private final HttpMessageListener RZ = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.RX.a(eVar);
                    if (eVar.RU && eVar.RW != null) {
                        com.baidu.tieba.recapp.report.c.buf().a(com.baidu.tieba.recapp.report.f.a(a.this.RX, eVar.RW));
                    }
                }
            }
        };

        public a(d dVar) {
            this.RX = dVar;
            this.RZ.setSelfListener(true);
            this.RZ.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.RZ);
        }

        @Override // com.baidu.afd.i
        public void pA() {
            if (!this.RY) {
                this.RY = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.RX.RP);
                afdSyncRequestMessage.setTag(this.RX.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
