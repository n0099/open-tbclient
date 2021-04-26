package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class LabelRecommendActivityConfig extends IntentConfig {
    public static final int FROM_FIRST_ACTIVATE = 1;
    public static final int FROM_WEAK_INTEREST = 2;

    public LabelRecommendActivityConfig(Context context, int i2) {
        super(context);
        getIntent().putExtra("from", i2);
    }
}
