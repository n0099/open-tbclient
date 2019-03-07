package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class TopicDetailActivityConfig extends IntentConfig {
    public TopicDetailActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("topic_id", j);
    }
}
