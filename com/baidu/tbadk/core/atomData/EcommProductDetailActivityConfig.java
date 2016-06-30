package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommProductDetailActivityConfig extends IntentConfig {
    public static final String IS_FROM_USER_INFO = "is_from_user_info";
    public static final String PRODUCT_ID = "product_id";

    public EcommProductDetailActivityConfig(Context context, long j, boolean z) {
        super(context);
        getIntent().putExtra("product_id", j);
        getIntent().putExtra(IS_FROM_USER_INFO, z);
    }
}
