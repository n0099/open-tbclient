package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void ps();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d RF;
        private boolean RG;
        private final HttpMessageListener RH = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.RF.a(eVar);
                    if (eVar.RC && eVar.RE != null) {
                        com.baidu.tieba.recapp.report.c.bqQ().a(com.baidu.tieba.recapp.report.f.a(a.this.RF, eVar.RE));
                    }
                }
            }
        };

        public a(d dVar) {
            this.RF = dVar;
            this.RH.setSelfListener(true);
            this.RH.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.RH);
        }

        @Override // com.baidu.afd.i
        public void ps() {
            if (!this.RG) {
                this.RG = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.RF.Ry);
                afdSyncRequestMessage.setTag(this.RF.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
