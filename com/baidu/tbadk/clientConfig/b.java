package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a Tr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.Tr = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean checkMessageIsBelongToCurPage;
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        checkMessageIsBelongToCurPage = this.Tr.checkMessageIsBelongToCurPage(responsedMessage);
        if (!checkMessageIsBelongToCurPage) {
            cVar5 = this.Tr.Tp;
            if (cVar5 != null) {
                cVar6 = this.Tr.Tp;
                cVar6.onError("");
            }
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            String errorString = responsedMessage.getErrorString();
            String string = TbadkCoreApplication.m411getInst().getString(n.j.neterror);
            if (!StringUtils.isNull(errorString)) {
                string = errorString;
            }
            cVar = this.Tr.Tp;
            if (cVar != null) {
                cVar2 = this.Tr.Tp;
                cVar2.onError(string);
            }
        } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
            if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                cVar3 = this.Tr.Tp;
                if (cVar3 != null) {
                    cVar4 = this.Tr.Tp;
                    cVar4.onError("");
                    return;
                }
                return;
            }
            this.Tr.a(((ClientConfigSocketResponse) responsedMessage).getData());
        } else {
            this.Tr.a(((ClientConfigHttpProtoResponse) responsedMessage).getData());
        }
    }
}
