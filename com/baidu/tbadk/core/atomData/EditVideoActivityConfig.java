package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
/* loaded from: classes.dex */
public class EditVideoActivityConfig extends IntentConfig {
    public EditVideoActivityConfig(Context context, String str, String str2, String str3, VideoInfo videoInfo) {
        super(context);
        getIntent().putExtra("forum_id", str2);
        getIntent().putExtra("forum_name", str);
        getIntent().putExtra("video_title", str3);
        getIntent().putExtra(WriteVideoActivityConfig.VIDEO_INFO, videoInfo);
    }
}
