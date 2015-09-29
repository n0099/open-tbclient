package com.baidu.tbadk.core.relogin;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.relogin.ReloginManager;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends HttpMessageListener {
    final /* synthetic */ ReloginManager XR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ReloginManager reloginManager, int i) {
        super(i);
        this.XR = reloginManager;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        ArrayList arrayList;
        if (httpResponsedMessage != null && (httpResponsedMessage instanceof ReloginManager.BgLoginHttpResponsedMessage)) {
            this.XR.XM = false;
            ReloginManager.BgLoginHttpResponsedMessage bgLoginHttpResponsedMessage = (ReloginManager.BgLoginHttpResponsedMessage) httpResponsedMessage;
            int statusCode = bgLoginHttpResponsedMessage.getStatusCode();
            int error = bgLoginHttpResponsedMessage.getError();
            com.baidu.tbadk.core.log.b.a(LoginActivityConfig.ACCOUNT, -1L, 0, "login_auto_local_result", bgLoginHttpResponsedMessage.getError(), bgLoginHttpResponsedMessage.getErrorString(), new Object[0]);
            if ((statusCode == 200 && error != 0) || statusCode != 200) {
                this.XR.e(TbadkCoreApplication.getCurrentAccountObj());
                if (bgLoginHttpResponsedMessage.getErrorString() != null) {
                    k.showToast(TbadkCoreApplication.m411getInst().getContext(), bgLoginHttpResponsedMessage.getErrorString());
                }
                arrayList = this.XR.XO;
                arrayList.clear();
                return;
            }
            this.XR.tq();
        }
    }
}
