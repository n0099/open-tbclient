package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class StoryPreviewActivityConfig extends IntentConfig {
    public static final String KEY_MEDIA_PATH = "KEY_MEDIA_PATH";
    public static final String KEY_MEDIA_TYPE = "KEY_MEDIA_TYPE";

    public StoryPreviewActivityConfig(Context context, int i) {
        super(context);
        setIntentAction(IntentAction.ActivityForResult);
        setRequestCode(i);
    }

    public void setMediaType(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_MEDIA_TYPE, i);
        }
    }

    public void setMediaPath(String str) {
        if (getIntent() != null) {
            getIntent().putExtra(KEY_MEDIA_PATH, str);
        }
    }

    public void setPageFrom(int i) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.CALL_FROM, i);
        }
    }

    public void setForumId(long j) {
        if (getIntent() != null) {
            getIntent().putExtra("forum_id", j);
        }
    }

    public void setForumName(String str) {
        if (getIntent() != null) {
            getIntent().putExtra("forum_name", str);
        }
    }
}
