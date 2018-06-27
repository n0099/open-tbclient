package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.video.VideoItemData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes.dex */
public class VideoPlayActivityConfig extends IntentConfig {
    public static final String FROM = "from";
    public static final String FROM_MAINTAB_RECOMMEND = "from_mainrtab_recommend";
    public static final String FROM_MAINTAB_VIDEO = "from_maintab_video";
    public static final String FROM_NANI_VIDEO = "from_nani_video";
    public static final String FROM_VIDEO_MIDDLE_VIDEO = "from_video_middle_video";
    public static final String OBJ_ID = "obj_id";
    public static final String PAGE_FIRST_IN = "page_first_in";
    public static final String PAGE_FROM = "page_from";
    public static final String PARAM_ST_TYPE = "st_type";
    public static final String PARAM_YUELAOU_LACATION = "yuelaou_locate";
    public static final String VIDEO_COVER_RECT = "video_cover_rect";
    public static final String VIDEO_DATA = "video_data";
    public static final String VIDEO_INDEX = "video_index";
    public static final String VIDEO_LIST = "video_list";
    public static List<VideoItemData> bigDataList;

    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i) {
        super(context);
        getIntent().putExtra(VIDEO_LIST, (Serializable) list);
        getIntent().putExtra(VIDEO_INDEX, i);
    }

    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str) {
        super(context);
        getIntent().putExtra(VIDEO_LIST, (Serializable) list);
        getIntent().putExtra(VIDEO_INDEX, i);
        getIntent().putExtra("from", str);
        getIntent().setSourceBounds(rect);
    }

    public VideoPlayActivityConfig(Context context, List<VideoItemData> list, int i, Rect rect, String str, String str2, String str3, String str4) {
        super(context);
        getIntent().putExtra(VIDEO_LIST, (Serializable) list);
        getIntent().putExtra(VIDEO_INDEX, i);
        getIntent().putExtra(PAGE_FROM, str);
        getIntent().putExtra("st_type", str2);
        getIntent().putExtra("yuelaou_locate", str3);
        getIntent().putExtra("from", str4);
        getIntent().setSourceBounds(rect);
    }
}
