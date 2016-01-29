package com.baidu.tbadk.clientConfig;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a SN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.SN = aVar;
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
        checkMessageIsBelongToCurPage = this.SN.checkMessageIsBelongToCurPage(responsedMessage);
        if (!checkMessageIsBelongToCurPage) {
            cVar5 = this.SN.SL;
            if (cVar5 != null) {
                cVar6 = this.SN.SL;
                cVar6.onError("");
            }
        } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
            String errorString = responsedMessage.getErrorString();
            String string = TbadkCoreApplication.m411getInst().getString(t.j.neterror);
            if (!StringUtils.isNull(errorString)) {
                string = errorString;
            }
            cVar = this.SN.SL;
            if (cVar != null) {
                cVar2 = this.SN.SL;
                cVar2.onError(string);
            }
        } else if (!(responsedMessage instanceof ClientConfigHttpProtoResponse)) {
            if (!(responsedMessage instanceof ClientConfigSocketResponse)) {
                cVar3 = this.SN.SL;
                if (cVar3 != null) {
                    cVar4 = this.SN.SL;
                    cVar4.onError("");
                    return;
                }
                return;
            }
            this.SN.a(((ClientConfigSocketResponse) responsedMessage).getData());
        } else {
            this.SN.a(((ClientConfigHttpProtoResponse) responsedMessage).getData());
        }
    }
}
