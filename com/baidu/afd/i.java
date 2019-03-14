package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pU();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Tq;
        private boolean Tr;
        private final HttpMessageListener Ts = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Tq.a(eVar);
                    if (eVar.Tn && eVar.Tp != null) {
                        com.baidu.tieba.recapp.report.c.bXE().a(com.baidu.tieba.recapp.report.f.a(a.this.Tq, eVar.Tp));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Tq = dVar;
            this.Ts.setSelfListener(true);
            this.Ts.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ts);
        }

        @Override // com.baidu.afd.i
        public void pU() {
            if (!this.Tr) {
                this.Tr = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Tq.Tj);
                afdSyncRequestMessage.setTag(this.Tq.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
