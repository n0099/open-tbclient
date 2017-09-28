package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class RecordVideoActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String LOCAL_VIDEO_OPEN = "is_local_video_open";
    public static final String VIDEO_TITLE = "video_title";

    public RecordVideoActivityConfig(Context context) {
        super(context);
    }

    public RecordVideoActivityConfig(Context context, boolean z, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str3);
        getIntent().putExtra("is_local_video_open", z);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
