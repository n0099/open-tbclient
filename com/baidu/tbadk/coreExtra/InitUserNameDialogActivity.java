package com.baidu.tbadk.coreExtra;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.b;
/* loaded from: classes.dex */
public class InitUserNameDialogActivity extends BaseActivity {
    b eap;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.eap = new b(this);
        this.eap.b(new b.a() { // from class: com.baidu.tbadk.coreExtra.InitUserNameDialogActivity.1
            @Override // com.baidu.tbadk.coreExtra.view.b.a
            public void g(AccountData accountData) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921350));
                InitUserNameDialogActivity.this.finish();
            }
        });
        this.eap.a(new b.a() { // from class: com.baidu.tbadk.coreExtra.InitUserNameDialogActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.b.a
            public void g(AccountData accountData) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921350));
                InitUserNameDialogActivity.this.finish();
            }
        });
        this.eap.bbw();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null && getIntent() != null && (getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA) instanceof AccountData)) {
            currentAccountInfo = (AccountData) getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA);
        }
        this.eap.setAccountData(currentAccountInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eap.mO(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eap.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }
}
