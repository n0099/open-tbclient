package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class InitUserNameDialogActivityConfig extends IntentConfig {
    public static String ACCOUNT_DATA = "account_data";

    public InitUserNameDialogActivityConfig(Context context) {
        super(context);
    }

    public void setAccountData(AccountData accountData) {
        if (getIntent() != null) {
            getIntent().putExtra(ACCOUNT_DATA, accountData);
        }
    }
}
