package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumTestActivityConfig extends IntentConfig {
    public static final String TEST_ID = "test_id";

    public ForumTestActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra(TEST_ID, j);
    }
}
