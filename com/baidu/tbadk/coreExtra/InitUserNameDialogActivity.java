package com.baidu.tbadk.coreExtra;

import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.a;
/* loaded from: classes.dex */
public class InitUserNameDialogActivity extends BaseActivity {
    a aAl;

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.aAl = new a(getPageContext());
        this.aAl.b(new a.InterfaceC0109a() { // from class: com.baidu.tbadk.coreExtra.InitUserNameDialogActivity.1
            @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0109a
            public void f(AccountData accountData) {
                InitUserNameDialogActivity.this.finish();
            }
        });
        this.aAl.Fz();
        this.aAl.i(TbadkCoreApplication.getCurrentAccountInfo());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.aAl.er(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aAl.onDestroy();
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
