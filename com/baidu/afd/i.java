package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void on();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Pf;
        private boolean Pg;
        private final HttpMessageListener Ph = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Pf.a(eVar);
                    if (eVar.Pc && eVar.Pe != null) {
                        com.baidu.tieba.recapp.report.b.bpc().a(com.baidu.tieba.recapp.report.e.a(a.this.Pf, eVar.Pe));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Pf = dVar;
            this.Ph.setSelfListener(true);
            this.Ph.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ph);
        }

        @Override // com.baidu.afd.i
        public void on() {
            if (!this.Pg) {
                this.Pg = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Pf.OY);
                afdSyncRequestMessage.setTag(this.Pf.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
