package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MotuVideoConfig extends IntentConfig {
    public static final String ACTION_FINISH_VIDEO_ALL_ACTIVITY = "cn.jingling.motu.mv.finish_all";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String IS_SINGLE_GOD_USER = "is_single_god_user";
    public static final String LOCAL_VIDEO_OPEN = "is_local_video_open";
    public static final String VIDEO_TITLE = "video_title";

    public MotuVideoConfig(Context context) {
        this(context, false, null, null, "");
    }

    public MotuVideoConfig(Context context, boolean z, String str, String str2, String str3) {
        super(context);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        getIntent().putExtra("video_title", str3);
        getIntent().putExtra(LOCAL_VIDEO_OPEN, z);
        setRequestCode(RequestResponseCode.REQUEST_RECORDER_VIDEO);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
