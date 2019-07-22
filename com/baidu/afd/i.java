package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public interface i {
    void pk();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Rt;
        private boolean Ru;
        private final HttpMessageListener Rv = new HttpMessageListener(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Rt.a(eVar);
                    if (eVar.Rq && eVar.Rs != null) {
                        com.baidu.tieba.recapp.report.c.ciy().a(com.baidu.tieba.recapp.report.f.a(a.this.Rt, eVar.Rs));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Rt = dVar;
            this.Rv.setSelfListener(true);
            this.Rv.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Rv);
        }

        @Override // com.baidu.afd.i
        public void pk() {
            if (!this.Ru) {
                this.Ru = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Rt.Rm);
                afdSyncRequestMessage.setTag(this.Rt.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
