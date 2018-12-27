package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void px();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d RZ;
        private boolean Sa;
        private final HttpMessageListener Sb = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.RZ.a(eVar);
                    if (eVar.RW && eVar.RY != null) {
                        com.baidu.tieba.recapp.report.c.bwf().a(com.baidu.tieba.recapp.report.f.a(a.this.RZ, eVar.RY));
                    }
                }
            }
        };

        public a(d dVar) {
            this.RZ = dVar;
            this.Sb.setSelfListener(true);
            this.Sb.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Sb);
        }

        @Override // com.baidu.afd.i
        public void px() {
            if (!this.Sa) {
                this.Sa = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.RZ.RR);
                afdSyncRequestMessage.setTag(this.RZ.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
