package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class am implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity Ql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(LoginActivity loginActivity) {
        this.Ql = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj == null) {
            currentAccountObj = com.baidu.tbadk.core.account.a.mk();
        }
        if (currentAccountObj == null && !TbadkCoreApplication.isSDKLogin) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NotLoginGuideActivityConfig(this.Ql.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
        }
        this.Ql.finish();
    }
}
