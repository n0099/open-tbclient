package com.baidu.tbadk.clientConfig;

import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.w;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes.dex */
public class ClientConfigModel extends BdBaseModel {
    private b Ra;
    private final com.baidu.adp.framework.listener.a Rb;

    public ClientConfigModel(BdBaseFragmentActivity<?> bdBaseFragmentActivity, b bVar) {
        super(bdBaseFragmentActivity.getPageContext());
        this.Rb = new a(this, CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.Ra = bVar;
        registerListener(this.Rb);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void bZ(String str) {
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
            if (this.Ra != null) {
                this.Ra.onError(TbadkCoreApplication.m9getInst().getString(w.l.data_load_error));
            }
        } else if (this.Ra != null) {
            this.Ra.z(dataRes);
        }
    }
}
