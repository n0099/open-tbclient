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
        private d Tr;
        private boolean Ts;
        private final HttpMessageListener Tt = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Tr.a(eVar);
                    if (eVar.To && eVar.Tq != null) {
                        com.baidu.tieba.recapp.report.c.bXA().a(com.baidu.tieba.recapp.report.f.a(a.this.Tr, eVar.Tq));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Tr = dVar;
            this.Tt.setSelfListener(true);
            this.Tt.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Tt);
        }

        @Override // com.baidu.afd.i
        public void pU() {
            if (!this.Ts) {
                this.Ts = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Tr.Tk);
                afdSyncRequestMessage.setTag(this.Tr.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
