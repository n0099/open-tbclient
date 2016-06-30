package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommOrderDetailActivityConfig extends IntentConfig {
    public static final String IS_PAY_DIRECT = "is_pay_direct";
    public static final String ORDER_ID = "order_id";

    public EcommOrderDetailActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra(ORDER_ID, str);
        getIntent().putExtra(IS_PAY_DIRECT, z);
    }
}
