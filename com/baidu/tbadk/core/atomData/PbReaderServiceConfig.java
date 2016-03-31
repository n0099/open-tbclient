package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class PbReaderServiceConfig extends IntentConfig {
    public static final String POST_ID = "post_id";
    public static final String TAG_ID = "tag_id";
    public static final String THREAD_ID = "thread_id";

    public PbReaderServiceConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.StartService);
        getIntent().putExtra(TAG_ID, i);
    }

    public void setPostId(String str) {
        getIntent().putExtra("post_id", str);
    }

    public void setThreadId(String str) {
        getIntent().putExtra("thread_id", str);
    }
}
