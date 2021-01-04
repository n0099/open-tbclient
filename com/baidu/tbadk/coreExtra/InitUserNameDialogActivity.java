package com.baidu.tbadk.coreExtra;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.b;
/* loaded from: classes.dex */
public class InitUserNameDialogActivity extends BaseActivity {
    b fso;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.fso = new b(this);
        this.fso.b(new b.a() { // from class: com.baidu.tbadk.coreExtra.InitUserNameDialogActivity.1
            @Override // com.baidu.tbadk.coreExtra.view.b.a
            public void g(AccountData accountData) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP));
                InitUserNameDialogActivity.this.finish();
            }
        });
        this.fso.a(new b.a() { // from class: com.baidu.tbadk.coreExtra.InitUserNameDialogActivity.2
            @Override // com.baidu.tbadk.coreExtra.view.b.a
            public void g(AccountData accountData) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_BC_CHAT_HANGUP));
                InitUserNameDialogActivity.this.finish();
            }
        });
        this.fso.bDb();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null && getIntent() != null && (getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA) instanceof AccountData)) {
            currentAccountInfo = (AccountData) getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA);
        }
        this.fso.setAccountData(currentAccountInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fso.se(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.fso.onDestroy();
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
