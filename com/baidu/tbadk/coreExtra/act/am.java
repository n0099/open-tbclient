package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.au;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.account.a.c();
        }
        if (currentAccountObj == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new au(this.a, au.b)));
        }
        this.a.finish();
    }
}
