package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class TopicDetailActivityConfig extends IntentConfig {
    public static final String KEY_IS_FROM_YUN_PUSH = "key_is_from_yunpush";

    public TopicDetailActivityConfig(Context context) {
        super(context);
    }

    public TopicDetailActivityConfig(Context context, long j) {
        super(context);
        getIntent().putExtra("topic_id", j);
    }

    public void setUri(Uri uri) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(IntentConfig.KEY_URI, uri);
        }
    }

    public void setIsFromYunPush(boolean z) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra(KEY_IS_FROM_YUN_PUSH, z);
        }
    }
}
