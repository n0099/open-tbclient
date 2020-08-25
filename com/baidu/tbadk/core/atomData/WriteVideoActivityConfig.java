package com.baidu.tbadk.core.atomData;

import android.app.Activity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.video.VideoTitleData;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class WriteVideoActivityConfig extends IntentConfig {
    public static final String ALL_VIDEO_TITLE = "all_video_title";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String FORUM_VIDEO_TITLE = "forum_video_title";
    public static final String FROM_TYPE = "from_type";
    public static final String KEY_CALL_FROM = "KEY_CALL_FROM";
    public static final String KEY_PRO_ZONE = "pro_zone";
    public static final String VIDEO_INFO = "video_info";
    public static final String VIDEO_TITLE = "video_title";

    public WriteVideoActivityConfig(Activity activity, String str, String str2, String str3, int i, VideoInfo videoInfo) {
        super(activity);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra(VIDEO_INFO, videoInfo);
        getIntent().putExtra("video_title", str3);
    }

    public WriteVideoActivityConfig(Activity activity, String str, String str2, String str3, String str4, int i, VideoInfo videoInfo, VideoTitleData videoTitleData, List<VideoTitleData> list) {
        super(activity);
        getIntent().putExtra("KEY_CALL_FROM", str);
        getIntent().putExtra("forum_id", str2);
        getIntent().putExtra("forum_name", str3);
        getIntent().putExtra(VIDEO_INFO, videoInfo);
        getIntent().putExtra("video_title", str4);
        getIntent().putExtra(FORUM_VIDEO_TITLE, videoTitleData);
        getIntent().putExtra(ALL_VIDEO_TITLE, (Serializable) list);
    }

    public void addFromType(String str) {
        getIntent().putExtra("from_type", str);
    }

    public void setProZone(int i) {
        getIntent().putExtra("pro_zone", i);
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        getIntent().putExtra("tab_list", frsTabInfoData);
    }

    public void setFrom(String str) {
        getIntent().putExtra("from", str);
    }
}
