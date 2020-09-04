package com.baidu.afd;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public interface i {
    void ro();

    /* loaded from: classes.dex */
    public static class a implements i {
        private d Yk;
        private boolean Yl;
        private final HttpMessageListener Ym = new HttpMessageListener(1003397) { // from class: com.baidu.afd.i.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003397 && (httpResponsedMessage instanceof AfdSyncResponseMessage)) {
                    e eVar = ((AfdSyncResponseMessage) httpResponsedMessage).adModel;
                    a.this.Yk.a(eVar);
                    if (eVar.Yh && eVar.Yj != null) {
                        com.baidu.tieba.recapp.report.d.dol().a(com.baidu.tieba.recapp.report.g.a(a.this.Yk, eVar.Yj));
                    }
                }
            }
        };

        public a(d dVar) {
            this.Yk = dVar;
            this.Ym.setSelfListener(true);
            this.Ym.setTag(dVar.getTag());
            MessageManager.getInstance().registerListener(this.Ym);
        }

        @Override // com.baidu.afd.i
        public void ro() {
            if (!this.Yl) {
                this.Yl = true;
                AfdSyncRequestMessage afdSyncRequestMessage = new AfdSyncRequestMessage(this.Yk.Yc);
                afdSyncRequestMessage.setTag(this.Yk.getTag());
                MessageManager.getInstance().sendMessage(afdSyncRequestMessage);
            }
        }
    }
}
