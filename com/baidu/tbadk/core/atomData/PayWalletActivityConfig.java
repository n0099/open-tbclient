package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.pay.PayConfig;
/* loaded from: classes.dex */
public class PayWalletActivityConfig extends IntentConfig {
    public static final String PAY_CONFIG = "pay_config";

    public PayWalletActivityConfig(Context context, PayConfig payConfig) {
        super(context);
        getIntent().putExtra(PAY_CONFIG, payConfig);
    }
}
