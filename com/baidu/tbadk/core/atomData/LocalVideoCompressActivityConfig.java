package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class LocalVideoCompressActivityConfig extends IntentConfig {
    public static final String KEY_LOCAL_VIDEO_DURATION = "local_video_duration";
    public static final String KEY_LOCAL_VIDEO_PATH = "local_video_path";
    public static final String KEY_LOCAL_VIDEO_THUMB_PATH = "local_video_thumb_path";
    public static final String KEY_LOCAL_VIEW_BG = "local_view_bg";

    public LocalVideoCompressActivityConfig(Context context, String str, String str2, String str3, String str4, String str5, long j, String str6) {
        super(context);
        getIntent().putExtra(KEY_LOCAL_VIDEO_PATH, str);
        getIntent().putExtra(KEY_LOCAL_VIDEO_THUMB_PATH, str2);
        getIntent().putExtra("forum_name", str4);
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("video_title", str5);
        getIntent().putExtra(KEY_LOCAL_VIDEO_DURATION, j);
        getIntent().putExtra(KEY_LOCAL_VIEW_BG, str6);
    }
}
