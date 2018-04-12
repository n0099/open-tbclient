package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void ly();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d IY;
        private boolean IZ;
        private final HttpMessageListener Ja = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.IY.a(eVar);
                    if (eVar.IU && eVar.IX != null) {
                        com.baidu.tieba.recapp.report.b.bke().a(com.baidu.tieba.recapp.report.e.a(a.this.IY, eVar.IX));
                    }
                }
            }
        };

        public a(d dVar) {
            this.IY = dVar;
            this.Ja.setSelfListener(true);
            this.Ja.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ja);
        }

        @Override // com.baidu.afd.i
        public void ly() {
            if (!this.IZ) {
                this.IZ = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.IY.IQ);
                afdSyncRequestMessage.setTag(this.IY.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
