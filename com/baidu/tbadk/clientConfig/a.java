package com.baidu.tbadk.clientConfig;

import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.base.e;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.t;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class a extends e {
    private c SL;
    private final com.baidu.adp.framework.listener.a SM;

    public a(BdBaseFragmentActivity<?> bdBaseFragmentActivity, c cVar) {
        super(bdBaseFragmentActivity.getPageContext());
        this.SM = new b(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.SL = cVar;
        registerListener(this.SM);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void cd(String str) {
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType(str);
        sendMessage(clientConfigNetMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DataRes dataRes) {
        if (dataRes == null) {
            if (this.SL != null) {
                this.SL.onError(TbadkCoreApplication.m411getInst().getString(t.j.data_load_error));
            }
        } else if (this.SL != null) {
            this.SL.w(dataRes);
        }
    }
}
