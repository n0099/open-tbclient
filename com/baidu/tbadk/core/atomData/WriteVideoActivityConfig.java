package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
/* loaded from: classes.dex */
public class WriteVideoActivityConfig extends IntentConfig {
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String VIDEO_INFO = "video_info";
    public static final String VIDEO_TITLE = "video_title";

    public WriteVideoActivityConfig(Activity activity, String str, String str2, String str3, int i, VideoInfo videoInfo) {
        super(activity);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(VIDEO_INFO, videoInfo);
        getIntent().putExtra("video_title", str3);
    }
}
