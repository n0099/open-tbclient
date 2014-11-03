package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity La;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(LoginActivity loginActivity) {
        this.La = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.account.a.jA();
        }
        if (currentAccountObj == null && !TbadkApplication.isSDKLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.La, NotLoginGuideActivityConfig.FROM_ACCOUNT)));
        }
        this.La.finish();
    }
}
