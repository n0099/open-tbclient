package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class LocalVideoCompressActivityConfig extends IntentConfig {
    public static final String KEY_LOCAL_VIDEO_PATH = "local_video_path";
    public static final String KEY_LOCAL_VIDEO_THUMB_PATH = "local_video_thumb_path";

    public LocalVideoCompressActivityConfig(Context context, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra(KEY_LOCAL_VIDEO_PATH, str);
        getIntent().putExtra(KEY_LOCAL_VIDEO_THUMB_PATH, str2);
        getIntent().putExtra("forum_name", str4);
        getIntent().putExtra("forum_id", str3);
    }
}
