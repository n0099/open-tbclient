package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class TopThemeListActivityConfig extends IntentConfig {
    public TopThemeListActivityConfig(Context context) {
        super(context);
    }

    public TopThemeListActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IntentConfig.MEMBER_BUY_SHOW, z);
    }
}
