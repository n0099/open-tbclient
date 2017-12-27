package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.video.VideoItemData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class VideoPlayActivityConfig extends IntentConfig {
    public static final String PAGE_FROM = "page_from";
    public static final String VIDEO_COVER_RECT = "video_cover_rect";
    public static final String VIDEO_DATA = "video_data";
    public static final String VIDEO_INDEX = "video_index";
    public static final String VIDEO_LIST = "video_list";

    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i) {
        super(context);
        getIntent().putExtra(VIDEO_LIST, (Serializable) list);
        getIntent().putExtra(VIDEO_INDEX, i);
    }

    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect) {
        super(context);
        getIntent().putExtra(VIDEO_LIST, (Serializable) list);
        getIntent().putExtra(VIDEO_INDEX, i);
        getIntent().setSourceBounds(rect);
    }
}
