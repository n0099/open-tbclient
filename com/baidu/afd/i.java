package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pl();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Rs;
        private boolean Rt;
        private final HttpMessageListener Ru = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Rs.a(eVar);
                    if (eVar.Rp && eVar.Rr != null) {
                        com.baidu.tieba.recapp.report.c.cjE().a(com.baidu.tieba.recapp.report.f.a(a.this.Rs, eVar.Rr));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Rs = dVar;
            this.Ru.setSelfListener(true);
            this.Ru.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ru);
        }

        @Override // com.baidu.afd.i
        public void pl() {
            if (!this.Rt) {
                this.Rt = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Rs.Rl);
                afdSyncRequestMessage.setTag(this.Rs.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
