package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.h.a<a> cHI;
    protected BdUniqueId mBdUniqueId;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a cHV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637) { // from class: com.baidu.tbadk.BdToken.activeConfig.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b.this.isLoading = false;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && b.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (b.this.cHI != null) {
                        b.this.cHI.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                a aVar = null;
                if (responsedMessage instanceof ActiveConfigSocketResMsg) {
                    aVar = ((ActiveConfigSocketResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof ActiveConfigHTTPResMsg) {
                    aVar = ((ActiveConfigHTTPResMsg) responsedMessage).getData();
                }
                n.axV().b(aVar);
                com.baidu.tbadk.core.f.a.aFy().c(aVar);
                if (b.this.cHI != null) {
                    b.this.cHI.onSuccess(aVar);
                }
            }
        }
    };

    public b(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        ayn();
        this.cHV.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.cHV);
    }

    public BdUniqueId getUniqueId() {
        return this.mBdUniqueId;
    }

    public void a(com.baidu.tbadk.h.a<a> aVar) {
        this.cHI = aVar;
    }

    public void aym() {
        if (!this.isLoading) {
            this.isLoading = true;
            ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
            activeConfigReqMsg.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(activeConfigReqMsg);
        }
    }

    private void ayn() {
        com.baidu.tieba.tbadkCore.a.a.a(309637, ActiveConfigSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, com.baidu.tieba.tbadkCore.a.a.bu(TbConfig.URL_ACTIVE_CONFIG, 309637));
        tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
