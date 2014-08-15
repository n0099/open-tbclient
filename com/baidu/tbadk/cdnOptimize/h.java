package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.a = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        BdUniqueId bdUniqueId;
        i iVar;
        i iVar2;
        i iVar3;
        if (httpResponsedMessage != null) {
            bdUniqueId = this.a.unique_id;
            if (bdUniqueId == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                f fVar = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                if (httpResponsedMessage.getError() != 0 || fVar == null || fVar.a != 0) {
                    iVar = this.a.c;
                    if (iVar != null) {
                        int error = httpResponsedMessage.getError();
                        String errorString = httpResponsedMessage.getErrorString();
                        boolean z = true;
                        if (httpResponsedMessage.getError() == 0) {
                            error = fVar.a;
                            errorString = fVar.b;
                            z = false;
                        }
                        w.a(z, String.valueOf(error), errorString);
                        return;
                    }
                    return;
                }
                iVar2 = this.a.c;
                if (iVar2 != null) {
                    iVar3 = this.a.c;
                    iVar3.a(fVar);
                }
            }
        }
    }
}
