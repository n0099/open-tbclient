package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class BubbleGroupActivityConfig extends IntentConfig {
    public BubbleGroupActivityConfig(Context context) {
        super(context);
    }

    public BubbleGroupActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra(IntentConfig.MEMBER_BUY_SHOW, z);
    }
}
