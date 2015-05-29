package com.baidu.tbadk.core.relogin;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ ReloginManager SW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ReloginManager reloginManager, int i) {
        super(i);
        this.SW = reloginManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ArrayList arrayList;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ReloginManager.BgLoginHttpResponsedMessage)) {
            this.SW.SQ = false;
            ReloginManager.BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (ReloginManager.BgLoginHttpResponsedMessage) httpResponsedMessage;
            int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
            int error = bgLoginHttpResponsedMessage.getError();
            if ((statusCode == 200 && error != 0) || statusCode != 200) {
                this.SW.e(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    n.showToast(TbadkCoreApplication.m411getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                arrayList = this.SW.SS;
                arrayList.clear();
                return;
            }
            this.SW.sh();
        }
    }
}
