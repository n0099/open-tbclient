package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
public class PaymentConfirmActivityConfig extends IntentConfig {
    public static final String REQUEST_PARAMS = "request_params";

    public PaymentConfirmActivityConfig(Context context, PaymentConfirmRequestData paymentConfirmRequestData) {
        super(context);
        getIntent().putExtra(REQUEST_PARAMS, paymentConfirmRequestData);
    }
}
