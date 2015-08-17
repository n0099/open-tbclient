package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BuyTBeanActivityConfig extends IntentConfig {
    public static final String GIFT_TBEAN = "gift_tbean";

    public BuyTBeanActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(GIFT_TBEAN, j);
    }
}
