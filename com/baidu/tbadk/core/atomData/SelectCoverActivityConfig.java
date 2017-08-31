package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class SelectCoverActivityConfig extends IntentConfig {
    public static final String VIDEO_HEIGHT = "video_height";
    public static final String VIDEO_PATH = "video_path";
    public static final String VIDEO_WIDTH = "video_width";

    public SelectCoverActivityConfig(Context context, String str, int i, int i2) {
        super(context);
        getIntent().putExtra("video_path", str);
        getIntent().putExtra(VIDEO_WIDTH, i);
        getIntent().putExtra(VIDEO_HEIGHT, i2);
    }
}
