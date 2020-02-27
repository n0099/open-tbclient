package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class TopicDetailActivityConfig extends IntentConfig {
    public static final String KEY_URI = "key_uri";

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
            intent.putExtra("key_uri", uri);
        }
    }
}
