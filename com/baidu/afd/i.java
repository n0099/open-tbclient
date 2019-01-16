package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pB();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Si;
        private boolean Sj;
        private final HttpMessageListener Sk = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Si.a(eVar);
                    if (eVar.Sf && eVar.Sh != null) {
                        com.baidu.tieba.recapp.report.c.bwO().a(com.baidu.tieba.recapp.report.f.a(a.this.Si, eVar.Sh));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Si = dVar;
            this.Sk.setSelfListener(true);
            this.Sk.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Sk);
        }

        @Override // com.baidu.afd.i
        public void pB() {
            if (!this.Sj) {
                this.Sj = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Si.Sb);
                afdSyncRequestMessage.setTag(this.Si.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
