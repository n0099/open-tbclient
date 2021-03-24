package com.baidu.tbadk.coreExtra;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InitUserNameDialogActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import d.b.h0.s.i.b;
/* loaded from: classes3.dex */
public class InitUserNameDialogActivity extends BaseActivity {
    public d.b.h0.s.i.b mInputUserNameDialog;

    /* loaded from: classes3.dex */
    public class a implements b.e {
        public a() {
        }

        @Override // d.b.h0.s.i.b.e
        public void a(AccountData accountData) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921350));
            InitUserNameDialogActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.e {
        public b() {
        }

        @Override // d.b.h0.s.i.b.e
        public void a(AccountData accountData) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921350));
            InitUserNameDialogActivity.this.finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        d.b.h0.s.i.b bVar = new d.b.h0.s.i.b(this);
        this.mInputUserNameDialog = bVar;
        bVar.v(new a());
        this.mInputUserNameDialog.w(new b());
        this.mInputUserNameDialog.p();
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo == null && getIntent() != null && (getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA) instanceof AccountData)) {
            currentAccountInfo = (AccountData) getIntent().getSerializableExtra(InitUserNameDialogActivityConfig.ACCOUNT_DATA);
        }
        this.mInputUserNameDialog.u(currentAccountInfo);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mInputUserNameDialog.s();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mInputUserNameDialog.z(1);
    }
}
