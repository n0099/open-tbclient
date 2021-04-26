package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes3.dex */
public class XiaoyingPlayerConfig extends IntentConfig {
    public static final String EXTRA_THUMBNAIL_URL = "extra_thumbnail_url";
    public static final String EXTRA_URL = "extra_url";
    public static final String EXTRA_VIDEO_HEIGHT = "extra_video_height";
    public static final String EXTRA_VIDEO_WIDTH = "extra_video_width";

    public XiaoyingPlayerConfig(Context context, String str, int i2, int i3, String str2) {
        super(context);
        getIntent().putExtra(EXTRA_URL, str);
        getIntent().putExtra(EXTRA_VIDEO_WIDTH, i2);
        getIntent().putExtra(EXTRA_VIDEO_HEIGHT, i3);
        getIntent().putExtra(EXTRA_THUMBNAIL_URL, str2);
    }
}
