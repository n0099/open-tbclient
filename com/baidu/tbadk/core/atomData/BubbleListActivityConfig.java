package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class BubbleListActivityConfig extends IntentConfig {
    public BubbleListActivityConfig(Context context) {
        super(context);
    }

    public BubbleListActivityConfig(Context context, boolean z) {
        super(context);
        getIntent().putExtra("member_buy_show", z);
    }
}
