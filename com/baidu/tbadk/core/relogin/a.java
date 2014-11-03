package com.baidu.tbadk.core.relogin;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ ReloginManager BY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ReloginManager reloginManager, int i) {
        super(i);
        this.BY = reloginManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ArrayList arrayList;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ReloginManager.BgLoginHttpResponsedMessage)) {
            this.BY.BT = false;
            ReloginManager.BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (ReloginManager.BgLoginHttpResponsedMessage) httpResponsedMessage;
            int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
            int error = bgLoginHttpResponsedMessage.getError();
            if ((statusCode == 200 && error != 0) || statusCode != 200) {
                this.BY.d(TbadkApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    m.showToast(TbadkApplication.m251getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                arrayList = this.BY.BV;
                arrayList.clear();
                return;
            }
            this.BY.lg();
        }
    }
}
