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
        private d Rb;
        private boolean Rc;
        private final HttpMessageListener Rd = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Rb.a(eVar);
                    if (eVar.QY && eVar.Ra != null) {
                        com.baidu.tieba.recapp.report.c.cfH().a(com.baidu.tieba.recapp.report.f.a(a.this.Rb, eVar.Ra));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Rb = dVar;
            this.Rd.setSelfListener(true);
            this.Rd.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Rd);
        }

        @Override // com.baidu.afd.i
        public void oP() {
            if (!this.Rc) {
                this.Rc = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Rb.QU);
                afdSyncRequestMessage.setTag(this.Rb.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
