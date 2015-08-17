package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PraiseListActivityConfig extends IntentConfig {
    public PraiseListActivityConfig(Context context, String str, String str2, String str3, boolean z) {
        super(context);
        getIntent().putExtra("thread_id", str);
        getIntent().putExtra("post_id", str2);
        getIntent().putExtra(IntentConfig.POST_DESC, str3);
        getIntent().putExtra(IntentConfig.IS_FROM_PB, z);
    }
}
