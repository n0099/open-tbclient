package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.pay.PayConfig;
/* loaded from: classes3.dex */
public class WalletPayResultActivityConfig extends IntentConfig {
    public static final String IS_DIALOG = "is_dialog";
    public static final String PAYDATA = "pay_data";
    public static final String PAY_RESULT = "pay_result";

    public WalletPayResultActivityConfig(Context context, boolean z, boolean z2, PayConfig payConfig) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        getIntent().putExtra(PAY_RESULT, z);
        getIntent().putExtra(IS_DIALOG, z2);
        getIntent().putExtra(PAYDATA, payConfig);
    }
}
