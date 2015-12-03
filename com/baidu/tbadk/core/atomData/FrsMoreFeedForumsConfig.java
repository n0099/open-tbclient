package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FrsMoreFeedForumsConfig extends IntentConfig {
    public static final String KEY_FEED_DATA_LIST = "KEY_FEED_DATA_LIST";

    public FrsMoreFeedForumsConfig(Context context, Serializable serializable) {
        super(context);
        getIntent().putExtra(KEY_FEED_DATA_LIST, serializable);
    }
}
