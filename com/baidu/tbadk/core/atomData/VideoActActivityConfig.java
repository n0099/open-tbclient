package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class VideoActActivityConfig extends IntentConfig {
    public static String VIDEO_ACTVIE_ID = "video_active_id";
    public static String VIDEO_ACTVIE_NAME = "video_active_name";

    public VideoActActivityConfig(Context context) {
        super(context);
    }

    public VideoActActivityConfig(Context context, int i, String str) {
        super(context);
        getIntent().putExtra(VIDEO_ACTVIE_ID, i);
        getIntent().putExtra(VIDEO_ACTVIE_NAME, str);
    }
}
