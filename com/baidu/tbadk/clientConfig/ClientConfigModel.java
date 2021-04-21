package com.baidu.tbadk.clientConfig;

import com.baidu.adp.base.BdBaseFragmentActivity;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.R;
import tbclient.GetClientConfig.DataRes;
/* loaded from: classes3.dex */
public class ClientConfigModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.p.a f12816e;

    /* renamed from: f  reason: collision with root package name */
    public final d.b.c.c.g.a f12817f;

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (!ClientConfigModel.this.v(responsedMessage)) {
                if (ClientConfigModel.this.f12816e != null) {
                    ClientConfigModel.this.f12816e.onError("");
                }
            } else if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                if (responsedMessage instanceof ClientConfigHttpProtoResponse) {
                    ClientConfigModel.this.w(((ClientConfigHttpProtoResponse) responsedMessage).getData());
                } else if (responsedMessage instanceof ClientConfigSocketResponse) {
                    ClientConfigModel.this.w(((ClientConfigSocketResponse) responsedMessage).getData());
                } else if (ClientConfigModel.this.f12816e != null) {
                    ClientConfigModel.this.f12816e.onError("");
                }
            } else {
                String errorString = responsedMessage.getErrorString();
                String string = TbadkCoreApplication.getInst().getString(R.string.neterror);
                if (StringUtils.isNull(errorString)) {
                    errorString = string;
                }
                if (ClientConfigModel.this.f12816e != null) {
                    ClientConfigModel.this.f12816e.onError(errorString);
                }
            }
        }
    }

    public ClientConfigModel(BdBaseFragmentActivity<?> bdBaseFragmentActivity, d.b.i0.p.a aVar) {
        super(bdBaseFragmentActivity.getPageContext());
        a aVar2 = new a(CmdConfigHttp.CMD_CLIENT_CONFIG, 303039);
        this.f12817f = aVar2;
        this.f12816e = aVar;
        registerListener(aVar2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final boolean v(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != getUniqueId()) ? false : true;
    }

    public final void w(DataRes dataRes) {
        if (dataRes == null) {
            if (this.f12816e != null) {
                this.f12816e.onError(TbadkCoreApplication.getInst().getString(R.string.data_load_error));
                return;
            }
            return;
        }
        d.b.i0.p.a aVar = this.f12816e;
        if (aVar != null) {
            aVar.a(dataRes);
        }
    }

    public void x(String str) {
        ClientConfigNetMessage clientConfigNetMessage = new ClientConfigNetMessage();
        clientConfigNetMessage.setType(str);
        sendMessage(clientConfigNetMessage);
    }
}
