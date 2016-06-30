package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EcommPersonManagerActivityConfig extends IntentConfig {
    public static final String IS_SELLER = "isSeller";
    public static final String SHOW_TYPE = "show_type";
    public static final int TYPE_ORDER = 1;
    public static final int TYPE_PRODUCT = 2;

    public EcommPersonManagerActivityConfig(Context context, boolean z, int i) {
        super(context);
        getIntent().putExtra(IS_SELLER, z);
        getIntent().putExtra(SHOW_TYPE, i);
    }
}
