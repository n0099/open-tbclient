package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ClientConfigModel Rc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ClientConfigModel clientConfigModel, int i, int i2) {
        super(i, i2);
        this.Rc = clientConfigModel;
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
        checkMessageIsBelongToCurPage = this.Rc.checkMessageIsBelongToCurPage(responsedMessage);
        if (!checkMessageIsBelongToCurPage) {
            bVar5 = this.Rc.Ra;
            if (bVar5 != null) {
                bVar6 = this.Rc.Ra;
                bVar6.onError("");
            }
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            String errorString = responsedMessage.getErrorString();
            String string = TbadkCoreApplication.m9getInst().getString(w.l.neterror);
            if (!StringUtils.isNull(errorString)) {
                string = errorString;
            }
            bVar = this.Rc.Ra;
            if (bVar != null) {
                bVar2 = this.Rc.Ra;
                bVar2.onError(string);
            }
        } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
            if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                bVar3 = this.Rc.Ra;
                if (bVar3 != null) {
                    bVar4 = this.Rc.Ra;
                    bVar4.onError("");
                    return;
                }
                return;
            }
            this.Rc.a(((ClientConfigSocketResponse) responsedMessage).getData());
        } else {
            this.Rc.a(((ClientConfigHttpProtoResponse) responsedMessage).getData());
        }
    }
}
