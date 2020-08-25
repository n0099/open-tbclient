package com.baidu.tbadk.clientConfig;

import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes2.dex */
public class ClientConfigModel extends BdBaseModel {
    private a dUq;
    private final com.baidu.adp.framework.listener.a dUr;

    public ClientConfigModel(BdBaseFragmentActivity<?> bdBaseFragmentActivity, a aVar) {
        super(bdBaseFragmentActivity.getPageContext());
        this.dUr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039) { // from class: com.baidu.tbadk.clientConfig.ClientConfigModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (!ClientConfigModel.this.checkMessageIsBelongToCurPage(responsedMessage)) {
                    if (ClientConfigModel.this.dUq != null) {
                        ClientConfigModel.this.dUq.onError("");
                    }
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    String errorString = responsedMessage.getErrorString();
                    String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    if (ClientConfigModel.this.dUq != null) {
                        ClientConfigModel.this.dUq.onError(string);
                    }
                } else if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                    ClientConfigModel.this.a(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                    ClientConfigModel.this.a(((ClientConfigSocketResponse) responsedMessage).getData());
                } else if (ClientConfigModel.this.dUq != null) {
                    ClientConfigModel.this.dUq.onError("");
                }
            }
        };
        this.dUq = aVar;
        registerListener(this.dUr);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void yL(String str) {
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
            if (this.dUq != null) {
                this.dUq.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
            }
        } else if (this.dUq != null) {
            this.dUq.an(dataRes);
        }
    }
}
