package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class AllThemeListActivityConfig extends IntentConfig {
    public AllThemeListActivityConfig(Context context) {
        super(context);
    }

    public AllThemeListActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("member_buy_show", z);
    }
}
