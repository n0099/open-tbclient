package com.baidu.tbadk.cdnOptimize;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends HttpMessageListener {
    final /* synthetic */ m BW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, int i) {
        super(i);
        this.BW = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        BdUniqueId bdUniqueId;
        o oVar;
        String str;
        boolean z;
        boolean z2;
        int i;
        o oVar2;
        o oVar3;
        if (httpResponsedMessage != null) {
            bdUniqueId = this.BW.unique_id;
            if (bdUniqueId == httpResponsedMessage.getOrginalMessage().getTag() && (httpResponsedMessage instanceof TbCdnGetIPListHttpResponseMsg)) {
                g gVar = ((TbCdnGetIPListHttpResponseMsg) httpResponsedMessage).ipListData;
                if (httpResponsedMessage.getError() != 0 || gVar == null || gVar.BI != 0) {
                    oVar = this.BW.BT;
                    if (oVar != null) {
                        int error = httpResponsedMessage.getError();
                        String errorString = httpResponsedMessage.getErrorString();
                        if (httpResponsedMessage.getError() == 0) {
                            z2 = false;
                            z = false;
                            i = gVar.BI;
                            str = gVar.errorString;
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
                    oVar2 = this.BW.BT;
                    if (oVar2 != null) {
                        oVar3 = this.BW.BT;
                        oVar3.a(gVar);
                    }
                    if (gVar.BK.size() == 0) {
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
                w.a(z2, z, String.valueOf(i), str);
            }
        }
    }
}
