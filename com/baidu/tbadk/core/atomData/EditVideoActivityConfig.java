package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
/* loaded from: classes.dex */
public class EditVideoActivityConfig extends IntentConfig {
    public static final String FROM_TYPE = "from_type";
    public static final String FROM_TYPE_RECORD_VIDEO_ACTIVITY = "from_record_activity";
    public static String LOCAL_PATH_KEY = "local_path";
    public static String MUSIC_ID_KEY = "music_id";
    public static String POSITION_KEY = "position";

    public EditVideoActivityConfig(Context context, String str, String str2, String str3, String str4, VideoInfo videoInfo) {
        super(context);
        getIntent().putExtra("forum_id", str3);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str4);
        getIntent().putExtra(WriteVideoActivityConfig.VIDEO_INFO, videoInfo);
        getIntent().putExtra("KEY_CALL_FROM", str);
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

    public void addFromType(String str) {
        getIntent().putExtra("from_type", str);
    }
}
