package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class ForumSearchActivityConfig extends IntentConfig {
    public ForumSearchActivityConfig(Context context) {
        super(context);
    }

    public void setFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_FROM, i);
        }
    }

    public void setLiveId(long j) {
        if (getIntent() != null) {
            getIntent().putExtra("extra_key_live_id", j);
        }
    }

    public void setOriginalThread(OriginalThreadInfo originalThreadInfo) {
        if (getIntent() != null) {
            getIntent().putExtra(SelectForumActivityConfig.EXTRA_KEY_ORIGINAL_THREAD, originalThreadInfo);
        }
    }
}
