package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class ConsumptionRecordsActivityConfig extends IntentConfig {
    public static final String JUMP_FRAGMENT_TYPE = "jump_fragment_type";
    public static final int TYPE_EXPENDITURE = 1;
    public static final int TYPE_INCOME = 2;
    public static final int TYPE_RECHARGE = 3;

    public ConsumptionRecordsActivityConfig(Context context) {
        super(context);
    }

    public ConsumptionRecordsActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra(JUMP_FRAGMENT_TYPE, i2);
    }
}
