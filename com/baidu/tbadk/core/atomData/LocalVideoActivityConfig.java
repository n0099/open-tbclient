package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LocalVideoActivityConfig extends IntentConfig {
    public static final String VIDEO_TITLE = "video_title";

    public LocalVideoActivityConfig(Context context) {
        super(context);
    }

    public LocalVideoActivityConfig(Context context, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str3);
    }
}
