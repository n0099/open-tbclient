package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BdToken.n;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tbadk.h.a<a> ewu;
    protected BdUniqueId mBdUniqueId;
    private boolean isLoading = false;
    private com.baidu.adp.framework.listener.a ewJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ACTIVE_CONFIG, 309637) { // from class: com.baidu.tbadk.BdToken.activeConfig.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a aVar;
            b.this.isLoading = false;
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && b.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    if (b.this.ewu != null) {
                        b.this.ewu.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof ActiveConfigSocketResMsg) {
                    aVar = ((ActiveConfigSocketResMsg) responsedMessage).getData();
                } else if (!(responsedMessage instanceof ActiveConfigHTTPResMsg)) {
                    aVar = null;
                } else {
                    aVar = ((ActiveConfigHTTPResMsg) responsedMessage).getData();
                }
                if ((responsedMessage.getOrginalMessage().getExtra() instanceof ActiveConfigReqMsg) && ((ActiveConfigReqMsg) responsedMessage.getOrginalMessage().getExtra()).launtchType == 0) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong("pref_key_active_config_info", System.currentTimeMillis());
                }
                if (aVar != null && aVar.eyG != null) {
                    if (b.this.ewu != null) {
                        b.this.ewu.aq(aVar);
                    }
                    if (aVar.eyG.is_first_up != 1) {
                        q.bjk().a(aVar.eyG);
                    }
                }
                if (aVar != null && b.this.bjP()) {
                    com.baidu.tbadk.core.sharedPref.b.bsO().putLong("pref_key_last_register_mission", System.currentTimeMillis());
                    n.bjf().c(aVar);
                    com.baidu.tbadk.core.f.a.bsK().d(aVar);
                    if (b.this.ewu != null) {
                        b.this.ewu.onSuccess(aVar);
                    }
                }
            }
        }
    };

    public b(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        bjQ();
        this.ewJ.setTag(getUniqueId());
        MessageManager.getInstance().registerListener(this.ewJ);
    }

    public BdUniqueId getUniqueId() {
        return this.mBdUniqueId;
    }

    public void a(com.baidu.tbadk.h.a<a> aVar) {
        this.ewu = aVar;
    }

    public boolean bjP() {
        return !UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bsO().getLong("pref_key_last_register_mission", 0L), System.currentTimeMillis());
    }

    public void c(boolean z, boolean z2, int i) {
        if (!this.isLoading) {
            if (!z) {
                this.isLoading = true;
            }
            com.baidu.tbadk.core.sharedPref.b.bsO().putLong("pref_key_last_active_config", System.currentTimeMillis());
            ActiveConfigReqMsg activeConfigReqMsg = new ActiveConfigReqMsg();
            activeConfigReqMsg.setFirstUp(z);
            activeConfigReqMsg.setSchemaUp(z2);
            activeConfigReqMsg.launtchType = i;
            activeConfigReqMsg.setTag(getUniqueId());
            MessageManager.getInstance().sendMessage(activeConfigReqMsg);
        }
    }

    private void bjQ() {
        com.baidu.tieba.tbadkCore.a.a.a(309637, ActiveConfigSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ACTIVE_CONFIG, com.baidu.tieba.tbadkCore.a.a.bN(TbConfig.URL_ACTIVE_CONFIG, 309637));
        tbHttpMessageTask.setResponsedClass(ActiveConfigHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
