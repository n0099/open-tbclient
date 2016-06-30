package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class HisProductListActivityConfig extends IntentConfig {
    public HisProductListActivityConfig(Context context, String str, int i) {
        super(context);
        getIntent().putExtra("user_id", str);
        getIntent().putExtra(IntentConfig.USER_SEX, i);
    }
}
