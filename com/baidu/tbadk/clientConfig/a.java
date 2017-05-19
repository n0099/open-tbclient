package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ClientConfigModel Rp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ClientConfigModel clientConfigModel, int i, int i2) {
        super(i, i2);
        this.Rp = clientConfigModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        b bVar5;
        b bVar6;
        checkMessageIsBelongToCurPage = this.Rp.checkMessageIsBelongToCurPage(responsedMessage);
        if (!checkMessageIsBelongToCurPage) {
            bVar5 = this.Rp.Rn;
            if (bVar5 != null) {
                bVar6 = this.Rp.Rn;
                bVar6.onError("");
            }
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            String errorString = responsedMessage.getErrorString();
            String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
            if (!StringUtils.isNull(errorString)) {
                string = errorString;
            }
            bVar = this.Rp.Rn;
            if (bVar != null) {
                bVar2 = this.Rp.Rn;
                bVar2.onError(string);
            }
        } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
            if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                bVar3 = this.Rp.Rn;
                if (bVar3 != null) {
                    bVar4 = this.Rp.Rn;
                    bVar4.onError("");
                    return;
                }
                return;
            }
            this.Rp.a(((ClientConfigSocketResponse) responsedMessage).getData());
        } else {
            this.Rp.a(((ClientConfigHttpProtoResponse) responsedMessage).getData());
        }
    }
}
