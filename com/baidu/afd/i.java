package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void oP();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Rc;
        private boolean Rd;
        private final HttpMessageListener Re = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Rc.a(eVar);
                    if (eVar.QZ && eVar.Rb != null) {
                        com.baidu.tieba.recapp.report.c.cfE().a(com.baidu.tieba.recapp.report.f.a(a.this.Rc, eVar.Rb));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Rc = dVar;
            this.Re.setSelfListener(true);
            this.Re.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Re);
        }

        @Override // com.baidu.afd.i
        public void oP() {
            if (!this.Rd) {
                this.Rd = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Rc.QV);
                afdSyncRequestMessage.setTag(this.Rc.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
