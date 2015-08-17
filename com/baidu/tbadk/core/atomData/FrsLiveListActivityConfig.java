package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class FrsLiveListActivityConfig extends IntentConfig {
    public FrsLiveListActivityConfig(Context context, String str, boolean z) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra(IntentConfig.FRS_MANAGER, z);
    }
}
