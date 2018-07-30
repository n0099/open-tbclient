package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void op();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Pe;
        private boolean Pf;
        private final HttpMessageListener Pg = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Pe.a(eVar);
                    if (eVar.Pb && eVar.Pd != null) {
                        com.baidu.tieba.recapp.report.c.boi().a(com.baidu.tieba.recapp.report.f.a(a.this.Pe, eVar.Pd));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Pe = dVar;
            this.Pg.setSelfListener(true);
            this.Pg.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Pg);
        }

        @Override // com.baidu.afd.i
        public void op() {
            if (!this.Pf) {
                this.Pf = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Pe.OX);
                afdSyncRequestMessage.setTag(this.Pe.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
