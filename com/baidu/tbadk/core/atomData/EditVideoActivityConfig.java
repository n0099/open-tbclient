package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tieba.frs.FrsTabInfoData;
/* loaded from: classes3.dex */
public class EditVideoActivityConfig extends IntentConfig {
    public static final String FROM_TYPE = "from_type";
    public static final String FROM_TYPE_RECORD_VIDEO_ACTIVITY = "from_record_activity";
    public static final String FROM_TYPE_WRITE_ACTIVITY_EDIT = "from_write_activity_edit";
    public static final String KEY_ANTI_DATA = "anti_data";
    public static final String KEY_PRO_ZONE = "pro_zone";
    public static String LOCAL_PATH_KEY = "local_path";
    public static String MUSIC_ID_KEY = "music_id";
    public static String POSITION_KEY = "position";

    public EditVideoActivityConfig(Context context, String str, String str2, String str3, String str4, VideoInfo videoInfo) {
        super(context);
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str4);
        getIntent().putExtra(WriteActivityConfig.VIDEO_INFO, videoInfo);
        getIntent().putExtra("KEY_CALL_FROM", str);
    }

    public void addFromType(String str) {
        getIntent().putExtra("from_type", str);
    }

    public void addMusicInfo(String str, String str2, int i) {
        getIntent().putExtra(LOCAL_PATH_KEY, str);
        getIntent().putExtra(MUSIC_ID_KEY, str2);
        getIntent().putExtra(POSITION_KEY, i);
    }

    public void addRequestForResult(int i) {
        setRequestCode(i);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public void setExtraData(AntiData antiData, PostPrefixData postPrefixData, String str, String str2) {
        if (getIntent() != null) {
            getIntent().putExtra(IntentConfig.FORUM_FIRST_DIR, str);
            getIntent().putExtra(IntentConfig.FORUM_SECOND_DIR, str2);
            getIntent().putExtra("prefix_data", postPrefixData);
            getIntent().putExtra("anti_data", antiData);
        }
    }

    public void setForumLevel(int i) {
        getIntent().putExtra("key_write_level", i);
    }

    public void setFrom(String str) {
        getIntent().putExtra("from", str);
    }

    public void setFrsTabInfo(FrsTabInfoData frsTabInfoData) {
        getIntent().putExtra("tab_list", frsTabInfoData);
    }

    public void setProZone(int i) {
        getIntent().putExtra(KEY_PRO_ZONE, i);
    }

    public void setStatisticFrom(int i) {
        getIntent().putExtra(WriteActivityConfig.KEY_STATISTIS_FROM, i);
    }
}
