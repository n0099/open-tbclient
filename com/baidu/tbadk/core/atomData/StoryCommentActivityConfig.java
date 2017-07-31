package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class StoryCommentActivityConfig extends IntentConfig {
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_PAGE_FROM = "page_from";
    public static final String KEY_THREAD_ID = "thread_id";

    public StoryCommentActivityConfig(Context context) {
        super(context);
    }

    public StoryCommentActivityConfig createMangaCfg(String str, String str2, int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("thread_id", str);
            intent.putExtra("forum_id", str2);
            intent.putExtra(KEY_PAGE_FROM, i);
        }
        return this;
    }
}
