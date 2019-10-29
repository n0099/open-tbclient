package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class VideoTopicActivityConfig extends IntentConfig {
    public VideoTopicActivityConfig(Context context) {
        super(context);
    }

    public VideoTopicActivityConfig createNormalCfg(int i, String str, String str2) {
        Intent intent = getIntent();
        intent.putExtra("topic_id", i);
        intent.putExtra("topic_name", str);
        intent.putExtra("forum_id", str2);
        return this;
    }
}
