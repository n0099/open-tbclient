package com.baidu.tbadk.BdToken.backUser;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes.dex */
public class b {
    private com.baidu.adp.framework.listener.a elx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_BACK_USER, 309689) { // from class: com.baidu.tbadk.BdToken.backUser.b.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.getOrginalMessage() != null && b.this.getUniqueId() == responsedMessage.getOrginalMessage().getTag() && !responsedMessage.hasError() && responsedMessage.getError() == 0) {
                a aVar = null;
                if (responsedMessage instanceof BackUserHTTPResMsg) {
                    aVar = ((BackUserHTTPResMsg) responsedMessage).getData();
                } else if (responsedMessage instanceof BackUserSocketResMsg) {
                    aVar = ((BackUserSocketResMsg) responsedMessage).getData();
                }
                if (aVar != null && aVar.enr) {
                    com.baidu.tbadk.core.sharedPref.b.bnH().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("pref_key_last_request_mission"), System.currentTimeMillis());
                    com.baidu.tbadk.core.f.a.bnD().bnE();
                }
            }
        }
    };
    protected BdUniqueId mBdUniqueId;

    public b(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
        beS();
        this.elx.setTag(this.mBdUniqueId);
        MessageManager.getInstance().registerListener(this.elx);
    }

    public void beT() {
        if (beU()) {
            BackUserReqMsg backUserReqMsg = new BackUserReqMsg();
            backUserReqMsg.setTag(this.mBdUniqueId);
            MessageManager.getInstance().sendMessage(backUserReqMsg);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.mBdUniqueId;
    }

    private void beS() {
        com.baidu.tieba.tbadkCore.a.a.a(309689, BackUserSocketResMsg.class, false, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_BACK_USER, com.baidu.tieba.tbadkCore.a.a.bJ(TbConfig.URL_BACK_USER, 309689));
        tbHttpMessageTask.setResponsedClass(BackUserHTTPResMsg.class);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private boolean beU() {
        return !UtilHelper.isSameDay(com.baidu.tbadk.core.sharedPref.b.bnH().getLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("pref_key_last_request_mission"), 0L), System.currentTimeMillis());
    }
}
