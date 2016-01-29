package com.baidu.tbadk.core.atomData;

import android.content.Context;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class MotuVideoConfig extends IntentConfig {
    public static final String ACTION_FINISH_VIDEO_ALL_ACTIVITY = "cn.jingling.motu.mv.finish_all";
    public static final String FORUM_ID = "forum_id";
    public static final String FORUM_NAME = "forum_name";
    public static final String IS_SINGLE_GOD_USER = "is_single_god_user";

    public MotuVideoConfig(Context context) {
        this(context, false, null, null);
    }

    public MotuVideoConfig(Context context, boolean z, String str, String str2) {
        super(context);
        getIntent().putExtra(IS_SINGLE_GOD_USER, z);
        getIntent().putExtra("forum_id", str);
        getIntent().putExtra("forum_name", str2);
        setRequestCode(13010);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
