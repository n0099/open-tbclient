package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g yc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.yc = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: b */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        BdUniqueId bdUniqueId;
        i iVar;
        String str;
        boolean z;
        boolean z2;
        int i;
        i iVar2;
        i iVar3;
        if (httpResponsedMessage != null) {
            bdUniqueId = this.yc.unique_id;
            if (bdUniqueId == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                f fVar = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                if (httpResponsedMessage.getError() != 0 || fVar == null || fVar.xU != 0) {
                    iVar = this.yc.xZ;
                    if (iVar != null) {
                        int error = httpResponsedMessage.getError();
                        String errorString = httpResponsedMessage.getErrorString();
                        if (httpResponsedMessage.getError() == 0) {
                            z2 = false;
                            z = false;
                            i = fVar.xU;
                            str = fVar.errorString;
                        } else {
                            str = errorString;
                            z = true;
                            z2 = false;
                            i = error;
                        }
                    }
                    i = -1;
                    z2 = true;
                    str = "";
                    z = true;
                } else {
                    iVar2 = this.yc.xZ;
                    if (iVar2 != null) {
                        iVar3 = this.yc.xZ;
                        iVar3.a(fVar);
                    }
                    if (fVar.xW.size() == 0) {
                        i = -1;
                        z2 = true;
                        str = "noList";
                        z = true;
                    }
                    i = -1;
                    z2 = true;
                    str = "";
                    z = true;
                }
                v.a(z2, z, String.valueOf(i), str);
            }
        }
    }
}
