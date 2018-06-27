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
        private d Ph;
        private boolean Pi;
        private final HttpMessageListener Pj = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Ph.a(eVar);
                    if (eVar.Pe && eVar.Pg != null) {
                        com.baidu.tieba.recapp.report.b.bpD().a(com.baidu.tieba.recapp.report.e.a(a.this.Ph, eVar.Pg));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Ph = dVar;
            this.Pj.setSelfListener(true);
            this.Pj.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Pj);
        }

        @Override // com.baidu.afd.i
        public void on() {
            if (!this.Pi) {
                this.Pi = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Ph.Pa);
                afdSyncRequestMessage.setTag(this.Ph.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
